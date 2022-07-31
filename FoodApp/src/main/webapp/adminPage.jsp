<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - TrivAdmin</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" />
    <link rel="stylesheet" href="assets/dashboard.css">
</head>

<body>

    <nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm">
        <div class="container-fluid">
            <div class="width-240px py-2 px-3">
                <a href="/" class="navbar-brand fw-bold text-sm-left">Trang chủ</a>
            </div>
            <div class="flex-md-grow-1 p-2">
                <button class="btn btn-light" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-expanded="false" aria-controls="sidebarMenu">
                    <i class="fas fa-bars"></i>
                </button>
            </div>
            <div class="d-none d-md-block">
                <div class="nav">
                    <ul class="nav">
                        <li class="nav-item">
                            <a href="#" class="nav-link p-3 text-dark" role="button" id="dropdownMenuNotify"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="far fa-bell"></i>
                                <span class="bg-danger dot-notify"></span>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right border-0 shadow p-0"
                                aria-labelledby="dropdownMenuNotify">
                                <ul class="nav nav-tabs" id="myTab" role="tablist">
                                    <li class="nav-item" role="presentation">
                                        <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home"
                                            role="tab" aria-controls="home" aria-selected="true">Alerts</a>
                                    </li>
                                    <li class="nav-item" role="presentation">
                                        <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile"
                                            role="tab" aria-controls="profile" aria-selected="false">Events</a>
                                    </li>
                                    <li class="nav-item" role="presentation">
                                        <a class="nav-link" id="contact-tab" data-toggle="tab" href="#contact"
                                            role="tab" aria-controls="contact" aria-selected="false">Logs</a>
                                    </li>
                                </ul>
                                <div class="tab-content" id="myTabContent">
                                    <div class="tab-pane fade p-4 show active" id="home" role="tabpanel"
                                        aria-labelledby="home-tab">...</div>
                                    <div class="tab-pane fade p-4" id="profile" role="tabpanel"
                                        aria-labelledby="profile-tab">...</div>
                                    <div class="tab-pane fade p-4" id="contact" role="tabpanel"
                                        aria-labelledby="contact-tab">...</div>
                                    <div class="dropdown-divider"></div>
                                    <div class="text-right px-4 pb-2">
                                        <a href="#" class="text-muted"><small>Load All</small></a>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li class="nav-item">
                            <div class="dropdown">
                                <a class="nav-link p-3 text-dark font-weight-bold text-muted dropdown-toggle" href="#"
                                role="button" id="dropdownMenuAccount" data-bs-toggle="dropdown" aria-expanded="false">
                                <i class="far fa-user"></i> F7Deat
                            </a>
                            <div class="dropdown-menu dropdown-menu-right border-0 shadow"
                                aria-labelledby="dropdownMenuAccount">
                                <a class="dropdown-item" href="#"><i class="far fa-user"></i> My Account</a>
                                <a class="dropdown-item" href="#"><i class="fas fa-cog"></i> Settings</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#"><i class="fas fa-sign-out-alt"></i> Logout</a>
                            </div>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a href="#" class="nav-link p-3 text-dark"><i class="fas fa-cog fa-spin"></i></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>
    <nav id="sidebarMenu" class="d-md-block bg-dark sidebar collapse h-100 shadow">
        <div class="sidebar-sticky pt-3">
            <ul class="nav flex-column">
                <li class="nav-item">
                    <a class="nav-link triv-nav-link active" href="admin-page">
                        <i class="fas fa-tachometer-alt"></i>
                        Dashboard <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link triv-nav-link" data-bs-toggle="collapse" href="#multiCollapseExample1" role="button"
                    aria-expanded="false" aria-controls="collapseExample"><i class="fas fa-gift"></i>Menu <i class="fa collapse-icon"></i></a>
                    <div class="collapse multi-collapse" id="multiCollapseExample1">
                        <a class="nav-link triv-nav-link pl-4" href="new">
                            &bull; Thêm sản phẩm
                        </a>
                        <a class="nav-link triv-nav-link pl-4" href="#">
                            &bull; Quản lý User
                        </a>
                        <a class="nav-link triv-nav-link pl-4" href="#">
                            &bull; Quản lý đơn hàng
                        </a>
                        <a class="nav-link triv-nav-link pl-4" href="#">
                            &bull; Thêm bài viết vào blog
                        </a>
                    </div>
                </li>
            </ul>

            <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                <span>Settings</span>
                <a class="d-flex align-items-center text-muted" href="#" aria-label="Add a new report">
                    <i class="fas fa-plus-circle"></i>
                </a>
            </h6>
            <ul class="nav flex-column mb-2">
                <li class="nav-item">
                    <a class="nav-link triv-nav-link" href="#">
                        <i class="fas fa-user"></i>
                        Account
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link triv-nav-link" href="#">
                        <i class="fas fa-user-lock"></i>
                        ...
                    </a>
                </li>
            </ul>
        </div>
    </nav>
    <main role="main" id="main">
        <div class="p-4 shadow-sm bg-white mt-3 rounded">
            <form class="list-product">
                <table style="width: 100%;" class="">
                    <!-- <input class="search-product" type="search" name="" id="" placeholder="Tìm kiếm ..."> -->
                        <tr class="search-product-tr" style="height:50px" >
                            <th style="width:8%">ID</th>
                            <th style="width:25%">Tên Sản Phẩm </th>
                            <th style="width:10%">Giá tiền </th>
                            <th style="width:30%">Mô tả </th>
                            <th style="width:15%; padding-left: 10px;">Hình ảnh</th>
                            <th style="width:12%" colspan="2">Các thao tác </th> 
                        </tr>
        				<c:forEach var="product" items="${listOfProduct }">
        				
        					<tr class="product-tr">
        						<th class="product-tr-id" > <c:out value="${product.productID}"></c:out> </th>
                            	<th class="product-tr-name" > <c:out value="${product.name}"></c:out> </th>
                            	<th class="product-tr-price" > <c:out value="${product.price }"></c:out> </th>
                            	<th class="product-tr-description"> <c:out value="${product.shortDescription}"></c:out> </th>
                            	<th class="product-img"><img class="product-tr-img" src="assets/img/<c:out value="${product.imageLink }"></c:out>" alt=""> </th>
                            	<th>
                                	<div class="btn-edit-product">
                                    <a href="edit?id=<c:out value="${product.productID }"></c:out>">Sửa</a>
                                	</div>
                            	</th>
                           		 <th><a class="btn-delete-product" href="delete?id=<c:out value="${product.productID }"/>">Xóa</a></th>
                        	</tr>
        				
        				</c:forEach>
                        
                </table>
            </form> 
        </div>
    </main>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</html>