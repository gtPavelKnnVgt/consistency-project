create table linked_document
(
    id                  bigint primary key generated always as identity,
    number              varchar not null,
    issue_date          date,
    format              varchar not null,
    type                varchar not null,
    close_date          date,
    financial_claim_id  bigint  not null,
    amount              numeric(15, 2),
    personal_account_id varchar,

    constraint fk_linked_document_financial_claim_id
        foreign key (financial_claim_id) references financial_claim (id)
);