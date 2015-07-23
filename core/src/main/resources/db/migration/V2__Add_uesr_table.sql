CREATE TABLE user (
  id INT AUTO_INCREMENT primary key,
  name VARCHAR(10) NOT NULL ,
  password VARCHAR (40) NOT NULL ,
  employee_id INT NOT NULL UNIQUE,
  FOREIGN KEY (employee_id) REFERENCES employee(id)
);

INSERT INTO user (name,password,employee_id) VALUES ('朱江',"698d51a19d8a121ce581499d7b701668",1 );
INSERT INTO user (name,password,employee_id) VALUES ('志慧',"698d51a19d8a121ce581499d7b701668",2 );
INSERT INTO user (name,password,employee_id) VALUES ('小明',"698d51a19d8a121ce581499d7b701668",3);
INSERT INTO user (name,password,employee_id) VALUES ('小崔',"698d51a19d8a121ce581499d7b701668",4);
INSERT INTO user (name,password,employee_id) VALUES ('小娟',"698d51a19d8a121ce581499d7b701668",5);
