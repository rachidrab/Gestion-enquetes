<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Portfolio Default | Triangle</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/lightbox.css" rel="stylesheet">  
        <link href="css/animate.min.css" rel="stylesheet"> 
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
    
        <!--[if lt IE 9]>
            <script src="js/html5shiv.js"></script>
            <script src="js/respond.min.js"></script>
        <![endif]-->       
        <link rel="shortcut icon" href="images/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
    </head><!--/head-->
    
    <body>
        <header id="header">      
            <div class="container">
                <div class="row">
                    <div class="col-sm-12 overflow">
                       <div class="social-icons pull-right">
                            <ul class="nav nav-pills">
                                <li><a href=""><i class="fa fa-facebook"></i></a></li>
                                <li><a href=""><i class="fa fa-twitter"></i></a></li>
                                <li><a href=""><i class="fa fa-google-plus"></i></a></li>
                                <li><a href=""><i class="fa fa-dribbble"></i></a></li>
                                <li><a href=""><i class="fa fa-linkedin"></i></a></li>
                            </ul>
                        </div> 
                    </div>
                 </div>
            </div>
            <div class="navbar navbar-inverse" role="banner">
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
    
                        <a class="navbar-brand" href="index.html">
                            <h1><img src="images/logo.png" alt="logo"></h1>
                        </a>
                        
                    </div>
                    <div class="collapse navbar-collapse">
                       <ul class="nav navbar-nav navbar-right">
                            <li><a >${user.prenom} ${user.nom}</a></li>
                            <li><a href="Home">MON PORTFOLIO</a></li>
                            <li><a href="Profil">MES INFORMATIONS</a></li>
                            <li><a href="Home.html">DECONNEXION</a></li>
                                 
                        </ul>
                    </div>
                
                </div>
            </div>
        </header>
        <!--/#header-->
    
    
        <section id="page-breadcrumb">
            <div class="vertical-center sun">
                 <div class="container">
                    <div class="row">
                        <div class="action">
                            <div class="col-sm-12">
                                <h1 class="title">Creer une Enquete</h1>
                                <p>Be Creative</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
       </section>
        <!--/#action-->
    
        <section id="portfolio">
            <div class="container">
                <div class="row">
                    <ul class="portfolio-filter text-center">
                      <li><a ></a></li>
                      
                    </ul><!--/#portfolio-filter-->
    
                    <div class="single-features">
                       
                        <div class="col-sm-5 wow fadeInRight" data-wow-duration="500ms" data-wow-delay="300ms">
                                <div class="contact-form bottom">
                                        <h2>Informations sur l'enquete</h2>
                                        <form  method="post" action="CreationEnquete">
                                            <div class="form-group">
                                            
                                                <input type="text" name="titre" class="form-control" required="required" placeholder="Titre">
                                            </div>
                                            <div class="form-group">
                                                    <input type="text" name="description" class="form-control" required="required" placeholder="Description">
                                                </div>
                                            <div class="form-group">
                                                    <input type="date" name="dateDebut" class="form-control" required="required" placeholder="Date de debut">
                                                </div>
                                                <div class="form-group">
                                                    <input type="date" name="dateFin" class="form-control" required="required" placeholder="Date de fin">
                                                </div>
                                                <div class="form-group">
                                                    <input type="text" name="nbQuestions" class="form-control" required="required" placeholder="Nombre de questions">
                                                </div>
                                                
                                                                   
                                            <div class="form-group">
                                                <input type="submit"  class="btn btn-submit" value="Go!">
                                            </div>
                                        </form>
                                       <c:if test="${not empty msg2}">
                                        <div class="alert alert-danger fade in">
                                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
                                            <h4>${msg2}</h4>
                                            <p></p>
                                        </div>
                                    </c:if>
                                    <c:if test="${not empty msg3}">
             
                                        <div class="alert alert-info fade in">
                                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
                                                <h4>${msg3}</h4>
                                                <p></p>
                                            </div>
                                    </c:if>
                                    </div>
                                  
                                
                        </div>
                    </div>
                         
                 
                </div>
            </div>
        </section>
        <!--/#portfolio-->
    
        <footer id="footer">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12 text-center bottom-separator">
                            <img src="images/home/under.png" class="img-responsive inline" alt="">
                        </div>
                        <div class="col-md-4 col-sm-6">
                         
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div >
                                <h2>Contacts</h2>
                                <address>
                                E-mail: <a href="mailto:someone@example.com">email@email.com</a> <br> 
                                Phone: +1 (123) 456 7890 <br> 
                                Fax: +1 (123) 456 7891 <br> 
                                </address>
        
                                <h2>Address</h2>
                                <address>
                                Unit C2, St.Vincent's Trading Est., <br> 
                                Feeder Road, <br> 
                                Bristol, BS2 0UY <br> 
                                United Kingdom <br> 
                                </address>
                            </div>
                            
                        </div>
                        <div class="col-md-4 col-sm-12">
                         
                        </div>
                        <div class="col-sm-12">
                            <div class="copyright-text text-center">
                                <p>&copy; EMSI. IIR4 G2.</p>
                                <p>Designed by <a target="_blank" href="http://www.themeum.com">Themeum</a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </footer>
        <!--/#footer-->
    
    
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/jquery.isotope.min.js"></script>
        <script type="text/javascript" src="js/lightbox.min.js"></script>
        <script type="text/javascript" src="js/wow.min.js"></script>
        <script type="text/javascript" src="js/main.js"></script>    
    </body>
    </html>
    