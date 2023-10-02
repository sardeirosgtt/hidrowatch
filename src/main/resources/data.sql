-- Inserindo dados na tabela Usuario
INSERT INTO usuario (cpf, nome, email) VALUES
    ('11111111111', 'Usuário 1', 'user1@example.com'),
    ('22222222222', 'Usuário 2', 'user2@example.com'),
    ('33333333333', 'Usuário 3', 'user3@example.com'),
    ('44444444444', 'Usuário 4', 'user4@example.com'),
    ('55555555555', 'Usuário 5', 'user5@example.com'),
    ('66666666666', 'Usuário 6', 'user6@example.com'),
    ('77777777777', 'Usuário 7', 'user7@example.com'),
    ('88888888888', 'Usuário 8', 'user8@example.com'),
    ('99999999999', 'Usuário 9', 'user9@example.com'),
    ('10101010101', 'Usuário 10', 'user10@example.com'),
    ('12121212121', 'Usuário 11', 'user11@example.com'),
    ('13131313131', 'Usuário 12', 'user12@example.com');

-- Inserindo dados na tabela Condominios
INSERT INTO condominios (nome, cnpj, email, endereco) VALUES
    ('Condomínio 1', '1234567890', 'condo1@example.com', 'Endereço 1'),
    ('Condomínio 2', '9876543210', 'condo2@example.com', 'Endereço 2');

-- Inserindo dados na tabela Bloco
INSERT INTO bloco (numero, qtd_Andar, condominio_id) VALUES
    ('Bloco A', 5, 1),
    ('Bloco B', 6, 1),
    ('Bloco C', 4, 2);

-- Inserindo dados na tabela Apartamento
INSERT INTO apartamento (numero, andar, bloco_id, usuario_id) VALUES
    ('101', 1, 1, 1),
    ('102', 1, 1, 2),
    ('201', 2, 1, 3),
    ('202', 2, 1, 4),
    ('301', 3, 1, 5),
    ('302', 3, 1, 6),
    ('101', 1, 2, 7),
    ('102', 1, 2, 8),
    ('201', 2, 2, 9),
    ('202', 2, 2, 10),
    ('301', 3, 2, 11),
    ('302', 3, 2, 12);

-- Inserindo dados na tabela Hidrometro
INSERT INTO hidrometro (numero, apartamento_id) VALUES
    ('H1-101', 1),
    ('H1-102', 2),
    ('H1-201', 3),
    ('H1-202', 4),
    ('H1-301', 5),
    ('H1-302', 6),
    ('H2-101', 7),
    ('H2-102', 8),
    ('H2-201', 9),
    ('H2-202', 10),
    ('H2-301', 11),
    ('H2-302', 12);

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
    (390.0, '2023-10-15', 11),
    (385.0, '2023-10-15', 12);

-- Inserindo dados na tabela Consumo
INSERT INTO consumo (valor, data_Consumo, apartamento_id) VALUES
    (10.0, '2023-10-15', 1),
    (10.0, '2023-10-15', 2),
    (10.0, '2023-10-15', 3),
    (10.0, '2023-10-15', 4),
    (10.0, '2023-10-15', 5),
    (10.0, '2023-10-15', 6),
    (5.0, '2023-10-15', 7),
    (5.0, '2023-10-15', 8),
    (5.0, '2023-10-15', 9),
    (5.0, '2023-10-15', 10),
    (5.0, '2023-10-15', 11),
    (5.0, '2023-10-15', 12);
