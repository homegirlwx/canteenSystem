DROP DATABASE IF EXISTS checkoutdbtest;
CREATE DATABASE checkoutdbtest DEFAULT CHARACTER SET utf8;
USE checkoutdbtest;


##创建用户表
CREATE TABLE users (
   userId int auto_increment KEY  comment 'user Id',
   userName VARCHAR(30),
   password  VARCHAR(32)
)ENGINE=InnoDB; 

##创建food表
CREATE TABLE foods (
	foodId int auto_increment PRIMARY KEY,
   foodName  VARCHAR(23) unique  comment 'jine',
   foodPrice  double NULL comment 'jine'
)ENGINE=InnoDB;

##创建用户订单表
CREATE TABLE orders (
   orderId INT AUTO_INCREMENT PRIMARY KEY,
   payment  double NULL comment 'jine',
   paymentType  int(3) NULL comment 'jine',
   paymentStatus  int(10) NULL comment 'jine',
   createTime datetime NULL comment 'jine', 
   #updateTime datetime NULL comment 'jine', 
   paymentTime datetime NULL comment 'jine', 
   #endTime datetime NULL comment 'jine', 
   #closeTime datetime NULL comment 'jine', 
   userId int   comment 'user alias'
)ENGINE=InnoDB; 

CREATE TABLE shopcart (
   id  INT AUTO_INCREMENT PRIMARY KEY,
   userId  int,
   foodId  int,
   num int(10),
   curStatus tinyint(4),
   createTime datetime NULL comment 'jine', 
	updateTime datetime NULL comment 'jine'
)ENGINE=InnoDB; 