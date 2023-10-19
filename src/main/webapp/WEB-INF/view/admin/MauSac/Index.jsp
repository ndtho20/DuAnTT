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
<form action="/mausac/add" method="post">
    <div class="form-floating mb-3">
        <input type="text" class="form-control" name="maMauSac" value="${cl.maMauSac}">
        <label>Ma Mau Sac</label>
    </div>
    <div class="form-floating mb-3">
        <input type="text" class="form-control" name="tenMauSac" value="${cl.tenMauSac}">
        <label>Ten Mau Sac</label>
    </div>
    <button type="submit">Add</button>
</form>

<h3 style="text-align: center; padding-bottom: 15px">Danh sách Mau Sac</h3>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Ma Mau Sac</th>
        <th scope="col">Ten Mau Sac</th>
        <th scope="col">Trang Thai</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${dsMauSac}" var="cl">
        <tr>
            <td>${cl.maMauSac}</td>
            <td>${cl.tenMauSac}</td>
            <td>${cl.trangThai == null ? '' : (cl.trangThai ? 'Dang Su Dung' : 'Ngung Su Dung')}</td>
            <td>
                <a href="/mausac/detail/${cl.idMauSac}">
                    <button class="btn btn-primary">Detail</button>
                </a>
                <a href="/mausac/delete/${cl.idMauSac}">
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
