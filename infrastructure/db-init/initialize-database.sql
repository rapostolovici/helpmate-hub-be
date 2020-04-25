-- create super user role
CREATE ROLE helpmate_su WITH LOGIN PASSWORD 'helpmate';
-- create app user role
CREATE ROLE mate WITH LOGIN PASSWORD 'mate' NOSUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION;

CREATE DATABASE helpmate_database;

GRANT ALL PRIVILEGES ON DATABASE helpmate_database TO helpmate_su;
GRANT ALL PRIVILEGES ON DATABASE helpmate_database TO mate;