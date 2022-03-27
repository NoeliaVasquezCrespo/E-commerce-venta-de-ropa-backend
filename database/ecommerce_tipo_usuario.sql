INSERT INTO tipo_usuario (id, tipo) VALUES (1, 'Administrador Sistema');
INSERT INTO tipo_usuario (id, tipo) VALUES (2, 'Cliente');


---Consulta a la base de datos


--- Obtener lista de usuario según el tipo
select u.id,tu.id, tu.tipo as Tipo, CONCAT(u.nombre, ' ', u.apellido) as usuario
from tipo_usuario tu
left join usuario u on (u.tipo_usuario_id = tu.id)
where tu.tipo = 'Administrador Sistema'