create table bill
(
    id_bill       varchar(255) not null,
    customer_bill varchar(255),
    product_bill  varchar(255),
    total_price   double,
    id_user       varchar(255),
    primary key (id_bill)
);