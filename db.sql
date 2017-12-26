CREATE DATABASE [CHECKIN]
USE CHECKIN
GO

CREATE TABLE ACCOUNT(
	RFID varchar(128) NOT NULL,
	codeID varchar(32) NOT NULL,
	fullName nvarchar(128) NOT NULL,
	PRIMARY KEY (RFID, codeID, fullName)
);
GO

INSERT INTO ACCOUNT VALUES ('0101', 'B1400680', N'Nguyễn Phước Âu');
INSERT INTO ACCOUNT VALUES ('0102', 'B1400694', N'Nguyễn Việt Huấn');
INSERT INTO ACCOUNT VALUES ('0103', 'B1400778', N'Dương Thành Oai');
INSERT INTO ACCOUNT VALUES ('0104', 'B1400689', N'Lý Trường	Giang');
INSERT INTO ACCOUNT VALUES ('0105', 'B1400707', N'Lê Văn Ngà');
INSERT INTO ACCOUNT VALUES ('0106', 'B1400692', N'Trương Công Hiển');
INSERT INTO ACCOUNT VALUES ('0107', 'B1400695', N'Từ Quốc Huy');
INSERT INTO ACCOUNT VALUES ('0108', 'B1400735', N'Nguyễn Nhật Triết');
INSERT INTO ACCOUNT VALUES ('0109', 'B1400696', N'Nguyễn Quốc Khánh');
INSERT INTO ACCOUNT VALUES ('0110', 'B1400704', N'Lê Minh Luân');
INSERT INTO ACCOUNT VALUES ('0111', 'B1400713', N'Đoàn Minh Nhựt');
INSERT INTO ACCOUNT VALUES ('0112', 'B1400700', N'Dương Văn	Lăng');
INSERT INTO ACCOUNT VALUES ('0113', 'B1400729', N'Huỳnh Hoàng Thơ');
INSERT INTO ACCOUNT VALUES ('0114', 'B1400768', N'Nguyễn Đại Lợi');
INSERT INTO ACCOUNT VALUES ('0115', 'B1400711', N'Phan Thanh Nhi');
INSERT INTO ACCOUNT VALUES ('1101', 'CB101', N'Trần Cao Đệ');
INSERT INTO ACCOUNT VALUES ('1102', 'CB102', N'Phạm Thế Phi');
INSERT INTO ACCOUNT VALUES ('1103', 'CB103', N'Trần Công Án');
INSERT INTO ACCOUNT VALUES ('1104', 'CB104', N'Trần Ngân Bình');
INSERT INTO ACCOUNT VALUES ('1105', 'CB105', N'Lâm Nhựt Khang');
INSERT INTO ACCOUNT VALUES ('1106', 'CB106', N'Thái Minh Tuấn');
INSERT INTO ACCOUNT VALUES ('1107', 'CB107', N'Bùi Võ Quốc Bảo');
INSERT INTO ACCOUNT VALUES ('1108', 'CB108', N'Phạm Thị Xuân Diễm');
INSERT INTO ACCOUNT VALUES ('1109', 'CB109', N'Nguyễn Ngọc Mỹ');
GO

CREATE TABLE LOGIN(
	username varchar(32) PRIMARY KEY,
	password varchar(1024) NOT NULL,
	codeSystem varchar(32) NOT NULL,
	fullName nvarchar(128) NOT NULL
);
GO

INSERT INTO LOGIN VALUES('root','25d55ad283aa400af464c76d713c07ad', '001', N'root') -- pass: 12345678
GO

CREATE TABLE  STUDENT(
	RFID varchar(128) NOT NULL,
    codeID varchar(32) PRIMARY KEY,
    fullName nvarchar(128) NOT NULL,
    class varchar(128) NOT NULL,
    majors nvarchar(256) NOT NULL,
    college nvarchar(256) NOT NULL,
    schoolYear varchar(32) NOT NULL
);
GO

INSERT INTO STUDENT VALUES ('0101', 'B1400680', N'Nguyễn Phước Âu', N'DI1496A1', N'Kỹ thuật phần mềm', N'Công nghệ thông tin và Truyền thông', '2014-2018');
INSERT INTO STUDENT VALUES ('0102', 'B1400694', N'Nguyễn Việt Huấn', N'DI1496A1', N'Kỹ thuật phần mềm', N'Công nghệ thông tin và Truyền thông', '2014-2018');
INSERT INTO STUDENT VALUES ('0103', 'B1400778', N'Dương Thành Oai', N'DI1496A1', N'Kỹ thuật phần mềm', N'Công nghệ thông tin và Truyền thông', '2014-2018');
INSERT INTO STUDENT VALUES ('0104', 'B1400689', N'Lý Trường	Giang', N'DI1496A1', N'Kỹ thuật phần mềm', N'Công nghệ thông tin và Truyền thông', '2014-2018');
INSERT INTO STUDENT VALUES ('0105', 'B1400707', N'Lê Văn Ngà', N'DI1496A1', N'Kỹ thuật phần mềm', N'Công nghệ thông tin và Truyền thông', '2014-2018');
INSERT INTO STUDENT VALUES ('0106', 'B1400692', N'Trương Công Hiển', N'DI1496A1', N'Kỹ thuật phần mềm', N'Công nghệ thông tin và Truyền thông', '2014-2018');
INSERT INTO STUDENT VALUES ('0107', 'B1400695', N'Từ Quốc Huy', N'DI1496A1', N'Kỹ thuật phần mềm', N'Công nghệ thông tin và Truyền thông', '2014-2018');
INSERT INTO STUDENT VALUES ('0108', 'B1400735', N'Nguyễn Nhật Triết', N'DI1496A1', N'Kỹ thuật phần mềm', N'Công nghệ thông tin và Truyền thông', '2014-2018');
INSERT INTO STUDENT VALUES ('0109', 'B1400696', N'Nguyễn Quốc Khánh', N'DI1496A1', N'Kỹ thuật phần mềm', N'Công nghệ thông tin và Truyền thông', '2014-2018');
INSERT INTO STUDENT VALUES ('0110', 'B1400704', N'Lê Minh Luân', N'DI1496A1', N'Kỹ thuật phần mềm', N'Công nghệ thông tin và Truyền thông', '2014-2018');
INSERT INTO STUDENT VALUES ('0111', 'B1400713', N'Đoàn Minh Nhựt', N'DI1496A1', N'Kỹ thuật phần mềm', N'Công nghệ thông tin và Truyền thông', '2014-2018');
INSERT INTO STUDENT VALUES ('0112', 'B1400700', N'Dương Văn	Lăng', N'DI1496A1', N'Kỹ thuật phần mềm', N'Công nghệ thông tin và Truyền thông', '2014-2018');
INSERT INTO STUDENT VALUES ('0113', 'B1400729', N'Huỳnh Hoàng Thơ', N'DI1496A1', N'Kỹ thuật phần mềm', N'Công nghệ thông tin và Truyền thông', '2014-2018');
INSERT INTO STUDENT VALUES ('0114', 'B1400768', N'Nguyễn Đại Lợi', N'DI1496A1', N'Kỹ thuật phần mềm', N'Công nghệ thông tin và Truyền thông', '2014-2018');
INSERT INTO STUDENT VALUES ('0115', 'B1400711', N'Phan Thanh Nhi', N'DI1496A1', N'Kỹ thuật phần mềm', N'Công nghệ thông tin và Truyền thông', '2014-2018');
GO

CREATE TABLE EMPLOYER(
	RFID varchar(128) NOT NULL,
	codeID varchar(32) PRIMARY KEY,
	fullName nvarchar(128) NOT NULL,
    email varchar(256) NOT NULL,
    gender nvarchar(256) NOT NULL,
    department nvarchar(256) NOT NULL
);
GO

INSERT INTO EMPLOYER VALUES ('1101', 'CB101', N'Trần Cao Đệ', 'tcde@cit.ctu.edu.vn', N'nam', N'Bộ môn Công nghệ thông tin');
INSERT INTO EMPLOYER VALUES ('1102', 'CB102', N'Phạm Thế Phi', 'ptphi@cit.ctu.edu.vn', N'nam', N'Bộ môn Công nghệ thông tin');
INSERT INTO EMPLOYER VALUES ('1103', 'CB103', N'Trần Công Án', 'tcan@cit.ctu.edu.vn', N'nam', N'Bộ môn Công nghệ thông tin');
INSERT INTO EMPLOYER VALUES ('1104', 'CB104', N'Trần Ngân Bình', 'tnbinh@cit.ctu.edu.vn', N'nữ', N'Bộ môn Công nghệ thông tin');
INSERT INTO EMPLOYER VALUES ('1105', 'CB105', N'Lâm Nhựt Khang', 'lnkhang@cit.ctu.edu.vn', N'nữ', N'Bộ môn Công nghệ thông tin');
INSERT INTO EMPLOYER VALUES ('1106', 'CB106', N'Thái Minh Tuấn', 'tmtuan@cit.ctu.edu.vn', N'nam', N'Bộ môn Công nghệ thông tin');
INSERT INTO EMPLOYER VALUES ('1107', 'CB107', N'Bùi Võ Quốc Bảo', 'bvqbao@cit.ctu.edu.vn', N'nam', N'Bộ môn Công nghệ thông tin');
INSERT INTO EMPLOYER VALUES ('1108', 'CB108', N'Phạm Thị Xuân Diễm', 'ptxdiem@cit.ctu.edu.vn', N'nữ', N'Bộ môn Công nghệ thông tin');
INSERT INTO EMPLOYER VALUES ('1109', 'CB109', N'Nguyễn Ngọc Mỹ', 'nndiem@cit.ctu.edu.vn', N'nữ', N'Bộ môn Công nghệ thông tin');
GO

CREATE TABLE EVENTS(
	codeNo varchar(32) PRIMARY KEY,
    name nvarchar(512) NOT NULL,
    date varchar(32) NOT NULL,
    beginTime varchar(32) NOT NULL,
    endTime varchar(32) NOT NULL
);
GO

INSERT INTO EVENTS VALUES ('E001', N'Ngày Hội Việc Làm 2017', '16/04/2017', '8:00', '10:00');
INSERT INTO EVENTS VALUES ('E002', N'Tuần lễ Khám phá Tri thức', '07/12/2017', '7:00', '8:45');
INSERT INTO EVENTS VALUES ('E003', N'Giao lưu với CLB CEO phần mềm Quang Trung', '26/7/2017', '14:00', '16:30');
GO

CREATE TABLE REGISTER(
	codeNo varchar(32) NOT NULL,
    RFID varchar(32) NOT NULL,
	codeID varchar(32) NOT NULL,
    PRIMARY KEY (codeNo, RFID)
);
GO

INSERT INTO REGISTER VALUES ('E001', '0101', 'B1400680');
INSERT INTO REGISTER VALUES ('E001', '0102', 'B1400694');
INSERT INTO REGISTER VALUES ('E001', '0103', 'B1400778');
INSERT INTO REGISTER VALUES ('E001', '0104', 'B1400689');
INSERT INTO REGISTER VALUES ('E001', '0105', 'B1400707');
INSERT INTO REGISTER VALUES ('E001', '0106', 'B1400692');
INSERT INTO REGISTER VALUES ('E001', '0107', 'B1400695');
INSERT INTO REGISTER VALUES ('E001', '0108', 'B1400735');
INSERT INTO REGISTER VALUES ('E001', '0109', 'B1400696');
INSERT INTO REGISTER VALUES ('E001', '0110', 'B1400704');
GO


CREATE TABLE CHECKIN(
	codeNo varchar(32) NOT NULL,
    codeID varchar(32) NOT NULL,
    fullName nvarchar(32) NOT NULL,
    inputTime varchar(32),
    outTime varchar(32),
	isJoin varchar(32),
    PRIMARY KEY (codeNo, codeID)
);
GO