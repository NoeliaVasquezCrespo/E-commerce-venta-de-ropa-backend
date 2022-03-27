INSERT INTO direccion (id, nombre_direccion, codigo_postal, telefono, ciudad_id) VALUES (1, 'Calacoto c. 13 esq, Av. Sanchez Bustamante Nro. 8009, La Paz', '0000', '75648908', 1);
INSERT INTO direccion (id, nombre_direccion, codigo_postal, telefono, ciudad_id) VALUES (2, 'Avenida Mariscal Santa Cruz', ' Edificio Hansa', '67855321', 2);

---Consulta a la base de datos


--- Obtener la dirección de un usuario
select dir.id, dir.nombre_direccion, dir.codigo_postal, dir.telefono, c.nombre_ciudad as Ciudad, CONCAT(u.nombre, ' ', u.apellido) as usuario
from direccion dir
left join usuario u on (u.direccion_id = dir.id)
left join ciudad c on (c.id = dir.ciudad_id)
where u.id = '2'