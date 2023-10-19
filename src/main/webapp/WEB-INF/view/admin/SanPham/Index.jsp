<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<form action="/sanpham/add" method="post">
    <div class="form-floating mb-3">
        <input type="text" class="form-control" name="maSanPham" value="${sp.maSanPham}">
        <label>Ma San Pham</label>
    </div>
    <div class="form-floating mb-3">
        <input type="text" class="form-control" name="tenSanPham" value="${sp.tenSanPham}">
        <label>Ten San Pham</label>
    </div>
    <button type="submit">Add</button>
</form>

<h3 style="text-align: center; padding-bottom: 15px">Danh sách San Pham</h3>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Ma San Pham</th>
        <th scope="col">Ten San Pham</th>
        <th scope="col">Trang Thai</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="sp" items="${dsSanPham}">
        <tr>
            <td>${sp.maSanPham}</td>
            <td>${sp.tenSanPham}</td>
            <td>${sp.trangThai == null ? '' : (sp.trangThai ? 'Dang Su Dung' : 'Ngung Su Dung')}</td>
            <td>
                <a href="/sanpham/detail/${sp.idSanPham}">
                    <button class="btn btn-primary">Detail</button>
                </a>
                <a href="/sanpham/delete/${sp.idSanPham}">
                    <button class="btn btn-danger">Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js"
        integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js"
        integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ"
        crossorigin="anonymous"></script>
</body>
</html>
