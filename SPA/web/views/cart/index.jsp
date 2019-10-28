<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Giỏ hàng</title>
    <link rel="shortcut icon" type="image" href="<c:url value = "/template/user/images/ic.ico"/>">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
    <link href="<c:url value='/template/user/style/style.css' />" rel="stylesheet" type="text/css" media="all"/>
    <link href="<c:url value='/template/user/style/detail.css' />" rel="stylesheet" type="text/css" media="all"/>
    <style type="text/css">.table&amp;amp;gt;tbody&amp;amp;gt;tr&amp;amp;gt;td, .table&amp;amp;gt;tfoot&amp;amp;gt;tr&amp;amp;gt;td {
                                                                                                                                     vertical-align: middle;
                                                                                                                                 }

    @media screen and (max-width: 600px) {
        table#cart tbody td .form-control {
            width:20%;
            display: inline !important;
        }

        .actions .btn {
            width:36%;
            margin:1.5em 0;
        }

        .actions .btn-info {
            float:left;
        }

        .actions .btn-danger {
            float:right;
        }

        table#cart thead {
            display: none;
        }

        table#cart tbody td {
            display: block;
            padding: .6rem;
            min-width:320px;
        }

        table#cart tbody tr td:first-child {
            background: #333;
            color: #fff;
        }

        table#cart tbody td:before {
            content: attr(data-th);
            font-weight: bold;
            display: inline-block;
            width: 8rem;
        }

        table#cart tfoot td {
            display:block;
        }
        table#cart tfoot td .btn {
            display:block;
        }
    }</style>
</head>
<body>


<!-- header -->
<%@ include file="/common/user/header.jsp" %>

<div class="container">

    <table id="cart" class="table table-hover table-condensed">
        <thead>
        <tr>
            <th style="width:50%">Tên sản phẩm</th>
            <th style="width:10%">Giá</th>
            <th style="width:8%">Số lượng</th>
            <th style="width:22%" class="text-center">Thành tiền</th>
            <th style="width:10%"> </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${order.iteam}" var="iteam" >
            <tr>
                <td data-th="Product">
                    <div class="row">
                        <div class="col-sm-2 hidden-xs"><img src="${iteam.product.getImage()}" alt="Sản phẩm 1" class="img-responsive" width="100">
                        </div>
                        <div class="col-sm-10">
                            <h4 class="nomargin">Sản phẩm: ${iteam.product.getName_product()}</h4>
                            <p>${iteam.product.getDescription()}</p>
                        </div>
                    </div>
                </td>
                <td data-th="Price">${iteam.product.getPrice()}USD</td>
                <td data-th="Quantity"><input class="form-control text-center" value="${iteam.quantity}" type="number">
                </td>
                <td data-th="Subtotal" class="text-center">${(iteam.quantity)*(iteam.product.getPrice())} USD</td>
                <td class="actions" data-th="">
                    <button class="btn btn-info btn-sm">
                        <a href="/cart?action=removeProductInCart&id=${iteam.product.getId_product()}">  <i  class="fa fa-minus "></i> </a>
                    </button>
                    <button class="btn btn-info btn-sm">
                        <a href="/cart?action=addInCart&id=${iteam.product.getId_product()}"><i class="fa fa-plus"></i> </a>
                    </button>
                </td>
            </tr>
        </c:forEach >
        </tbody><tfoot>
    <tr>
        <td><a href="/product" class="btn btn-warning"><i class="fa fa-angle-left"></i> Tiếp tục mua hàng</a>
        </td>
        <td colspan="2" class="hidden-xs"> </td>
        <td class="hidden-xs text-center"><strong>Tổng tiền ${totalMoney} USD</strong>
        </td>
        <td><button  type="button" class="btn cart btn-info btn-lg"
                     data-toggle="modal" data-target="#myModal" data-price="60">Thanh toán <i class="fa fa-angle-right"></i></button>
        </td>
    </tr>
    </tfoot>
    </table>
    <div class="container" id="popup">
        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <form method="post" action="/cart?action=pay">
                    <div class="modal-content">
                        <div class="modal-body popup_center">
                            <div class="run-customer">
                                <h3>Thông tin liên hệ</h3>
                                <div class="form-row">
                                    <label class="lebel-abs">Tên:</label>
                                    <input type="text" class="form-control" name="name_customer"  placeholder="Nhập tên đầy đủ"required minlength="5" maxlength="30">
                                </div>
                                <div class="form-row"><label class="lebel-abs">Số điện thoại:</label>
                                    <input type="phone" class="form-control"  name="phone" placeholder="Nhập số điện thoại"required >
                                </div>
                                <div class="form-row"><label class="lebel-abs">Địa chỉ:</label>
                                    <input type="text" class="form-control" name="address" placeholder="Nhập địa chỉ"required >
                                </div>
                            </div>
                        </div>
                        <input type="submit" class="btn btn-default style_button">
                        </input>
                    </div>
                </form>

            </div>
        </div>
    </div
    <%@ include file="/common/user/footer.jsp" %>
            <!-- footer -->
</div>
<script type="text/javascript" src="<c:url value='/template/user/b_j/js/create_js.js' />"></script>
</body>
</html>
