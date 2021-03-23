drop table if exists task;

create table task(id bigint identity NOT NULL primary key, name varchar(255), description varchar(255), last_modification_date TIMESTAMP NOT NULL DEFAULT NOW());
