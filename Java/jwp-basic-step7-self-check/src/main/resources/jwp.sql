DROP TABLE IF EXISTS USERS;

CREATE TABLE USERS ( 
	userId          varchar(12)		NOT NULL, 
	password		varchar(12)		NOT NULL,
	name			varchar(20)		NOT NULL,
	email			varchar(50),	
  	
	PRIMARY KEY               (userId)
);

INSERT INTO USERS VALUES('admin', 'password', '자바지기', 'admin@slipp.net');

DROP TABLE IF EXISTS QUESTIONS;

CREATE TABLE QUESTIONS (
	questionId 			bigint				auto_increment,
	writer				varchar(30)			NOT NULL,
	title				varchar(50)			NOT NULL,
	contents			varchar(5000)		NOT NULL,
	createdDate			timestamp			NOT NULL,
	countOfAnswer int,
	PRIMARY KEY               (questionId)
);

DROP TABLE IF EXISTS ANSWERS;

CREATE TABLE ANSWERS (
	answerId 			bigint				auto_increment,
	writer				varchar(30)			NOT NULL,
	contents			varchar(5000)		NOT NULL,
	createdDate			timestamp			NOT NULL,
	questionId			bigint				NOT NULL,				
	PRIMARY KEY         (answerId)
);

INSERT INTO QUESTIONS (questionId, writer, title, contents, createdDate, countOfAnswer) VALUES
(1, '자바지기',
'asdf',
'd',
CURRENT_TIMESTAMP, 0);

INSERT INTO QUESTIONS (questionId, writer, title, contents, createdDate, countOfAnswer) VALUES
(2, '김문수',
'asdf',
'dfff',
CURRENT_TIMESTAMP, 0);

INSERT INTO QUESTIONS (questionId, writer, title, contents, createdDate, countOfAnswer) VALUES
(3, '자바지기',
'd',
'fff',
CURRENT_TIMESTAMP, 0);


INSERT INTO QUESTIONS (questionId, writer, title, contents, createdDate, countOfAnswer) VALUES
(4, '자바지기',
'sd',
'ff',
CURRENT_TIMESTAMP, 0);

INSERT INTO QUESTIONS (questionId, writer, title, contents, createdDate, countOfAnswer) VALUES
(5, 'johnburr',
'e',
'yy',
CURRENT_TIMESTAMP, 0);

INSERT INTO QUESTIONS (questionId, writer, title, contents, createdDate, countOfAnswer) VALUES
(6, '자바지기',
'sds',
'jjj',
CURRENT_TIMESTAMP, 0);

INSERT INTO QUESTIONS (questionId, writer, title, contents, createdDate, countOfAnswer) VALUES
(7, 'javajigi',
'sdfadsf',
'fgfgsdfgsdf',
CURRENT_TIMESTAMP, 2);

INSERT INTO ANSWERS (writer, contents, createdDate, questionId) VALUES
('eungju',
'hh',
CURRENT_TIMESTAMP, 7);

INSERT INTO ANSWERS (writer, contents, createdDate, questionId) VALUES
('Hanghee Yi',
'jjj',
CURRENT_TIMESTAMP, 7);

INSERT INTO QUESTIONS (questionId, writer, title, contents, createdDate, countOfAnswer) VALUES
(8, '자바지기',
'yyyy','dddd',
CURRENT_TIMESTAMP, 3);

INSERT INTO ANSWERS (writer, contents, createdDate, questionId) VALUES
('jhindhal.jhang',
'kjh',
CURRENT_TIMESTAMP, 8);

INSERT INTO ANSWERS (writer, contents, createdDate, questionId) VALUES
('강우',
'b ',
CURRENT_TIMESTAMP, 8);

INSERT INTO ANSWERS (writer, contents, createdDate, questionId) VALUES
('Toby Lee',
'jhg',
CURRENT_TIMESTAMP, 8);