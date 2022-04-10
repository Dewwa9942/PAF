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

# Payment - NIC, Month, Price, Date
CREATE TABLE payment(
                     id INT NOT NULL AUTO_INCREMENT,
                     nic VARCHAR(10) NOT NULL,
                     month VARCHAR(100) NOT NULL,
                     price VARCHAR(100) NOT NULL,
                     date VARCHAR(100) NOT NULL,

                     CONSTRAINT pk_payment PRIMARY KEY(id)
);

INSERT INTO payment(nic,month,price,date)
VALUES
    ("123456789V", "month 1", "price 1", "date 1"),
    ("234567890V", "month 2", "price 2", "date 2"),
    ("345678901V", "month 3", "price 3", "date 3"),
    ("456789012V", "month 4", "price 4", "date 4"),
    ("567890123V", "month 5", "price 5", "date 5");

# Bill - NIC, Price, Date, Meter Reader
CREATE TABLE bill(
                     id INT NOT NULL AUTO_INCREMENT,
                     nic VARCHAR(10) NOT NULL,
                     price VARCHAR(100) NOT NULL,
                     date VARCHAR(100) NOT NULL,
                     meterReader VARCHAR(100) NOT NULL,

                     CONSTRAINT pk_bill PRIMARY KEY(id)
);

INSERT INTO bill(nic,price,date,meterReader)
VALUES
    ("123456789V", "price 1", "date 1", "meter reader 1"),
    ("234567890V", "price 2", "date 2", "meter reader 2"),
    ("345678901V", "price 3", "date 3", "meter reader 3"),
    ("456789012V", "price 4", "date 4", "meter reader 4"),
    ("567890123V", "price 5", "date 5", "meter reader 5");

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
