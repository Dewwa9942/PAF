DROP DATABASE IF EXISTS electroGridDB;

CREATE DATABASE electroGridDB;
USE electroGridDB;

SET @@SESSION.auto_increment_increment=1;

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
