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
<!-- header -->
<%@ include file="/common/user/header.jsp" %>
<!-- header -->

<div class="container">
    <div id="myCarousel" class="carousel slide">
        <!-- Menu -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <!-- Items -->
        <div class="carousel-inner">
            <!-- Item 1 -->
            <div class="item active">
                <img src="/template/user/images/sls1.png"/>
            </div>
            <!-- Item 2 -->
            <div class="item">
                <img src="/template/user/images/sls3.png"/>
            </div>
            <!-- Item 3 -->
            <div class="item">
                <img src="/template/user/images/sls2.png" />
            </div>
        </div>
    </div>
</div>


<%--<div class="container">--%>
<%--        <ul class="nav nav-tabs " >--%>
<%--            <li class="active col-xs-4 col-md-3 col-sm-4">--%>
<%--                <a data-toggle="tab" href="#menu3"><span class="tab1"><b>Selling Products</b></span></a>--%>

<%--            </li>--%>
<%--            <li class="col-xs-4 col-md-3 col-sm-4"><a data-toggle="tab" href="#menu1"><span class="tab1"><b>New Products</b></span></a></li>--%>
<%--            <li class="col-xs-4 col-md-3 col-sm-4"><a data-toggle="tab" href="#menu2"><span class="tab1"><b>Most view</b></span></a></li>--%>

<%--        </ul>--%>

<%--</div>--%>
<div class="container">
    <div id="banner" class="hidden-xs hidden-sm">
            <img style="height: 100%;width: 100%" src="/template/user/images/Banner1.png"/>
    </div>
</div>


<div class="container" class="products2">
    <div class="row">
        <div class="col-md-12">
            <div>
                <div>
                    <div class="menu3">Skin</div>
                </div>
                <div class="line"></div>
                <div  class="products2_1 hidden-xs hidden-sm">
                    <c:forEach items='${requestScope["products"]}' var="product" >
                        <c:if test="${product.getCategory_id()== 112}">
                            <div class="col-md-2 bordershadow box">
                                <div class="products2_2">
                                    <a href="/product?action=view&id=${product.getId_product()}"><img class="product" src="${product.getImage()}"></a>
                                </div>
                                <div class="products2_3">
                                    <div>
                                        <a href="/product?action=view&id=${product.getId_product()}"><span class="product-name">${product.getName_product()}</span></a>
                                    </div>
                                    <div class="products2_4">
                                        <span class="price-old">80 USD</span>
                                        <span>${product.getPrice()} USD</span>
                                    </div>
                                    <div>
                                        <button type="button" class="btn cart btn-info btn-lg"
                                                data-toggle="modal" data-target="#myModal" data-price="60">
                                            <i class="fas fa-shopping-bag"></i>
                                            <a href="/cart?action=addInCart&id=${product.getId_product()}"><span class="cart1">Add To Cart</span> </a>


                                        </button>
                                    </div>
                                </div>
                                <div class="ribbon"><span>Sale 25%</span></div>
                            </div>
                        </c:if>
                    </c:forEach >
                </div>
            </div>
        </div>
    </div>
</div>
    <%--Jewehy--%>
    <div class="container" class="products2">
    <div class="row">
        <div class="col-md-12">
            <div>
                <div>
                    <div class="menu3">Jewelry</div>
                </div>
                <div class="line"></div>
                <div  class="products2_1 hidden-xs hidden-sm">
                    <c:forEach items='${requestScope["products"]}' var="product" >
                        <c:if test="${product.getCategory_id()== 113}">
                            <div class="col-md-2 bordershadow box">
                                <div class="products2_2">
                                    <a href="/product?action=view&id=${product.getId_product()}"><img class="product" src="${product.getImage()}"></a>
                                </div>
                                <div class="products2_3">
                                    <div>
                                        <a href="/product?action=view&id=${product.getId_product()}"><span class="product-name">${product.getName_product()}</span></a>
                                    </div>
                                    <div class="products2_4">
                                        <span class="price-old">80 USD</span>
                                        <span>${product.getPrice()} USD</span>
                                    </div>
                                    <div>
                                        <button type="button" class="btn cart btn-info btn-lg"
                                                data-toggle="modal" data-target="#myModal" data-price="60">
                                            <i class="fas fa-shopping-bag"></i>
                                            <a href="/cart?action=addInCart&id=${product.getId_product()}"><span class="cart1">Add To Cart</span> </a>


                                        </button>
                                    </div>
                                </div>
                                <div class="ribbon"><span>Sale 25%</span></div>
                            </div>
                        </c:if>
                    </c:forEach >
                </div>
            </div>
        </div>
    </div>
    </div>
    <%--Nail Paints--%>
    <div class="container" class="products2">
        <div class="row">
            <div class="col-md-12">
                <div>
                    <div>
                        <div class="menu3">Nail Paints</div>
                    </div>
                    <div class="line"></div>
                    <div  class="products2_1 hidden-xs hidden-sm">
                        <c:forEach items='${requestScope["products"]}' var="product" >
                            <c:if test="${product.getCategory_id()== 114}">
                                <div class="col-md-2 bordershadow box">
                                    <div class="products2_2">
                                        <a href="/product?action=view&id=${product.getId_product()}"><img class="product" src="${product.getImage()}"></a>
                                    </div>
                                    <div class="products2_3">
                                        <div>
                                            <a href="/product?action=view&id=${product.getId_product()}"><span class="product-name">${product.getName_product()}</span></a>
                                        </div>
                                        <div class="products2_4">
                                            <span class="price-old">80 USD</span>
                                            <span>${product.getPrice()} USD</span>
                                        </div>
                                        <div>
                                            <button type="button" class="btn cart btn-info btn-lg"
                                                    data-toggle="modal" data-target="#myModal" data-price="60">
                                                <i class="fas fa-shopping-bag"></i>
                                                <a href="/cart?action=addInCart&id=${product.getId_product()}"><span class="cart1">Add To Cart</span> </a>


                                            </button>
                                        </div>
                                    </div>
                                    <div class="ribbon"><span>Sale 25%</span></div>
                                </div>
                            </c:if>
                        </c:forEach >
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%--Hair--%>
    <div class="container" class="products2">
        <div class="row">
            <div class="col-md-12">
                <div>
                    <div>
                        <div class="menu3">Hair</div>
                    </div>
                    <div class="line"></div>
                    <div  class="products2_1 hidden-xs hidden-sm">
                        <c:forEach items='${requestScope["products"]}' var="product" >
                            <c:if test="${product.getCategory_id()== 111}">
                                <div class="col-md-2 bordershadow box">
                                    <div class="products2_2">
                                        <a href="/product?action=view&id=${product.getId_product()}"><img class="product" src="${product.getImage()}"></a>
                                    </div>
                                    <div class="products2_3">
                                        <div>
                                            <a href="/product?action=view&id=${product.getId_product()}"><span class="product-name">${product.getName_product()}</span></a>
                                        </div>
                                        <div class="products2_4">
                                            <span class="price-old">80 USD</span>
                                            <span>${product.getPrice()} USD</span>
                                        </div>
                                        <div>
                                            <button type="button" class="btn cart btn-info btn-lg"
                                                    data-toggle="modal" data-target="#myModal" data-price="60">
                                                <i class="fas fa-shopping-bag"></i>
                                                <a href="/cart?action=addInCart&id=${product.getId_product()}"><span class="cart1">Add To Cart</span> </a>


                                            </button>
                                        </div>
                                    </div>
                                    <div class="ribbon"><span>Sale 25%</span></div>
                                </div>
                            </c:if>
                        </c:forEach >
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container pic1 hidden-xs hidden-sm">
        <div>
            <div class="hover15 pic2"><img src="/template/user/images/@3.png"></div>
            <div class="hover15"><img src="/template/user/images/@5.png"></div>
        </div>
        <div >
            <div class="hover15 pic3">
                <img src="/template/user/images/@4.jpg">
            </div>
        </div>
    </div>

    <div class="container hidden-md hidden-lg pic_xs">
        <div><img src="/template/user/images/@3.png"></div>
        <div><img src="/template/user/images/@5.png"></div>
    </div>

    <div class="container news">
        <div>
            <div class="menu3">News</div>
        </div>
        <div class="line"></div>
        <div  class="news ">
            <div class="col-md-4 col-xs-12 col-sm-6 bordershadow news1" >
                <div class="news4">
                    <div>
                        <a href="news3.html"><img src="/template/user/images/news1.jpg"></a>
                    </div>
                    <div class="news2">
                        <a href="news3.html">Care to have beautiful hands</a>
                    </div>
                    <div class="news3">
                        SIMPLON’s Beauty care centre is a founder and CEO of Glossier cosmetics for women. 8X is an influential figure in the fashion industry in general...
                    </div>
                </div>
                <div class="news5">
                    February 22th, 2019
                </div>
            </div>
            <div class="col-md-4 col-xs-12 col-sm-6 bordershadow news1" >
                <div class="news4">
                    <div>
                        <a href="news1.html"><img src="/template/user/images/news2.png"></a>
                    </div>
                    <div class="news2">
                        <a href="news1.html">Vitamin E and 10 beauty skin tools</a>
                    </div>
                    <div class="news3">
                        Vitamin E is an essential nutrient for skin health, it is considered a "medicinal god" in the care and maintenance of the youthful and...
                    </div>
                </div>
                <div class="news5">
                    February 20th, 2019
                </div>
            </div>
            <div class="col-md-4 col-xs-12 col-sm-6 bordershadow news1">
                <div class="news4">
                    <div>
                        <a href="news2.html"><img src="/template/user/images/news3.jpg"></a>
                    </div>
                    <div class="news2">
                        <a href="news2.html">4 Bright skin recipes from inside </a>
                    </div>
                    <div class="news3">
                        Today, there are many means, skin care beauty tools that help women become much more beautiful from the outside, but the...
                    </div>
                </div>
                <div class="news5">
                    February 21th, 2019
                </div>
            </div>
        </div>

    <!-- footer -->
    <%@ include file="/common/user/footer.jsp" %>
    <!-- footer -->

    <script type="text/javascript" src="<c:url value='/template/user/b_j/js/create_js.js' />"></script>
</body>
</html>
