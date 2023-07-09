--liquibase formatted sql

--changeset duy:0001
CREATE SEQUENCE IF NOT EXISTS auto_user_code;
CREATE EXTENSION IF NOT EXISTS pgcrypto;
CREATE TABLE IF NOT EXISTS users
(
    user_id           VARCHAR(36) NOT NULL,
    user_code         VARCHAR(10) NOT NULL UNIQUE DEFAULT CONCAT('NV', LPAD(NEXTVAL('auto_user_code')::TEXT, 6, '0')),
    username          VARCHAR(10) NULL,
    first_name        VARCHAR(10) NULL,
    last_name         VARCHAR(10) NULL,
    mobile            VARCHAR(15) NULL,
    active            varchar(10) NOT NULL        DEFAULT 'ACTIVE',
    email             VARCHAR(50) NULL,
    password          VARCHAR(255) NOT NULL,
    registered_at     VARCHAR(20) NOT NULL        DEFAULT TO_CHAR(NOW(), 'DD-MM-YYYY HH24:MI:SS'),
    modification_date DATE        NULL            DEFAULT NULL,
    lastLogin         DATE        NULL            DEFAULT NULL,
    PRIMARY KEY (user_id)
);
CREATE UNIQUE INDEX "index_mobile" ON users (mobile ASC);
CREATE UNIQUE INDEX "index_mail" ON users (email ASC);

--changeset duy:0002
CREATE TABLE IF NOT EXISTS role -- Create Role
(
    role_id     VARCHAR(36)  NOT NULL DEFAULT GEN_RANDOM_UUID(),
    title       VARCHAR(30)  NOT NULL,
    slug        VARCHAR(15)  NOT NULL,
    active      varchar(10)  NOT NULL DEFAULT 'ACTIVE',
    description varchar(200) NULL,
    created_at  VARCHAR(20)  NOT NULL DEFAULT TO_CHAR(NOW(), 'DD-MM-YYYY HH24:MI:SS'),
    updated_at  DATE         NULL     DEFAULT NULL,
    PRIMARY KEY (role_id)
);
CREATE UNIQUE INDEX index_slug ON role (slug ASC);

CREATE TABLE IF NOT EXISTS user_role  -- Create User_Role
(
    user_id VARCHAR(36) NOT NULL,
    role_id VARCHAR(36) NOT NULL,
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT fku_role FOREIGN KEY (role_id)
        REFERENCES role (role_id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT fkr_user FOREIGN KEY (user_id)
        REFERENCES users (user_id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

INSERT INTO role (TITLE, SLUG, ACTIVE, DESCRIPTION)
VALUES ('Cấp ADMIN', 'ROLE_ADMIN', 'ACTIVE', 'Thông tin mô tả ADMIN'),
       ('Cấp User', 'ROLE_USER', 'ACTIVE', 'Thông tin mô tả USER'),
       ('Cấp Manage', 'ROLE_MANAGER', 'ACTIVE', 'Thông tin mô tả MANAGER');