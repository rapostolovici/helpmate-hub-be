CREATE SEQUENCE sq_user_id START 1;

CREATE TABLE t_user(
   id BIGINT PRIMARY KEY DEFAULT NEXTVAL('sq_user_id'),
   first_name VARCHAR(50),
   last_name VARCHAR(50),
   CONSTRAINT user_id_unique UNIQUE(id)
);

CREATE INDEX ON t_user (id);