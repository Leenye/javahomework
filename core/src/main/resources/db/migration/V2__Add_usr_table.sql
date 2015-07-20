CREATE TABLE usr_table (
  id INT AUTO_INCREMENT primary key,
  name VARCHAR(10) NOT NULL ,
  gender CHAR(1) NOT NULL ,
  age INT NOT NULL ,
  email VARCHAR(30) NOT NULL,
  password VARCHAR (40) NOT NULL ,
  employee_id INT NOT NULL UNIQUE,
  FOREIGN KEY (employee_id) REFERENCES employee_table(id)
);

INSERT INTO usr_table (name,gender,age,email,password,employee_id) VALUES ('朱江','M','12','123@hello',"698d51a19d8a121ce581499d7b701668",1 );
INSERT INTO usr_table (name,gender,age,email,password,employee_id) VALUES ('志慧','F','10','123@123',"698d51a19d8a121ce581499d7b701668",2 );
INSERT INTO usr_table (name,gender,age,email,password,employee_id) VALUES ('小明','M','9','john@123',"698d51a19d8a121ce581499d7b701668",3);
INSERT INTO usr_table (name,gender,age,email,password,employee_id) VALUES ('小崔','M','10','123@123',"698d51a19d8a121ce581499d7b701668",4);
INSERT INTO usr_table (name,gender,age,email,password,employee_id) VALUES ('小娟','F','16','123@00',"698d51a19d8a121ce581499d7b701668",5);
