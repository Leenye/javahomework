CREATE TABLE course_table (
  id INT AUTO_INCREMENT primary key,
  name VARCHAR(10) NOT NULL,
  time VARCHAR(10) NOT NULL,
  coach_id INT NOT NULL,
  FOREIGN KEY (coach_id) REFERENCES employee_table(id)
);

INSERT INTO course_table (name,time,coach_id) VALUES ('动感单车',"星期一",1);
INSERT INTO course_table (name,time,coach_id) VALUES ('搏击操',"星期一",3);
INSERT INTO course_table (name,time,coach_id) VALUES ('私教课',"星期二",1);
INSERT INTO course_table (name,time,coach_id) VALUES ('瑜伽',"星期二",2);
INSERT INTO course_table (name,time,coach_id) VALUES ('私教课',"星期三",2);
INSERT INTO course_table (name,time,coach_id) VALUES ('搏击',"星期三",3);
INSERT INTO course_table (name,time,coach_id) VALUES ('瑜伽',"星期五",2);
INSERT INTO course_table (name,time,coach_id) VALUES ('动感单车',"星期五",1);




