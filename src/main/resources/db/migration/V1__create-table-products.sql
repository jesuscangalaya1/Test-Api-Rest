
CREATE TABLE productos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL unique,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(200),
    precio DOUBLE NOT NULL,
    stock INT NOT NULL,
    deleted BOOLEAN NOT NULL DEFAULT FALSE

);