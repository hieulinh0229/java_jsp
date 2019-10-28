<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang chủ</title>
    <link rel="shortcut icon" type="image" href="<c:url value = "/template/user/images/ic.ico"/>">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
    <link href="<c:url value='/template/user/style/detail.css' />" rel="stylesheet" type="text/css" media="all"/>
    <link href="<c:url value='/template/user/style/style.css' />" rel="stylesheet" type="text/css" media="all"/>
</head>
<body>
<header>
    <div class="container" >
        <div>
            <div class="row">

                <div class="col-lg-2 col-xs-4 col-sm-4 logo flex">
                    <a href="/product"><img src="<c:url value='/template/user/images/logo.png'/>" ></a>

                    <div class="hidden-md hidden-lg hidden-sm col-xs-offset-5" >
                        <div class="dropdown drop_xs" >
                            <button class="btn btn-default dropdown-toggle color_but" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                <i class="fas fa-bars"></i>

                            </button>
                            <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenu1">
                                <li class="active_xs ">
                                    <a href="index.html">Home</a>
                                </li>
                                <li class="dropdown ">
                                    <a class="dropdown-toggle" href="categories1.html">Categories
                                        <span class="caret"></span>
                                    </a>

                                    <ul class="dropdown-menu1">
                                        <li><a href="jewelry.html">Jewelry</a></li>
                                        <li><a href="skin.html">Skin</a></li>
                                        <li><a href="make_up_kits.html">Make-up Kits</a></li>
                                        <li><a href="nail_paints.html">Nail Paints</a></li>
                                        <li><a href="nail_arts.html">Nail Arts</a></li>
                                        <li><a href="hair.html">Hair</a></li>
                                        <li><a href="wedding_kits.html">Wedding Kits</a></li>
                                        <li><a href="upcoming_products.html">Upcoming Products</a></li>
                                    </ul>
                                </li>
                                <li class=""><a href="news.html">News</a></li>
                                <li class=""><a href="gallery.html">Gallery</a></li>
                                <li class=""><a href="about_us.html">About Us</a></li>
                                <li class=""><a href="contact_us.html">Contact Us</a></li>
                            </ul>
                        </div>
                    </div>
                </div>




                <div class="col-lg-4 col-lg-push-6 col-xs-12 col-sm-8 flex col4">

                    <div class="buy">
                        <div>
                            <i class="fas fa-cart-arrow-down"></i>
                        </div>
                        <div class="buy1" >
                            <div><a href="/views/cart/index.jsp">Shopping cart</a></div>
                            <div>
                                <span class="">${quantityProductInCart} product</span>
                            </div>
                        </div>
                    </div>
                    <div class="user">
                        <div>
                            <i class="far fa-user"></i>
                        </div>
                        <div class="user1">
                            <c:if test="${not empty username}">
                                <div><a class="nonlist" href='#'>${username}</a></div>
                                <div><a href='<c:url value="/thoat?action=logout"/>'>Logout</a></div>
                            </c:if>

                            <c:if test="${empty username}">
                                <div><a href='<c:url value="/dang-nhap?action=login"/>'>Login</a></div>
                                <div><a href='<c:url value="/admin-users?action=register"/>'>Register</a></div>
                            </c:if>
                        </div>
                    </div>

                </div>
                <div class="col-lg-6 col-lg-pull-4 col-xs-12 col6" >
                    <form method="get" action="search">
                        <div class="flex">
                            <div class="hidden-xs dropdown input-group-btn" >

                                <select class="form-control" id="sel1" name="id" required >

                                    <c:forEach items='${requestScope["categories"]}' var="categories" >
                                    <option value="${categories.getId_categories()}">${categories.getName_categories()}</option>
                                    </c:forEach>
                                </select>

                            </div>
                            <div class="form-group ">
                                <input  type="text" class="form-control" name="keyword" id="usr" placeholder="Search product..." required >
                            </div>
                            <div class="input-group-btn ">
                                <button class="btn">
                                    <b>Search</b>
                                </button>
                            </div>
                        </div>
                    </form>

                </div>
            </div>
        </div>

        <nav class="nav1 row">
            <div class="navbar col-md-9 col-sm-10 hidden-xs">
                <div class="container-fluid">
                    <div class="navbar-header hidden-xs hidden-sm hidden-md">
                        <span class="navbar-brand ">BEAUTY-CARE</span>
                    </div>
                    <ul class="nav navbar-nav" >
                        <li class="active">
                            <a href="/product">Home</a>
                        </li>
                        <li class="nav2"><a href="about_us.html">News</a></li>
                        <li class="nav2"><a href="about_us.html">Gallery</a></li>
                        <li class="nav2"><a href="about_us.html">About Us</a></li>
                        <li class="nav2"><a href="contact_us.html">Contact Us</a></li>
                    </ul>
                </div>
            </div>

            <div class="hotl col-md-3 hidden-xs hidden-sm">
                <div class="hotl1">
                    <img src="<c:url value='/template/user/images/phone.png'/>">
                </div>
                <div class="hotl0 flex">
                    <span class="hotl2">Hotline:</span>&nbsp;
                    <span class="hotl3"> +849998888</span>
                </div>
            </div>

            <div class="col-sm-2 hidden-xs hidden-md hidden-lg hotl0">


                <div class="hotl2_xs">Hotline:</div>
                <div class="hotl3_xs"> +849998888</div>

            </div>
        </nav>
    </div>
</header>

</body>
</html>
