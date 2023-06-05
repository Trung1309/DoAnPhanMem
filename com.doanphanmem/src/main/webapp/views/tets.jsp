<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chọn địa điểm</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            // Lấy danh sách tỉnh thành và điền vào select box
            $.getJSON("https://api.example.com/locations", function(data) {
                var provinces = data.provinces;
                var provinceSelect = $("#province");
                provinceSelect.empty();
                provinceSelect.append("<option value=''>Chọn tỉnh thành</option>");
                $.each(provinces, function(index, province) {
                    provinceSelect.append("<option value='" + province.id + "'>" + province.name + "</option>");
                });
            });
            
            // Khi chọn tỉnh thành, tải danh sách quận huyện tương ứng
            $("#province").change(function() {
                var provinceId = $(this).val();
                if (provinceId !== "") {
                    $.getJSON("https://api.example.com/locations/districts?provinceId=" + provinceId, function(data) {
                        var districts = data.districts;
                        var districtSelect = $("#district");
                        districtSelect.empty();
                        districtSelect.append("<option value=''>Chọn quận huyện</option>");
                        $.each(districts, function(index, district) {
                            districtSelect.append("<option value='" + district.id + "'>" + district.name + "</option>");
                        });
                    });
                } else {
                    $("#district").empty();
                    $("#ward").empty();
                }
            });
            
            // Khi chọn quận huyện, tải danh sách phường xã tương ứng
            $("#district").change(function() {
                var districtId = $(this).val();
                if (districtId !== "") {
                    $.getJSON("https://api.example.com/locations/wards?districtId=" + districtId, function(data) {
                        var wards = data.wards;
                        var wardSelect = $("#ward");
                        wardSelect.empty();
                        wardSelect.append("<option value=''>Chọn phường xã</option>");
                        $.each(wards, function(index, ward) {
                            wardSelect.append("<option value='" + ward.id + "'>" + ward.name + "</option>");
                        });
                    });
                } else {
                    $("#ward").empty();
                }
            });
        });
    </script>
</head>
<body>
    <h1>Chọn địa điểm</h1>
    <form>
        <label for="province">Tỉnh thành:</label>
        <select id="province" name="province">
            <option value="">Chọn tỉnh thành</option>
        </select>
        <br>
        
        <label for="district">Quận huyện:</label>
        <select id="district" name="district">
            <option value="">Chọn quận huyện</option>
        </select>
        <br>
        
        <label for="ward">Phường xã:</label>
        <select id="ward" name="ward">
            <option value="">Chọn phường xã</option>
        </select>
    </form>
</body>
</html>
