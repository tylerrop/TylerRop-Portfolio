import java.awt.Color;
import java.io.*;
import display.*;
import java.util.Scanner;
/**
 * controls the game. reads in the input text files and handles hero and troll battle sequences
 * 
 * @author (Tyler Rop) 
 * @version (version 3)
 */
public class control
{   
    //new graphical interface object    
    private GuiInterface displayInterface = GuiInterface.getInstance();

    //2d array that stores all of the cave objects
    private Cave[][] caveStorage;

    //the hero that the user will play as
    private hero hero;

    //the collumn position that the user is in
    private int userCol;

    //the row position that the user is in
    private int userRow;

    //the right-most collumn
    private int maxCol;

    //the bottom-most row
    private int maxRow;

    //the left-most collumn
    private int minCol;

    //the top-most row
    private int minRow;

    /**
     * Method - getCave
     * checks to see if a user can move to a cave in the 2d array
     * if there is a cave around the user's location (not a null element in the array), then those cave(s) will be found and the user will be allowed to move to them
     */
    private Cave getCave(int row, int col)
    {
        //cave to be checked for existance
        Cave found = null;

        //check to make sure that the cave is in bounds of the 2d array rows and collumns
        if(row >=0 && col >= 0)
        {
            if(row < maxRow && col < maxCol)
            {
                //the user will be able to move to this found cave
                found = caveStorage[row][col];
            }
        }

        return found;
    }

    /**
     * Method - start
     * asks the user to select the text file for the game.
     * sets the character at their start location.
     * sets up the caves and the gui
     */
    public void start() throws IOException
    {
        //the map is set up and drawn after the user enters the file for the game
        displayInterface.showWindow();

        //the user is asked to select a game file
        File selectedFile = displayInterface.getGameFile();

        //game graphics are displayed
        DisplayGraphics graphics = displayInterface.getDisplayGraphics();

        //the file is read
        readGameFile(selectedFile);

        //the graphics for the game are put together by the interface part of the program
        graphics.buildMap(maxRow, maxCol);

        //all caves that are inbounds of the 2d array are 
        for(int row=0; row < maxRow; row++)

            for(int col=0; col < maxCol; col++)
            {
                if(caveStorage[row][col] != null)
                {
                    graphics.setCaveColorAt(row,col, caveStorage[row][col].getMapCaveColor() );
                }
            }

        //map is updated and drawn for the user
        graphics.updateDrawnMap();

        //sets the start location for the user
        graphics.setUserLocation(userRow,userCol);

        //the map is drawn for the user
        graphics.updateDrawnMap();

        //the game loops while the user moves until the user dies or wins or exits the game
        do
        {
            caveStorage[userRow][userCol].setUser(hero);
            //color the contents of the cave
            caveStorage[userRow][userCol].drawCave(graphics);
            caveStorage[userRow][userCol].executeUserInteraction(displayInterface);
            
            

            //the user is asked to inout theiur choice of where they want to move to
            displayInterface.setUserDisplayMessage("Where do you want to move?");

            //these booleans define where the user can move to
            boolean up=true;
            boolean right=true;
            boolean down=true;
            boolean left=true;

            //if there is no cave up, down, right, or left of the user, then the user will not be able to move to these respective spots because they are null

            if(getCave(userRow-1,userCol) == null) 
            {
                up = false;
            }
            if(getCave(userRow,userCol+1) == null) 
            {
                right = false;
            }
            if(getCave(userRow+1,userCol) == null) 
            {
                down = false;
            }
            if(getCave(userRow,userCol-1) == null)
            {
                left = false;
            }

            //the action that the user selects as a string
            String moveDir = displayInterface.getUserMoveAction(up,right,down,left, GuiInterface.MAP_SCREEN);

            //the previous location that the user was at has the user from there set to null so that we do not have duplication of users
            caveStorage[userRow][userCol].setUser(null);

            //moving the user
            //the user indicates that they want to move right, and their position is updated so that they move right one collumn (if they are allowed to)
            if(moveDir.compareTo("RIGHT") == 0)
            {
                userCol = userCol +1;
            }

            //the user indicates that they want to move left, and their position is updated so that they move left one collumn (if they are in bounds still)
            if(moveDir.compareTo("LEFT") == 0)
            { 
                userCol = userCol - 1;
            }

            //the user indicates that they want to move up, and their position is updated so that they move up one row (if they are in bounds still)
            if(moveDir.compareTo("UP") == 0)
            {
                userRow = userRow - 1;
            }
            //the user indicates that they want to move down, and their position is updated so that they move down one row (if ther are in bounds still)
            if(moveDir.compareTo("DOWN") == 0)
            {
                userRow = userRow + 1; 
            } 

            //The map GUI is updated
            graphics.setUserLocation(userRow, userCol);

        }while(!displayInterface.diduserClickExit());
    }

    /**
     * Method - makeWeapon
     * reads from the input text file and makes the approprioate weapon based on the information from the text file
     */
    private weapon makeWeapon(Scanner inFile)
    {
        //the weapon to make
        weapon wep = null;

        //the name of the weapon
        String weaponName;

        //the weapons power is first read a as a string and then will be converted to the actual int weaponPower
        String weaponPowerString;
        int weaponPower;

        //the length of a weapon (if a weapon has a length)
        int weaponLength;

        //the axes weight if first read as a string and then converted into the int axeWeight 
        String axeWeightString;
        int axeWeight;

        //the users weapon type is read in and split up so that the information from the line can be used
        String weaponLine = inFile.nextLine().trim();
        String[] parts = weaponLine.split(",");
        String weaponType = parts[0];

        //if the users weapon type is a dagger then the specific information required for the dagger weaopon is read in
        if(weaponType.equals("DAGGER"))
        {
            //daggers name is read in
            weaponName = parts[1];

            //the daggers power is read in
            weaponPower = Integer.parseInt(parts[2]);

            //the new dagger is created
            wep = new dagger(0,weaponName,weaponPower);
        }

        //weapon type is just a fist
        else if(weaponType.equals("FIST"))
        {
            //the name of the fists is set to Man Fist
            weaponName = "Man Fist";

            //the new fist weapon is created
            wep = new fist();
        }

        //weapon type is a normal sword
        else if(weaponType.equals("SWORD"))
        {
            //sword name is read in
            weaponName = parts[1];

            //the swords power is read in
            weaponPower = Integer.parseInt(parts[2]);

            //the length of the sword is read in
            weaponLength = Integer.parseInt(parts[3]);

            //the new sword weapon is created
            wep = new sword(0,weaponName,weaponPower, weaponLength);
        }

        //users weapon type is an axe
        else if(weaponType.equals("AXE"))
        {
            //axe name is read in
            weaponName = parts[1];

            //the axes power is read in
            weaponPower = Integer.parseInt(parts[2]);

            //the axes weight is read in
            axeWeight = Integer.parseInt(parts[3]);

            //the new axe weapon is created
            wep = new axe(0,weaponName,weaponPower, axeWeight);
        }

        //users weapon type is the Kill All Sword
        else if(weaponType.equals("KILL_ALL"))
        {
            //kill all sword name is set
            weaponName = "Kill All Sword";

            //the weapons ultimate power is set
            weaponPower = 999999;

            //the weapons ul;timate length is set
            weaponLength = 999999;

            //the new kill all sword weapon is created
            wep = new killAllSword();
        }

        //whatever weapon was made is returned
        return wep;
    }

    /**
     * Method - readGameFile
     * reads in the txt file that the user types in.
     * the read in file is used to create all of the user, troll, and cave settings for the game
     * exceptioons are handled so that if the user enters something that is not a usable txt file, then the program will ask the user to enter a new file name (until they enter a valid file name)
     * 
     */
    public void readGameFile(File selectedFile)throws IOException
    {
        //scanner that reads through the txt file
        Scanner inFile = new Scanner(selectedFile);

        
        //user information
        
        
        //users health
        int userHealth;

        //users defense
        int userDefense;

        //users coins 
        int userCoins;

        //users weapon
        String userWeapon;

        //users weapon name
        String weaponName;

        //the weapons power is first read a as a string and then will be converted to the actual int weaponPower
        String weaponPowerString;
        int weaponPower;

        //the length of a weapon (if a weapon has a length)
        int weaponLength;

        //the axes weight if first read as a string and then converted into the int axeWeight 
        String axeWeightString;
        int axeWeight;

        //cave related variables
        //this is the row that the cave is in, it is initially read in as a string and then converted to an integer
        String caveRowString;
        //the row a cave is in
        int caveRow;

        //this is the column that the cave is in, it is initially read in as a string and then converted to an integer
        String caveColString;
        //the collumn a cave is in
        int caveCol;

        //the location that the hero/user will start the game in.
        //first read in as strings and then converted to ints
        String startColString;
        String startRowString;
        int startRow;
        int startCol;

        //the number of caves
        int numCaves;

        //type of cave
        String caveType;

        //the caves name
        String caveName;

        //the caves row and collumn location are read in as strings and then set as integers
        String caveRowLocationString;
        int caveRowLocation;
        String caveColLocationString;
        int caveColLocation;

        //the fee for the user to health is read as a string and then will be converted ato an integer
        String caveHealingFeeString;
        int healFee;

        //the cost for fixing a weapon is read as a string and then will be converted to an integer
        String caveFixingFeeString;
        int fixFee;

        //the message from a story cave
        String storyMessage;

        //the type of troll in the cave
        String trollType;

        //the name of thr troll in the cave
        String trollName;

        //the health of the troll in the cave
        int trollHealth;

        //the defense level of the troll in the cave
        int trollDefenseLevel;

        //the number of coins that the troll in the cave has
        int trollCoins;

        //the weapon that the troll in the cave has
        String trollWeapon;

        //now the file is actually read in while there are lines to read in from the file

        //user health is read in
        userHealth = inFile.nextInt();
        inFile.nextLine();

        //user defense level is read in
        userDefense = inFile.nextInt();
        inFile.nextLine();

        //user coins amount is read in
        userCoins = inFile.nextInt();
        inFile.nextLine();

        //the delimiter is set to use commas now
        inFile.useDelimiter(",");

        //the users weapon type is read in/make and given to the user character
        weapon userWep = makeWeapon(inFile);
        hero = new hero("Eddard Stark", userHealth, userDefense, userCoins, userWep);

        //now we move onto reading cave based inforamtion
        //read in cave row as a string and then convert it to an integer
        inFile.reset();
        inFile.useDelimiter(",");
        caveRowString = inFile.next();
        caveRow = Integer.parseInt(caveRowString);

        //the comma is skipped and the scanner reads until the end of the line
        inFile.skip(",");
        inFile.useDelimiter("\r\n");
        caveColString = inFile.next();
        caveCol = Integer.parseInt(caveColString);

        //2d array for storing caves
        caveStorage = new Cave[caveRow][caveCol];
        maxRow = caveRow;
        maxCol = caveCol;

        //read in the start cave location for the user
        inFile.nextLine();
        //the delimiter is reset
        inFile.reset();
        //the delimiter is set to a comma
        inFile.useDelimiter(",");

        //the users start row is read as a string and then it is converted to an integer
        startRowString = inFile.next();
        startRow = Integer.parseInt(startRowString);
        userRow = startRow;

        //the comma is skipped and the delimiter is set to read to the end of the line
        inFile.skip(",");
        inFile.useDelimiter("\r\n");

        // the users start collumn is read as a string and then converted to an integer
        startColString = inFile.next();
        startCol = Integer.parseInt(startColString);
        userCol = startCol;

        inFile.nextLine();
        inFile.reset();

        //the number of caves in the map is read in
        numCaves = inFile.nextInt();

        inFile.nextLine();

        //here we read in all the actual caves in the file
        for(int i = 0; i < numCaves; i++)
        {
            //the type of cave is read
            caveType = inFile.nextLine();

            //if the cave is  a story cave then specific story cave stuff is read in
            if(caveType.equals("STORY_CAVE"))
            {
                // the caves name is read in
                caveName = inFile.nextLine();

                //the delimiter is set to a comma
                inFile.useDelimiter(",");

                //the story caves row is read in as a string and then converted to an integer
                caveRowLocationString = inFile.next();
                caveRowLocation = Integer.parseInt(caveRowLocationString);

                //the comma is skipped
                inFile.skip(",");

                //the delimiter is set to read to the end of the line
                inFile.useDelimiter("\r\n");
                caveColLocationString = inFile.next();
                caveColLocation = Integer.parseInt(caveColLocationString);

                //reading healing and fixing fees
                inFile.nextLine();
                inFile.reset();
                inFile.useDelimiter(",");
                //the fee for the user to heal is read in as a string and thyen converted to an integer
                caveHealingFeeString = inFile.next();
                healFee = Integer.parseInt(caveHealingFeeString);

                inFile.skip(",");
                inFile.useDelimiter("\r\n");

                //the fee for the user to fix their weapon is read in as a string and thyen converted to an integer
                caveFixingFeeString = inFile.next();
                fixFee = Integer.parseInt(caveFixingFeeString);

                inFile.nextLine();
                inFile.reset();

                //the story message from the cave is read in
                storyMessage = inFile.nextLine();

                //the new story cave is created and stored in the cave 2d array
                Cave storyCave = new storyCave(caveRowLocation, caveColLocation, healFee, fixFee, storyMessage);
                caveStorage[caveRowLocation][caveColLocation] = storyCave;

            }

            //if the cave is a battle cave
            else if(caveType.equals("BATTLE_CAVE"))
            {
                //cave name is read in
                caveName = inFile.nextLine();

                //delimiter is set to a comma
                inFile.useDelimiter(",");

                //the row of the cave is read in as a string and converted to an integer
                caveRowLocationString = inFile.next();
                caveRowLocation = Integer.parseInt(caveRowLocationString);

                inFile.skip(",");
                inFile.useDelimiter("\r\n");

                //the collumn of the cave is read in as a string and converted to an integer
                caveColLocationString = inFile.next();
                caveColLocation = Integer.parseInt(caveColLocationString);

                inFile.nextLine();

                //read in the troll info for the troll thats in the cave

                //the type of troll is read in
                trollType = inFile.nextLine();

                //the trolls name is read in
                trollName = inFile.nextLine();

                //the trolls health is read in
                trollHealth = inFile.nextInt();

                inFile.nextLine();

                //the trolls defense leel is read in
                trollDefenseLevel = inFile.nextInt();

                inFile.nextLine();

                //the coins that the troll has is read in
                trollCoins = inFile.nextInt();

                inFile.nextLine();

                //the delimiter is set to a comma
                inFile.useDelimiter(",");

                //the trolls weapon type is read in/made and given to the troll
                weapon trollWep = makeWeapon(inFile);
                
                //the approriate troll type is created based on the input from the file and then is placed in the battle cave with the trolls weapon.
                //the troll is then placed in the battle cave which is stored in its respective location in the 2d array that holds all of the caves.
                if(trollType.equals("BESERKER"))
                {
                    berserker berserker = new berserker(trollName, trollHealth, trollDefenseLevel, trollCoins, trollWep);

                    Cave battleCave = new battleCave(berserker, caveRowLocation, caveColLocation);
                    caveStorage[caveRowLocation][caveColLocation] = battleCave;
                }
                if(trollType.equals("RANDOMGER"))
                {
                    randomger randomger = new randomger(trollName, trollHealth, trollDefenseLevel, trollCoins, trollWep);

                    Cave battleCave = new battleCave(randomger, caveRowLocation, caveColLocation);
                    caveStorage[caveRowLocation][caveColLocation] = battleCave;
                }
                if(trollType.equals("BOSS"))
                {
                    bigBoss bigBoss = new bigBoss(trollName, trollHealth, trollDefenseLevel, trollCoins, trollWep);

                    Cave battleCave = new battleCave(bigBoss, caveRowLocation, caveColLocation);
                    caveStorage[caveRowLocation][caveColLocation] = battleCave;
                }
            }
        }
    }
}

