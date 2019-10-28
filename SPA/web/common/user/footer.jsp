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
<footer class="container-fluid">
    <div class="container hidden-xs">
        <div class="ft-top ">
            <div class="row">
                <div class="col-md-3 col-sm-3 col-xs-6 ft-top-content">
                    <div class="row">
                        <div class="col-md-4 col-sm-4 col-xs-5 ">
                            <i class="fas fas2 fa-shuttle-van"></i>
                        </div>
                        <div class="col-md-8 col-sm-8 col-xs-7">
                            <h4>Free shipping</h4>
                            <span class="hidden-xs">for orders from 50 USD</span>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-3 col-xs-6 ">
                    <div class="row">
                        <div class="col-md-4 col-sm-4 col-xs-5">
                            <i class="fas fas2 fa-sync"></i>
                        </div>
                        <div class="col-md-8 col-sm-8 col-xs-7">
                            <h4>Refund</h4>
                            <span class="hidden-xs">100% after 30 days of purchase</span>
                        </div>
                    </div>
                </div>

                <div class="col-md-3 col-sm-3 col-xs-6 ft-top-content1">
                    <div class="row">
                        <div class="col-md-4 col-sm-4 col-xs-5">
                            <i class="fas fas2 fa-headphones"></i>
                        </div>
                        <div class="col-md-8 col-sm-8 col-xs-7">
                            <h4>Friendly support</h4>
                            <span class="hidden-xs">24/7 support</span>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-3 col-xs-6 ft-top-content1">
                    <div class="row">
                        <div class="col-md-4 col-sm-4 col-xs-5 ">
                            <i class="fas fas2 fa-shield-alt"></i>
                        </div>
                        <div class="col-md-8 col-sm-8 col-xs-7">
                            <h4>Pay</h4>
                            <span class="hidden-xs">Payment security</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="container hidden-lg hidden-md hidden-sm" >
        <div class="ft-top-xs ">
            <div class="col-xs-6">

                <div class="row" >
                    <div class="col-md-4 col-sm-4 col-xs-5 ">
                        <i class="fas fas2 fa-shuttle-van"></i>
                    </div>
                    <div class="col-md-8 col-sm-8 col-xs-7">
                        <h4>Free shipping</h4>
                        <span class="hidden-xs">for orders from 50 USD</span>
                    </div>
                </div>


                <div class="row ft-xs">
                    <div class="col-md-4 col-sm-4 col-xs-5">
                        <i class="fas fas2 fa-sync"></i>
                    </div>
                    <div class="col-md-8 col-sm-8 col-xs-7">
                        <h4>Refund</h4>
                        <span class="hidden-xs">100% after 30 days of purchase</span>
                    </div>
                </div>

            </div>
            <div class="col-xs-6 " >

                <div class="row ft-top-content1">
                    <div class="col-md-4 col-sm-4 col-xs-5">
                        <i class="fas fas2 fa-headphones"></i>
                    </div>
                    <div class="col-md-8 col-sm-8 col-xs-7">
                        <h4>Friendly support</h4>
                        <span class="hidden-xs">24/7 support</span>
                    </div>
                </div>


                <div class="row ft-xs ft-top-content1">
                    <div class="col-md-4 col-sm-4 col-xs-5 ">
                        <i class="fas fas2 fa-shield-alt"></i>
                    </div>
                    <div class="col-md-8 col-sm-8 col-xs-7">
                        <h4>Pay</h4>
                        <span class="hidden-xs">Payment security</span>
                    </div>
                </div>

            </div>
        </div>
    </div>


    <div class="row ft-content">
        <div class="col-md-4 col-xs-12 ft1 hidden-xs hidden-sm">
            <div class="item-content-ft">
                <div class="menu4">Contact information</div>
                <div class="line"></div>
                <p>
                    <i class="fas fas2 fa-home"></i><span> Address: 28 Nguyen Tri Phuong, Hue City</span>
                </p>
                <p>
                    <i class="fas fas2 fa-phone"></i><span> Tel: +849998888</span>
                </p>
                <p>
                    <i class="fas fas2 fa-envelope-open"></i><span> Email: support@simplon.com</span>
                </p>
            </div>
        </div>

        <div class="col-md-4 col-sm-3 col-xs-12 hidden-lg hidden-md ">
            <div class="item-content-ft">
                <div class="menu4">Contact information</div>
                <div class="line"></div>
                <p>
                    <i class="fas fas2 fa-home"></i><span>Address: 28 Nguyen Tri Phuong, Hue City</span>
                </p>
                <p>
                    <i class="fas fas2 fa-phone"></i><span> Tel: +849998888</span>
                </p>
                <p>
                    <i class="fas fas2 fa-envelope-open"></i><span> Email: support@simplon.com</span>
                </p>
            </div>
        </div>
        <div class="col-md-8 col-sm-9 col-xs-12 hidden-sm">
            <div class="row ft2">
                <div class="col-md-4 col-sm-3 col-xs-12">
                    <div class="lst-item-ft">
                        <div class="menu4">Customer support</div>
                        <div class="line"></div>
                        <ul>
                            <li><a href="contact_us.html">Contact</a></li>
                            <li><a href="contact_us.html">Buy from far away</a></li>
                            <li><a href="contact_us.html">Warranty Policy</a></li>
                            <li><a href="contact_us.html">Regulations for redemption</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-4 col-sm-3 col-xs-12">
                    <div class="lst-item-ft">
                        <div class="menu4">Main product</div>
                        <div class="line"></div>
                        <ul>
                            <li><a href="skin.html">Skin</a></li>
                            <li><a href="jewelry.html">Jewellry</a></li>
                            <li><a href="make_up_kits.html">Make-up Kits</a></li>
                            <li><a href="nail_paints.html">Nail Paints</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-4 col-sm-3 col-xs-12">
                    <div class="list-item-ft">
                        <div class="menu4">Get 20% voucher now</div>
                        <div class="line"></div>
                        <div class="register">
                            <p>Extremely shocking discounts - 20% off service fee when you register via Email</p>
                            <form action="">
                                <input type="text" class="form-control form-control1" placeholder="Input email">
                                <button class="btn" type="submit">Register</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class=" col-sm-3 col-xs-12 hidden-lg hidden-md hidden-xs" >
            <div class="lst-item-ft">
                <div class="menu4">Customer support</div>
                <div class="line"></div>
                <ul>
                    <li><a href="contact_us.html">Contact</a></li>
                    <li><a href="contact_us.html">Buy from far away</a></li>
                    <li><a href="contact_us.html">Warranty Policy</a></li>
                    <li><a href="contact_us.html">Regulations for redemption</a></li>
                </ul>
            </div>
        </div>
        <div class=" col-sm-3 col-xs-12 hidden-lg hidden-md hidden-xs">
            <div class="lst-item-ft">
                <div class="menu4">Main product</div>
                <div class="line"></div>
                <ul>
                    <li><a href="skin.html">Skin</a></li>
                    <li><a href="jewelry.html">Jewellry</a></li>
                    <li><a href="make_up_kits.html">Make-up Kits</a></li>
                    <li><a href="nail_paints.html">Nail Paints</a></li>
                </ul>
            </div>
        </div>
        <div class=" col-sm-3 col-xs-12 hidden-lg hidden-md hidden-xs">
            <div class="list-item-ft">
                <div class="menu4">Get 20% voucher now</div>
                <div class="line"></div>
                <div class="register">
                    <p>Extremely shocking discounts - 20% off service fee when you register via Email</p>
                    <form action="">
                        <input type="text" class="form-control form-control1" placeholder="Input email">
                        <button class="btn" type="submit">Register</button>
                    </form>
                </div>
            </div>
        </div>

    </div>
    <div class="ft-bottom flex hidden-xs hidden-sm">
        <div class=" ft3">
            <p> Copyright © 2019 - <a href="index.html">SIMPLON’s Beauty Care Center</a> – Shop of cosmetics and accessories in Hue City</p>
        </div>
        <div class=" icon-ft-bt">
            <a href="#">
                <i class="fab fa-facebook"></i>
            </a>
            <a href="#">
                <i class="fab fa-twitter"></i>
                <a href="#">
                    <i class="fab fa-youtube"></i>
                </a>
                <a href="#">
                    <i class="fab fa-google-plus-g"></i>
                </a>
            </a>
            <a href="#">
                <i class="fab fa-cc-visa"></i>
            </a>
            <a href="#">
                <i class="fab fa-cc-paypal"></i>
            </a>
        </div>
    </div>

    <div class="ft-bottom flex hidden-lg hidden-md ">
        <div class=" ft3_xs">
            <p> Copyright © 2019 - <a href="index.html">SIMPLON’s Beauty Care Center</a> – Shop of cosmetics and accessories in Hue City</p>
        </div>
        <div class=" icon-ft-bt_xs">
            <a href="#">
                <i class="fab fa-facebook"></i>
            </a>
            <a href="#">
                <i class="fab fa-twitter"></i>
                <a href="#">
                    <i class="fab fa-youtube"></i>
                </a>
                <a href="#">
                    <i class="fab fa-google-plus-g"></i>
                </a>
            </a>
            <a href="#">
                <i class="fab fa-cc-visa"></i>
            </a>
            <a href="#">
                <i class="fab fa-cc-paypal"></i>
            </a>
        </div>
    </div>
</footer>

<script type="text/javascript" src="<c:url value='/template/user/b_j/js/create_js.js' />"></script>
</body>
</html>
