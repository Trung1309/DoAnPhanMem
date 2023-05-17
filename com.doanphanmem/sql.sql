create database DTB_Nhom9_01118
go
use DTB_Nhom9_01118
go 

create table tbl_ChucVu
(
	MaCV	Nvarchar(20) primary key,
	TenCV	Nvarchar(50),
	
)
go
create table tbl_HangHoa
(
	MaHH	Nvarchar(10) not null primary key,
	tenHH nvarchar(100),
	KhoiLuong	numeric,
	donGia	money

)
go
create table tbl_QuyenTruyCap
(
	maQuyen Int not null primary key,
	tenQuyen nvarchar(50)
)
go
create table tbl_phongBan
(
	maPB nvarchar(10) not null primary key,
	tenPB nvarchar(50)
)


go
create table tbl_banQuanLy
(
	tenTKQL nvarchar(10) not null primary key,
	maQuyen int foreign key references tbl_QuyenTruyCap(maQuyen),
	matKhau varchar(100),
	maPB nvarchar(10) foreign key references tbl_phongBan(maPB)
)
go
create table tbl_ThongBao
(
	maTB int not null primary key,
	tenTKQL nvarchar(10) foreign key references  tbl_banQuanLy(tenTKQL),
	tieuDe nvarchar(50),
	noiDung nvarchar(200)
	
)

go

create table tbl_Admin
(
	tenTK nvarchar(10) not null primary key,
	matKhau varchar(100),
	maQuyen Int foreign key references tbl_QuyenTruyCap(maQuyen)
)
go
create table tbl_TinhThanh
(
	Id_TT	Varchar(10) not null primary key,
	TenTT	NVARCHAR(100)

)
go

create table tbl_QuanHuyen
(
	Id_QH	Varchar(10) not null primary key,
	TenQH	NVARCHAR(100),
	Id_TT	Varchar(10) foreign key references tbl_TinhThanh(Id_TT)
)
create table tbl_PhuongXa
(
	Id_PX	Varchar(10) not null primary key,
	TenPX	NVARCHAR(100),
	Id_QH	Varchar(10) foreign key references tbl_QuanHuyen(Id_QH)
)





---

create table tbl_nhanVien
(
	TenTKNV nvarchar(30) not null primary key,
	MaQuyen int foreign key references tbl_QuyenTruyCap(maQuyen),
	MatKhau Nvarchar(20),
	TenNV	nvarchar(50),
	NgaySinh	nvarchar(50),
	Cccd	varchar(20),
	GioiTinh	Nvarchar(10),
	Sdt	varchar(14),
	Email	Nvarchar(50),
	ngayQD	Nvarchar(10),
	Anh		Nvarchar(max),
	Id_PX	Varchar(10) foreign key references tbl_PhuongXa(Id_PX),
	maCV nvarchar(20) foreign key references tbl_ChucVu(maCV),
)

go



create table tbl_KhachHang
(
	TenTKKH	Nvarchar(10) not null primary key,
	MaQuyen	int foreign key references tbl_QuyenTruyCap(maQuyen),
	MatKhau	Nvarchar(20),
	TenKH	Nvarchar(50),
	Email 	nvarchar(50),
	Sdt	Nchar(20),
	Cccd	Nchar(20),
	Id_PX	Varchar(10) foreign key references tbl_PhuongXa(Id_PX)
)
go
create table tbl_GoiCuoc
(
	MaGoiCuoc	nvarchar(10) not null primary key,
	TenGoiCuoc	Nvarchar(max),
	KhoiLuong	int,
	MoTa	Nvarchar(max),
	ThoiGianGiao	Nvarchar(50),
	GiaCuoc	Money
)
go
create table tbl_VanChuyen
(
	MaVC	INT not null primary key,
	tinhTrang	NVARCHAR(100),
	GhiChu	NVARCHAR(100),
	AnhXacNhan	Varbinary(MAX)

)





create table tbl_DonHang
(
	MaDH int identity(1,1) not null primary key,	
	SdtNguoiNhan 	Nvarchar(20),
	NgayTaoDon	nvarchar(50),
	donGia nvarchar(50),
	NgayGiaoHang nvarchar(50),
	TrangThaiDonHang	Nvarchar(MAX),
	TrangThaiGiaoHang	Nvarchar(100),
	DiaChiGH	Nvarchar(max),
	hinhAnh nvarchar(max),
	TenTKKH	Nvarchar(10) foreign key references tbl_KhachHang(TenTKKH),
	TenTKNV	nvarchar(30) foreign key references tbl_nhanVien(TenTKNV),
	MaGoiCuoc	nvarchar(10) foreign key references tbl_GoiCuoc(MaGoiCuoc),
	MaVC	INT foreign key references tbl_VanChuyen(MaVC),
	phuongXa nvarchar(50),
	quanHuyen nvarchar(50),
	tinhThanh nvarchar(50),
	tenSP nvarchar(max),
	loaiSP nvarchar(max),
	khoiLuong int ,
	soLuong int,
	hoTenNguoiNhan nvarchar(50),
	loaiGoiCuoc nvarchar(50)
)

go
create table tbl_ChiTietDonHang
(
	MaDH	int foreign key references tbl_DonHang(MaDH),
	MaHH	nvarchar(10) foreign key references tbl_HangHoa(MaHH)
)

insert into tbl_QuyenTruyCap
values (1,'Admin'),
		(2,'BanQuanLy'),
		(3,'NhanVien'),
		(4,'KhachHang')

insert into tbl_ChucVu
values ('QL',N'Quản Lý'),
		('NV',N'Nhân Viên')

insert into tbl_TinhThanh
values	('1',N'Hà Giang'),
		('2',N'Nam Định'),
		('3',N'Đà Nẵng')

insert into tbl_QuanHuyen
values	('1',N'Nam Long','1'),
		('2',N'Nam Phong','2'),
		('3',N'Hải Châu','3'),
		('4',N'Phong Nam','1')

insert into tbl_PhuongXa
values	('1',N'Bá Văn','2'),
		('2',N'Phong Nam','4'),
		('3',N'Nam Đàn','1'),
		('4',N'Thanh Bình','2')

GO
-- proc đăng kí tài khoản mơi --
CREATE PROCEDURE DBO.proc_dangKiTaiKhoan(
	@tenDN NVARCHAR(10),
	@tenKH nvarchar(50),
	@email nvarchar(50),
	@sdt nchar(20),
	@matKhau nvarchar(20)
)
AS
	BEGIN TRY
	INSERT INTO tbl_KhachHang 
	(TenTKKH,TenKH,Email, Sdt, MatKhau,MaQuyen)
	VALUES(
	@tenDN,@tenKH,@email,@sdt,@matKhau,4)
	END TRY
	BEGIN CATCH
	PRINT N'Lỗi';
	THROW
	END CATCH
		
drop proc DBO.proc_taoDonHang
GO
--Proc tạo đơn hàng --
CREATE PROCEDURE DBO.proc_taoDonHang(
	@tenNguoiNhan nvarchar(50),
	@diaChiGiaoHang nvarchar(50),
	@tinhThanh nvarchar(50),
	@quanHuyen nvarchar(50),
	@phuongXa nvarchar(50),
	@sdtNguoiNhan nvarchar(20),
	@dichVu nvarchar(50),
	@khoiLuong int,
	@tenSP nvarchar(50),
	@soLuong int,
	@tenTKKH nvarchar(50)
)
AS
	BEGIN TRY
	INSERT INTO tbl_DonHang
	(hoTenNguoiNhan,NgayTaoDon,DiaChiGH,tinhThanh,quanHuyen, phuongXa,SdtNguoiNhan,loaiGoiCuoc,khoiLuong,tenSP,soLuong,TenTKKH,TrangThaiDonHang)
	VALUES(
	@tenNguoiNhan,FORMAT (getdate(), 'dd/MM/yyyy, hh:mm:ss tt'),@diaChiGiaoHang,@tinhThanh,@quanHuyen,@phuongXa,@sdtNguoiNhan,@dichVu,@khoiLuong,@tenSP,@soLuong,@tenTKKH,N'Chờ xử lý')
	END TRY
	BEGIN CATCH
	PRINT N'Lỗi';
	THROW
	END CATCH
GO

--end proc--

SELECT *
FROM tbl_DonHang
WHERE MaDH = 52


