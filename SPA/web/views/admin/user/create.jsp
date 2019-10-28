
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

<!-- header -->
<%@ include file="/common/admin/header.jsp" %>
<!-- header -->

<div id="wrapper">

    <!-- Sidebar -->
    <ul class="sidebar navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="<c:url value = "/views/admin/home.jsp"/>">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Dashboard</span>
            </a>
        </li>
<%--        <li class="nav-item dropdown">--%>
<%--            <a class="nav-link dropdown-toggle" href="<c:url value = "/admin-users"/>" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
<%--                <i class="fas fa-fw fa-folder"></i>--%>
<%--                <span>Quản lý tài khoản</span>--%>
<%--            </a>--%>
<%--            <div class="dropdown-menu" aria-labelledby="pagesDropdown">--%>
<%--                <h6 class="dropdown-header">Login Screens:</h6>--%>
<%--                <a class="dropdown-item" href="<c:url value = "/views/user/login.jsp"/>">Login</a>--%>
<%--                <a class="dropdown-item" href="<c:url value = "/views/user/register.jsp"/>">Register</a>--%>
<%--                <a class="dropdown-item" href="forgot-password.html">Forgot Password</a>--%>
<%--                <div class="dropdown-divider"></div>--%>
<%--                <h6 class="dropdown-header">Other Pages:</h6>--%>
<%--                <a class="dropdown-item" href="404.html">404 Page</a>--%>
<%--            </div>--%>
<%--        </li>--%>
        <li class="nav-item">
            <a class="nav-link" href="<c:url value = "/admin-users"/>">
                <i class="fas fa-users-cog"></i>
                <span>Quản lý tài khoản</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<c:url value = "/admin-products"/>">
                <i class="fas fa-fw fa-table"></i>
                <span>Quản lý sản phẩm</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="tables.html">
                <i class="fas fa-shopping-cart"></i>
                <span>Đơn hàng</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="tables.html">
                <i class="fas fa-fw fa-chart-area"></i>
                <span>Thống kê lượt truy cập</span></a>
        </li>
    </ul>

    <div id="content-wrapper">

        <div class="container-fluid">

            <!-- Breadcrumbs-->
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="<c:url value = "/views/admin/home.jsp"/>">Dashboard</a>
                </li>
                <li class="breadcrumb-item active">Quản lý tài khoản</li>
            </ol>

            <!-- Page Content -->
<%--            <h1>Trang quản trị</h1>--%>
<%--            <hr>--%>

            <div class="container">
                <h2>Tạo mới tài khoản</h2>
                <hr>

                    <c:if test='${requestScope["message"] != null}'>
                        <div class="alert alert-success">
                            <h4><strong>Thành công!</strong></h4><span class="message">${requestScope["message"]}</span>
                        </div>
                    </c:if>

                <form class="form-horizontal" method="post">
                    <div class="form-group">
                        <label class="control-label col-sm-2">Usename</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" name="username" id="username" placeholder="Enter username">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2">Password</label>
                        <div class="col-sm-7">
                            <input type="password" class="form-control" name="password" id="password" placeholder="Enter password">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2">Fullname</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="fullname" name="fullname" placeholder="Enter fullname">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2">Trạng thái</label>
                           <div class="col-sm-7">
                               <select class="form-control" name="status" id="status">
                                   <option value="1">Đang hoạt động</option>
                                   <option value="2">Đã nghỉ</option>
                               </select>
                           </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2">Vai trò:</label>
                        <div class="col-sm-7">
                            <select class="form-control" name="roleid" id="roleid">
                                <option value="1">Admin</option>
                                <option value="2">Người dùng</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <a class="btn btn-success" href="/admin-users"><i class="fas fa-arrow-left"></i> Quay lại</a>
                            <button type="submit" class="btn btn-primary"><i class="fas fa-plus"></i> Tạo mới</button>
                            <a class="btn btn-danger" href="/admin-users"><i class="far fa-window-close"></i> Huỷ bỏ</a>
                        </div>
                    </div>
                </form>
            </div>


        </div>
        <!-- /.container-fluid -->

        <!-- Sticky Footer -->
        <%--        <footer class="sticky-footer">--%>
        <%--            <div class="container my-auto">--%>
        <%--                <div class="copyright text-center my-auto">--%>
        <%--                    <span>Copyright © Your Website 2019</span>--%>
        <%--                </div>--%>
        <%--            </div>--%>
        <%--        </footer>--%>

    </div>
    <!-- /.content-wrapper -->

</div>
<!-- /#wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="<c:url value = "/views/admin/login.jsp"/>">Logout</a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="<c:url value = "/template/admin/vendor/jquery/jquery.min.js"/>"></script>
<script src="<c:url value = "/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

<!-- Core plugin JavaScript-->
<script src="<c:url value = "/template/admin/vendor/jquery-easing/jquery.easing.min.js"/>"></script>

<!-- Custom scripts for all pages-->
<script src="<c:url value = "/template/admin/js/sb-admin.min.js"/>"></script>
</body>
</html>
