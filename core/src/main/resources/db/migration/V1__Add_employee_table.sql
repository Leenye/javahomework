CREATE TABLE employee(
  id INT AUTO_INCREMENT primary key,
  name VARCHAR (10) NOT NULL ,
  gender CHAR(1) NOT NULL ,
  age INT NOT NULL ,
  email VARCHAR(30) NOT NULL,
  role VARCHAR(10) NOT NULL,
  statement VARCHAR (20)
);

INSERT INTO employee (name,gender,age,email,role,statement) VALUES ("lily",'F','1','1@hello',"coach","on");
INSERT INTO employee (name,gender,age,email,role,statement) VALUES ("lucy",'F','2','23@hello',"coach","on");
INSERT INTO employee (name,gender,age,email,role,statement) VALUES ("john",'M','3','13@hello',"coach","on");
INSERT INTO employee (name,gender,age,email,role,statement) VALUES ("mike",'M','8','123@hello',"OPs","on");
INSERT INTO employee (name,gender,age,email,role,statement) VALUES ("coco",'F','12','3@hello',"HR","on");

