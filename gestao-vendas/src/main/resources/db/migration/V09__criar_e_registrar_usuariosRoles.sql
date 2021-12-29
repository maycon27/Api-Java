create table usuarios_roles (
         usuario_codigo bigint not null,
         role_codigo bigint not null,
         FOREIGN KEY (usuario_codigo) REFERENCES usuario(id),
         FOREIGN KEY (role_codigo) REFERENCES role(id)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

insert into usuarios_roles(usuario_codigo,role_codigo) values(1, 1);
insert into usuarios_roles(usuario_codigo,role_codigo) values(2, 2);