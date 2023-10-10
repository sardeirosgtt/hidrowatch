INSERT INTO usuario (cpf, nome, email, password, role) VALUES
('11111111111', 'Usuário 1', 'usuario1@email.com', 'senha123', 'USER'),
('22222222222', 'Usuário 2', 'usuario2@email.com', 'senha456', 'ADMIN');


-- Inserindo dados na tabela Condominios
INSERT INTO condominios (nome, cnpj, email, endereco) VALUES
    ('Condomínio 1', '1234567890', 'condo1@example.com', 'Endereço 1'),
    ('Condomínio 2', '9876543210', 'condo2@example.com', 'Endereço 2');

INSERT INTO blocos (numero, qtdAndar, condominio_id) VALUES
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
('H101', 'AGUA', 1),
('H102', 'AGUA', 2),
('H201', 'AGUA', 3),
('H202', 'AGUA', 4),
('H301', 'LUZ', 5),
('H401', 'AGUA', 6),
('H402', 'AGUA', 7),
('H501', 'AGUA', 8),
('H601', 'LUZ', 9),
('H701', 'AGUA', 10),
('H702', 'AGUA', 11);

-- Inserindo dados na tabela Leitura
INSERT INTO leitura (valor, data_Leitura, hidrometro_id) VALUES
    (110.0, '2023-10-15', 1),
    (105.0, '2023-10-15', 2),
    (230.0, '2023-10-15', 3),
    (225.0, '2023-10-15', 4),
    (340.0, '2023-10-15', 5),
    (335.0, '2023-10-15', 6),
    (160.0, '2023-10-15', 7),
    (155.0, '2023-10-15', 8),
    (280.0, '2023-10-15', 9),
    (275.0, '2023-10-15', 10),
    (390.0, '2023-10-15', 11);

INSERT INTO consumo (valor, dataConsumo, apartamento_id) VALUES
(100.0, '2023-10-01 08:00:00', 1),
(95.0, '2023-10-02 08:00:00', 2),
(85.0, '2023-10-03 08:00:00', 3),
(70.0, '2023-10-04 08:00:00', 4),
(60.0, '2023-10-05 08:00:00', 5),
(50.0, '2023-10-01 08:00:00', 6),
(45.0, '2023-10-02 08:00:00', 7),
(35.0, '2023-10-03 08:00:00', 8),
(20.0, '2023-10-04 08:00:00', 9),
(10.0, '2023-10-05 08:00:00', 10),
(5.0, '2023-10-01 08:00:00', 11);
