INSERT INTO producto (id, codigo_producto, nombre_producto, descripcion, precio, administrador_id, status) VALUES (25, 'SWAE345', 'Camiseta Para Mujer Nicor', 'Camisetas de a centavo', 135.00, 2, 1);
INSERT INTO producto (id, codigo_producto, nombre_producto, descripcion, precio, administrador_id, status) VALUES (26, 'SER214', 'Camista para mujer tinsa', 'Camisetas de a centavo', 135.00, 2, 1);
INSERT INTO producto (id, codigo_producto, nombre_producto, descripcion, precio, administrador_id, status) VALUES (27, '3456', 'Pantalón Unisex Bici O Moto 2', 'Patalon', 50.00, 2, 1);
INSERT INTO producto (id, codigo_producto, nombre_producto, descripcion, precio, administrador_id, status) VALUES (28, 'ZXCSA32', 'Chamarra Para Mujer Acolchada', 'Chamarra', 12.00, 5, 1);
INSERT INTO producto (id, codigo_producto, nombre_producto, descripcion, precio, administrador_id, status) VALUES (29, 'ASDFR', 'Chamarra Para Mujer Bosana', 'Chamarra', 21.00, 2, 1);
INSERT INTO producto (id, codigo_producto, nombre_producto, descripcion, precio, administrador_id, status) VALUES (30, 'RA32120A19', 'Jean para mujer Chenlly', 'Jeans femeninos', 12.00, 2, 1);
INSERT INTO producto (id, codigo_producto, nombre_producto, descripcion, precio, administrador_id, status) VALUES (31, 'RA24231', 'Sudadera Haile', 'Sudadera deportiva', 23.00, 2, 1);
INSERT INTO producto (id, codigo_producto, nombre_producto, descripcion, precio, administrador_id, status) VALUES (32, 'ERT5ASQ', 'Sudadera Fliza', 'Sudadera deportiva', 145.00, 5, 1);
INSERT INTO producto (id, codigo_producto, nombre_producto, descripcion, precio, administrador_id, status) VALUES (33, 'ERT3421F', 'Camiseta Liverpool', 'Camiseta Deportiva', 500.00, 2, 1);


INSERT INTO fotos_producto (id, producto_id, foto) VALUES (11, 25, 'productImage/fwav74entb20224683346User25.png');
INSERT INTO fotos_producto (id, producto_id, foto) VALUES (12, 26, 'productImage/z7u55t8zve20224683552User26.png');
INSERT INTO fotos_producto (id, producto_id, foto) VALUES (13, 27, 'productImage/b921a6znrv20224691631User27.png');
INSERT INTO fotos_producto (id, producto_id, foto) VALUES (14, 28, 'productImage/egl984fsve20224693546User28.png');
INSERT INTO fotos_producto (id, producto_id, foto) VALUES (15, 29, 'productImage/rfvx12t8xc20224693815User29.png');
INSERT INTO fotos_producto (id, producto_id, foto) VALUES (16, 30, 'productImage/u9polzxa9s2022469401User30.png');
INSERT INTO fotos_producto (id, producto_id, foto) VALUES (17, 31, 'productImage/mqt1wsf0q520224694211User31.png');
INSERT INTO fotos_producto (id, producto_id, foto) VALUES (18, 32, 'productImage/eaoj1sy9r62022469448User32.png');
INSERT INTO fotos_producto (id, producto_id, foto) VALUES (19, 33, 'productImage/scf4ov8g5o202246101752User33.png');

-- Consulta a base de datos

-- Mostrar productos disponibles
select p.id, p.nombre_producto, p.precio,t.nombre_talla, tp.stock, CONCAT(pro.nombre, ' ', pro.apellido) as proveedor, e.nombre
from producto p
left join proveedor pro on (p.proveedor_id = pro.id)
left join empresa e on (e.id = pro.empresa_id)
left join talla_producto tp on (tp.producto_id = p.id)
left join talla t on (t.id = tp.talla_id)
where tp.stock>0
