ALTER SESSION SET CURRENT_SCHEMA = TIENDAGG


--Procedimiento para obtener los datos de un login
create or replace
PROCEDURE sp_LoginVerification
(in_correo IN login.correo%TYPE,
 in_contrasena IN login.contrasena%TYPE,
 out_cursor_login OUT SYS_REFCURSOR
)
AS
BEGIN
  OPEN out_cursor_login FOR
  SELECT l.correo, l.contrasena
  FROM login l
  WHERE l.correo = in_correo and l.contrasena = in_contrasena;
  
END;


--Procedimiento para obtener los datos de un login
create or replace
PROCEDURE sp_checkCorreo
(in_correo IN login.correo%TYPE,
 out_cursor_login OUT SYS_REFCURSOR
)
AS
BEGIN
  OPEN out_cursor_login FOR
  SELECT l.correo
  FROM login l
  WHERE l.correo = in_correo;
  
END;


--Procedimiento para obtener un usuario
create or replace
PROCEDURE sp_getUser
(in_id IN usuario.id_usuario%TYPE,
 out_cursor_usuario OUT SYS_REFCURSOR
)
AS
BEGIN
  OPEN out_cursor_usuario FOR
  SELECT *
  FROM usuario u
  WHERE u.id_usuario = in_id;
END;


--Procedimiento para obtener todos los usuarios
create or replace
PROCEDURE sp_getUsers
 (out_cursor_usuarios OUT SYS_REFCURSOR)
AS
BEGIN
  OPEN out_cursor_usuarios FOR
  SELECT u.nombre_usuario, u.primer_apellido, u.segundo_apellido, t.descripcion, l.correo
  FROM usuario u 
  INNER JOIN tipo_usuario t ON u.tipo_usuario = t.tipo_usuario
  INNER JOIN login l ON u.id_usuario = l.id_usuario;
END;


--Procedimiento para guardar un usuario
create or replace
PROCEDURE sp_postUser
(in_id IN usuario.id_usuario%TYPE,
 in_nombre IN usuario.nombre_usuario%TYPE,
 in_apellido1 IN usuario.primer_apellido%TYPE,
 in_apellido2 IN usuario.segundo_apellido%TYPE,
 in_tipo IN varchar2,
 in_correo IN login.correo%TYPE,
 in_contrasena IN login.contrasena%TYPE
)
AS
var_tipo_id usuario.tipo_usuario%TYPE;
BEGIN
  SELECT t.tipo_usuario INTO var_tipo_id
  FROM tipo_usuario t WHERE t.descripcion = in_tipo;
  INSERT INTO usuario(id_usuario, nombre_usuario, primer_apellido, segundo_apellido, tipo_usuario)
  VALUES (in_id, in_nombre, in_apellido1, in_apellido2, var_tipo_id);
  INSERT INTO login(id_usuario, correo, contrasena)
  VALUES (in_id, in_correo, in_contrasena);  
END;



--Procedimiento para guardar una categoria
create or replace
PROCEDURE sp_postCategoria
(in_name IN categoria.nombre_cat%TYPE,
 in_descripcion IN categoria.descripcion_cat%TYPE
)
AS
BEGIN
  INSERT INTO categoria(nombre_cat,descripcion_cat)
  VALUES (in_name,in_descripcion);
END;


--Procedimiento para obtener categorias
create or replace
PROCEDURE sp_getCategorias
(out_cursor_categorias OUT SYS_REFCURSOR)
AS
BEGIN
  OPEN out_cursor_categorias FOR
  SELECT c.nombre_cat, c.descripcion_cat, c.id_categoria
  FROM categoria c;
END;


--Procedimiento para guardar prodcutos
create or replace
PROCEDURE sp_postProducto
(in_id IN producto.id_producto%TYPE,
 in_nombre IN producto.nombre_producto%TYPE,
 in_descripcion IN producto.descripcion_producto%TYPE,
 in_precio IN producto.precio%TYPE,
 in_cantidad IN producto.cantidad%TYPE,
 in_categoria IN categoria.nombre_cat%TYPE
)
AS
var_categoria_id categoria.id_categoria%TYPE;
BEGIN
  SELECT c.id_categoria INTO var_categoria_id
  FROM categoria c WHERE c.nombre_cat = in_categoria;
  INSERT INTO producto(id_producto, nombre_producto, descripcion_producto, precio, cantidad, id_categoria)
  VALUES (in_id, in_nombre, in_descripcion, in_precio, in_cantidad, var_categoria_id);
END;


--Procedimiento para obtener productos
create or replace
PROCEDURE sp_getProductos
 (out_cursor_productos OUT SYS_REFCURSOR)
AS
BEGIN   
  OPEN out_cursor_productos FOR
  SELECT p.id_producto, p.nombre_producto, p.precio, p.cantidad, c.nombre_cat
  FROM producto p
  INNER JOIN categoria c ON c.id_categoria = p.id_categoria;
END;




