CREATE TABLE operacao (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    data TIMESTAMP NOT NULL,
    logradouro VARCHAR(40) NOT NULL,
    numero VARCHAR(10),
    complemento VARCHAR(40),
    bairro VARCHAR(40) NOT NULL,
    cidade VARCHAR(40) NOT NULL,
    uf VARCHAR(2) NOT NULL,
    cep VARCHAR(10),
    responsavel_id BIGINT,
    viatura_id BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (responsavel_id) REFERENCES policial(id),
    FOREIGN KEY (viatura_id) REFERENCES viaturas(id)
);