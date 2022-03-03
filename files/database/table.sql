create table f_file
(
    id   bigint       not null auto_increment,
    name varchar(255) null,
    primary key (id)
);

create table f_page
(
    id      bigint       not null auto_increment,
    file_id bigint       not null,
    name    varchar(255) null,
    primary key (id)
);

create table f_layer
(
    id      bigint       not null auto_increment,
    page_id bigint       not null,
    name    varchar(255) null,
    primary key (id)
);