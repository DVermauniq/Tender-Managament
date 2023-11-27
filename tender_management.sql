create database tender_management;
use tender_management;
create table Admin(userId int not null auto_increment primary key,userName varchar(12) not null unique,password varchar(10));
-- partial insertion --
insert into Admin(userName,password)values('root','root');
select * from Admin;

create table Vendor(venId int primary key,vname varchar(15),mobile int,email varchar(30), address varchar(20),companyName varchar(25));
desc Vendor;
-- insert values
insert into Vendor values(1,'Arjit singh',983467449,'arjit@gmail.com','delhi','Shree Om constructions');
insert into Vendor values(2,'Amandeep',983499289,'Amandeep@gmail.com','gurugaon','deep constructions');
insert into Vendor values(3,'Monika sharma',983445289,'Monika@gmail.com','mumbai','Sharma constructions');
insert into Vendor values(4,'rahul',983887289,'rahul@gmail.com','lucknow','Rj constructions');
insert into Vendor values(5,'pawan singh',983461189,'pawan@gmail.com','rohtak','pawan constructions');
insert into Vendor values(6,'Atul mangla',973455289,'Atul@gmail.com','karnal','AM Constructions');
select * from Vendor;

create table Tender(tenId int primary key,vname varchar(15),Type varchar(30), price int,location varchar(25));
desc Tender;
insert into Tender values(1,'Arjun','Raod',500000,'delhi');
insert into Tender values(2,'karan','hospital',700000,'mp');
insert into Tender values(3,'Ashu','flyover',900000,'up');
insert into Tender values(4,'Jay','hotel',400000,'haryana');
select * from Tender;
show tables;

create table Bidder(Id int primary key,venId int references Vendor(venId),tenID int references Tender(tenID),price int,Status varchar(25));
desc Bidder;