DROP DATABASE IF EXISTS electroGridDB;

CREATE DATABASE electroGridDB;
USE electroGridDB;

SET @@SESSION.auto_increment_increment=1;

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
    ("B", "2022-04-11", "10.30", "4"),
    ("C", "2022-04-12", "8.00", "4"),
    ("D", "2022-04-13", "9.00", "6"),
    ("E", "2022-04-14", "10.00", "5");
