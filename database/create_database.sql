-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-04-12 20:40:29.766

-- tables
-- Table: administrador
CREATE TABLE administrador (
                               id int NOT NULL AUTO_INCREMENT,
                               nombre varchar(40) NOT NULL,
                               apellido varchar(40) NOT NULL,
                               edad int NOT NULL,
                               correo_electronico varchar(60) NOT NULL,
                               tipo_administrador_id int NOT NULL,
                               password varchar(30) NOT NULL,
                               status int NOT NULL,
                               empresa_id int NULL,
                               CONSTRAINT administrador_pk PRIMARY KEY (id)
);

-- Table: categoria
CREATE TABLE categoria (
                           id int NOT NULL AUTO_INCREMENT,
                           categoria varchar(30) NOT NULL,
                           status int NOT NULL,
                           CONSTRAINT categoria_pk PRIMARY KEY (id)
);

-- Table: categoria_producto
CREATE TABLE categoria_producto (
                                    id int NOT NULL AUTO_INCREMENT,
                                    categoria_id int NOT NULL,
                                    producto_id int NOT NULL,
                                    status int NOT NULL,
                                    CONSTRAINT categoria_producto_pk PRIMARY KEY (id)
);

-- Table: ciudad
CREATE TABLE ciudad (
                        id int NOT NULL AUTO_INCREMENT,
                        nombre_ciudad varchar(45) NOT NULL,
                        CONSTRAINT ciudad_pk PRIMARY KEY (id)
);

-- Table: color
CREATE TABLE color (
                       id int NOT NULL AUTO_INCREMENT,
                       descripcion varchar(100) NOT NULL,
                       CONSTRAINT color_pk PRIMARY KEY (id)
);

-- Table: compra
CREATE TABLE compra (
                        id int NOT NULL AUTO_INCREMENT,
                        usuario_id int NOT NULL,
                        fecha int NOT NULL,
                        monto_total int NOT NULL,
                        tipo_pago_id int NOT NULL,
                        status int NOT NULL,
                        CONSTRAINT compra_pk PRIMARY KEY (id)
);

-- Table: direccion
CREATE TABLE direccion (
                           id int NOT NULL AUTO_INCREMENT,
                           nombre_direccion varchar(100) NOT NULL,
                           codigo_postal varchar(45) NOT NULL,
                           telefono varchar(40) NOT NULL,
                           ciudad_id int NOT NULL,
                           status int NOT NULL,
                           CONSTRAINT direccion_pk PRIMARY KEY (id)
);

-- Table: empresa
CREATE TABLE empresa (
                         id int NOT NULL AUTO_INCREMENT,
                         nombre varchar(45) NOT NULL,
                         nit varchar(45) NOT NULL,
                         CONSTRAINT empresa_pk PRIMARY KEY (id)
);

-- Table: fotos_producto
CREATE TABLE fotos_producto (
                                id int NOT NULL AUTO_INCREMENT,
                                foto varchar(100) NOT NULL,
                                product_talla_color_foto_id int NOT NULL,
                                CONSTRAINT fotos_producto_pk PRIMARY KEY (id)
);

-- Table: oferta
CREATE TABLE oferta (
                        id int NOT NULL AUTO_INCREMENT,
                        fecha_inicio date NOT NULL,
                        fecha_fin date NOT NULL,
                        monto_descuento decimal(8,2) NOT NULL,
                        status int NOT NULL,
                        CONSTRAINT oferta_pk PRIMARY KEY (id)
);

-- Table: oferta_producto
CREATE TABLE oferta_producto (
                                 id int NOT NULL AUTO_INCREMENT,
                                 oferta_id int NOT NULL,
                                 producto_id int NOT NULL,
                                 status int NOT NULL,
                                 CONSTRAINT oferta_producto_pk PRIMARY KEY (id)
);

-- Table: product_talla_color_foto
CREATE TABLE product_talla_color_foto (
                                          id int NOT NULL AUTO_INCREMENT,
                                          producto_id int NOT NULL,
                                          talla_id int NOT NULL,
                                          color_id int NOT NULL,
                                          stock int NOT NULL,
                                          status int NOT NULL,
                                          CONSTRAINT product_talla_color_foto_pk PRIMARY KEY (id)
);

-- Table: producto
CREATE TABLE producto (
                          id int NOT NULL AUTO_INCREMENT,
                          codigo_producto varchar(100) NOT NULL,
                          nombre_producto varchar(45) NOT NULL,
                          descripcion varchar(45) NOT NULL,
                          precio decimal(8,2) NOT NULL,
                          administrador_id int NOT NULL,
                          status int NOT NULL,
                          CONSTRAINT producto_pk PRIMARY KEY (id)
);

-- Table: producto_compra
CREATE TABLE producto_compra (
                                 id int NOT NULL AUTO_INCREMENT,
                                 compra_id int NOT NULL,
                                 producto_id int NOT NULL,
                                 cantidad int NOT NULL,
                                 status int NOT NULL,
                                 CONSTRAINT producto_compra_pk PRIMARY KEY (id)
);

-- Table: talla
CREATE TABLE talla (
                       id int NOT NULL AUTO_INCREMENT,
                       nombre_talla varchar(10) NOT NULL,
                       CONSTRAINT talla_pk PRIMARY KEY (id)
);

-- Table: tipo_administrador
CREATE TABLE tipo_administrador (
                                    id int NOT NULL AUTO_INCREMENT,
                                    tipo varchar(100) NOT NULL,
                                    CONSTRAINT tipo_administrador_pk PRIMARY KEY (id)
);

-- Table: tipo_pago
CREATE TABLE tipo_pago (
                           id int NOT NULL AUTO_INCREMENT,
                           tipo varchar(30) NOT NULL,
                           CONSTRAINT tipo_pago_pk PRIMARY KEY (id)
);

-- Table: usuario
CREATE TABLE usuario (
                         id int NOT NULL AUTO_INCREMENT,
                         nombre varchar(40) NOT NULL,
                         apellido varchar(40) NOT NULL,
                         edad int NULL,
                         correo_electronico varchar(60) NOT NULL,
                         password varchar(30) NOT NULL,
                         status int NOT NULL,
                         direccion_id int NOT NULL,
                         CONSTRAINT usuario_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: administrador_empresa (table: administrador)
ALTER TABLE administrador ADD CONSTRAINT administrador_empresa FOREIGN KEY administrador_empresa (empresa_id)
    REFERENCES empresa (id);

-- Reference: administrador_tipo_administrador (table: administrador)
ALTER TABLE administrador ADD CONSTRAINT administrador_tipo_administrador FOREIGN KEY administrador_tipo_administrador (tipo_administrador_id)
    REFERENCES tipo_administrador (id);

-- Reference: compra_tipo_pago (table: compra)
ALTER TABLE compra ADD CONSTRAINT compra_tipo_pago FOREIGN KEY compra_tipo_pago (tipo_pago_id)
    REFERENCES tipo_pago (id);

-- Reference: compra_usuario (table: compra)
ALTER TABLE compra ADD CONSTRAINT compra_usuario FOREIGN KEY compra_usuario (usuario_id)
    REFERENCES usuario (id);

-- Reference: direccion_ciudad (table: direccion)
ALTER TABLE direccion ADD CONSTRAINT direccion_ciudad FOREIGN KEY direccion_ciudad (ciudad_id)
    REFERENCES ciudad (id);

-- Reference: fotos_producto_product_talla_color_foto (table: fotos_producto)
ALTER TABLE fotos_producto ADD CONSTRAINT fotos_producto_product_talla_color_foto FOREIGN KEY fotos_producto_product_talla_color_foto (product_talla_color_foto_id)
    REFERENCES product_talla_color_foto (id);

-- Reference: oferta_producto_oferta (table: oferta_producto)
ALTER TABLE oferta_producto ADD CONSTRAINT oferta_producto_oferta FOREIGN KEY oferta_producto_oferta (oferta_id)
    REFERENCES oferta (id);

-- Reference: oferta_producto_producto (table: oferta_producto)
ALTER TABLE oferta_producto ADD CONSTRAINT oferta_producto_producto FOREIGN KEY oferta_producto_producto (producto_id)
    REFERENCES producto (id);

-- Reference: product_talla_color_foto_color (table: product_talla_color_foto)
ALTER TABLE product_talla_color_foto ADD CONSTRAINT product_talla_color_foto_color FOREIGN KEY product_talla_color_foto_color (color_id)
    REFERENCES color (id);

-- Reference: product_talla_color_foto_producto (table: product_talla_color_foto)
ALTER TABLE product_talla_color_foto ADD CONSTRAINT product_talla_color_foto_producto FOREIGN KEY product_talla_color_foto_producto (producto_id)
    REFERENCES producto (id);

-- Reference: product_talla_color_foto_talla (table: product_talla_color_foto)
ALTER TABLE product_talla_color_foto ADD CONSTRAINT product_talla_color_foto_talla FOREIGN KEY product_talla_color_foto_talla (talla_id)
    REFERENCES talla (id);

-- Reference: producto_administrador (table: producto)
ALTER TABLE producto ADD CONSTRAINT producto_administrador FOREIGN KEY producto_administrador (administrador_id)
    REFERENCES administrador (id);

-- Reference: producto_categoria_categoria (table: categoria_producto)
ALTER TABLE categoria_producto ADD CONSTRAINT producto_categoria_categoria FOREIGN KEY producto_categoria_categoria (categoria_id)
    REFERENCES categoria (id);

-- Reference: producto_categoria_producto (table: categoria_producto)
ALTER TABLE categoria_producto ADD CONSTRAINT producto_categoria_producto FOREIGN KEY producto_categoria_producto (producto_id)
    REFERENCES producto (id);

-- Reference: producto_compra_compra (table: producto_compra)
ALTER TABLE producto_compra ADD CONSTRAINT producto_compra_compra FOREIGN KEY producto_compra_compra (compra_id)
    REFERENCES compra (id);

-- Reference: producto_compra_producto (table: producto_compra)
ALTER TABLE producto_compra ADD CONSTRAINT producto_compra_producto FOREIGN KEY producto_compra_producto (producto_id)
    REFERENCES producto (id);

-- Reference: usuario_direccion (table: usuario)
ALTER TABLE usuario ADD CONSTRAINT usuario_direccion FOREIGN KEY usuario_direccion (direccion_id)
    REFERENCES direccion (id);

-- End of file.

