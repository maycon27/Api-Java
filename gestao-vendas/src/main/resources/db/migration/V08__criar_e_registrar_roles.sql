create table role (
                      id bigint not null auto_increment,
                      nome varchar(255),
                      primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

insert into role(id,nome) values (1, 'ROLE_USER');
insert into role(id,nome) values (2, 'ROLE_ADMIN');