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
    ("A", "date 1", "time 1", "totalHours 1"),
    ("B", "date 2", "time 2", "totalHours 2"),
    ("C", "date 3", "time 3", "totalHours 3"),
    ("D", "date 4", "time 4", "totalHours 4"),
    ("E", "date 5", "time 5", "totalHours 5");
