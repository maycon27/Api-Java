CREATE TABLE venda (
	codigo BIGINT PRIMARY KEY AUTO_INCREMENT,
	data DATE NOT NULL,
	codigo_cliente BIGINT NOT NULL,
	codigo_vendedor BIGINT NOT NULL,
	FOREIGN KEY (codigo_cliente) REFERENCES cliente(codigo),
	FOREIGN KEY (codigo_vendedor) REFERENCES vendedor(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO venda(data, codigo_cliente, codigo_vendedor) VALUES ('2021-01-02', 1, 1);
INSERT INTO venda(data, codigo_cliente, codigo_vendedor) VALUES ('2021-01-08', 1, 1);
INSERT INTO venda(data, codigo_cliente, codigo_vendedor) VALUES ('2021-01-25', 1, 1);
INSERT INTO venda(data, codigo_cliente, codigo_vendedor) VALUES ('2021-01-12', 2, 2);
INSERT INTO venda(data, codigo_cliente, codigo_vendedor) VALUES ('2021-01-12', 3, 2);
INSERT INTO venda(data, codigo_cliente, codigo_vendedor) VALUES ('2021-01-30', 3, 3);
INSERT INTO venda(data, codigo_cliente, codigo_vendedor) VALUES ('2021-02-02', 4, 3);
INSERT INTO venda(data, codigo_cliente, codigo_vendedor) VALUES ('2021-02-02', 5, 3);
INSERT INTO venda(data, codigo_cliente, codigo_vendedor) VALUES ('2021-02-02', 7, 2);
INSERT INTO venda(data, codigo_cliente, codigo_vendedor) VALUES ('2021-02-09', 7, 2);
INSERT INTO venda(data, codigo_cliente, codigo_vendedor) VALUES ('2021-02-12', 8, 1);
INSERT INTO venda(data, codigo_cliente, codigo_vendedor) VALUES ('2021-02-15', 9, 1);
INSERT INTO venda(data, codigo_cliente, codigo_vendedor) VALUES ('2021-02-17', 9, 1);
INSERT INTO venda(data, codigo_cliente, codigo_vendedor) VALUES ('2021-02-17', 10, 1);