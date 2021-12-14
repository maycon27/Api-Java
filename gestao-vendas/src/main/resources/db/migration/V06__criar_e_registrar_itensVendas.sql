CREATE TABLE item_venda (
	codigo BIGINT PRIMARY KEY AUTO_INCREMENT,
	codigo_produto BIGINT NOT NULL,
	codigo_venda BIGINT NOT NULL,
	quantidade INTEGER NOT NULL,
	preco_vendido DECIMAL(10,2) NOT NULL,
	pagamento_a_vista DECIMAL(10,2) NOT NULL,
	pagamento_a_prazo DECIMAL(10,2) NOT NULL,
	FOREIGN KEY (codigo_produto) REFERENCES produto(codigo),
	FOREIGN KEY (codigo_venda) REFERENCES venda(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO item_venda(codigo_produto, codigo_venda, quantidade, preco_vendido, pagamento_a_vista, pagamento_a_prazo) VALUES (1, 1, 1, 870, 870, 0);
INSERT INTO item_venda(codigo_produto, codigo_venda, quantidade, preco_vendido, pagamento_a_vista, pagamento_a_prazo) VALUES (15, 1, 1, 249, 149, 100);
INSERT INTO item_venda(codigo_produto, codigo_venda, quantidade, preco_vendido, pagamento_a_vista, pagamento_a_prazo) VALUES (2, 2, 1, 1623.20, 1000, 623.20);
INSERT INTO item_venda(codigo_produto, codigo_venda, quantidade, preco_vendido, pagamento_a_vista, pagamento_a_prazo) VALUES (3, 3, 1, 1073.36, 1073.36, 0);
INSERT INTO item_venda(codigo_produto, codigo_venda, quantidade, preco_vendido, pagamento_a_vista, pagamento_a_prazo) VALUES (4, 4, 1, 1899, 1200, 699);
INSERT INTO item_venda(codigo_produto, codigo_venda, quantidade, preco_vendido, pagamento_a_vista, pagamento_a_prazo) VALUES (5, 5, 1, 3300, 2500, 800);
INSERT INTO item_venda(codigo_produto, codigo_venda, quantidade, preco_vendido, pagamento_a_vista, pagamento_a_prazo) VALUES (6, 6, 1, 700, 400, 300);
INSERT INTO item_venda(codigo_produto, codigo_venda, quantidade, preco_vendido, pagamento_a_vista, pagamento_a_prazo) VALUES (7, 7, 1, 800, 400, 400);
INSERT INTO item_venda(codigo_produto, codigo_venda, quantidade, preco_vendido, pagamento_a_vista, pagamento_a_prazo) VALUES (8, 8, 1, 900, 500, 400);
INSERT INTO item_venda(codigo_produto, codigo_venda, quantidade, preco_vendido, pagamento_a_vista, pagamento_a_prazo) VALUES (9, 9, 3, 419.70, 419.70, 0);
INSERT INTO item_venda(codigo_produto, codigo_venda, quantidade, preco_vendido, pagamento_a_vista, pagamento_a_prazo) VALUES (16, 9, 1, 160.50, 160.50, 0);
INSERT INTO item_venda(codigo_produto, codigo_venda, quantidade, preco_vendido, pagamento_a_vista, pagamento_a_prazo) VALUES (10, 10, 1, 106.80, 106.80, 0);
INSERT INTO item_venda(codigo_produto, codigo_venda, quantidade, preco_vendido, pagamento_a_vista, pagamento_a_prazo) VALUES (17, 10, 1, 299.90, 100, 199.90);
INSERT INTO item_venda(codigo_produto, codigo_venda, quantidade, preco_vendido, pagamento_a_vista, pagamento_a_prazo) VALUES (11, 11, 1, 424.86, 300, 124.86);
INSERT INTO item_venda(codigo_produto, codigo_venda, quantidade, preco_vendido, pagamento_a_vista, pagamento_a_prazo) VALUES (12, 12, 1, 1164.94, 500, 664.94);
INSERT INTO item_venda(codigo_produto, codigo_venda, quantidade, preco_vendido, pagamento_a_vista, pagamento_a_prazo) VALUES (13, 13, 1, 415.90, 300, 115.90);
INSERT INTO item_venda(codigo_produto, codigo_venda, quantidade, preco_vendido, pagamento_a_vista, pagamento_a_prazo) VALUES (14, 14, 1, 1370, 1000, 379);