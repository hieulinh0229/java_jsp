<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tìm kiếm</title>
    <link rel="shortcut icon" type="image" href="<c:url value = "/template/user/images/ic.ico"/>">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
    <link href="<c:url value='/template/user/style/style.css' />" rel="stylesheet" type="text/css" media="all"/>
    <link href="<c:url value='/template/user/style/detail.css' />" rel="stylesheet" type="text/css" media="all"/>

</head>
<body>
<%@ include file="/common/user/header.jsp" %>


<!-- header -->
<div class="container">
    <%--    <ul class="nav nav-tabs " >--%>
    <%--        <li class="active col-xs-4 col-md-3 col-sm-4">--%>
    <%--            <a data-toggle="tab" href="#menu3"><span class="tab1"><b>Selling Products</b></span></a>--%>

    <%--        </li>--%>
    <%--        <li class="col-xs-4 col-md-3 col-sm-4"><a data-toggle="tab" href="#menu1"><span class="tab1"><b>New Products</b></span></a></li>--%>
    <%--        <li class="col-xs-4 col-md-3 col-sm-4"><a data-toggle="tab" href="#menu2"><span class="tab1"><b>Most view</b></span></a></li>--%>

    <%--    </ul>--%>

</div>
<div class="container products2">
    <div >
        <div>
            <div class="menu3">Kết quả tìm kiếm</div>
        </div>

        <div class="line"></div>

        <div  class="products2_1 hidden-xs hidden-sm">
            <p style="font-size: 20px">Tìm thấy ${sumResult} kết quả </p>
            <c:forEach items='${requestScope["products"]}' var="product" >
                    <div class="col-md-2 bordershadow">
                        <div class="products2_2">
                            <a href="/product?action=view&id=${product.getId_product()}"><img class="product" src="${product.getImage()}"></a>
                        </div>
                        <div class="products2_3">
                            <div>
                                <a href="/product?action=view&id=${product.getId_product()}">
                                    <span class="product-name">${product.getName_product()} </span></a>
                            </div>
                            <div class="products2_4">
                                <span>${product.getAmount()} USD</span>
                            </div>
                            <div>
                                <button type="button" class="btn cart btn-info btn-lg"
                                        data-toggle="modal" data-target="#myModal" data-price="98">
                                    <i class="fas fa-shopping-bag"></i>
                                    <span class="cart1">Add To Cart</span>
                                </button>
                            </div>
                        </div>
                    </div>
            </c:forEach >
            <p class="alert-warning" style="font-size: 20px">${noResult}</p>
        </div>
    </div>
    <div class="container news">

    </div>
    <div class="container" id="popup">
        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h3 class="modal-title">Your cart</h3>
                    </div>
                    <div class="modal-body popup_center">
                        <p> <i class="fas fa-check"></i>  Your product has been added to the cart.</p>
                    </div>
                    <div class="modal-footer">
                        <a href="shopping_cart.html">
                            <button type="button" class="btn btn-default style_button">
                                Go to the cart
                            </button>
                        </a>
                        <button type="button" class="btn btn-default style_button" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <!-- footer -->
    <%@ include file="/common/user/footer.jsp" %>
    <!-- footer -->
    <script type="text/javascript" src="<c:url value='/template/user/b_j/js/create_js.js' />"></script>
</body>
</html>
