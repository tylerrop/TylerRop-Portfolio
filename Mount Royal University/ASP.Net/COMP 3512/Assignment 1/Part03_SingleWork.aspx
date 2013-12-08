<%@ Page Language="VB" AutoEventWireup="false" CodeFile="Part03_SingleWork.aspx.vb" Inherits="Part03_SingleWork" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1" runat="server">
    http://localhost:11250/COMP3512-assign1_trop315/Default.aspx#about
    <title>COMP 3532 - Assign #1 | Single Work (Part 3)</title>
   
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <link rel="icon" type="image/png" href="art-images/server_client_exchange.ico" />

    <!--Bootstrap-->
    <link href="bootstrap-3.0.0/dist/css/bootstrap.css" rel="stylesheet"/>

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
        <!--changed from 10-->
        <div class="col-lg-12">
            <asp:FormView ID="singlePainting" runat="server"  DataSourceID="workData">
                <ItemTemplate>
                    <!--overall upper artist info content holder-->
                    <div class="col-lg-12">
                    
                    <!--Painting name-->
                    <h2><%# Eval("Title")%></h2>
                    
                        <!--ARTIST NAME LINK HERE-->
                        <p>By: <a href="Part02_SingleArtist.aspx?ArtistID=<%# Eval("ArtistID") %>"><%# Eval("FirstName") %> <%# Eval("LastName") %></a></p>

                       




                        <!--ArtWork Picture trigger modal -->
                        <a data-toggle="modal" href="#myModal">

                        <!--ArtWork picture col-xs-4 col-sm-4 col-md-4 col-lg-4-->
                        <img src="art-images/works/medium/<%# Eval("ImageFileName")%>.jpg" 
                             alt="<%# Eval("Title")%>"
                             class="noLeftPadding col-xs-12 col-sm-4 col-md-4 col-lg-4"/>
                        </a>



                          <!-- Modal -->
                          <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                              <div class="modal-content">
                                <div class="modal-header">
                                  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                  <h4 class="modal-title"><%# Eval("Title") %> by <%# Eval("FirstName") %> <%# Eval("LastName") %></h4>
                                </div>
                                <div class="modal-body">
                                   <img src="art-images/works/large/<%# Eval("ImageFileName")%>.jpg" alt="<%# Eval("Title")%>" class="modalPic"/>
                                </div>
                                <div class="modal-footer">
                                  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                  
                                </div>
                              </div><!-- /.modal-content -->
                            </div><!-- /.modal-dialog -->
                          </div><!-- /.modal -->
















                      
                        <!--ArtWork Info-->
                        <div class="col-xs-12 col-sm-8 col-md-8 col-lg-6">
                            <!--artist description paragraph-->
                            <p class="col-lg-12 noLeftPadding"><%# Eval("Description")%></p>

                            <!--Painting Price-->
                            <p class="redPrice"><%# Eval("MSRP", "{0:C}")%></p>


                            
                            <div class="btn-group">
                                 <!--Wish List link-->
                            <asp:HyperLink ID="HyperLink2" runat="server" CssClass="btn btn-default blueLinks" NavigateUrl="#">
                                <span class="glyphicon glyphicon-gift blueLinks"></span> Add to Wish List
                            </asp:HyperLink>

                            <!--Shoping Cart link-->
                            <asp:HyperLink ID="HyperLink3" runat="server" CssClass="btn btn-default blueLinks" NavigateUrl="#">
                                <span class="glyphicon glyphicon-shopping-cart blueLinks"></span> Add to Shopping Cart
                            </asp:HyperLink>
                            <!--End of btn-group-->
                            </div>

                            <br />
                            <br />

                            <!--Panel for ArtistWork Details-->
                            <div class="panel panel-default">
                                <div class="panel-heading noMargins leftPadEightPix">Product Details</div>
                                
                                <!-- Table -->
                                <table class="table">
                                    <!--Date-->
                                    <tr class="col-xs-12 col-sm-12 col-md-12">
                                        <td class="col-sm-3 boldText">Date:</td>
                                        <td class="col-sm-3"><%# Eval("YearOfWork")%></td>
                                    </tr>

                                    <!--Medium-->
                                    <tr class="col-xs-12 col-sm-12 col-md-12">
                                        <td class="col-sm-3 boldText">Medium:</td>
                                        <td class="col-sm-3"><%# Eval("Medium")%></td>
                                    </tr>

                                    <!--Dimension-->
                                    <tr class="col-xs-12 col-sm-12 col-md-12">
                                        <td class="col-sm-3 boldText">Dimension:</td>
                                        <td class="col-sm-3"><%# Eval("Width")%> cm x <%# Eval("Height")%> cm</td>
                                    </tr>

                                    <!--Home-->
                                    <tr class="col-xs-12 col-sm-12 col-md-12">
                                        <td class="col-sm-3 boldText">Home:</td>
                                        <td class="col-sm-3"><%# Eval("OriginalHome")%></td>
                                    </tr>

                                    <!--Genres NEEDS REPEATER-->
                                    <tr class="col-xs-12 col-sm-12 col-md-12">
                                        <td class="col-sm-3 boldText">Genres:</td>
                                        <td class="col-sm-3">
                                            <asp:Repeater runat="server" ID="PaintingGenres" DataSourceID="Genres">
                                                <ItemTemplate>
                                                    <a href="#"><%# Eval("GenreName")%></a><br />
                                                </ItemTemplate>
                                            </asp:Repeater>
                                         </td>
                                    </tr>

                                    <!--Subjects NEEDS REPEATER-->
                                    <tr class="col-xs-12 col-sm-12 col-md-12">
                                        <td class="col-sm-3 boldText">Subjects:</td>
                                        <td class="col-sm-3">
                                            <asp:Repeater ID="PaintingSubjects" runat="server" DataSourceID="Subjects">
                                                <ItemTemplate>
                                                    <a href="#"><%# Eval("SubjectName")%></a><br />
                                                </ItemTemplate>
                                            </asp:Repeater>
                                        </td>
                                    </tr>
                                </table>
                                
                            <!--End of panel panel-default-->
                            </div>
                            
                        <!--End of col-xs-12 col-sm-6 col-md-8 col-lg-8-->                          
                        </div>  


                       
                        <!--Sales Panel-->
                        <div class="col-xs-12 
                                    col-sm-8 col-sm-offset-4 
                                    col-md-8 col-md-offset-4 
                                    col-lg-2 col-lg-offset-0">
                            <div class="panel panel-info">
                                <div class="panel-heading noMargins leftPadEightPix">Sales</div>
                                    <table class="table">
                                            
                                        <asp:Repeater ID="SalesDates" runat="server" DataSourceID="OrderInfo">
                                            <ItemTemplate>
                                                <tr>
                                                    <td><a href="#"><%# Eval("DateCreated", "{0:M/dd/yyyy}") %></a></td>
                                                </tr>
                                            </ItemTemplate>
                                                    
                                         </asp:Repeater>
                                      </table>
                                  </div>
                                  
                            <!--End of panel oanel-info-->
                            </div>
                        <!--End of col-xs-12 col-sm-8 col-sm-offset-4 col-md-8 col-md-offset-4 col-lg-2 col-lg-offset-0 noLeftPadding" style="padding-left: 15px;-->
                        </div>                  


                                    
                                   
                </ItemTemplate>              
            </asp:FormView>
            

           


        <!--End of row-->
        </div>
        

    <!--End of container-->
    </div> 
        
        
       
        <!----------------------------------------------------------->
        <!-- WORK INFO DATA SOURCE used for formview-->
        <asp:SqlDataSource ID="workData" 
                           runat="server"
                           ConnectionString="<%$ ConnectionStrings:ConnectionString %>"
                           SelectCommand="SELECT works.*, 
                                          artist.FirstName, 
                                          artist.LastName FROM ArtWorks works, Artists artist WHERE works.ArtWorkID=?
                                         AND works.ArtistID=artist.ArtistID"
                           ProviderName="<%$ ConnectionStrings:ConnectionString.ProviderName %>">
            <SelectParameters>
                <asp:QueryStringParameter
                    Name="art"
                    QueryStringField="ArtWorkID"
                    Type="int32"
                    DefaultValue="394" />
             </SelectParameters>
        </asp:SqlDataSource>




        <!--Order Info data source-->
        <asp:SqlDataSource ID="OrderInfo" 
                           runat="server"
                           ConnectionString="<%$ ConnectionStrings:ConnectionString %>"
                           SelectCommand="SELECT ord.DateCreated FROM Orders ord, OrderDetails det 
                                          WHERE det.ArtWorkID=? AND 
                                          det.OrderID=ord.OrderID"
                           ProviderName="<%$ ConnectionStrings:ConnectionString.ProviderName %>">
            <SelectParameters>
                <asp:QueryStringParameter
                    Name="art"
                    QueryStringField="ArtWorkID"
                    Type="int32"
                    DefaultValue="394" />
            </SelectParameters>
        </asp:SqlDataSource>



         <!--Genres data source-->
         <asp:SqlDataSource ID="Genres" 
                           runat="server"
                           ConnectionString="<%$ ConnectionStrings:ConnectionString %>"
                           SelectCommand="SELECT g.GenreName FROM Genres g, ArtWorkGenres a 
                                          WHERE a.ArtWorkID=? AND 
                                          g.GenreID=a.GenreID"
                           ProviderName="<%$ ConnectionStrings:ConnectionString.ProviderName %>">
             <SelectParameters>
                 <asp:QueryStringParameter
                    Name="art"
                    QueryStringField="ArtWorkID"
                    Type="int32"
                    DefaultValue="394" />
             </SelectParameters>
         </asp:SqlDataSource>



         <!--Subjects data source-->
         <asp:SqlDataSource ID="Subjects" 
                           runat="server"
                           ConnectionString="<%$ ConnectionStrings:ConnectionString %>"
                           SelectCommand="SELECT s.SubjectName FROM Subjects s, ArtWorkSubjects a 
                                          WHERE a.ArtWorkID=? AND 
                                          s.SubjectID=a.SubjectID"
                           ProviderName="<%$ ConnectionStrings:ConnectionString.ProviderName %>">
             <SelectParameters>
                 <asp:QueryStringParameter
                    Name="art"
                    QueryStringField="ArtWorkID"
                    Type="int32"
                    DefaultValue="394" />
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