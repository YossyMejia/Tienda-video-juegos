ALTER SESSION SET CURRENT_SCHEMA = TIENDAGG


--Procedimiento para obtener los datos de un login
create or replace
PROCEDURE sp_LoginVerif
(in_correo IN login.correo%TYPE,
 in_contrasena IN login.contrasena%TYPE,
 out_cursor_login OUT SYS_REFCURSOR
)
AS
BEGIN
  OPEN out_cursor_login FOR
  SELECT l.correo, l.contrasena, u.id_usuario
  FROM login l 
  INNER JOIN usuario u on l.id_usuario=u.id_usuario
  WHERE l.correo = in_correo and l.contrasena = in_contrasena;                              --cerrar cursores
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
 in_categoria IN categoria.id_categoria%TYPE
)
AS
BEGIN
  INSERT INTO producto(id_producto, nombre_producto, descripcion_producto, precio, cantidad, id_categoria)
  VALUES (in_id, in_nombre, in_descripcion, in_precio, in_cantidad, in_categoria);
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


--Procedimiento para obtener los detalles de un producto
create or replace
PROCEDURE sp_getProductoDetalles
 (in_id IN producto.id_producto%TYPE,
 out_cursor_productos OUT SYS_REFCURSOR)
AS
BEGIN   
  OPEN out_cursor_productos FOR
  SELECT p.id_producto, p.nombre_producto, p.precio, p.cantidad, c.nombre_cat, p.descripcion_producto
  FROM producto p
  INNER JOIN categoria c ON c.id_categoria = p.id_categoria
  WHERE p.id_producto = in_id;
END;

--Funcion para filtrar los productos por precio y categoria
CREATE OR REPLACE
FUNCTION fn_getProductosFitlrados 
(in_precio IN producto.precio%TYPE, 
in_categoria IN categoria.nombre_cat%TYPE) 
return sys_refcursor
AS
   datos_filtrados   sys_refcursor;
BEGIN
   OPEN datos_filtrados FOR
        select p.id_producto, p.nombre_producto, p.precio, p.cantidad, c.nombre_cat
        from producto p
        inner join categoria c on p.id_categoria = c.id_categoria
        WHERE p.precio >= in_precio and trim(upper(c.nombre_cat)) LIKE trim(upper('%' || in_categoria || '%'));

   RETURN datos_filtrados;
END;


--Procedimiento para modificar un producto
create or replace
PROCEDURE sp_putProducto
(in_id IN producto.id_producto%TYPE,
 in_nombre IN producto.nombre_producto%TYPE,
 in_precio IN producto.precio%TYPE,
 in_cantidad IN producto.cantidad%TYPE
)
AS
BEGIN
  UPDATE producto SET nombre_producto = in_nombre, precio = in_precio, cantidad = in_cantidad
  WHERE id_producto = in_id;
END;

--Procedimiento para eliminar un producto
create or replace
PROCEDURE sp_deleteProducto
(in_id IN producto.id_producto%TYPE)
AS
BEGIN
  DELETE FROM producto
  WHERE id_producto = in_id;
END;

--Procedimiento para crear una solicitud
create or replace
PROCEDURE sp_postSolicitud
(
 in_usuario IN solicitudtecnica.id_usuario%TYPE,
 in_descripcion IN solicitudtecnica.descripcion%TYPE,
 in_fecha_solicitud IN solicitudtecnica.fecha_solicitud%TYPE
)
AS
BEGIN
  INSERT INTO solicitudTecnica(id_usuario, descripcion, fecha_solicitud)
  VALUES (in_usuario, in_descripcion, in_fecha_solicitud);
END;


--Procedimiento para obtener solicitudes que aun no se responden
create or replace
PROCEDURE sp_getSolicitudes
 (out_cursor_solicitudes OUT SYS_REFCURSOR)
AS
BEGIN   
  OPEN out_cursor_solicitudes FOR
  SELECT *
  FROM solicitudTecnica soli
  LEFT JOIN soluciontecnica solu
  ON soli.id_solicitudtecnica = solu.id_solicitud
  WHERE solu.id_solicitud IS NULL;
END;


--Procedimento para crear respuestas a solicitudes
create or replace
PROCEDURE sp_postSolucion
(
 in_tecnico IN solucionTecnica.id_tecnico%TYPE,
 in_respuesta IN solucionTecnica.respuesta%TYPE,
 in_fecha_solicitud IN soluciontecnica.fecha_solucion%TYPE,
 in_id_solicitud IN soluciontecnica.id_solicitud%TYPE
)
AS
BEGIN
  INSERT INTO soluciontecnica(id_tecnico, respuesta, fecha_solucion, id_solicitud)
  VALUES (in_tecnico, in_respuesta, in_fecha_solicitud, in_id_solicitud);
END;


--Procedimento para obtener las soluciones que tienen respuestas 
create or replace
PROCEDURE sp_getSolicitudesSoluciones
 (out_cursor_solicitudesSoluciones OUT SYS_REFCURSOR)
AS
BEGIN
  OPEN out_cursor_solicitudesSoluciones FOR
  SELECT s.id_solicitudTecnica, s.id_usuario, s.descripcion, so.id_tecnico, so.respuesta 
  FROM solicitudTecnica s
  INNER JOIN soluciontecnica so
  ON s.id_solicitudtecnica = so.id_solicitud;
END;


--Obtener detalles de una solucion
create or replace
PROCEDURE sp_getSolicitudDetalle
 (in_idsolicitud IN solicitudtecnica.id_usuario%TYPE,
 out_cursor_solicitudesSoluciones OUT SYS_REFCURSOR)
AS
BEGIN
  OPEN out_cursor_solicitudesSoluciones FOR
  SELECT  s.id_usuario, s.descripcion, so.id_tecnico, so.respuesta, so.fecha_solucion
  FROM solicitudTecnica s
  INNER JOIN soluciontecnica so
  ON s.id_solicitudtecnica = so.id_solicitud
  WHERE in_idsolicitud = s.id_solicitudTecnica;
END;


