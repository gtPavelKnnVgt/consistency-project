create table financial_claim
(
    id                 bigint primary key generated always as identity,
    number             varchar not null,
    date               date not null,
    status varchar not null,
    agreement_id bigint,
    verification_status varchar,

    constraint fk_financial_claim_agreement_id
        foreign key (agreement_id) references agreement (id)
);