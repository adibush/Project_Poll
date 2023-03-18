
CREATE TABLE poll(
    id int NOT NULL AUTO_INCREMENT,
    question_id int ,
    question_title varchar(300) NOT NULL DEFAULT '',
    question_first_answer varchar(300) NOT NULL DEFAULT '',
    question_second_answer varchar(300) NOT NULL DEFAULT '',
    question_third_answer varchar(300) NOT NULL DEFAULT '',
    question_fourth_answer varchar(300) NOT NULL DEFAULT '',
    user_id INTEGER  ,
    answer varchar(300)


) ;






