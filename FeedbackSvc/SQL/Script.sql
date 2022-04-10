DROP DATABASE IF EXISTS electroGridDB;

CREATE DATABASE electroGridDB;
USE electroGridDB;

SET @@SESSION.auto_increment_increment=1;

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
