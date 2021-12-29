create table usuario (
                      id bigint not null auto_increment,
                      email varchar(255),
                      login varchar(255),
                      nome varchar(255),
                      senha varchar(255),
                      primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

insert into usuario(nome,email,login,senha) values ('Maycon','maycon@gmail.com','maycon27','$2a$10$HKveMsPlst41Ie2LQgpijO691lUtZ8cLfcliAO1DD9TtZxEpaEoJe');
insert into usuario(nome,email,login,senha) values ('admin','admin@gmail.com','admin','$2a$10$HKveMsPlst41Ie2LQgpijO691lUtZ8cLfcliAO1DD9TtZxEpaEoJe');