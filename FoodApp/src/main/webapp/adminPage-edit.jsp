<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/admin_style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <title>Quản Lý</title>
</head>
<body>
    <div id="root">
        <div class="nav">
            
            <a class="nav-a" href="admin.html">
                <img src="/assets/img/good2.png" alt="">
                Quản trị viên</a>
            <a class="nav-a" href="index.html">
                <i class="fas fa-home"></i>
                Trang Chủ</a>
            <a class="nav-a" href="Order.html">
                <i class="fas fa-utensils"></i>
                Đặt ngay</a>
        </div>
        
        
        <!-- sửa thông tin sản phẩm -->
        <div class="modal js-modal" style="display: block">
            <form class="form-product form-edit-product" action="update?id=<c:out value="${productEdit.productID}"></c:out>" method="post">
                <button class="form-close js-form-close">
                    <i class="fa-solid fa-xmark"></i>
                </button>
                <table>
                    
                        <h2>Thay đổi thông tin sản phẩm</h2>
                    
                    <tr>
                        <td>Tên sản phẩm</td>
                        <td><input type="text" name="nameEdit" value="<c:out value="${productEdit.name}"></c:out>"></td>
                    </tr>
                    <tr>
                        <td>Giá tiền</td>
                        <td><input type="text" name="priceEdit" value="<c:out value="${productEdit.price}"></c:out>"></td>
                    </tr>
                    <tr>
                        <td>Mô tả</td>
                        <td><input type="text" name="shortDescriptionEdit" value="<c:out value="${productEdit.shortDescription}"></c:out>"></td>
                    </tr>
                    <tr>
                        <td>Hình ảnh</td>
                        <td style="display:flex; padding:10px 34px">
                            <img style="height: 120px; width: auto;" src="assets/img/<c:out value="${productEdit.imageLink}"></c:out>" alt="">
                            <input type="file" name="imageLinkEdit" style="padding: 40px 20px;">
                        </td>
                    </tr>
                </table>
                <button class="btn-form-edit-product">
                    <i class="fa-solid fa-check"></i>
                    Hoàn tất</button>
        
            </form>
        </div>
    </div>    

</body>
</html>

