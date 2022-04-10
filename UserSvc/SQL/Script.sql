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
