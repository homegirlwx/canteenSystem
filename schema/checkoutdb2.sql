DROP DATABASE IF EXISTS checkoutdb2;
CREATE DATABASE checkoutdb2 DEFAULT CHARACTER SET utf8;
USE checkoutdb2;

##创建用户表
CREATE TABLE users (
   userId int auto_increment KEY  comment 'user Id',
   userName VARCHAR(30),
   password  VARCHAR(32)
)ENGINE=InnoDB; 

##创建用户登录日志表
CREATE TABLE t_shopping_cart (
   cart_id  INT AUTO_INCREMENT PRIMARY KEY,
   user_alias  VARCHAR(23) ,
   item  VARCHAR(23),
   login_datetime datetime
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

##创建订单明细表
CREATE TABLE orderdetails (
   orderId VARCHAR(23) NULL comment 'jine',
   orderItem  VARCHAR(23) NULL comment 'jine',
   quantity  int(10) NULL comment 'jine',
   itemPrice  decimal(8,2) NULL comment 'jine',
   subtotalPrice decimal(8,2) NULL comment 'jine',
   PRIMARY KEY(orderId, ordetItem)
)ENGINE=InnoDB; 

##创建food表
CREATE TABLE foods (
   foodName  VARCHAR(23) unique PRIMARY KEY comment 'jine',
   foodPrice  double NULL comment 'jine'
)ENGINE=InnoDB; 


##插入初始化数据
INSERT INTO users (userAlias, userName, password) 
             VALUES('t-xuan', 'xuan', '123456');
COMMIT;