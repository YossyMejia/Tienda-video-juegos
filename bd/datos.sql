ALTER SESSION SET CURRENT_SCHEMA = TIENDAGG


--Tipo usuario
INSERT INTO tipo_usuario (tipo_usuario, descripcion) values (1, 'Administrador');
INSERT INTO tipo_usuario (tipo_usuario, descripcion) values (2, 'Cliente');
INSERT INTO tipo_usuario (tipo_usuario, descripcion) values (3, 'Soporte Tecnico');
INSERT INTO tipo_usuario (tipo_usuario, descripcion) values (4, 'Repartidor');

select * from tipo_usuario;




--Direccion
INSERT INTO direccion (id_direccion, datos_extra) values (1, 'Frente palo mangos');
INSERT INTO direccion (id_direccion, datos_extra) values (2, 'al lado de pulperia san ramon');
INSERT INTO direccion (id_direccion, datos_extra) values (3, 'casa roja');
INSERT INTO direccion (id_direccion, datos_extra) values (4, 'Frente al pali');

select * from direccion;



--Usuario 
INSERT INTO usuario(id_usuario,nombre_usuario,primer_apellido,segundo_apellido,tipo_usuario) values(207709754,'Jossy','Mejia','Vargas','1');

select * from usuario;


--Login
INSERT INTO login (id_usuario,correo, contrasena) values (207709754, 'yozi0808@gmail.com', '1234');

select * from login;


--Categoria
select * from categoria;

--Producto
select * from producto;

--Solicitud
select * from solicitudtecnica

select * from solucionTecnica