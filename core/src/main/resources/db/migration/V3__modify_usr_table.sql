ALTER TABLE usr_table ADD role VARCHAR(5) NOT NULL;
ALTER TABLE usr_table ADD statement VARCHAR(5) NOT NULL DEFAULT TRUE ;

INSERT INTO usr_table (name,gender,age,email,password,role,statement) VALUES ('朱江','M','12','123@hello',"698d51a19d8a121ce581499d7b701668","coach","InUse" );
INSERT INTO usr_table (name,gender,age,email,password,role,statement) VALUES ('志慧','F','10','123@123',"698d51a19d8a121ce581499d7b701668","coach","InUse" );
INSERT INTO usr_table (name,gender,age,email,password,role,statement) VALUES ('小明','M','9','john@123',"698d51a19d8a121ce581499d7b701668","coach","InUse");
INSERT INTO usr_table (name,gender,age,email,password,role,statement) VALUES ('小崔','M','10','123@123',"698d51a19d8a121ce581499d7b701668","OP","InUse" );
INSERT INTO usr_table (name,gender,age,email,password,role,statement) VALUES ('小娟','F','16','123@00',"698d51a19d8a121ce581499d7b701668","HR","InUse" );

CREATE TABLE course_table (
  course_id INT AUTO_INCREMENT primary key,
  course_name VARCHAR(10) NOT NULL,
  course_coach INT NOT NULL,
  FOREIGN KEY (course_coach) REFERENCES usr_table(id)
);

INSERT INTO course_table (course_name,course_coach) VALUES ('动感单车',1);
INSERT INTO course_table (course_name,course_coach) VALUES ('瑜伽',2);
INSERT INTO course_table (course_name,course_coach) VALUES ('搏击操',3);
INSERT INTO course_table (course_name,course_coach) VALUES ('私教课',1);
INSERT INTO course_table (course_name,course_coach) VALUES ('私教课',2);
INSERT INTO course_table (course_name,course_coach) VALUES ('私教课',3);



CREATE TABLE time_table (
  time_id INT AUTO_INCREMENT primary key,
  course_time VARCHAR(10) NOT NULL
);

INSERT INTO time_table (course_time) VALUES ('星期一');
INSERT INTO time_table (course_time) VALUES ('星期二');
INSERT INTO time_table (course_time) VALUES ('星期三');
INSERT INTO time_table (course_time) VALUES ('星期四');
INSERT INTO time_table (course_time) VALUES ('星期五');


CREATE TABLE course_time_table (
  relationship_id INT AUTO_INCREMENT primary key,
  relationship_course_id INT NOT NULL,
  relationship_time_id INT NOT NULL,
  CONSTRAINT FOREIGN KEY (relationship_course_id) REFERENCES course_table(course_id),
  CONSTRAINT FOREIGN KEY (relationship_time_id) REFERENCES time_table(time_id)
);


