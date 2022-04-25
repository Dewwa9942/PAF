DROP DATABASE IF EXISTS electroGridDB;

CREATE DATABASE electroGridDB;
USE electroGridDB;

SET @@SESSION.auto_increment_increment=1;

# Payment - Month, Price, Date, Method
CREATE TABLE payment(
                     id INT NOT NULL AUTO_INCREMENT,
                     month VARCHAR(100) NOT NULL,
                     price VARCHAR(100) NOT NULL,
                     date VARCHAR(100) NOT NULL,
                     method VARCHAR(50) NOT NULL ,

                     CONSTRAINT pk_payment PRIMARY KEY(id)
);

INSERT INTO payment(month,price,date, method)
VALUES
    ("month 1", "price 1", "date 1", "method 1"),
    ("month 2", "price 2", "date 2", "method 2"),
    ("month 3", "price 3", "date 3", "method 3"),
    ("month 4", "price 4", "date 4", "method 4"),
    ("month 5", "price 5", "date 5", "method 5");
