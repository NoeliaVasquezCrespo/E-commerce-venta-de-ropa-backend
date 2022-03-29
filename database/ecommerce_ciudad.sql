INSERT INTO ciudad (id, nombre_ciudad) VALUES (1, 'La Paz');
INSERT INTO ciudad (id, nombre_ciudad) VALUES (2, 'Santa Cruz');
INSERT INTO ciudad (id, nombre_ciudad) VALUES (3, 'Cochabamba');
INSERT INTO ciudad (id, nombre_ciudad) VALUES (4, 'Sucre');
INSERT INTO ciudad (id, nombre_ciudad) VALUES (5, 'Oruro');
INSERT INTO ciudad (id, nombre_ciudad) VALUES (6, 'Tarija');
INSERT INTO ciudad (id, nombre_ciudad) VALUES (7, 'Potosí');
INSERT INTO ciudad (id, nombre_ciudad) VALUES (8, 'Beni');
INSERT INTO ciudad (id, nombre_ciudad) VALUES (9, 'Pando');


-- Consulta a la base de datos

-- Obtener la direcciones registradas según ciudades por id
select c.id, dir.nombre_direccion as Direccion, c.nombre_ciudad as Ciudad
from ciudad c
left join direccion dir on (c.id = dir.ciudad_id)
where c.id = '1'
              
-- Obtener direcciones por las ciudades  
select c.id, dir.nombre_direccion as Direccion, c.nombre_ciudad as Ciudad
from ciudad c
left join direccion dir on (c.id = dir.ciudad_id)
order by c.id
     