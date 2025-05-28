create table repayment_demand_link
(
    id                 bigint primary key generated always as identity,
    number             varchar not null,
    date               date,
    type               varchar not null,
    financial_claim_id bigint  not null,
    amount             numeric(15, 2),

    constraint fk_repayment_demand_link_financial_claim_id
        foreign key (financial_claim_id) references financial_claim (id)
);