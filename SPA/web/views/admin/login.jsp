<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link href="<c:url value='/template/admin/vendor/fontawesome-free/css/all.min.css' />" rel="stylesheet" type="text/css">
    <link href="<c:url value='/template/admin/css/sb-admin.css' />" rel="stylesheet">
</head>
<body>

</body><body class="bg-dark">

<div class="container">
    <div class="card card-login mx-auto mt-5">
        <div class="card-header">Đăng nhập</div>
        <div class="card-body">
            <div class="form-group">
                <c:if test='${requestScope["message"] != null}'>
                    <div class="alert alert-danger">
                        <h4><strong>Lỗi!</strong></h4><span class="message">${requestScope["message"]}</span>
                    </div>
                </c:if>
            </div>
            <form action="/dang-nhap?action=login" method="post">
                <div class="form-group">
                    <div class="form-label-group">
                        <input type="text" id="username" name="username" class="form-control" placeholder="Email address" required="required" autofocus="autofocus">
                        <label for="username">Username</label>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <input type="password" id="password" name="password" class="form-control" placeholder="Password" required="required">
                        <label for="password">Password</label>
                    </div>
                </div>
                <div class="form-group">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" value="remember-me">
                            Nhớ mật khẩu
                        </label>
                    </div>
                </div>
                <input type="submit" class="btn btn-primary btn-block" value="Đăng nhập">
            </form>
            <div class="text-center">
                <a class="d-block small mt-3" href="/admin-users?action=register">Đăng ký tài khoản</a>
                <a class="d-block small" href="#">Quên mật khẩu</a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="<c:url value='/template/admin/vendor/jquery/jquery.min.js' />"></script>
<script src="<c:url value='/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>

<!-- Core plugin JavaScript-->
<script src="<c:url value='/template/admin/vendor/jquery-easing/jquery.easing.min.js' />"></script>

</body>
</html>
