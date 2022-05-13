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
    ("January", "100", "2022-01-28", "Visa Card"),
    ("February", "200", "2022-02-28", "Master Card"),
    ("March", "300", "2022-03-28", "Master Card"),
    ("April", "400", "2022-04-28", "Visa Card"),
    ("May", "500", "2022-05-28", "Visa Card");
