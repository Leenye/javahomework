CREATE TABLE employee_table(
  id INT AUTO_INCREMENT primary key,
  name VARCHAR (10) NOT NULL ,
  role VARCHAR(10) NOT NULL,
  statement VARCHAR (20)
);

INSERT INTO employee_table (name,role,statement) VALUES ("lily","coach","on");
INSERT INTO employee_table (name,role,statement) VALUES ("lucy","coach","on");
INSERT INTO employee_table (name,role,statement) VALUES ("john","coach","on");
INSERT INTO employee_table (name,role,statement) VALUES ("mike","OPs","on");
INSERT INTO employee_table (name,role,statement) VALUES ("coco","HR","on");

