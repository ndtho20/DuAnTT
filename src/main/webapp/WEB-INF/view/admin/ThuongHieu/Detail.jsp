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
<form action="/thuonghieu/update/${ThuongHieu.idThuongHieu}" method="post">
    <div class="form-floating mb-3">
        <input type="text" class="form-control" name="maThuongHieu" value="${ThuongHieu.maThuongHieu}">
        <label>Ma Thuong Hieu</label>
    </div>
    <div class="form-floating mb-3">
        <input type="text" class="form-control" name="tenThuongHieu" value="${ThuongHieu.tenThuongHieu}">
        <label>Ten Thuong Hieu</label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="trangThai" value="true" <c:if test="${ThuongHieu.trangThai == true}">checked</c:if> >
        <label class="form-check-label">
            Dang Su Dung
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="trangThai" value="false" <c:if test="${ThuongHieu.trangThai == false}">checked</c:if> >
        <label class="form-check-label">
            Ngung Su Dung
        </label>
    </div>

    <button type="submit">Update</button>
</form>
</body>
</html>
