<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>jQuery Search Autocomplete</title>

    <style type="text/css" title="currentStyle">
                @import "css/grid_sytles.css";
                @import "css/themes/smoothness/jquery-ui-1.8.4.custom.css";
    </style>

    <!-- jQuery libs -->
    <script  type="text/javascript" src="js/jquery-1.6.1.min.js"></script>
    <script  type="text/javascript" src="js/jquery-ui-1.7.custom.min.js"></script>

    <script  type="text/javascript" src="js/jquery-search.js"></script>

</head>
<body>

<div id="container">

    <div id="dataTable">

        <div class="ui-grid ui-widget ui-widget-content ui-corner-all">

            <div class="ui-grid-header ui-widget-header ui-corner-top clearfix">

                <div class="header-left">
                    <!-- Left side of table header -->
                </div>

                <div class="header-right">
                    Search: <input style="width:150px;" id="searchData" type="text"></div>
                </div>

            <table class="ui-grid-content ui-widget-content cStoreDataTable" id="cStoreDataTable">
                <thead>
                    <tr>
                        <th class="ui-state-default">Name</th>
                        <th class="ui-state-default">Address</th>
                        <th class="ui-state-default">Phone</th>
                        <th class="ui-state-default">email</th>
                    </tr>
                </thead>
                <tbody id="results"></tbody>
            </table>
            <div class="ui-grid-footer ui-widget-header ui-corner-bottom">
                <div class="grid-results">Results </div>
            </div>
        </div>
    </div>

</div>

</body>
</html>