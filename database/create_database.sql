create table categoria
(
    id        int auto_increment
        primary key,
    categoria varchar(30) not null
);

create table ciudad
(
    id            int auto_increment
        primary key,
    nombre_ciudad varchar(45) not null
);

create table color
(
    id          int auto_increment
        primary key,
    descripcion varchar(100) not null
);

create table direccion
(
    id               int auto_increment
        primary key,
    nombre_direccion varchar(100) not null,
    codigo_postal    varchar(45)  not null,
    telefono         varchar(40)  not null,
    ciudad_id        int          not null,
    status           int          not null,
    constraint direccion_ciudad
        foreign key (ciudad_id) references ciudad (id)
);

create table empresa
(
    id     int auto_increment
        primary key,
    nombre varchar(45) not null,
    nit    varchar(45) not null
);

create table oferta
(
    id              int auto_increment
        primary key,
    fecha_inicio    date          not null,
    fecha_fin       date          not null,
    monto_descuento decimal(8, 2) not null,
    status          int           not null
);

create table talla
(
    id           int auto_increment
        primary key,
    nombre_talla varchar(10) not null
);

create table tipo_administrador
(
    id   int auto_increment
        primary key,
    tipo varchar(100) not null
);

create table administrador
(
    id                    int auto_increment
        primary key,
    nombre                varchar(40) not null,
    apellido              varchar(40) not null,
    edad                  int         not null,
    correo_electronico    varchar(60) not null,
    tipo_administrador_id int         not null,
    password              varchar(30) not null,
    status                int         not null,
    empresa_id            int         null,
    constraint administrador_empresa
        foreign key (empresa_id) references empresa (id),
    constraint administrador_tipo_administrador
        foreign key (tipo_administrador_id) references tipo_administrador (id)
);

create table producto
(
    id               int auto_increment
        primary key,
    codigo_producto  varchar(100)  not null,
    nombre_producto  varchar(45)   not null,
    descripcion      varchar(45)   not null,
    precio           decimal(8, 2) not null,
    administrador_id int           not null,
    status           int           not null,
    constraint producto_administrador
        foreign key (administrador_id) references administrador (id)
);

create table categoria_producto
(
    id           int auto_increment
        primary key,
    categoria_id int not null,
    producto_id  int not null,
    status       int not null,
    constraint producto_categoria_categoria
        foreign key (categoria_id) references categoria (id),
    constraint producto_categoria_producto
        foreign key (producto_id) references producto (id)
);

create table oferta_producto
(
    id          int auto_increment
        primary key,
    oferta_id   int not null,
    producto_id int not null,
    status      int not null,
    constraint oferta_producto_oferta
        foreign key (oferta_id) references oferta (id),
    constraint oferta_producto_producto
        foreign key (producto_id) references producto (id)
);

create table product_talla_color_foto
(
    id          int auto_increment
        primary key,
    producto_id int not null,
    talla_id    int not null,
    color_id    int not null,
    stock       int not null,
    status      int not null,
    constraint product_talla_color_foto_color
        foreign key (color_id) references color (id),
    constraint product_talla_color_foto_producto
        foreign key (producto_id) references producto (id),
    constraint product_talla_color_foto_talla
        foreign key (talla_id) references talla (id)
);

create table fotos_producto
(
    id                          int auto_increment
        primary key,
    foto                        varchar(100) not null,
    product_talla_color_foto_id int          not null,
    constraint fotos_producto_product_talla_color_foto
        foreign key (product_talla_color_foto_id) references product_talla_color_foto (id)
);

create table tipo_pago
(
    id   int auto_increment
        primary key,
    tipo varchar(30) not null
);

create table usuario
(
    id                 int auto_increment
        primary key,
    nombre             varchar(40) not null,
    apellido           varchar(40) not null,
    edad               int         null,
    correo_electronico varchar(60) not null,
    password           varchar(30) not null,
    status             int         not null,
    direccion_id       int         not null,
    constraint usuario_direccion
        foreign key (direccion_id) references direccion (id)
);

create table compra
(
    id           int auto_increment
        primary key,
    usuario_id   int not null,
    fecha        int not null,
    monto_total  int not null,
    tipo_pago_id int not null,
    status       int not null,
    constraint compra_tipo_pago
        foreign key (tipo_pago_id) references tipo_pago (id),
    constraint compra_usuario
        foreign key (usuario_id) references usuario (id)
);

create table producto_compra
(
    id          int auto_increment
        primary key,
    compra_id   int not null,
    producto_id int not null,
    cantidad    int not null,
    status      int not null,
    constraint producto_compra_compra
        foreign key (compra_id) references compra (id),
    constraint producto_compra_producto
        foreign key (producto_id) references producto (id)
);

