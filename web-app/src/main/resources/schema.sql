DROP TABLE if exists product;
CREATE TABLE products
(
    id VARCHAR (256) PRIMARY KEY ,
    name VARCHAR (256) ,
    quilograms NUMERIC,
    deliver_date DATE,
    price NUMERIC ,
);

DROP TABLE if exists consumers;

CREATE TABLE consumers
(
    id VARCHAR (256) PRIMARY KEY ,
    name VARCHAR (256) ,
    address VARCHAR (256) PRIMARY KEY ,
    email VARCHAR (256) PRIMARY KEY ,
    dni VARCHAR (10) PRIMARY KEY ,
);

DROP TABLE if exists farmers;

CREATE TABLE farmers
(
    id VARCHAR (256) PRIMARY KEY ,
    name VARCHAR (256) ,
    address VARCHAR (256) PRIMARY KEY ,
    email VARCHAR (256) PRIMARY KEY ,
    dni VARCHAR (10) PRIMARY KEY ,
);

DROP TABLE if exists organic_lots;

CREATE TABLE organic_lots
(
    id VARCHAR (256) PRIMARY KEY ,
    quilograms NUMERIC,
    deliver_date DATE,
    done_date DATE,
    state VARCHAR(20),
);