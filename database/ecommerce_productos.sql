INSERT INTO producto (id, codigo_producto, nombre_producto, descripcion, precio, administrador_id, status) VALUES (25, 'SWAE345', 'Camiseta Para Mujer Nicor', 'Camisetas de a centavo', 135.00, 2, 1);
INSERT INTO producto (id, codigo_producto, nombre_producto, descripcion, precio, administrador_id, status) VALUES (26, 'SER214', 'Camista para mujer tinsa', 'Camisetas de a centavo', 135.00, 2, 1);
INSERT INTO producto (id, codigo_producto, nombre_producto, descripcion, precio, administrador_id, status) VALUES (27, '3456', 'Pantalón Unisex Bici O Moto 2', 'Patalon', 50.00, 2, 1);
INSERT INTO producto (id, codigo_producto, nombre_producto, descripcion, precio, administrador_id, status) VALUES (28, 'ZXCSA32', 'Chamarra Para Mujer Acolchada', 'Chamarra', 12.00, 5, 1);
INSERT INTO producto (id, codigo_producto, nombre_producto, descripcion, precio, administrador_id, status) VALUES (29, 'ASDFR', 'Chamarra Para Mujer Bosana', 'Chamarra', 21.00, 2, 1);
INSERT INTO producto (id, codigo_producto, nombre_producto, descripcion, precio, administrador_id, status) VALUES (30, 'RA32120A19', 'Jean para mujer Chenlly', 'Jeans femeninos', 12.00, 2, 1);
INSERT INTO producto (id, codigo_producto, nombre_producto, descripcion, precio, administrador_id, status) VALUES (31, 'RA24231', 'Sudadera Haile', 'Sudadera deportiva', 23.00, 2, 1);
INSERT INTO producto (id, codigo_producto, nombre_producto, descripcion, precio, administrador_id, status) VALUES (32, 'ERT5ASQ', 'Sudadera Fliza', 'Sudadera deportiva', 145.00, 5, 1);
INSERT INTO producto (id, codigo_producto, nombre_producto, descripcion, precio, administrador_id, status) VALUES (33, 'ERT3421F', 'Camiseta Liverpool', 'Camiseta Deportiva', 500.00, 2, 1);
INSERT INTO producto (id, codigo_producto, nombre_producto, descripcion, precio, administrador_id, status) VALUES (34, '35467AS', 'Chamarra de cuero', 'Chamarra de cuero', 30.00, 2, 1);
INSERT INTO producto (id, codigo_producto, nombre_producto, descripcion, precio, administrador_id, status) VALUES (35, '35467AS', 'Chamarra de montaña', 'Chamarra de montaña', 50.00, 2, 1);

INSERT INTO product_talla_color_foto (id, producto_id, talla_id, color_id, stock, status) VALUES (1, 25, 2, 1, 20, 1);
INSERT INTO product_talla_color_foto (id, producto_id, talla_id, color_id, stock, status) VALUES (2, 26, 3, 1, 54, 1);
INSERT INTO product_talla_color_foto (id, producto_id, talla_id, color_id, stock, status) VALUES (3, 27, 3, 2, 20, 1);
INSERT INTO product_talla_color_foto (id, producto_id, talla_id, color_id, stock, status) VALUES (4, 28, 2, 2, 30, 1);
INSERT INTO product_talla_color_foto (id, producto_id, talla_id, color_id, stock, status) VALUES (5, 29, 2, 1, 30, 1);
INSERT INTO product_talla_color_foto (id, producto_id, talla_id, color_id, stock, status) VALUES (6, 30, 3, 2, 30, 1);
INSERT INTO product_talla_color_foto (id, producto_id, talla_id, color_id, stock, status) VALUES (7, 31, 3, 2, 30, 1);
INSERT INTO product_talla_color_foto (id, producto_id, talla_id, color_id, stock, status) VALUES (8, 32, 1, 1, 30, 1);
INSERT INTO product_talla_color_foto (id, producto_id, talla_id, color_id, stock, status) VALUES (9, 33, 2, 2, 23, 1);
INSERT INTO product_talla_color_foto (id, producto_id, talla_id, color_id, stock, status) VALUES (10, 31, 4, 12, 20, 1);
INSERT INTO product_talla_color_foto (id, producto_id, talla_id, color_id, stock, status) VALUES (11, 25, 3, 2, 10, 1);
INSERT INTO product_talla_color_foto (id, producto_id, talla_id, color_id, stock, status) VALUES (12, 26, 2, 4, 6, 1);
INSERT INTO product_talla_color_foto (id, producto_id, talla_id, color_id, stock, status) VALUES (13, 29, 5, 4, 10, 1);

INSERT INTO fotos_producto (id, foto, product_talla_color_foto_id) VALUES (1, 'productImage/fwav74entb20224683346User25.png', 1);
INSERT INTO fotos_producto (id, foto, product_talla_color_foto_id) VALUES (2, 'productImage/z7u55t8zve20224683552User26.png', 2);
INSERT INTO fotos_producto (id, foto, product_talla_color_foto_id) VALUES (3, 'productImage/b921a6znrv20224691631User27.png', 3);
INSERT INTO fotos_producto (id, foto, product_talla_color_foto_id) VALUES (4, 'productImage/egl984fsve20224693546User28.png', 4);
INSERT INTO fotos_producto (id, foto, product_talla_color_foto_id) VALUES (5, 'productImage/rfvx12t8xc20224693815User29.png', 5);
INSERT INTO fotos_producto (id, foto, product_talla_color_foto_id) VALUES (6, 'productImage/u9polzxa9s2022469401User30.png', 6);
INSERT INTO fotos_producto (id, foto, product_talla_color_foto_id) VALUES (7, 'productImage/mqt1wsf0q520224694211User31.png', 7);
INSERT INTO fotos_producto (id, foto, product_talla_color_foto_id) VALUES (8, 'productImage/eaoj1sy9r62022469448User32.png', 8);
INSERT INTO fotos_producto (id, foto, product_talla_color_foto_id) VALUES (9, 'productImage/scf4ov8g5o202246101752User33.png', 9);

-- Consulta a base de datos

-- Mostrar productos disponibles
select p.id, p.nombre_producto, p.precio,t.nombre_talla, tp.stock, CONCAT(pro.nombre, ' ', pro.apellido) as proveedor, e.nombre
from producto p
left join proveedor pro on (p.proveedor_id = pro.id)
left join empresa e on (e.id = pro.empresa_id)
left join talla_producto tp on (tp.producto_id = p.id)
left join talla t on (t.id = tp.talla_id)
where tp.stock>0
