CREATE TABLE usr_table (
  id INT AUTO_INCREMENT primary key,
  name VARCHAR(10) NOT NULL ,
  gender CHAR(1) NOT NULL ,
  age INT NOT NULL ,
  email VARCHAR(30) NOT NULL
);

INSERT INTO ${usr_table} (name,gender,age,email) VALUES ('aa','m','10','123@123');
INSERT INTO ${usr_table} (name,gender,age,email) VALUES ('hey','f','16','123@00');
INSERT INTO ${usr_table} (name,gender,age,email) VALUES ('lucy','m','12','123@hello');
INSERT INTO ${usr_table} (name,gender,age,email) VALUES ('lily','m','10','123@123');
INSERT INTO ${usr_table} (name,gender,age,email) VALUES ('john','f','9','john@123');
