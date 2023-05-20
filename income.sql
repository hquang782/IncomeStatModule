create database `incomestat`;
use `incomestat`;

CREATE TABLE `store` (
    `ID` INT(11) PRIMARY KEY auto_increment,
    `name` VARCHAR(255) NOT NULL,
    `address` VARCHAR(255) NOT NULL,
    `des` VARCHAR(255) NOT NULL,
    `starRating` int(10) 
    
);

create table `MotorBike`(
	`ID` int(11) primary key auto_increment, 
    `name` varchar(255) not null,
    `type` varchar(255) not null,
    `numberplate` varchar(255) not null,
    `company` varchar(255) not null,
    `price` float(10) not null,
	`des` varchar(255),
	`storeID` int(11),
    foreign key(`storeID`) references `store`(`id`)
);

create table `user`(
	`ID` int(11) primary key auto_increment, 
	`username` varchar(255) not null,
    `password` varchar(255) not null,
    `role` varchar(255) not null
);

create table `client`(
	`ID` int(11) primary key auto_increment, 
    `fullname` varchar(255) not null,
    `idCard` varchar(255) not null,
    `address` varchar(255) not null,
    `email` varchar(255) not null,
    `tel` varchar(255) not null,
    `note` varchar(255) not null
);

create table `error`(
	`ID` int(11) primary key auto_increment, 
	`name` varchar(255) not null,
    `fine` float(10) not null,
    `note` varchar(255)
);

create table `motorbikeerror`(
	`ID` int(11) primary key auto_increment,
    `note` varchar(255),
    `errorID` int(11),
    `motorbikeID` int(11),
    foreign key (`errorID`) references `error`(`ID`),
    foreign key (`motorbikeID`) references `motorbike`(`ID`)
);

create table `renting` (
	`ID` int(11) primary key auto_increment,
    `rentDay` date,
	`note` varchar(255) ,
    `userID` int(11),
    `clientID` int(11),
    foreign key (`userID`) references `user`(`ID`),
    foreign key (`clientID` ) references `client`(`ID`)
);

create table `rentedmotorbike`(
	`ID` int(11) primary key auto_increment,
    `price` float(10) not null,
    `reveiveDay` date not null,
    `returnDay` date not null,
    `saleOff` float(10) not null,
    `isTaken` boolean not null,
    `motorbikeID` int(11) ,
    `rentingID` int(11),
    foreign key (`motorbikeID`) references `motorbike`(`ID`),
    foreign key (`rentingID`) references `renting`(`ID`)
);

create table `checkederror`(
	`ID` int(11) primary key auto_increment,
    `note` varchar(255) ,
    `rentedmotorbikeID` int(11),
    `errorID` int(11) ,
    foreign key(`rentedmotorbikeID`) references `rentedmotorbike`(`ID`),
    foreign key(`errorID`) references `error`(`ID`)
);

create table `bill`(
	`ID` int(11) primary key auto_increment,
	`paymentDay` date not null,
    `paymentType` varchar(255) not null,
    `amount` float(10),
    `rentingID` int(11) ,
    `userID` int(11),
    foreign key (`rentingID`) references `renting`(`ID`),
    foreign key (`userID`) references `user`(`ID`)
);

CREATE TABLE `deposit` (
    `ID` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `value` FLOAT(10),
    `note` VARCHAR(255),
    `rentingID` INT(11),
    FOREIGN KEY (`rentingID`)
        REFERENCES `renting` (`ID`)
);

create table `insurance` (
	`ID` int(11) primary key auto_increment,
    `name` varchar(255) not null,
    `note` varchar(255) ,
    `rentingID` int(11),
    foreign key (`rentingID`) references `renting`(`ID`)    
);