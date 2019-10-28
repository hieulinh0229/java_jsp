<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
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


  <p class="alert-warning" style="font-size: 20px">${noResult}</p>


    <%@ include file="/common/user/footer.jsp" %>
    <!-- footer -->
    <script type="text/javascript" src="<c:url value='/template/user/b_j/js/create_js.js' />"></script>
</body>
</html>
