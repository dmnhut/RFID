--CREATE DATABASE [CHECKIN]

--USE [CHECKIN]

----------------------------------------------------------------------------------

CREATE TABLE ACCOUNT(
	RFID varchar(128) NOT NULL,
	codeID varchar(32) NOT NULL,
	fullName nvarchar(128) NOT NULL,
	PRIMARY KEY (RFID, codeID, fullName)
);

INSERT INTO ACCOUNT VALUES('unknow', 'B1400713', N'Doan Minh Nhut')

----------------------------------------------------------------------------------
CREATE TABLE LOGIN(
	username varchar(32) PRIMARY KEY,
  password varchar(1024) NOT NULL,
	codeSystem varchar(32) NOT NULL,
	fullName nvarchar(128) NOT NULL,
);

INSERT INTO LOGIN VALUES('admin','admin', '001', N'Doan Minh Nhut')

----------------------------------------------------------------------------------

CREATE TABLE STUDENT(
	  RFID varchar(128) NOT NULL,
    codeID varchar(32) PRIMARY KEY,
    fullName nvarchar(128) NOT NULL,
    class varchar(128) NOT NULL,
    majors nvarchar(256) NOT NULL,
    codeNoCollege varchar(32) NOT NULL,
    schoolYear varchar(32) NOT NULL
);

----------------------------------------------------------------------------------

CREATE TABLE CODENOCOLLEGE(
	  codeNoCollege varchar(32) PRIMARY KEY,
	  college nvarchar(256) NOT NULL
);

----------------------------------------------------------------------------------

CREATE TABLE EMPLOYER(
		RFID varchar(128) NOT NULL,
		codeID varchar(32) PRIMARY KEY,
		fullName nvarchar(128) NOT NULL,
    email varchar(256) NOT NULL,
    gender nvarchar(256) NOT NULL,
    department nvarchar(256) NOT NULL
);

----------------------------------------------------------------------------------

CREATE TABLE EVENTS(
	  codeNo varchar(32) PRIMARY KEY,
    name nvarchar(512) NOT NULL,
    date varchar(32) NOT NULL,
    beginTime varchar(32) NOT NULL,
    endTime varchar(32) NOT NULL
);

----------------------------------------------------------------------------------

CREATE TABLE REGISTER(
	  codeNo varchar(32) NOT NULL,
    RFID varchar(32) NOT NULL,
		codeID varchar(32) NOT NULL,
    PRIMARY KEY (codeNo, RFID),
);

----------------------------------------------------------------------------------

CREATE TABLE CHECKIN(
	  codeNo varchar(32) NOT NULL,
    codeID varchar(32) NOT NULL,
    fullName nvarchar(32) NOT NULL,
    inputTime varchar(32),
    outTime varchar(32),
		isJoin varchar(32),
    PRIMARY KEY (codeNo, codeID)
);

----------------------------------------------------------------------------------
