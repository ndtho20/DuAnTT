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
<form action="/chitietsp/update/${ctsp.idChiTietSanPham}" method="post">
    <div class="form-floating mb-3">
        <input type="text" class="form-control" name="maChiTietSanPham" value="${ctsp.maChiTietSanPham}">
        <label>Ma Chi Tiet San Pham</label>
    </div>
    <div class="form-floating mb-3">
        <input type="text" class="form-control" name="tenSanPham" value="${ctsp.tenSanPham}">
        <label>Ten Chi Tiet San Pham</label>
    </div>
    <div class="form-floating mb-3">
        <select class="form-select" name="idSanPham" aria-label="Chọn Sản Phẩm">
            <option value="" disabled>Chọn Sản Phẩm</option>
            <c:forEach var="sp" items="${dsSP}">
                <option value="${sp.idSanPham}" ${sp.idSanPham == ctsp.sanPham.idSanPham ? 'selected' : ''}>${sp.tenSanPham}</option>
            </c:forEach>
        </select>
        <label for="idSanPham">Sản Phẩm</label>
    </div>

    <br>
    <div class="form-floating mb-3">
        <select class="form-select" name="idChatLieu" aria-label="Chọn Chất Liệu">
            <option value="" disabled>Chọn Chất Liệu</option>
            <c:forEach var="cl" items="${dsCL}">
                <option value="${cl.idChatLieu}" ${cl.idChatLieu == ctsp.chatLieu.idChatLieu ? 'selected' : ''}>${cl.tenChatLieu}</option>
            </c:forEach>
        </select>
        <label for="idChatLieu">Chất Liệu</label>
    </div>
    <br>

    <div class = "form-floating mb-3">
    <select class="form-select" name="idSize" aria-label="Chọn Size">
        <option value="" disabled>Chọn Size</option>
        <c:forEach var="size" items="${dsSize}">
            <option value="${size.idSize}" ${size.idSize == ctsp.size.idSize ? 'selected' : ''}>${size.tenSize}</option>
        </c:forEach>
    </select>
    <label for="idSize">Size</label>
    </div>

    <br>
    <div class="form-floating mb-3">
        <select class="form-select" name="idThuongHieu" aria-label="Chọn Thương Hiệu">
            <option value="" disabled>Chọn Thương Hiệu</option>
            <c:forEach var="th" items="${dsThuongHieu}">
                <option value="${th.idThuongHieu}" ${th.idThuongHieu == ctsp.thuongHieu.idThuongHieu ? 'selected' : ''}>${th.tenThuongHieu}</option>
            </c:forEach>
        </select>
        <label for="idThuongHieu">Thương Hiệu</label>
    </div>
    <br>
    <div class="form-floating mb-3">
        <select class="form-select" name="idXuatXu" aria-label="Chọn Xuất Xứ">
            <option value="" disabled>Chọn Xuất Xứ</option>
            <c:forEach var="xx" items="${dsXuatXu}">
                <option value="${xx.idXuatXu}" ${xx.idXuatXu == ctsp.xuatXu.idXuatXu ? 'selected' : ''}>${xx.tenXuatXu}</option>
            </c:forEach>
        </select>
        <label for="idXuatXu">Xuất Xứ</label>
    </div>

    <br>
    <div class="form-floating mb-3">
        <select class="form-select" name="idMauSac" aria-label="Chọn Màu Sắc">
            <option value="" disabled>Chọn Màu Sắc</option>
            <c:forEach var="ms" items="${dsMauSac}">
                <option value="${ms.idMauSac}" ${ms.idMauSac == ctsp.mauSac.idMauSac ? 'selected' : ''}>${ms.tenMauSac}</option>
            </c:forEach>
        </select>
        <label for="idMauSac">Màu Sắc</label>
    </div>
    <br>
    <div class="form-floating mb-3">
        <input type="text" class="form-control" name="soLuong" value="${ctsp.soLuong}">
        <label>So Luong</label>
    </div>
    <div class="form-floating mb-3">
        <input type="text" class="form-control" name="moTa" value="${ctsp.moTa}">
        <label>Mo Ta</label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="trangThai" value="true" ${ctsp.trangThai == true ? 'checked' : ''}>
        <label class="form-check-label">
            Dang Su Dung
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="trangThai" value="false" ${ctsp.trangThai == false ? 'checked' : ''}>
        <label class="form-check-label">
            Ngung Su Dung
        </label>
    </div>
    <button type="submit">Update</button>
</form>
</body>
</html>
