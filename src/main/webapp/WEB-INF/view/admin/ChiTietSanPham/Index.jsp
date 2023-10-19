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
<form action="/chitietsp/add" method="post">
    <div class="form-floating mb-3">
        <input type="text" class="form-control" name="maChiTietSanPham">
        <label>Ma Chi Tiet San Pham</label>
    </div>
    <div class="form-floating mb-3">
        <input type="text" class="form-control" name="tenSanPham">
        <label>Ten Chi Tiet San Pham</label>
    </div>
    <div class="form-floating mb-3">
        <select class="form-select" name="SanPham" aria-label="Default select example">
            <option selected>San Pham</option>
            <c:forEach var="sp" items="${dsSP}">
                <option value="${sp.idSanPham}">${sp.tenSanPham}</option>
            </c:forEach>
        </select>
    </div>
    <br>
    <div class="form-floating mb-3">
        <select class="form-select" name="ChatLieu" aria-label="Default select example">
            <option selected>Chat Lieu</option>
            <c:forEach var="cl" items="${dsCL}">
                <option value="${cl.idChatLieu}">${cl.tenChatLieu}</option>
            </c:forEach>
        </select>
    </div>
    <br>
    <div class="form-floating mb-3">
        <select class="form-select" name="Size" aria-label="Default select example">
            <option selected>Size</option>
            <c:forEach var="size" items="${dsSize}">
                <option value="${size.idSize}">${size.tenSize}</option>
            </c:forEach>
        </select>
    </div>
    <br>
    <div class="form-floating mb-3">
        <select class="form-select" name="ThuongHieu" aria-label="Default select example">
            <option selected>Thuong Hieu</option>
            <c:forEach var="th" items="${dsThuongHieu}">
                <option value="${th.idThuongHieu}">${th.tenThuongHieu}</option>
            </c:forEach>
        </select>
    </div>
    <br>
    <div class="form-floating mb-3">
        <select class="form-select" name="XuatXu" aria-label="Default select example">
            <option selected>Xuat Xu</option>
            <c:forEach var="xx" items="${dsXuatXu}">
                <option value="${xx.idXuatXu}">${xx.tenXuatXu}</option>
            </c:forEach>
        </select>
    </div>
    <br>
    <div class="form-floating mb-3">
        <select class="form-select" name="MauSac" aria-label="Default select example">
            <option selected>Mau Sac</option>
            <c:forEach var="ms" items="${dsMauSac}">
                <option value="${ms.idMauSac}">${ms.tenMauSac}</option>
            </c:forEach>
        </select>
    </div>
    <br>
    <div class="form-floating mb-3">
        <input type="text" class="form-control" name="soLuong">
        <label>So Luong</label>
    </div>
    <div class="form-floating mb-3">
        <input type="text" class="form-control" name="moTa">
        <label>Mo Ta</label>
    </div>
    <button type="submit">Add</button>
</form>

<h3 style="text-align: center; padding-bottom: 15px">Danh sách Chi Tiet San Pham</h3>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Ma Chi Tiet San Pham</th>
        <th scope="col">Ten Chi Tiet San Pham</th>
        <th scope="col">San Pham</th>
        <th scope="col">Chat Lieu</th>
        <th scope="col">Size</th>
        <th scope="col">Thuong Hieu</th>
        <th scope="col">Xuat Xu</th>
        <th scope="col">Mau Sac</th>
        <th scope="col">So Luong</th>
        <th scope="col">Mo Ta</th>
        <th scope="col">Trang Thai</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="ctsp" items="${dsCTSP}">
        <tr>
            <td>${ctsp.maChiTietSanPham}</td>
            <td>${ctsp.tenSanPham}</td>
            <td>${ctsp.sanPham.tenSanPham}</td>
            <td>${ctsp.chatLieu.tenChatLieu}</td>
            <td>${ctsp.size.tenSize}</td>
            <td>${ctsp.thuongHieu.tenThuongHieu}</td>
            <td>${ctsp.xuatXu.tenXuatXu}</td>
            <td>${ctsp.mauSac.tenMauSac}</td>
            <td>${ctsp.soLuong}</td>
            <td>${ctsp.moTa}</td>
            <td>
                <c:choose>
                    <c:when test="${ctsp.trangThai == null}"></c:when>
                    <c:otherwise>${ctsp.trangThai ? 'Dang Su Dung' : 'Ngung Su Dung'}</c:otherwise>
                </c:choose>
            </td>
            <td>
                <a href="/chitietsp/detail/${ctsp.idChiTietSanPham}">
                    <button class="btn btn-primary">Detail</button>
                </a>
                <a href="/chitietsp/delete/${ctsp.idChiTietSanPham}">
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
