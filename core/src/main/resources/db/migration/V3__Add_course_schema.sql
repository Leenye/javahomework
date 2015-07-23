CREATE TABLE course (
  id INT AUTO_INCREMENT primary key,
  name VARCHAR(10) NOT NULL,
  details VARCHAR (50)

);

INSERT INTO course (name,details) VALUES ('动感单车','锻炼耐力，减肥');
INSERT INTO course (name,details) VALUES ('健美操','健身美体');
INSERT INTO course (name) VALUES ('动感单车');

CREATE TABLE schedule (
  id INT NOT NULL AUTO_INCREMENT primary key,
  course_id INT,
  coach_id INT,
  time DATE,
  customer VARCHAR(20) ,

  FOREIGN KEY (course_id) REFERENCES course(id) ,
  FOREIGN KEY (coach_id) REFERENCES employee(id)
);

