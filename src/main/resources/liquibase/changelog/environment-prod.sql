--liquibase formatted sql

--changeset duy:0001
CREATE SEQUENCE IF NOT EXISTS auto_user_code;
CREATE TABLE users
(
    user_id           VARCHAR(36) NOT NULL,
    user_code         VARCHAR(10) NOT NULL UNIQUE DEFAULT CONCAT('NV', LPAD(NEXTVAL('auto_user_code')::TEXT, 6, '0')),
    username          VARCHAR(10) NULL,
    first_name        VARCHAR(10) NULL,
    last_name         VARCHAR(10) NULL,
    mobile            VARCHAR(15) NULL,
    active            varchar(10) NOT NULL        DEFAULT 'ACTIVE',
    email             VARCHAR(50) NULL,
    password          VARCHAR(60) NOT NULL,
    registered_at     DATE        NOT NULL,
    modification_date DATE        NULL            DEFAULT NULL,
    lastLogin         DATE        NULL            DEFAULT NULL,
    PRIMARY KEY (user_id)
);
