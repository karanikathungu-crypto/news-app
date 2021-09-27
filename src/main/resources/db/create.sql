SET MODE PostgresSQL;
CREATE DATABASE companynews;
\c companynews;
CREATE TABLE if NOT EXISTS news(
    id SERIAL PRIMARY KEY,
    headline VARCHAR,
    information VARCHAR,
);

CREATE TABLE if NOT EXISTS departments(
    id SERIAL PRIMARY KEY,
    departmentName VARCHAR,
    staffNumber INTEGER
);
CREATE TABLE if NOT EXISTS users(
    id SERIAL PRIMARY KEY,
    userName VARCHAR
);
