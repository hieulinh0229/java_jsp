<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 7/4/2019
  Time: 8:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông tin chi tiết sản phẩm</title>
    <link rel="shortcut icon" type="image" href="<c:url value = "/template/user/images/ic.ico"/>">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
    <link href="<c:url value='/template/user/style/style.css' />" rel="stylesheet" type="text/css" media="all"/>
    <link href="<c:url value='/template/user/style/detail.css' />" rel="stylesheet" type="text/css" media="all"/>
    <link href="<c:url value='/template/user/style/etalage.css' />" rel="stylesheet" type="text/css" media="all"/>
    <script type="text/javascript" src="/template/user/b_j/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/template/user/b_j/js/bootstrap.min.js"></script>

</head>
<body>
<!-- header -->
<%@ include file="/common/user/header.jsp" %>
<!-- header -->
<div class="container">
    <div class="backgr">


    </div>
</div>

<!-- Content -->
<div class="content">
    <div class="container">

        <div class="">
            <div class="col-md-9 col-sm-9- col-xs-12">
                <div class="row">
                    <div class="single_grid">
                        <div class="col-md-3 col-sm-12 col-xs-12 grid images_3_of_2">
                            <a href="/product?action=view&id=${product.getId_product()}"><img style="width: 325px;height: 400px"  src="${product.getImage()}"></a>

                        </div>
                        <div class="col-md-6 col-sm-12 col-xs-12 span1_of_1_des">
                            <div class="desc1">
                                <h2 > ${product.getName_product()}</h2>
                                <div class="products2_4">
                                    <span class="price-old">30 USD</span>
                                    <span>${product.getAmount()} USD</span>
                                </div>
                                <div class="status">Status: &nbsp <span>available</span></div>
                                <div class="inf-pro">
                                    <ul>
                                        <li>Brand: other</li>
                                        <li>Product line: other</li>
                                        <li>Free shipping</li>
                                        <li>10% discount when buying online</li>
                                    </ul>
                                </div>
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="input-quantity">

                                            <div class="custom input_number_product custom-btn-number">
                                                <button class="btn_num num_1 button button_qty" onclick="var result = document.getElementById('qtym'); var qtypro = result.value; if( !isNaN( qtypro ) &amp;&amp; qtypro > 1 ) result.value--;return false;" type="button">-</button>
                                                <input type="text" id="qtym" name="quantity" value="1" onkeyup="valid(this,'numbers')" onkeypress="validate(event)" class="form-control prd_quantity">
                                                <button class="btn_num num_2 button button_qty" onclick="var result = document.getElementById('qtym'); var qtypro = result.value; if( !isNaN( qtypro )) result.value++;return false;" type="button">+</button>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-2 button_detail" style="top: 257px;">

                                        <button type="button" class="btn cart btn-info btn-lg" data-toggle="modal" data-target="#myModal" data-price="20" >
                                            <i class="fas fa-shopping-bag"></i>
                                            <a href="/cart?action=addInCart&id=${product.getId_product()}"><span class="cart1">Add To Cart</span> </a>
                                        </button>

                                    </div>
                                </div>

                                <div class="share-desc">
                                    <div class="share">
                                        <h4>Share Product :</h4>
                                        <ul class="share_nav">
                                            <li><a href="#"><img src="/template/user/images/facebook.png" title="facebook"></a></li>
                                            <li><a href="#"><img src="/template/user/images/twitter.png" title="Twitter"></a></li>
                                            <li><a href="#"><img src="/template/user/images/rss.png" title="Rss"></a></li>
                                            <li><a href="#"><img src="/template/user/images/gpluse.png" title="Google+"></a></li>
                                        </ul>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="tab-select-inf">
                    <ul class="nav nav-tabs">
                        <li class="active">
                            <a data-toggle="tab" href="#menu1" >Product Information</a>
                        </li>
                        <li>
                            <a data-toggle="tab" href="#menu2">Shopping Guide</a>
                        </li>
                    </ul>

                    <div class="tab-content">
                        <div id="menu1" class="tab-pane fade in active">
                            <table class="table table-striped">	<br>
                                <p>Maybelline Bitten 3.9g - Unique three-color texture that creates a trendy 3D ombre effect, vivid colors for a naturally beautiful lips. Ultra creamy formula moisturizes lips for 12 hours.</p>
                                <p class="font-bolt">Product features:</p>
                                <p>Water color effects create vivid colors for beautiful natural lips.</p>
                                <p>Ultra Creamy formula gives lips a full, moisturizing lips for 12 hours.</p>
                                <p>3 Shades OMBRE color from dark to light in 1 lipstick to create ombre lip effect with just 1 lipstick.</p>
                                <p class="font-bolt">Suitable skin type:</p>
                                <p>Suitable for all skin types.</p>
                                <p class="font-bolt">Description</p>
                                <p>${product.getDescription()}</p>


                            </table>
                        </div>
                        <div id="menu2" class="tab-pane fade">
                            <h3>Shopping Guide</h3>
                            <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
                        </div>
                    </div>

                </div>
            </div>

        </div>

        <aside class="col-md-3 mar_top">

            <div class="news-asi-bottom mar">
                <div class="tit-news">
                    <div class="tit-news-text">Categories</div>
                    <div class="line"></div>
                </div>
                <div>
                    <ul>
                        <li><a href="categories1.html"><i class="fas fa-chevron-circle-right"></i>
                            <span >All Products</span>
                        </a></li>
                        <li><a href="jewelry.html"><i class="fas fa-chevron-circle-right"></i> Jewelry</a></li>
                        <li><a href="skin.html"><i class="fas fa-chevron-circle-right"></i>
                            <span >Skin</span></a></li>
                        <li><a href="make_up_kits.html"><i class="fas fa-chevron-circle-right"></i>
                            <span style="color: #EC407A; font-weight: bold;">Make-up Kits</span></a></li>
                        <li><a href="nail_paints.html">
                            <i class="fas fa-chevron-circle-right"></i>
                            Nail Paints
                        </a></li>
                        <li><a href="nail_paints.html"><i class="fas fa-chevron-circle-right"></i> Nail Arts</a></li>
                        <li><a href="hair.html"><i class="fas fa-chevron-circle-right"></i> Hair</a></li>
                        <li><a href="wedding_kits.html"><i class="fas fa-chevron-circle-right"></i> Wedding Kits</a></li>
                        <li><a href="upcoming_products.html"><i class="fas fa-chevron-circle-right"></i> Upcoming Products</a></li>

                    </ul>

                </div>
            </div>

        </aside>
    </div>

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
<script  src="<c:url value='/template/user/b_j/js/jquery.etalage.min.js' />"></script>
</body>
</html>
