create database HMS
use HMS
create table Admin(
username varchar(25),
password varchar(25)
);
DROP DATABASE HMS
create table StaffType(
staffType varchar(50)  PRIMARY KEY
)
 create table Staff(
stId int IDENTITY(1,1),
firstName varchar(20) NOT NULL,
lastName varchar(20) NOT NULL,
mobileNo varchar(10) UNIQUE NOT NULL,
gender varchar(6) NOT NULL,
age tinyInt NOT NULL,
email varchar(20) UNIQUE,
homeAddress varchar(50) NOT NULL,
stafftype varchar(50) foreign key references StaffType(staffType),
CONSTRAINT PK_STAFF PRIMARY KEY(stId)
);
SELECT * FROM Staff
SELECT doctorId,firstName,lastName,mobileNo,gender,age,Name,email,homeAddress FROM Doctor,Staff,Department WHERE StaffType='Doctor' AND stId =staffId
DELETE STAFF WHERE stId=4
DELETE DOCTOR WHERE doctorId=1000
INSERT INTO STAFF VALUES('Eman','Yasin','0923567832','FEMALE',27,'emu@gmail.com','nifas silk','Nurse')
INSERT INTO STAFF VALUES('Menal','Yusuf','0923510832','FEMALE',27,'sam@gmail.com','nifas silk','Nurse')
INSERT INTO STAFF VALUES('Kamila','Mustafa','0910867832','FEMALE',27,'aqw12@gmail.com','nifas silk','Nurse')
INSERT INTO STAFF VALUES('Yohhana','Markos','0923563082','FEMALE',27,'dva@gmail.com','nifas silk','Doctor')
INSERT INTO STAFF VALUES('Danait','Sol','0901727832','FEMALE',27,'kope@gmail.com','nifas silk','Receptionist')
INSERT INTO STAFF VALUES('Feruz','Jemal','0920842632','FEMALE',27,'pisa@gmail.com','nifas silk','Receptionist')
INSERT INTO STAFF VALUES('Faiza','Seid','0998526832','FEMALE',27,'aqer@gmail.com','nifas silk','Receptionist')
INSERT INTO StaffType VALUES('Doctor')
INSERT INTO StaffType VALUES('Nurse')
INSERT INTO StaffType VALUES('Receptionist')
select * from staff
create table Department(
deptId int IDENTITY(1,1),
Name varchar(50) NOT NULL,
CONSTRAINT PK_DEPARTMENT PRIMARY KEY(deptId)
);

INSERT INTO Department VALUES('Cardiology')

create table Doctor(
doctorId int identity(1000,1),
deptId int foreign key references Department(deptId),
staffId int foreign key references Staff(stId) on delete cascade,
username varchar(25) UNIQUE,
password varchar(25) NOT NULL,
active bit NOT NULL DEFAULT 1,
CONSTRAINT PK_DOCTOR PRIMARY KEY(doctorId)
);
ALTER TABLE Doctor
  ADD CONSTRAINT FK_DOCTOR_STAFF
  FOREIGN KEY (staffId)
  REFERENCES Staff(stId)
  ON DELETE CASCADE;
DELETE STAFF WHERE stId=4
SELECT * FROM Staff
ALTER TABLE Doctor ALTER COLUMN staffId  int  on delete cascade
SELECT * FROM Doctor,Staff Where doctorId=1000 AND stId=staffId

INSERT INTO DOCTOR VALUES(1,1000,'belay','12345',1)
SELECT doctorId,firstName,lastName,mobileNo,gender,age,Name,homeAddress FROM Doctor,Staff,Department
create table Nurse(
nurseId int identity(1000,1),
staffId int foreign key references Staff(stId) ON DELETE CASCADE,
active bit NOT NULL DEFAULT 1,
CONSTRAINT PK_NURSE PRIMARY KEY(nurseId),
);
alter table nurse alter column nurseId int identity ;
INSERT INTO Nurse VALUES(1001,1)
SELECT * FROM Nurse
SELECT nurseId,firstName,lastName,mobileNo,gender,age,homeAddress FROM NURSE,Staff WHERE StaffType='Nurse'

Create table Receptionist(
rId int identity(1000,1),
staffId int foreign key references Staff(stId) ON DELETE CASCADE,
username varchar(10) UNIQUE  NOT NULL,
password varchar(10)  NOT NULL,
);
ALTER TABLE Nurse
  ADD CONSTRAINT FK_NURSE_STAFF
  FOREIGN KEY (staffId)
  REFERENCES Staff(stId)
  ON DELETE CASCADE;

INSERT INTO Receptionist VALUES(1002,'eman','emuti')
SELECT * FROM Receptionist, Staff
SELECT rId,firstName,lastName,mobileNo,gender,age,homeAddress FROM Receptionist,Staff WHERE StaffType='Receptionist'
create table Patient(
patientId int identity (1000,1),
firstName varchar(25) NOT NULL,
lastName varchar(25) NOT NULL,
mobileNo varchar(20) UNIQUE NOT NULL,
patient_type varchar(25) NOT NULL,
bloodgroup varchar(10) NOT NULL,
Address varchar(50),
dateAdded date NOT NULL DEFAULT GETDATE(),
age tinyint NOT NULL,
gender varchar(6) NOT NULL,
CONSTRAINT PK_PATIENT PRIMARY KEY(patientID));
ALTER TABLE PATIENT ADD disease varchar(50)

INSERT INTO Patient VALUES('John','Smith','0945405147','inpatient','AB-','addis ababa ethiopia',GETDATE(),19,'MALE')


SELECT * FROM Doctor




create table Medicine(
medicineId int identity(1000,1) primary key,
medicineName varchar(20) NOT NULL,
medicineCompany varchar(20) ,
medicineCost varchar(20) 
);

 create table Prescription(
prescId int PRIMARY KEY identity(1,1000),
ptId int foreign key references Patient(patientId),
docId int foreign key references Doctor(doctorId),
medicineId int foreign key references Medicine(medicineId),
dose varchar(255) NOT NULL,
dateof date  NOT NULL DEFAULT GETDATE(),
given bit NOT NULL
);

create table Room(
roomNo TINYint NOT NULL,
roomFloor tinyInt NOT NULL,
available bit DEFAULT 1,
CONSTRAINT PK_ROOM primary key(roomNo)
);

 create table Appointment(
appointId int identity(1000,1) primary key,
ptId int foreign key references Patient(patientId),
docId int foreign key references Doctor(doctorId),
nursId int foreign key references Nurse(nurseId),
roomNo tinyint foreign key references Room(roomNo),
dateof date  NOT NULL DEFAULT GETDATE(),
done bit NOT NULL
);

insert into Admin values('Admin','1234')







