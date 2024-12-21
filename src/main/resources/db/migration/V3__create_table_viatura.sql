CREATE TABLE viaturas
(
    id      BIGINT NOT NULL AUTO_INCREMENT,
    placa   VARCHAR(10) NOT NULL,
    prefixo VARCHAR(10) NOT NULL,
    marca   VARCHAR(50) NOT NULL,
    modelo  VARCHAR(50) NOT NULL,
    ano     VARCHAR(4) NOT NULL,
    km      VARCHAR(10) NOT NULL,
    PRIMARY KEY (id)
);