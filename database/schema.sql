create database usertask

create table user (
	  user_id char(8) not null UNIQUE,
	  username varchar(64) not null,
	  name varchar(255)
	);

INSERT INTO user (user_id, username, name) VALUES ('1b80114c', 'fred', 'Fred');
INSERT INTO user (user_id, username, name) VALUES ('cf66dae3', 'wilma', 'Wilma');
INSERT INTO user (user_id, username, name) VALUES ('a8b9800d', 'barney', 'Barney');
INSERT INTO user (user_id, username, name) VALUES ('66223e28', 'betty', 'Betty');

create table task (
	  task_id int not null UNIQUE AUTO_INCREMENT,
      description varchar(255),
	  priority int not null,
	  due_date DATE,
      username char(255)
	);

