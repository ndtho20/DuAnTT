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
<form action="/thuonghieu/add" method="post">
    <div class="form-floating mb-3">
        <input type="text" class="form-control" name="maThuongHieu" value="">
        <label>Ma Thuong Hieu</label>
    </div>
    <div class="form-floating mb-3">
        <input type="text" class="form-control" name="tenThuongHieu" value="">
        <label>Ten Thuong Hieu</label>
    </div>
    <button type="submit">Add</button>
</form>

<h3 style="text-align: center; padding-bottom: 15px">Danh sách Thuong Hieu</h3>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Ma Thuong Hieu</th>
        <th scope="col">Ten Thuong Hieu</th>
        <th scope="col">Trang Thai</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${dsThuongHieu}" var="thuongHieu">
        <tr>
            <td><c:out value="${thuongHieu.maThuongHieu}" /></td>
            <td><c:out value="${thuongHieu.tenThuongHieu}" /></td>
            <td>
                <c:choose>
                    <c:when test="${thuongHieu.trangThai == true}">
                        Dang Su Dung
                    </c:when>
                    <c:when test="${thuongHieu.trangThai == false}">
                        Ngung Su Dung
                    </c:when>
                    <c:otherwise>
                        <c:out value="" />
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <a href="<c:url value='/thuonghieu/detail/' />${thuongHieu.idThuongHieu}">
                    <button class="btn btn-primary">Detail</button>
                </a>
                <a href="<c:url value='/thuonghieu/delete/' />${thuongHieu.idThuongHieu}">
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
