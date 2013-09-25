/*
 * File: A5.sql
 * Class: COMP 2521
 * Semester: Winter 2012
 * Assignment: 5
 * Student: Tyler Rop
 * Date: April 12, 2013
 */


\! rm A5.log
tee A5.log
use dbms14;

/*1*/
/*
This trigger creates a date/time stamp for a Meow and ensures that the Meow how between 1 and
9 words in it. 
*/
DROP TRIGGER IF EXISTS meow_time_stamp;
DELIMITER $$

CREATE TRIGGER meow_time_stamp
BEFORE INSERT
ON MEOW
FOR EACH ROW
    BEGIN
	/*There has to be atleast 1 word in the Meow*/	
	IF word_counter(NEW.MeowText) <> 0
	/*There has to be no more than 9 word in the Meow*/ 
	AND word_counter(NEW.MeowText) <= 9
	    /*The Meow passes the word count requirements so it's time stamp is posted*/
	    THEN SET NEW.MeowDate = NOW();
	    
	/*The meow did not pass the word count requirements*/
	ELSE
            /*An error is signaled telling the user that the Meow was invalid*/
	    /*Also, a cat is running the error handling of the database,
	      hence the Meooooow*/ 
	    SIGNAL SQLSTATE VALUE '45000'
	    SET MESSAGE_TEXT = 'The Meow you entered is invalid. Meooooow';
	
	END IF;
    END; $$
DELIMITER ;

/*Practise Meow insert data that is too long*/
INSERT INTO MEOW (MeowID, UserID, MeowText, Active) 
       VALUES (178, 1, 'tylers (meow)!, meow meow meow meow meow meow meow meow', 1);

/*Practise Meow insert data that is a correct length Meow*/
INSERT INTO MEOW (MeowID, UserID, MeowText, Active)
       VALUES (178, 1, 'tylers (meow)!, meow meow meow meow', 1);

/*Printing out practise info to prove that the Meows were inserted or not due to their validity*/
SELECT * FROM MEOW;

/*
word_couter
Function to count words
The function is dropped if it exists already.
Text is passed in that will have it's words counted
The # of spaces in the string ar counted to determine the # of words
The length of the string must not be zero if t is to be counted
This function is valled by the meow_time_stamp trigger
*/
DROP FUNCTION IF EXISTS word_counter;
DELIMITER $$
CREATE FUNCTION word_counter(MeowText VARCHAR(5000)  )
        RETURNS INT
	BEGIN
        DECLARE i INT;
                IF ( LENGTH(MeowText) <> 0 )
		   THEN
                   SET i = LENGTH(MeowText) - LENGTH( REPLACE( MeowText, ' ', '') ) + 1;
                
		ELSE
                   SET i = 0;
                END IF;
        RETURN i;
END $$
DELIMITER ;


/*2*/
/*
Email insert trigger for verification
Each email mush have some text, then a '@' 
and some more text, then a '.' and some more text after
*/
DROP TRIGGER IF EXISTS email_checker_i;
DELIMITER $$
CREATE TRIGGER email_checker_i
BEFORE INSERT 
ON USER
FOR EACH ROW
BEGIN
	/*The string is checked to make sure that it fits the email requirements*/
	/*An error is issued if the requirements are not met */
	IF NEW.Email NOT LIKE '%@%.%' THEN
	   SIGNAL SQLSTATE VALUE '45000'
	   SET MESSAGE_TEXT = 'Invalid Email Address. Meeeoooow';
	END IF; 
END $$
DELIMITER ;


/*
Email update trigger for verification
Works exactly the same as the email insert trigger
Only difference is that this trigger is for an update instead
*/
DROP TRIGGER IF EXISTS email_checker_update;
DELIMITER $$
CREATE TRIGGER email_checker_update
BEFORE UPDATE
ON USER
FOR EACH ROW
BEGIN
        IF NEW.Email NOT LIKE '%@%.%' THEN
           SIGNAL SQLSTATE VALUE '45000'
           SET MESSAGE_TEXT = 'Invalid Email Address';
        END IF;
END $$
DELIMITER ;

/*Practise User insert data*/
INSERT INTO USER (UserID, Email, NikName, NameFirst, NameLast)
       VALUES (201520315, 'rop.tyler@gmail.com', 'T-Rop', 'Tyler', 'Rop');

/*Printing out practise info*/
SELECT * FROM USER;

/*Practise Avatar insert data*/
INSERT INTO AVATAR (UserID, Avatar) VALUES (2, 'c/users/grumpcat/meme.png');

/*3*/
/*
Insert trigger to add a timestamp to PRIDE
*/
DROP TRIGGER IF EXISTS pride_stamp;
DELIMITER $$
CREATE TRIGGER pride_stamp
BEFORE INSERT
ON PRIDE
FOR EACH ROW
    BEGIN
	SET NEW.JoinDate = NOW();
    END $$
DELIMITER ;

/*Practise PRIDE insert data*/
INSERT INTO PRIDE (UserID, KittenID)
       VALUES (201520315, 2);

/*4*/
/*
A)
*/
/*
This view counts the MeowText per each user 
*/
DROP VIEW IF EXISTS MeowCount;
CREATE VIEW MeowCount AS SELECT UserID, COUNT(MeowText) AS MeCount  FROM MEOW GROUP By UserID; 
SELECT * FROM MeowCount;

/*
This view counts the Kittens per each user
*/
DROP VIEW IF EXISTS KittenCount;
CREATE VIEW KittenCount AS SELECT UserID, COUNT(KittenID) AS KidCount  FROM PRIDE GROUP BY UserID;
SELECT * FROM KittenCount;


/*
This view counts the prides that each Kitten is in per each KittenID
*/
DROP VIEW IF EXISTS PrideCount;
CREATE VIEW PrideCount AS SELECT KittenID, COUNT(KittenID) AS PrCount FROM PRIDE GROUP BY KittenID;
SELECT * FROM PrideCount;


/*
This view lists te public profile for all active users
If certain values are null then they are replaced
values have to match up from all of the previous 3 views as they are 
left joined if they are to be shown in the final table
*/
DROP VIEW IF EXISTS USERS;
CREATE VIEW USERS AS SELECT u.NikName, 
       	       	  	 IFNULL( a.Avatar, 'No Avatar Path'), 
			 IFNULL(kc.KidCount, 0),
			 IFNULL(mc.MeCount, 0),
			 IFNULL(pc.PrCount, 0) 
			 FROM USER AS u 
       			      
			      LEFT JOIN AVATAR a 	    ON ( u.UserID = a.UserID ) 
       			      LEFT JOIN KittenCount kc      ON ( u.UserID = kc.UserID )
       			      LEFT JOIN MeowCount mc 	    ON ( u.UserID = mc.UserID )
       			      LEFT JOIN PrideCount pc	    ON ( u.UserID = pc.KittenID )	      
       			      
			      GROUP BY u.UserID;

/*B)*/
/*
This PRIDES view lists all of the prides that a user belongs to.
UserId's and KittenId's have to match up to.
*/
DROP VIEW IF EXISTS PRIDES;
CREATE VIEW PRIDES AS SELECT DISTINCT(u1.NikName) AS ME,
       	                     	   u2.NikName AS KITTEN  
				   FROM PRIDE p1, 
				   PRIDE p2, 
				   USER u1,
				   USER u2
				   
			WHERE u1.UserID = p1.UserID AND
			      p1.KittenID = u2.UserID AND
			      u1.UserID = p1.UserID AND
			      p2.KittenID <> u1.UserID
			      
			      ORDER BY u1.NikName;


/*C)*/
/*
This view retrieves the timeline for particular users
The user has to be active to be shown
*/
DROP VIEW IF EXISTS TIMELINE;
CREATE VIEW TIMELINE AS SELECT u.NikName, 
       	    	     	       m.MeowDate, 
			       m.MeowText
			       FROM USER AS u, MEOW AS m
			            WHERE m.UserID = u.UserID AND u.Active = 1
				    GROUP BY u.NikName ORDER BY m.MeowDate;

/*5*/
/*
This destroyer procedure deactivates a user
It takes in a NikName for a user (which it will deactivate)
If there is not a user with the entered NikName then an error is given
*/
DROP PROCEDURE IF EXISTS destroyer;
DELIMITER $$
CREATE PROCEDURE destroyer (Name VARCHAR(50)  ) 
BEGIN
	DECLARE NN INT;
	IF ( (SELECT COUNT(*) FROM USER WHERE Name = NikName) = 0 )
	   THEN
	   SIGNAl SQLSTATE VALUE '45000'
	   SET MESSAGE_TEXT = 
	       'You entered an invalid nikname. The nikname you entered is not stored in the database.';
           
	ELSE
	   SET NN = ( SELECT UserID FROM USER WHERE Name = NikName  );
	   UPDATE USER
	   SET ACTIVE = 0
	       WHERE NikName = Name;
	       
	   UPDATE MEOW
	   SET ACTIVE = 0
	       WHERE UserID = NN;

	   DELETE FROM PRIDE
	       WHERE UserID = NN OR KittenID = NN;

	END IF;
END;
$$
DELIMITER ;

/*test to deactivate with the destroyer procedure*/
destroyer(Tab62); 

notee
