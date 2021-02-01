

DROP TABLE banking_structure.result_verification;
CREATE TABLE banking_structure.result_verification
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
    checkndfl boolean,
    is_not_criminal boolean,
    credit_id integer
);

