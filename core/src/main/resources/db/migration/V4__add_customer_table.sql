CREATE TABLE customer_table (
  customer_id INT AUTO_INCREMENT primary key,
  customer_name VARCHAR (10) NOT NULL ,
  ownCoach_id INT ,
  ownCourses INT ,
  FOREIGN KEY (ownCoach_id) REFERENCES usr_table(id),
  FOREIGN KEY (ownCourses) REFERENCES course_table(course_id)
);
