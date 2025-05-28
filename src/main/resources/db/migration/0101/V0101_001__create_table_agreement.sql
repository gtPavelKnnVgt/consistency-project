create table agreement
(
    id bigint primary key generated always as identity,
    number varchar not null,
    validity_date date not null
);