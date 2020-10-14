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
INSERT INTO usuario(id_usuario,nombre_usuario,primer_apellido,segundo_apellido,tipo_usuario) values(309990999,'Carlos','Sanchez','Vilalreal','1');


select * from usuario;


--Login
INSERT INTO login (id_usuario,correo, contrasena) values (309990999, 'carlos@gmail.com', '1234');

select * from login;


--Categoria
select * from categoria;


--Producto
INSERT INTO producto (id_producto, nombre_producto, descripcion_producto, precio, cantidad, id_categoria) 
values (123129, 'The last', 'juego sobre zombies', 12500,45, 1);

UPDATE producto SET nombre_producto = 'last 2222', precio = 101010, cantidad = 12211
  WHERE id_producto = 123129;

delete from producto where id_producto = 123129;


select * from producto;
--Solicitud
select * from solicitudtecnica


select * from solucionTecnica


select * from tarjeta


select * from direccion


select * from orden;

select * from ordenxproducto;

select * from factura;
