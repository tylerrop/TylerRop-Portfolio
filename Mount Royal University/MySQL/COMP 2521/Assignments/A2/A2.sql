/*
 * File: A2.sql
 * Class: COMP 2521
 * Semester: Winter 2012
 * Assignment: 2
 * Student: Tyler Rop
 * Date: February 15, 2013
 */


\! rm A2.log

tee A2.log

use calgaryweather;

/*Part 1 - The Calgary Weather Database*/

/*1*/
/*
In Assignment 1 you wrote a query to list the \number of days
below -30". Using that query as a basis, write a query to nd the average,
minimum and maximum number of \days below -30" per year?
*/
SELECT FORMAT( AVG(chicken), 0 ) AS "Average" ,
       FORMAT( MIN(chicken), 0 ) AS "Minimum",
       FORMAT( MAX(chicken), 0 ) AS "Maximum"

FROM
(
SELECT COUNT(cw_day) AS chicken
FROM calgary_weather 
WHERE cw_min_temp < -30
GROUP BY cw_year
ORDER BY cw_year
)
AS temptable
;


/*2*/
/*Which day had the coldest minimum temperature and which
day had the warmest maximum temperature? List the day and the tem-
perature. This needs to be done with a single query and should return a
single line.
*/
SELECT c1.cw_min_temp, 
       c1.cw_date,
            c2.cw_max_temp,
	    c2.cw_date 

       FROM calgary_weather c1,
       	    calgary_weather c2
       	    
WHERE c1.cw_min_temp = 
(
SELECT MIN(cw_min_temp)
FROM calgary_weather c1
)

AND c2.cw_max_temp =
(
SELECT MAX(cw_max_temp)
FROM calgary_weather c2
)
;


/*3*/
/*
List all of the days that have the same: minimum temperature,
maximum temperature, and total precipitation. Only include days with
more than 0 total precipitation. Your result should look something like:

Order the result by maximum temperature, minimum temperature, total
precipitation and date. There should be no duplicate rows.
*/
SELECT c1.cw_date, 
       c1.cw_min_temp,
       c1.total_precip,
       
       c2.cw_date, 
       c2.cw_max_temp
       
       
       FROM calgary_weather c1,
            calgary_weather c2
       
WHERE c1.total_precip > 0 
      AND c2.total_precip > 0
      AND c1.cw_date <> c2.cw_date 
      AND c1.cw_min_temp = c2.cw_min_temp
      AND c1.cw_max_temp = c2.cw_max_temp
      AND c1.total_precip = c2.total_precip

GROUP BY c1.cw_date 
ORDER BY c1.cw_max_temp, c1.total_precip, c1.cw_date DESC
;


/*4*/
/*
Repeat the question above using a dierent query technique.
Your two queries should return the an identical result. If not, one of them
is wrong!
*/
SELECT c1.cw_date,
       c1.cw_min_temp,
       c1.total_precip,
       c1.cw_max_temp
       
       FROM calgary_weather c1

WHERE EXISTS
(
SELECT 'x'
FROM calgary_weather c2

      WHERE c1.total_precip > 0
      AND c2.total_precip > 0
      AND c1.cw_date <> c2.cw_date
      AND c1.cw_min_temp = c2.cw_min_temp
      AND c1.cw_max_temp = c2.cw_max_temp
      AND c1.total_precip = c2.total_precip
)
GROUP BY c1.cw_date
ORDER BY c1.cw_max_temp, c1.total_precip, c1.cw_date DESC
;


/*5*/
/*
I ride a bike for transportation. Often people, cyclists and
non, will remark that Calgary weather is too inclement for year round
bike riding. I always reply that there are a few days where the weather is
nasty, but that there are far more good days than bad.

I need you to nd out the truth. Write a query that catagorizes days as
\Good", \Poor" or \Stay Home" riding days, based on the conditions,
and counts how many there are of each.

Extreme heat or cold, high winds, heavy snowfall or heavy rain make for
poor riding.

Stay Home" a high less than -20 and more than 10 cm of snow.
Poor": A low temperature below -20 or a high temperature above +30
or wind gusts over 70 kph or more than 12 cm of snow or more than 50
mm rain.

All other days are \Good".
Use a UNION to create the query. The categories are mutually exclusive
so the total \Good" plus the total \Poor" should equal the total number
of days in the database.
Your query should display the category, the number of day in that category
and the average number of days per year in that category.
*/
SELECT "Stay Home" AS "Type of Day",
       day_count AS "Number of Days",
       FORMAT(
		day_count /(SELECT COUNT(DISTINCT (cw_year)
	     )
FROM calgary_weather), 2) AS "Average"

FROM
(
	SELECT COUNT(cw_date) AS day_count
	FROM calgary_weather
	WHERE cw_max_temp < -20
	AND total_snow > 10
	AND cw_date <= '2012-06-12'
) AS stay_home


UNION


/* Poor */
   SELECT "Poor" AS "Type of Day",
   	  day_count AS "Number of Days",
	  FORMAT(day_count/(SELECT COUNT(DISTINCT (cw_year))
	  FROM calgary_weather), 2) AS "Average"
	  
	  FROM
	  (
		SELECT COUNT(cw_date) AS day_count
		FROM calgary_weather
		WHERE cw_min_temp < -20
		OR cw_max_temp > 30
		OR spd_of_max_gust > 70
		OR total_snow > 12
		OR total_rain > 50
		AND cw_date <= '2012-06-12'
	  ) AS poor


UNION


/* Good */
SELECT "Good" AS "Type of Day" ,
       COUNT(cw_year) AS "Number of Days",
       FORMAT(
              COUNT(cw_year) / (SELECT COUNT(DISTINCT(cw_year)
	     )

FROM calgary_weather), 2) AS "Average"

FROM calgary_weather
     WHERE cw_min_temp >= -20
     AND cw_max_temp <= 30
     AND spd_of_max_gust <= 70
     AND total_snow <= 12
     AND total_rain <= 50
     AND cw_date <= '2012-06-12'
;


/*Part 2 - The Mountain Database*/

use mountain;

/*1*/
/*
How many mountains are in each mountain range in the database?
Show the range name, the continent and the number of mountains. Order
the result from the highest to lowest number of mountains, then alpha-
betically by the name of the mountain range.
*/
SELECT mr.range_name,
       con.name,
       COUNT(mtn.mountain_id)

       FROM mountain_range mr, 
       	    mountain mtn, 
	    continent con

WHERE mtn.range_id = mr.range_id
AND mr.range_continent = con.cont_id
GROUP BY mr.range_name
ORDER BY COUNT(mtn.mountain_name) DESC, mr.range_name ASC
;


/*2*/
/*
Alter your query to include ranges that do not have any moun-
tains.
*/
SELECT mr.range_name, 
       con.name,
       COUNT(mtn.mountain_id)
       FROM mountain_range mr

LEFT JOIN mountain mtn
USING(range_id)

JOIN continent con ON(mr.range_continent = con.cont_id)
GROUP BY mr.range_name
ORDER BY COUNT(mtn.mountain_name) DESC, mr.range_name DESC
;


/*3*/
/*
Rewrite the query above using a different technique.
*/
SELECT mr.range_name,
       con.name,
       COUNT(mtn.mountain_id)

       FROM mountain_range mr,
            mountain mtn,
            continent con
	    WHERE mr.range_id = mtn.range_id
	    	   AND mr.range_continent = con.cont_id
	    GROUP BY mr.range_id

UNION

SELECT mr.range_name,
       con.name,
       0

       FROM mountain_range mr,
            continent con

WHERE NOT EXISTS
(
SELECT 'x'
       FROM mountain mtn
       WHERE mr.range_id = mtn.range_id
)

AND mr.range_continent = con.cont_id
GROUP BY mr.range_id
ORDER BY 3 DESC, 1 ASC
;


/*4*/
/*
Which continent has the highest average height of its peaks?
*/
SELECT con.name,
       AVG(mtn.elevation)

       FROM mountain_range mr,
            mountain mtn,
            continent con

WHERE mtn.range_id = mr.range_id
AND mr.range_continent = con.cont_id
GROUP BY con.name
ORDER BY AVG(mtn.elevation) DESC LIMIT 1
;


/*5*/
/*
To answer this question you will need to create what is called
a cross tab query. You want to count the high, medium and low peaks on
each of three continents, Europe, North America and Asia.

Low mountains are less than 10,000 feet. Medium mountains are between
10,000 and 20,000 feet and high mountains are more than 20,000 feet.
The mountain database includes a function, ft to m() which converts its
argument to meters, from feet.
*/
SELECT "HIGH" AS categorty,
( SELECT COUNT(elevation_feet) FROM mountains
  WHERE continent = "North America" AND elevation_feet > 20000
) AS "n.america",

( SELECT COUNT(elevation_feet) FROM mountains
  WHERE continent = "Asia" AND elevation_feet > 20000
) AS "asia"
,
( SELECT COUNT(elevation_feet) FROM mountains
  WHERE continent = "Europe" AND elevation_feet > 20000
) AS "europe"


UNION


SELECT "MEDIUM" AS category,
( SELECT COUNT(elevation_feet) FROM mountains
  WHERE continent = "North America" AND elevation_feet < 20000
  AND elevation_feet > 10000
) AS "n.america",

( SELECT COUNT(elevation_feet) FROM mountains
  WHERE continent = "Asia" AND elevation_feet < 20000
  AND elevation_feet > 10000
) AS "asia",

( SELECT COUNT(elevation_feet) FROM mountains AS mtns5
  WHERE continent = "Europe" AND elevation_feet < 20000
  AND elevation_feet > 10000
) AS "europse"


UNION


SELECT "LOW" AS category,
( SELECT COUNT(elevation_feet) FROM mountains
  WHERE continent = "North America" 
  AND elevation_feet < 10000
) AS "n.america",

( SELECT COUNT(elevation_feet) FROM mountains
  WHERE continent = "Asia"
  AND elevation_feet < 10000
) AS "asia",

( SELECT COUNT(elevation_feet) FROM mountains
  WHERE continent = "Europe"
  AND elevation_feet < 10000
) AS "europe"
;



notee
