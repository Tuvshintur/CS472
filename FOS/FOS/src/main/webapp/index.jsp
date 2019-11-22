<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="theme-color" content="#e54c2a">
    <!-- Favicon -->
    <link type="image/x-icon" rel="shortcut icon" href="favicon.png">
    <title>STEAM - Restaurant and Drinks Responsive HTML5 Template</title>
    <meta name="description"
          content="STEAM - Restaurant, food and Drinks HTML5 website template is Modern, Clean and Professional site template. Prefect for RESTAURANT, Bakery, Cafe, Bar, Catering, food business and for personal chef portfolio website.">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <!-- Bootstrap stylesheet -->
    <link href="https://www.spheretheme.com/html/steam/assets/libs/bootstrap-4.0.0-dist/css/bootstrap.min.css"
          rel="stylesheet">
    <!-- icofont -->
    <link href="css/icofont.css" rel="stylesheet" type="text/css">
    <!-- crousel css -->
    <link href="https://www.spheretheme.com/html/steam/assets/libs/owlcarousel2/assets/owl.carousel.min.css"
          rel="stylesheet" type="text/css">
    <!-- Animated Headlines css -->
    <link href="https://www.spheretheme.com/html/steam/assets/libs/animated-headlines/animated-headlines.css"
          rel="stylesheet" type="text/css">
    <!-- mb.YTPlayer css -->
    <link href="https://www.spheretheme.com/html/steam/assets/libs/mb.YTPlayer/css/jquery.mb.YTPlayer.min.css"
          rel="stylesheet" type="text/css">
    <!-- Switch Style css -->
    <link href="https://www.spheretheme.com/html/steam/assets/switch-style/switch-style.css" rel="stylesheet"
          type="text/css">
    <!-- Theme Stylesheet -->
    <link href="https://www.spheretheme.com/html/steam/assets/css/style.css" rel="stylesheet" type="text/css">

    <!-- jquery -->
    <script src="js/jquery.min.js"></script>
    <!-- jquery Validate -->
    <script src="https://www.spheretheme.com/html/steam/assets/libs/jquery-validation/jquery.validate.min.js"></script>
    <!-- popper js -->
    <script src="https://www.spheretheme.com/html/steam/assets/libs/popper/popper.min.js"></script>
    <!-- bootstrap js -->
    <script src="https://www.spheretheme.com/html/steam/assets/libs/bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>
    <!-- owlcarousel js -->
    <script src="https://www.spheretheme.com/html/steam/assets/libs/owlcarousel2/owl.carousel.min.js"></script>
    <!--inview js code-->
    <script src="https://www.spheretheme.com/html/steam/assets/libs/jquery.inview/jquery.inview.min.js"></script>
    <!--CountTo js code-->
    <script src="https://www.spheretheme.com/html/steam/assets/libs/jquery.countTo/jquery.countTo.js"></script>
    <!-- Animated Headlines js code-->
    <script src="https://www.spheretheme.com/html/steam/assets/libs/animated-headlines/animated-headlines.js"></script>
    <!-- mb.YTPlayer js code-->
    <script src="https://www.spheretheme.com/html/steam/assets/libs/mb.YTPlayer/jquery.mb.YTPlayer.min.js"></script>
    <!-- Switch Style js -->
    <script src="js/switch-style.js"></script>
    <!--internal js-->
    <script src="https://www.spheretheme.com/html/steam/assets/js/internal.js"></script>
    <link href="css/custom.css" rel="stylesheet" type="text/css">
</head>

<body class="header-0 wide-layout">
<script type='text/javascript'>
	function addtocart(event, foodId, action){
		event = event || window.event;
		event.preventDefault();
		console.log("add to cart"+foodId);
		$.ajax({
	        url: "${pageContext.request.contextPath}/order?id="+foodId+"&action="+action,
	        type: "GET",
	        success: function (data) {
	        	console.log('SUCCESS');
	        	console.log(data);
	            $("#cartTost").html(data);
	        },
	        error: function(error) {
	            console.log(error);
	        }
	    });
	}
    $(document).ready(function() {
    	var sh = ${show ? true : false};
    	if(sh) {
    		$('#myModal').modal('show');
    	} else {
    		$('#myModal').modal('hide');
    	}
    	
        $('#mainFilter a').click(function () {
            var type = $(this).text();
            $('.loader').show();
            $.ajax({
                url: "${pageContext.request.contextPath}/main",
                type: "POST",
                data: {filter : type},
                success: function (data) {
                    console.log(data);

                    var html = '';

                    $.each(data, function (index,value) {
                        html += '                      <div class="col-md-6 col-sm-6 col-xs-12">\n' +
                            '                                            <div class="box">\n' +
                            '                                                <div class="image">\n' +
                            '                                                    <img src="${pageContext.request.contextPath}/upload?imageId=' + value.image_id +'" alt="image" title="image" class="img-fluid">\n' +
                            '                                                </div>\n' +
                            '                                                <div class="caption">\n' +
                            '                                                    <h4>' + value.name +'</h4>\n' +
                            '                                                    <p class="des">Type:' + value.type +'</p>\n' +
                            '                                                    <p class="des">' + value.calories +'kcal</p>\n' +
                            '                                                    <p class="des">Popularity: ' + value.order_count +' times ordered!</p>\n' +
                            '                                                    <span>' + value.description +'</span>\n' +
                            '                                                    <div class="price">$' + value.price +'</div>\n' +
                            '													<a class="order" href="#" onclick="addtocart(event, '+value.foodId+',\'add\')">Add</a>'+
                            '                                                </div>\n' +
                            '                                            </div>\n' +
                            '                                        </div>\n';
                    });

                    $('#foodContent').html(html);

                    $('.loader').hide();

                },
                error: function(error) {
                    console.log(error);
                }
            });
        });
        
        $('#mainFilter a').first().click();
        addtocart();
        $("#placeYourOrder").click(function() {
            $('html, body').animate({
                scrollTop: $("#mainFilter").offset().top
            }, 800);
        });
    });
</script>
<a href="#" class="bottom-top" style="display: block;"><i class="icofont icofont-bubble-up"></i></a>
<div class="wrapper">
    <!--[if lt IE 8]>
    <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a
            href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->

    <!-- Loader Start -->
    <div class="loader" style="display: none">
        <div class="loader-inner">
            <h4>Cooking in progress..</h4>
            <div id="cooking">
                <div class="bubble"></div>
                <div class="bubble"></div>
                <div class="bubble"></div>
                <div class="bubble"></div>
                <div class="bubble"></div>
                <div id="area">
                    <div id="sides">
                        <div id="pan"></div>
                        <div id="handle"></div>
                    </div>
                    <div id="pancake">
                        <div id="pastry"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Loader End -->

    <!--  Header Start  -->
    <header>
        <!--Top Header End -->

        <div class="container">
            <div class="row">
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <!-- Logo Start  -->
                    <div id="logo">
                        <!-- <a href="index.html"><img id="logo_img" class="img-fluid" src="./img/logo.png" alt="logo" title="logo"></a> -->
                    </div>
                    <!-- Logo End  -->
                </div>

                <div class="col-md-7 col-sm-6 col-xs-12 paddleft">
                    <!-- Main Menu Start  -->
                    <div id="menu">
                        <nav class="navbar navbar-expand-md">
                            <div class="navbar-header">
                                <span class="menutext d-block d-md-none">Menu</span>
                                <button data-target=".navbar-ex1-collapse" data-toggle="collapse" class="btn btn-navbar navbar-toggler" type="button">
                                    <i class="icofont icofont-navigation-menu"></i>
                                </button>
                            </div>
                            <div class="collapse navbar-collapse navbar-ex1-collapse padd0">
                                <ul class="nav navbar-nav">
                                    <li class="nav-item">
                                        <a href="#" data-toggle="dropdown">HOME</a>
                                    </li>
                                    <li class="nav-item"><a href="about.html">about us</a></li>
                                    <li class="nav-item dropdown"><a href="#" class="dropdown-toggle"
                                                                     data-toggle="dropdown">Our Menu</a>
                                        <div class="dropdown-menu">
                                            <div class="dropdown-inner">
                                                <ul class="list-unstyled">
                                                    <li><a href="menu1.html">Paleo</a></li>
                                                    <li><a href="menu2.html">Keto</a></li>
                                                    <li><a href="menu3.html">Vegan</a></li>
                                                    <li><a href="menu4.html">Gluten-Free</a></li>
                                                    <li><a href="menu5.html">Freestyle</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </li>


                                </ul>
                            </div>
                        </nav>
                    </div>
                    <!-- Main Menu End -->
                </div>
                <div class="col-md-2 col-sm-12 col-xs-12 button-top paddleft">
                    <a class="btn-primary btn" href="#mainFilter" id="placeYourOrder">Book Your Meal</a>
                </div>
            </div>
        </div>
    </header>
    <!-- Header End   -->

    <div class="bread-crumb">
        <div class="container">
            <div class="matter" style="width: 50vw; color: white;">
                <div class="cd-headline clip">
                    <h4>LOVES <span class="cd-words-wrapper" style="width: 81.743px; overflow: hidden;">
                                <b class="is-visible">HEALTHY</b>
                                <b class="is-hidden">QUALITY</b>
                                <b class="is-hidden">TESTY</b>
                            </span>FOOD</h4>
                </div>
            </div>
        </div>
    </div>
    <!-- Food Menu Start -->
    <div class="menu">
        <div class="menu-inner">
            <div class="container">
                <div class="row ">
                    <!-- Title Content Start -->
                    <div class="col-sm-12 col-xs-12 commontop text-center">
                        <h4>Our Menu</h4>
                        <div class="divider style-1 center">
                            <span class="hr-simple left"></span>
                            <i class="icofont icofont-ui-press hr-icon"></i>
                            <span class="hr-simple right"></span>
                        </div>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam efficitur placerat nulla, in
                            suscipit erat sodales id. Nullam ultricies eu turpis at accumsan. Mauris a sodales mi, eget
                            lobortis nulla.</p>
                    </div>
                    <!-- Title Content End -->
                    <div class="col-sm-12 col-xs-12">
                        <!--  Menu Tabs Start  -->
                        <ul class="nav nav-tabs list-inline" id="mainFilter">
                            <li class="nav-item">
                                <a class="nav-link active" href="#" data-toggle="tab" aria-expanded="true">all</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#breakfast" data-toggle="tab"
                                   aria-expanded="false">Paleo</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href='#Keto' data-toggle="tab" aria-expanded="false">Keto</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#dinner" data-toggle="tab" aria-expanded="false">Vegan</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#drinks" data-toggle="tab" aria-expanded="false">Gluten-Free</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#others" data-toggle="tab" aria-expanded="false">Freestyle</a>
                            </li>
                        </ul>
                        <!--  Menu Tabs Start  -->

                        <div class="tab-content">
                            <div class="tab-pane show active" id="all">
                                <div class="row" id="foodContent">

                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Food Menu End -->


    <!-- Footer Start -->
    <footer>

        <div class="footer-bottom">
            <div class="container">
                <div class="row powered">
                    <div class="col-md-12 col-sm-12 text-center order-md-1">
                        <p>WAP - Web Application Programming Aug, 2019</p>
                    </div>

                </div>
            </div>
        </div>
    </footer>
    <!-- Footer End  -->

</div>
<div id="cartTost"></div>
	<div id="myModal" class="modal fade in" style="display: none;">
	<div class="modal-dialog modal-confirm">
		<div class="modal-content">
			<div class="modal-header">
				<div class="icon-box">
					<i class="material-icons">check</i>
				</div>
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
			</div>
			<div class="modal-body text-center">
				<h4>Great!</h4>	
				<p><c:out value="${result}"/></p>
				<button class="btn btn-success" data-dismiss="modal"><span>See You Soon.</span> <i class="material-icons"></i></button>
			</div>
		</div>
	</div>
</div>
	<c:out value="${result}"/>
</body>

</html>
