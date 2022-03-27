-- Created by Vertabelo (http://vertabelo.com)

CREATE TABLE categoria (
    id int NOT NULL AUTO_INCREMENT,
    nombre_categoria varchar(30) NOT NULL,
    CONSTRAINT categoria_pk PRIMARY KEY (id)
);

-- Table: ciudad
CREATE TABLE ciudad (
    id int NOT NULL AUTO_INCREMENT,
    nombre_ciudad varchar(45) NOT NULL,
    CONSTRAINT ciudad_pk PRIMARY KEY (id)
);

-- Table: compra
CREATE TABLE compra (
    id int NOT NULL AUTO_INCREMENT,
    usuario_id int NOT NULL,
    fecha int NOT NULL,
    monto_total int NOT NULL,
    tipo_pago_id int NOT NULL,
    CONSTRAINT compra_pk PRIMARY KEY (id)
);

-- Table: direccion
CREATE TABLE direccion (
    id int NOT NULL AUTO_INCREMENT,
    nombre_direccion varchar(100) NOT NULL,
    codigo_postal varchar(45) NOT NULL,
    telefono varchar(40) NOT NULL,
    ciudad_id int NOT NULL,
    CONSTRAINT direccion_pk PRIMARY KEY (id)
);

-- Table: empresa
CREATE TABLE empresa (
    id int NOT NULL AUTO_INCREMENT,
    nombre varchar(45) NOT NULL,
    nit varchar(45) NOT NULL,
    CONSTRAINT empresa_pk PRIMARY KEY (id)
);

-- Table: oferta
CREATE TABLE oferta (
    id int NOT NULL AUTO_INCREMENT,
    fecha_inicio date NOT NULL,
    fecha_fin date NOT NULL,
    monto_descuento decimal(8,2) NOT NULL,
    CONSTRAINT oferta_pk PRIMARY KEY (id)
);

-- Table: oferta_producto
CREATE TABLE oferta_producto (
    oferta_id int NOT NULL,
    producto_id int NOT NULL,
    status int NOT NULL,
    CONSTRAINT oferta_producto_pk PRIMARY KEY (oferta_id,producto_id)
);

-- Table: producto
CREATE TABLE producto (
    id int NOT NULL AUTO_INCREMENT,
    nombre_producto varchar(45) NOT NULL,
    precio decimal(8,2) NOT NULL,
    status int NOT NULL,
    proveedor_id int NOT NULL,
    descripcion varchar(45) NOT NULL,
    CONSTRAINT producto_pk PRIMARY KEY (id)
);

-- Table: producto_categoria
CREATE TABLE producto_categoria (
    categoria_id int NOT NULL,
    producto_id int NOT NULL,
    CONSTRAINT producto_categoria_pk PRIMARY KEY (categoria_id,producto_id)
);

-- Table: producto_compra
CREATE TABLE producto_compra (
    compra_id int NOT NULL,
    producto_id int NOT NULL,
    cantidad int NOT NULL,
    CONSTRAINT producto_compra_pk PRIMARY KEY (compra_id,producto_id)
);

-- Table: proveedor
CREATE TABLE proveedor (
    id int NOT NULL AUTO_INCREMENT,
    nombre varchar(45) NOT NULL,
    apellido varchar(45) NOT NULL,
    correo_electronico varchar(60) NOT NULL,
    password varchar(45) NOT NULL,
    status int NOT NULL,
    empresa_id int NOT NULL,
    CONSTRAINT proveedor_pk PRIMARY KEY (id)
);

-- Table: talla
CREATE TABLE talla (
    id int NOT NULL,
    nombre_talla varchar(10) NOT NULL,
    CONSTRAINT talla_pk PRIMARY KEY (id)
);

-- Table: talla_producto
CREATE TABLE talla_producto (
    talla_id int NOT NULL AUTO_INCREMENT,
    producto_id int NOT NULL,
    stock int NOT NULL,
    status int NOT NULL,
    CONSTRAINT talla_producto_pk PRIMARY KEY (talla_id)
);

-- Table: tipo_pago
CREATE TABLE tipo_pago (
    id int NOT NULL AUTO_INCREMENT,
    tipo varchar(30) NOT NULL,
    CONSTRAINT tipo_pago_pk PRIMARY KEY (id)
);

-- Table: tipo_usuario
CREATE TABLE tipo_usuario (
    id int NOT NULL AUTO_INCREMENT,
    tipo varchar(30) NOT NULL,
    CONSTRAINT tipo_usuario_pk PRIMARY KEY (id)
);

-- Table: usuario
CREATE TABLE usuario (
    id int NOT NULL AUTO_INCREMENT,
    nombre varchar(40) NOT NULL,
    apellido varchar(40) NOT NULL,
    edad int NULL,
    correo_electronico varchar(60) NOT NULL,
    user_name varchar(40) NOT NULL,
    password varchar(30) NOT NULL,
    status int NOT NULL,
    tipo_usuario_id int NOT NULL,
    direccion_id int NOT NULL,
    CONSTRAINT usuario_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: compra_tipo_pago (table: compra)
ALTER TABLE compra ADD CONSTRAINT compra_tipo_pago FOREIGN KEY compra_tipo_pago (tipo_pago_id)
    REFERENCES tipo_pago (id);

-- Reference: compra_usuario (table: compra)
ALTER TABLE compra ADD CONSTRAINT compra_usuario FOREIGN KEY compra_usuario (usuario_id)
    REFERENCES usuario (id);

-- Reference: direccion_ciudad (table: direccion)
ALTER TABLE direccion ADD CONSTRAINT direccion_ciudad FOREIGN KEY direccion_ciudad (ciudad_id)
    REFERENCES ciudad (id);

-- Reference: oferta_producto_oferta (table: oferta_producto)
ALTER TABLE oferta_producto ADD CONSTRAINT oferta_producto_oferta FOREIGN KEY oferta_producto_oferta (oferta_id)
    REFERENCES oferta (id);

-- Reference: oferta_producto_producto (table: oferta_producto)
ALTER TABLE oferta_producto ADD CONSTRAINT oferta_producto_producto FOREIGN KEY oferta_producto_producto (producto_id)
    REFERENCES producto (id);

-- Reference: producto_categoria_categoria (table: producto_categoria)
ALTER TABLE producto_categoria ADD CONSTRAINT producto_categoria_categoria FOREIGN KEY producto_categoria_categoria (categoria_id)
    REFERENCES categoria (id);

-- Reference: producto_categoria_producto (table: producto_categoria)
ALTER TABLE producto_categoria ADD CONSTRAINT producto_categoria_producto FOREIGN KEY producto_categoria_producto (producto_id)
    REFERENCES producto (id);

-- Reference: producto_compra_compra (table: producto_compra)
ALTER TABLE producto_compra ADD CONSTRAINT producto_compra_compra FOREIGN KEY producto_compra_compra (compra_id)
    REFERENCES compra (id);

-- Reference: producto_compra_producto (table: producto_compra)
ALTER TABLE producto_compra ADD CONSTRAINT producto_compra_producto FOREIGN KEY producto_compra_producto (producto_id)
    REFERENCES producto (id);

-- Reference: producto_proveedor (table: producto)
ALTER TABLE producto ADD CONSTRAINT producto_proveedor FOREIGN KEY producto_proveedor (proveedor_id)
    REFERENCES proveedor (id);

-- Reference: proveedor_empresa (table: proveedor)
ALTER TABLE proveedor ADD CONSTRAINT proveedor_empresa FOREIGN KEY proveedor_empresa (empresa_id)
    REFERENCES empresa (id);

-- Reference: talla_producto_producto (table: talla_producto)
ALTER TABLE talla_producto ADD CONSTRAINT talla_producto_producto FOREIGN KEY talla_producto_producto (producto_id)
    REFERENCES producto (id);

-- Reference: talla_producto_talla (table: talla_producto)
ALTER TABLE talla_producto ADD CONSTRAINT talla_producto_talla FOREIGN KEY talla_producto_talla (talla_id)
    REFERENCES talla (id);

-- Reference: usuario_direccion (table: usuario)
ALTER TABLE usuario ADD CONSTRAINT usuario_direccion FOREIGN KEY usuario_direccion (direccion_id)
    REFERENCES direccion (id);

-- Reference: usuario_tipo_usuario (table: usuario)
ALTER TABLE usuario ADD CONSTRAINT usuario_tipo_usuario FOREIGN KEY usuario_tipo_usuario (tipo_usuario_id)
    REFERENCES tipo_usuario (id);

-- End of file.

