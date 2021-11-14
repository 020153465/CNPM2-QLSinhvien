IF DB_ID('QLSinhvien') IS NULL
BEGIN
	CREATE DATABASE QLSinhvien
END
GO
USE QLSinhvien

IF OBJECT_ID(N'Sinhvien') IS NULL
BEGIN
	CREATE TABLE Sinhvien(
		MaSV CHAR(6),
		Hoten NVARCHAR(40) NOT NULL,
		Namsinh int,

		PRIMARY KEY (MaSV)
	);
END

IF (NOT EXISTS(SELECT 1 FROM Sinhvien))
BEGIN
	INSERT INTO Sinhvien VALUES
		('500000', 'Bill Door', 1997),
		('500001', 'Elon Must', 1998),
		('500002', 'John Xina', 1999)
END

SELECT * FROM Sinhvien