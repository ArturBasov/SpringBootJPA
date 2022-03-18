-- liquibase formatted sql

-- changeset ArthurBasov:1

CREATE TABLE authors
(
    id             serial NOT NULL PRIMARY KEY,
    name           varchar(100),
    surname        varchar(100),
    payment_status int
);

CREATE TABLE file_type
(
    id   serial NOT NULL PRIMARY KEY,
    type varchar(100)
);

CREATE TABLE files
(
    id           serial NOT NULL PRIMARY KEY,
    file_name    varchar(100),
    track_name   varchar(100),
    placements   int,
    author_id    int,
    file_type_id int,
    FOREIGN KEY (author_id) REFERENCES authors (id),
    FOREIGN KEY (file_type_id) REFERENCES file_type (id)
);

CREATE TABLE author_types
(
    author_id int,
    type_id   int,
    PRIMARY KEY (author_id, type_id),
    FOREIGN KEY (author_id) REFERENCES authors (id),
    FOREIGN KEY (type_id) REFERENCES file_type(id)
);

