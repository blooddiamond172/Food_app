<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - TrivAdmin</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
        integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
        crossorigin="anonymous" />
    <link rel="stylesheet" href="/assets/dashboard.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
</head>

<body>

    <nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm">
        <div class="container-fluid">
            <div class="width-240px py-2 px-3">
                <a href="/" class="navbar-brand fw-bold text-sm-left">Trang chủ</a>
            </div>
            <div class="flex-md-grow-1 p-2">
                <button class="btn btn-light" data-bs-toggle="collapse" data-bs-target="#sidebarMenu"
                    aria-expanded="false" aria-controls="sidebarMenu">
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
                                    role="button" id="dropdownMenuAccount" data-bs-toggle="dropdown"
                                    aria-expanded="false">
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
    <main role="main" id="main" style="margin-left: 0 ;">
        <!-- sửa thông tin sản phẩm -->
        <div class="modal js-modal">
        <form action="update" method=post>
            <div class="form-product form-add-product">
                <a class="form-close js-form-close" href="dashboard.html">
                    <i class="fa-solid fa-xmark"></i>
                </a>
                <div style="width: 700px; margin: auto;">

                    <h2>Thay đổi thông tin sản phẩm</h2>

                    <div class="form-row">
                        <div style="display: flex">
                            <div>Mã sản phẩm:</div> 
                            <input type="text" name="idEdit" style="width: 210px; margin-left: 22px;" value="${productEdit.productID }">
                        </div>
                        <div style="display: flex">
                            <div>Tên sản phẩm:</div> 
                            <input type="text" name="nameEdit" style="width: 210px; margin-left: 20px;" value="${productEdit.name }">
                        </div>
                    </div>
                    <div class="form-row">
                        <div>Giá tiền:</div>
                        <input type="text" name="priceEdit" style="width: 579px" value="${productEdit.price }">
                    </div>
                    <div class="form-row">
                        <div>Mô tả:</div>
                        <textarea name="shortDescriptionEdit" id="" type="text" cols="74" rows="2" style="resize: none;">${productEdit.shortDescription }</textarea>
                    </div>
                    <div class="form-row" style="justify-content: inherit;">
                        <div >Hình ảnh:</div>
                        <div style="display:flex;">
                            <div style="margin-left: 52px; text-align: left;">
                                <input id="imgInp"  name="imageLinkEdit" value="${productEdit.imageLink }" type="file">
                                <img id="imgProduct" style="height: 160px; width: 200px; margin-bottom: 10px;" alt="">
                            </div>
                        </div>
                    </div>
                </div>
                <button class="btn-form-product">
                    <i class="fa-solid fa-check"></i>
                    Hoàn tất
                </button>
            </div>
        </form>
        </div>

    </main>
    <script>
        imgInp.onchange = evt => {
            const [file] = imgInp.files
            if (file) {
                imgProduct.src = URL.createObjectURL(file)
                imgProduct.style.width='200px';
                imgProduct.style.height='160px';
            }
        }
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
        crossorigin="anonymous"></script>
</body>
</html>