<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="assets/admin_style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
<title>Quản Lý</title>
</head>
<body>
	<div id="root">
		<div class="nav">

			<a class="nav-a" href="admin.html"> <img
				src="/assets/img/good2.png" alt=""> Quản trị viên
			</a> <a class="nav-a" href="index.html"> <i class="fas fa-home"></i>
				Trang Chủ
			</a> <a class="nav-a" href="Order.html"> <i class="fas fa-utensils"></i>
				Đặt ngay
			</a>
		</div>


		<!-- thêm sản phẩm -->
		<div class="add-product">
			<form class="form-product" action="insert" method="post">
				<h2>Thêm sản phẩm mới</h2>
				<table>
					<tbody>
						<tr>
							<td>Mã sản phẩm</td>
							<td><input type="text" name="productID"></td>
						</tr>
						<tr>
							<td>Tên sản phẩm</td>
							<td><input type="text" name="name"></td>
						</tr>
						<tr>
							<td>Giá tiền</td>
							<td><input type="text" name="price"></td>
						</tr>
						<tr>
							<td>Mô tả</td>
							<td><input type="text" name="shortDescription"></td>
						</tr>
						<tr>
							<td>Hình ảnh</td>
							<td><input type="file" name="imageLink"></td>
						</tr>
					</tbody>
				</table>
				<button class="btn-form-add-product">
					<i class="fa-solid fa-plus"></i> Thêm mới
				</button>

			</form>
		</div>
	</div>

</body>
</html>

