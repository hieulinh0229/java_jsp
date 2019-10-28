<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Admin</title>

    <!-- Custom fonts for this template-->
    <link href="<c:url value = "/template/admin/vendor/fontawesome-free/css/all.min.css"/>" rel="stylesheet" type="text/css">
    <!-- Page level plugin CSS-->
    <link href="<c:url value = "/template/admin/vendor/datatables/dataTables.bootstrap4.css"/>" rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="<c:url value = "/template/admin/css/sb-admin.css"/>" rel="stylesheet">
</head>
<body id="page-top">

<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

    <a class="navbar-brand mr-1" href="/admin-home">Administrator</a>

    <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
        <i class="fas fa-bars"></i>
    </button>

    <!-- Navbar Search -->
    <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0" action="/admin-products?action=search" method="post">
        <div class="input-group">
            <input type="text" id="search" name="search" class="form-control" placeholder="Search product" aria-label="Search" aria-describedby="basic-addon2">
            <div class="input-group-append">
                <button class="btn btn-primary" type="submit">
                    <i class="fas fa-search"></i>
                </button>
            </div>
        </div>
    </form>

    <!-- Navbar -->
<%--    <ul class="navbar-nav ml-auto ml-md-0">--%>
<%--    <li>--%>
<%--        <a class="navbar-brand mr-1" href="#">Xin chào, ${Admin}</a>--%>
<%--        <a class="navbar-brand mr-1" href='<c:url value="/thoat?action=logout"/>'><i class="fas fa-sign-out-alt"></i>Thoát</a>--%>
<%--    </li>--%>
<%--        <li class="nav-item dropdown no-arrow">--%>
<%--            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
<%--                <i class="fas fa-user-circle fa-fw"></i> ${Admin}--%>
<%--            </a>--%>
<%--            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">--%>
<%--                <a class="dropdown-item" href="#">Settings</a>--%>
<%--                <a class="dropdown-item" href="#">Activity Log</a>--%>
<%--                <div class="dropdown-divider"></div>--%>
<%--                <a class="dropdown-item" href='<c:url value="/thoat?action=logout"/>' data-toggle="modal" data-target="#logoutModal">Logout</a>--%>
<%--            </div>--%>
<%--        </li>--%>
<%--    </ul>--%>
    <!-- Example single danger button -->
    <div class="btn-group">
        <button type="button" class="btn btn-light">
            <i class="fas fa-user-circle fa-fw"></i> ${username}
        </button>
    </div>
    &nbsp;
    <div>
        <c:if test="${not empty username}">
            <a href="/thoat?action=logout " class="btn btn-danger">
                <i class="fas fa-sign-out-alt"></i> Thoát
            </a>
        </c:if>
    </div>
</nav>

<!-- Bootstrap core JavaScript-->
<script src="<c:url value = "/template/admin/vendor/jquery/jquery.min.js"/>"></script>
<script src="<c:url value = "/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

<!-- Core plugin JavaScript-->
<script src="<c:url value = "/template/admin/vendor/jquery-easing/jquery.easing.min.js"/>"></script>

<!-- Custom scripts for all pages-->
<script src="<c:url value = "/template/admin/js/sb-admin.min.js"/>"></script>
</body>
</html>
