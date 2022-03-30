#INSERT INTO usuario (id, nombre, apellido, edad, correo_electronico, user_name, password, status, tipo_usuario_id, direccion_id) VALUES (2, 'Juan', 'Perez', 30, 'juanperez@gmail.com', 'juperez', '123', 1, 1, 1);
#INSERT INTO usuario (id, nombre, apellido, edad, correo_electronico, user_name, password, status, tipo_usuario_id, direccion_id) VALUES (3, 'Maria', 'Sanchez', 25, 'marisanchez@gmail.com', 'admin', '123', 1, 1, 2);

INSERT INTO tipo_administrador (id, tipo) VALUES (1, 'Sistema');
INSERT INTO tipo_administrador (id, tipo) VALUES (2, 'Proveedor');

INSERT INTO administrador (id, nombre, apellido, edad, correo_electronico, tipo_administrador_id, user_name, password, status) VALUES (1, 'Juan', 'Perez', 30, 'jupe@gmail.com', 1, 'admin', '123', 1);
INSERT INTO administrador (id, nombre, apellido, edad, correo_electronico, tipo_administrador_id, user_name, password, status) VALUES (2, 'Pedro', 'Murillo', 25, 'pedromu@gmail.com', 1, 'pedroM', '456', 1);
