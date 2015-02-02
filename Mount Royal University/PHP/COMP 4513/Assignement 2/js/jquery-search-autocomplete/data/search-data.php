<?php

    /* Database setup information */
    $dbhost = 'localhost';  // Database Host
    $dbuser = 'root';       // Database Username
    $dbpass = '';           // Database Password
    $dbname = 'search';     // Database Name

    /* Connect to the database and select database */
    $conn = mysql_connect($dbhost, $dbuser, $dbpass) or die(mysql_error());
    mysql_select_db($dbname);

    /* The search input from user ** passed from jQuery .get() method */
    $param = $_GET["searchData"];

    /* If connection to database, run sql statement. */
    if ($conn) {

        /* Fetch the users input from the database and put it into a
         valuable $fetch for output to our table. */
        $fetch = mysql_query("SELECT * FROM customers WHERE name REGEXP '^$param' OR email REGEXP '^$param' OR phone REGEXP '^$param'");

        /*
           Retrieve results of the query to and build the table.
           We are looping through the $fetch array and populating
           the table rows based on the users input.
         */
        while ( $row = mysql_fetch_object( $fetch ) ) {
            $sResults .= '<tr id="'. $row->id . '">';
            $sResults .= '<td>' . $row->name . '</td>';
            $sResults .= '<td>' . $row->address . '</td>';
            $sResults .= '<td>' . $row->phone . '</td>';
            $sResults .= '<td>' . $row->email . '</td></tr>';
        }

    }

    /* Free connection resources. */
    mysql_close($conn);

    /* Toss back the results to populate the table. */
    echo $sResults;

?>