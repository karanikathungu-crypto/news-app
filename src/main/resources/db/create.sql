--SET MODE PostgresSQL;
CREATE TABLE if NOT EXISTS news(
    id int PRIMARY KEY auto_increment,
    headline VARCHAR,
    information VARCHAR,
);

CREATE TABLE if NOT EXISTS departments(
    id int PRIMARY KEY auto_increment,
    departmentName VARCHAR,
    staffNumber INTEGER
);
CREATE TABLE if NOT EXISTS users(
    id int PRIMARY KEY auto_increment,
    userName VARCHAR,
    companyPosition VARCHAR,
);

