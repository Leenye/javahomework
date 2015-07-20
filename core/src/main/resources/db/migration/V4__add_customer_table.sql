CREATE TABLE customer_table (
  id INT AUTO_INCREMENT primary key,
  name VARCHAR (10) NOT NULL ,
  coach_id INT ,
  FOREIGN KEY (coach_id) REFERENCES employee_table(id)
);

INSERT INTO customer_table (name,coach_id) VALUES ('王欢',1);
INSERT INTO customer_table (name,coach_id) VALUES ('燕子',2);
INSERT INTO customer_table (name,coach_id) VALUES ('宇飞',1);

