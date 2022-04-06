INSERT INTO producto (id, codigo_producto, nombre_producto, descripcion, stock, precio, color_id, talla_id, administrador_id, status) VALUES (25, 'SWAE345', 'Camiseta Para Mujer Nicor', 'Camisetas de mujer', 20, 135.00, 1, 2, 1, 1);
INSERT INTO producto (id, codigo_producto, nombre_producto, descripcion, stock, precio, color_id, talla_id, administrador_id, status) VALUES (26, 'SER214', 'Camista para mujer tinsa', 'Camisetas de mujer', 54, 135.00, 1, 3, 1, 1);

INSERT INTO fotos_producto (id, producto_id, foto) VALUES (11, 25, 'productImage/fwav74entb20224683346User25.png');
INSERT INTO fotos_producto (id, producto_id, foto) VALUES (12, 26, 'productImage/z7u55t8zve20224683552User26.png');

-- Consulta a base de datos

-- Mostrar productos disponibles
select p.id, p.nombre_producto, p.precio,t.nombre_talla, tp.stock, CONCAT(pro.nombre, ' ', pro.apellido) as proveedor, e.nombre
from producto p
left join proveedor pro on (p.proveedor_id = pro.id)
left join empresa e on (e.id = pro.empresa_id)
left join talla_producto tp on (tp.producto_id = p.id)
left join talla t on (t.id = tp.talla_id)
where tp.stock>0
