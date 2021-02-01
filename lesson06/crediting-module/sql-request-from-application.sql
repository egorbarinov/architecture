

DROP TABLE banking_structure.course;
CREATE TABLE banking_structure.course
(
    date timestamp without time zone NOT NULL,
    PRIMARY KEY (date)
);


DROP TABLE banking_structure.rate_valute_mapping;
CREATE TABLE banking_structure.rate_valute_mapping
(
    course_date timestamp without time zone,
    valutes_pk bigserial

);

DROP TABLE banking_structure.currencies;
create table banking_structure.currencies (
    pk bigserial,
    id varchar(255),
    num_code varchar(255),
    char_code varchar(255),
    nominal numeric,
    name varchar(255),
    value numeric,
    primary key (pk));

-- Table: banking_structure.client

DROP TABLE banking_structure.client;
CREATE TABLE banking_structure.client
(
    id bigserial,
    name character varying(255),
    address character varying(255),
    is_resident boolean,
    job character varying(255),
    passport_id character varying(255),
    salary integer,
    status character varying(255),
    is_check_for_debts boolean,
    is_checkndfl boolean,
    is_not_criminal boolean,
    credit_id integer
);

-- Table: banking_structure.credit

DROP TABLE banking_structure.credit;
CREATE TABLE banking_structure.credit
(
    credit_id bigserial,
    credit_amount double precision,
    credit_period integer,
    credit_percentage double precision
);




