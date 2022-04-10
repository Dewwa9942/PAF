DROP DATABASE IF EXISTS electroGridDB;

CREATE DATABASE electroGridDB;
USE electroGridDB;

SET @@SESSION.auto_increment_increment=1;

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
