create table if not exists link
(
    id                  serial primary key,
    transaction_type_id integer,
    FOREIGN KEY (transaction_type_id) REFERENCES transaction_type (id),
    driver_id           integer,
    FOREIGN KEY (driver_id) REFERENCES driver (id),
    amount              bigint,
    week_number         integer,
    date                date,
    comment             varchar
);

