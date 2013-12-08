<%@ Page Language="VB" AutoEventWireup="false" CodeFile="Part02_SingleArtist.aspx.vb" Inherits="Part02_SingleArtist" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1" runat="server">
    http://localhost:11250/COMP3512-assign1_trop315/Default.aspx#about
    <title>COMP 3532 - Assign #1 | Single Artist (Part 2)</title>
   
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


    <!--Container for Spacing-->
    <div class="topSpacing"></div>


    <div class="container">
        <!--changed from 10-->
        <div class="col-lg-12">
            <asp:Repeater ID="skuTest" runat="server"  DataSourceID="selectedArtist">
                <ItemTemplate>
                    <!--overall upper artist info content holder-->
                    <div class="col-lg-12">
                    
                    <!--Artist name-->
                    <h2><%# Eval("FirstName")%> <%# Eval("LastName")%></h2>
                    
                        <br />

                       
                        <!--Artist picture col-xs-4 col-sm-4 col-md-4 col-lg-4-->
                        <img src="art-images/artists/medium/<%# Eval("ArtistID")%>.jpg" 
                             alt="<%# Eval("FirstName")%>  <%# Eval("LastName")%>"
                             class="noLeftPadding col-xs-12 col-sm-4 col-md-4 col-lg-4"/>
                      
                        <!--Artist description-->
                        <div class="col-xs-12 col-sm-8 col-md-8 col-lg-8">
                            <!--artist description-->
                            <p><%# Eval("Details")%></p>

                            <!--Favorites link-->
                            <asp:HyperLink ID="FavoritesLink" runat="server" CssClass="btn btn-default blueLinks" NavigateUrl="#">
                                <span class="glyphicon glyphicon-heart blueLinks"></span> Add to Favorites
                            </asp:HyperLink>

                            <br />
                            <br />

                            <!--Panel for Artist Details-->
                            <div class="panel panel-default">
                                <div class="panel-heading noMargins boldText leftPadEightPix">Artist Details</div>
                                
                                <!-- Table -->
                                <table class="table">
                                    <!--Date-->
                                    <tr class="col-xs-12 col-sm-12 col-md-12">
                                        <td class="col-sm-3 boldText">Date:</td>
                                        <td class="col-sm-3"><%# Eval("YearOfBirth")%> - <%# Eval("YearOfDeath")%></td>
                                    </tr>

                                    <!--Nationality-->
                                    <tr class="col-xs-12 col-sm-12 col-md-12">
                                        <td class="col-sm-3 boldText">Nationality:</td>
                                        <td class="col-sm-3"><%# Eval("Nationality")%></td>
                                    </tr>

                                    <!--Wikipedia Link-->
                                    <tr class="col-xs-12 col-sm-12 col-md-12">
                                        <td class="col-sm-3 boldText">More Info:</td>
                                        <td class="col-sm-3"><a href="<%# Eval("ArtistLink")%>"><%# Eval("ArtistLink")%></a></td>
                                    </tr>
                                </table>
                                
                            <!--End of panel panel-default-->
                            </div>
                            
                        <!--End of col-xs-12 col-sm-6 col-md-8 col-lg-8-->                          
                        </div>  
                   </div>                              
                                   
                </ItemTemplate>              
            </asp:Repeater>
            

            <!--spacing container-->            
            <div class="clearfix"></div>
            
            <!--Art by container-->   
            <div class="col-lg-12">
                <asp:Repeater ID="ArtByRepeater" runat="server" DataSourceID="selectedArtist">
                    <ItemTemplate>
                        <h4 class="noLeftPadding">Art by <%# Eval("FirstName")%> <%# Eval("LastName")%></h4>
                    </ItemTemplate>
                </asp:Repeater>
            </div>


            <!--Prints out all ArtWorks by the painter-->
            <div class="col-lg-12">
                <asp:Repeater ID="ArtworksRepeater" runat="server" DataSourceID="paintingsByArtist">
                    <ItemTemplate>
                        <div class="thumbnail col-xs-12 col-sm-2 col-md-3 col-lg-2 singlePaintingByArtist overFlow">
                            <!--ArtWork image-->
                            <a href="Part03_SingleWork.aspx?ArtWorkID=<%# Eval("ArtWorkID")%>">
                                <img src="art-images/works/square-medium/<%# Eval("ImageFileName")%>.jpg" alt="<%# Eval("Title")%>" class="thumbnail singlePaintingByArtistIMG" />
                            </a>

                            <br />

                            <!--ArtWork title-->
                            <a href="Part03_SingleWork.aspx?ArtWorkID=<%# Eval("ArtWorkID")%>"><%# Eval("Title")%></a>

                            <br />
                            <br />

                            <!--ArtWork buttons-->
                            <!--View link-->
                            <a href="Part03_SingleWork.aspx?ArtWorkID=<%# Eval("ArtWorkID")%>"class="btn btn-primary btn-xs">
                                <span class="glyphicon glyphicon-info-sign"></span> View
                            </a>

                            <!--Wish link-->
                            <a href="#"class="btn btn-success btn-xs">
                                <span class="glyphicon glyphicon-gift"></span> Wish
                            </a>

                            <!--Wish link-->
                            <a href="#"class="btn btn-info btn-xs">
                                <span class="glyphicon glyphicon-shopping-cart"></span> Cart
                            </a>

                        

                        <!--End of thumbnail-->
                        </div>
                    </ItemTemplate>
                </asp:Repeater>
            <!--End of col-lg-12-->
            </div>






        <!--End of row-->
        </div>
        

    <!--End of container-->
    </div> 
        
        <!--Artist info data source-->
        <asp:SqlDataSource ID="selectedArtist" runat="server" 
                           ConnectionString="<%$ ConnectionStrings:ConnectionString %>" 
                           SelectCommand="SELECT FirstName, LastName, ArtistID, Details, YearOfBirth, YearOfDeath, Nationality, ArtistLink FROM [Artists] WHERE ArtistID=@qweryID"
                           ProviderName="<%$ ConnectionStrings:ConnectionString.ProviderName %>">

            <SelectParameters>
                <asp:QuerystringParameter Name="qweryID" QueryStringField="ArtistID" DefaultValue="19" />
            </SelectParameters>
        </asp:SqlDataSource> 



        <!--Artist painting data source-->
        <asp:SqlDataSource ID="paintingsByArtist" 
                           runat="server" 
                           ConnectionString="<%$ ConnectionStrings:ConnectionString %>" 
                           SelectCommand="SELECT ArtWorkID, ImageFileName, Title FROM [ArtWorks] WHERE ArtistID=@qweryID"
                           ProviderName="<%$ ConnectionStrings:ConnectionString.ProviderName %>">

            <SelectParameters>
                <asp:QuerystringParameter Name="qweryID" QueryStringField="ArtistID" DefaultValue="19" />
            </SelectParameters>
        </asp:SqlDataSource>

    </form>

   <!-- Bootstrap core JavaScript
   ================================================== -->
   <!-- Placed at the end of the document so the pages load faster -->
   <script src="bootstrap-3.0.0/assets/js/jquery.js"></script>
   <script src="bootstrap-3.0.0/dist/js/bootstrap.min.js"></script>


</body>
</html>
