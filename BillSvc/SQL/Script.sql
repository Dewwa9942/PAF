DROP DATABASE IF EXISTS electroGridDB;

CREATE DATABASE electroGridDB;
USE electroGridDB;

SET @@SESSION.auto_increment_increment=1;

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
