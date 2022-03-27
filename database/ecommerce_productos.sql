INSERT INTO producto (id, nombre_producto,precio,status,proveedor_id, descripcion) VALUES (1, 'Tenis', 141.68, 1, 1, 'Zapatillas para hombre y mujer de todo color');
INSERT INTO producto (id, nombre_producto,precio,status,proveedor_id, descripcion) VALUES (2, 'Pantalones', 89.5, 1, 2, 'Pantalones Vaqueros Para mujer');


---Consulta a base de datos

--Mostrar productos disponibles
select p.id, p.nombre_producto, p.precio,t.nombre_talla, tp.stock, CONCAT(pro.nombre, ' ', pro.apellido) as proveedor, e.nombre
from producto p
left join proveedor pro on (p.proveedor_id = pro.id)
left join empresa e on (e.id = pro.empresa_id)
left join talla_producto tp on (tp.producto_id = p.id)
left join talla t on (t.id = tp.talla_id)
where tp.stock>0
