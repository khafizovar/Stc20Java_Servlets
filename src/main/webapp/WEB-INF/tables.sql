-- auto-generated definition
create table mobile
(
    id           bigserial    not null
        constraint mobile_pkey
            primary key,
    model        varchar(100) not null,
    price        integer      not null,
    manufacturer varchar(100) not null
);

alter table mobile
    owner to postgres;


-- auto-generated definition
create table users
(
    username     text not null,
    email        text,
    phone_number text,
    password     text  not null
);

alter table users
    owner to postgres;

