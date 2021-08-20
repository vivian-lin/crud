CREATE TABLE test (
    id INT NOT NULL IDENTITY PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

INSERT INTO test (name) values ('this is my name');