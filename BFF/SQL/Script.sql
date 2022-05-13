DROP DATABASE IF EXISTS electroGridDB;

CREATE DATABASE electroGridDB;
USE electroGridDB;

SET @@SESSION.auto_increment_increment=1;

# User - NIC, Name, City, Number
CREATE TABLE user(
                     id INT NOT NULL AUTO_INCREMENT,
                     nic VARCHAR(10) NOT NULL,
                     name VARCHAR(100) NOT NULL,
                     city VARCHAR(100) NOT NULL,
                     number VARCHAR(10) NOT NULL,

                     CONSTRAINT pk_user PRIMARY KEY(id)
);

INSERT INTO user(nic,name,city,number)
VALUES
    ("123456789V", "user 1", "city 1", "123456789"),
    ("234567890V", "user 2", "city 2", "234567890"),
    ("345678901V", "user 3", "city 3", "345678901"),
    ("456789012V", "user 4", "city 4", "456789012"),
    ("567890123V", "user 5", "city 5", "567890123");

# Payment - Month, Price, Date, Method
CREATE TABLE payment(
                     id INT NOT NULL AUTO_INCREMENT,
                     month VARCHAR(100) NOT NULL,
                     price VARCHAR(100) NOT NULL,
                     date VARCHAR(100) NOT NULL,
                     method VARCHAR(50) NOT NULL,

                     CONSTRAINT pk_payment PRIMARY KEY(id)
);

INSERT INTO payment(month,price,date,method)
VALUES
        ("January", "100", "2022-01-28", "Visa Card"),
        ("February", "200", "2022-02-28", "Master Card"),
        ("March", "300", "2022-03-28", "Master Card"),
        ("April", "400", "2022-04-28", "Visa Card"),
        ("May", "500", "2022-05-28", "Visa Card");

# Bill - Month, Price, Date, Meter Reader
CREATE TABLE bill(
                     id INT NOT NULL AUTO_INCREMENT,
                     month VARCHAR(50) NOT NULL,
                     price VARCHAR(100) NOT NULL,
                     date VARCHAR(100) NOT NULL,
                     meterReader VARCHAR(100) NOT NULL,

                     CONSTRAINT pk_bill PRIMARY KEY(id)
);

INSERT INTO bill(month,price,date,meterReader)
VALUES
    ("month 1", "price 1", "date 1", "meter reader 1"),
    ("month 2", "price 2", "date 2", "meter reader 2"),
    ("month 3", "price 3", "date 3", "meter reader 3"),
    ("month 4", "price 4", "date 4", "meter reader 4"),
    ("month 5", "price 5", "date 5", "meter reader 5");

# Feedback - NIC, Category, Location, Message
CREATE TABLE feedback(
                     id INT NOT NULL AUTO_INCREMENT,
                     nic VARCHAR(10) NOT NULL,
                     category VARCHAR(100) NOT NULL,
                     location VARCHAR(100) NOT NULL,
                     message VARCHAR(100) NOT NULL,

                     CONSTRAINT pk_feedback PRIMARY KEY(id)
);

INSERT INTO feedback(nic,category,location,message)
VALUES
    ("123456789V", "category 1", "location 1", "message 1"),
    ("234567890V", "category 2", "location 2", "message 2"),
    ("345678901V", "category 3", "location 3", "message 3"),
    ("456789012V", "category 4", "location 4", "message 4"),
    ("567890123V", "category 5", "location 5", "message 5");

# PowerCutSchedule - Zone, Date, Time, TotalHours
CREATE TABLE powercutschedule(
                     id INT NOT NULL AUTO_INCREMENT,
                     zone VARCHAR(10) NOT NULL,
                     date VARCHAR(100) NOT NULL,
                     time VARCHAR(100) NOT NULL,
                     totalHours VARCHAR(100) NOT NULL,

                     CONSTRAINT pk_powercutschedule PRIMARY KEY(id)
);

INSERT INTO powercutschedule(zone,date,time,totalHours)
VALUES
        ("A", "2022-04-10", "8.30", "5"),
        ("B", "2022-04-11", "10.30 2", "4"),
        ("C", "2022-04-12", "8.00", "4"),
        ("D", "2022-04-13", "9.00", "6"),
        ("E", "2022-04-14", "10.00", "5");