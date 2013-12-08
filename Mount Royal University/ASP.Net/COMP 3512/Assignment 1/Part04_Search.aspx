<%@ Page Language="VB" AutoEventWireup="false" CodeFile="Part04_Search.aspx.vb" Inherits="Part04_Search" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1" runat="server">
    http://localhost:11250/COMP3512-assign1_trop315/Default.aspx#about
    <title>COMP 3532 - Assign #1 | Artist Data List</title>
   
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" type="image/png" href="art-images/server_client_exchange.ico" />

    <!--Bootstrap-->
    <link href="bootstrap-3.0.0/dist/css/bootstrap.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
        <script src="bootstrap-3.0.0/assets/js/html5shiv.js" ></script>
        <script src="bootstrap-3.0.0/assets/js/respond.min.js"></script>
    <![endif]-->

    <!--Custom CSS styles-->
    <link href="bootstrap-3.0.0/customStyles.css" rel="stylesheet" />

</head>
<body>
    <form id="form1" runat="server">

    <!--Top navigation-->
    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <!--menu button for moile screen sizes-->
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                <!--End of navbar-toggle-->
                </button>
                
                <!--Assign 1 home link-->
                <asp:HyperLink ID="Assign1Link" runat="server" CssClass="navbar-brand" NavigateUrl="~/Default.aspx" Text="Assign 1" /> 
             
            <!--End of navbar-header-->
            </div>

            <!--Top nav menu-->
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><asp:HyperLink ID="HomeLink" runat="server" NavigateUrl="~/Default.aspx" Text="Home" /></li>
                    <li><asp:HyperLink ID="AboutLink" runat="server" NavigateUrl="~/AboutUs.aspx" Text="About Us" /></li>
                    
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Pages <b class="caret"></b></a>
                        <!--ASP CHANGE-->


                        <ul class="dropdown-menu">
                            <li><asp:HyperLink ID="ArtistsDataLink" runat="server" NavigateUrl="~/Part01_ArtistsDataList.aspx" Text="Artists Data List (Part 1)" /></li>
                            <li><asp:HyperLink ID="SingleArtistLink" runat="server" NavigateUrl="~/Part02_SingleArtist.aspx" Text="Single Artists (Part 2)" /></li>
                            <li><asp:HyperLink ID="SingleWorkLink" runat="server" NavigateUrl="~/Part03_SingleWork.aspx" Text="Single Work (Part 3)" /></li>
                            <li><asp:HyperLink ID="SearchLink" runat="server" NavigateUrl="~/Part04_Search.aspx" Text="Search (Part 4)" /></li>
                            <!--Dont need this code for now
                        <!--End of dropdown-menu-->
                        </ul>
                    <!--End of dropdown li-->
                    </li>
              <!--End of nav navbar-nav-->
              </ul>
              
              <!--Right search-->
              <div class="navbar-form navbar-right">
                    <!--Search box-->
                    <p id="nameBlock">Tyler Rop</p>
                    <div class="form-group">
                        <asp:TextBox Text="Search Paintings" ID="RightSearch" TextMode="SingleLine" runat="server" CssClass="form-control" />
                    <!--End of form-group-->
                    </div>
                    
                    <!--ASP CHANGE-->
                    <!--Search button-->
                    <asp:Button ID="RightSubmit" runat="server" Text="Search" CssClass="btn btn-primary" />
                    <!--End of search form-->
              </div>


            <!--End of navbar-collapse collapse-->  
            </div>
        <!--End of container-->    
        </div>
    <!--End of navbar navbar-inverse navbar-fixed-top-->
    </div>

    <!--Extra top spacing between navbar and content-->
    <br />
    <div class="topSpacing"></div>

    <div class="container">
        <div class="col-lg-10">
            <h1>Artist Data List (Part 1)</h1>
        

        
         <!--End of col-lg-10-->
        </div>

    <!--End of container-->
    </div>



    <asp:SqlDataSource ID="sqlArtists" 
                       runat="server" 
                       ConnectionString="<%$ ConnectionStrings:ConnectionString %>"
                       SelectCommand="SELECT * FROM [Artists] ORDER BY LastName"
                       ProviderName="<%$ ConnectionStrings:ConnectionString.ProviderName %>">
    </asp:SqlDataSource>


    </form>

   <!-- Bootstrap core JavaScript
   ================================================== -->
   <!-- Placed at the end of the document so the pages load faster -->
   <script src="bootstrap-3.0.0/assets/js/jquery.js"></script>
   <script src="bootstrap-3.0.0/dist/js/bootstrap.min.js"></script>


</body>
</html>
