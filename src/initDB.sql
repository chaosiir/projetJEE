USE projetJEE;

CREATE TABLE Students(
	ID varchar(9) NOT NULL,
	Gender varchar(1) NOT NULL,
	FirstName varchar(64) NOT NULL,
	LastName varchar(64) NOT NULL,
	Birthday date NOT NULL,
	Bac varchar(16),
	BacYear int,
	BacGrade varchar(2),
	Degree varchar(16),
	DegreeYear int,
	DegreeCity varchar(64),
	RegistrationYear int,
	EmailPro varchar(64),
	EmailPer varchar(64),
	PRIMARY KEY (ID)
);