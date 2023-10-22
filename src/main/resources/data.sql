INSERT INTO usuario (cpf, nome, email, password, role) VALUES
('11111111111', 'Usuário 1', 'usuario1@email.com', 'senha123', '0'),
('22222222222', 'Usuário 2', 'usuario2@email.com', 'senha456', '1');


-- Inserindo dados na tabela Condominios
INSERT INTO condominios (nome, cnpj, email, endereco) VALUES
    ('Condomínio 1', '1234567890', 'condo1@example.com', 'Endereço 1'),
    ('Condomínio 2', '9876543210', 'condo2@example.com', 'Endereço 2');

INSERT INTO bloco (numero, qtd_Andar, condominio_id) VALUES
('Bloco 1', 5, 1),
('Bloco 2', 6, 1),
('Bloco 3', 4, 2);


INSERT INTO apartamento (numero, andar, bloco_id, usuario_id) VALUES
('101', 1, 1, 1),
('102', 1, 1, NULL),
('201', 2, 1, NULL),
('202', 2, 1, NULL),
('301', 3, 1, NULL),
('401', 4, 2, 2),
('402', 4, 2, NULL),
('501', 5, 2, NULL),
('601', 6, 2, NULL),
('701', 7, 3, NULL),
('702', 7, 3, NULL);


INSERT INTO hidrometro (numero, tipo, apartamento_id) VALUES
('H101', 'AGUAFRIA', 1),
('H102', 'AGUAFRIA', 2),
('H201', 'AGUAFRIA', 3),
('H202', 'AGUAFRIA', 4),
('H301', 'AGUAFRIA', 5),
('H401', 'AGUAFRIA', 6),
('H402', 'AGUAQUENTE', 7),
('H501', 'AGUAFRIA', 8),
('H601', 'AGUAFRIA', 9),
('H701', 'AGUAQUENTE', 10),
('H702', 'AGUAQUENTE', 11);

-- Inserindo dados na tabela Leitura
INSERT INTO leitura (valor, data_Leitura, hidrometro_id) VALUES
    (110.0, '2023-10-15', 1),
    (105.0, '2023-10-15',2),
    (230.0, '2023-10-15', 3),
    (225.0, '2023-10-15', 4),
    (340.0, '2023-10-15', 5),
    (335.0, '2023-10-15', 6),
    (160.0, '2023-10-15', 7),
    (155.0, '2023-10-15', 8),
    (280.0, '2023-10-15', 9),
    (275.0, '2023-10-15', 10),
    (390.0, '2023-10-15', 11);

INSERT INTO consumo (valor, data_Consumo, leitura_Anterior, leitura_Atual, hidrometro_id) VALUES
    (110.0, '2023-10-15', 45.0, 155.0, 1),
    (105.0, '2023-10-15', 35.0, 140.0, 2),
    (230.0, '2023-10-15', 100.0, 330.0, 3),
    (225.0, '2023-10-15', 110.0, 335.0, 4),
    (340.0, '2023-10-15', 210.0, 550.0, 5),
    (335.0, '2023-10-15', 200.0, 535.0, 6),
    (160.0, '2023-10-15', 70.0, 230.0, 7),
    (155.0, '2023-10-15', 65.0, 220.0, 8),
    (280.0, '2023-10-15', 125.0, 405.0, 9),
    (275.0, '2023-10-15', 120.0, 400.0, 10),
    (390.0, '2023-10-15', 170.0, 560.0, 11);

