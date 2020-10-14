ALTER SESSION SET CURRENT_SCHEMA = TIENDAGG
       
       
       
        
--TRIGGER PRODUCTO

--Tabla para back up de producto
drop table producto_bu;


CREATE TABLE producto_bu ( 
action_date TIMESTAMP, 
action VARCHAR2(50),
change_by VARCHAR2 (50),
table_name VARCHAR2 (30),
table_id NUMBER,
old_data VARCHAR2 (300),
new_data VARCHAR2 (300)
);

--Trigger producto
CREATE OR REPLACE TRIGGER PRODUCTO_BU_TRIGGER
  AFTER INSERT OR UPDATE OR DELETE
  ON producto FOR EACH ROW
DECLARE
  action  producto_bu.action%TYPE;
  id_tabla producto.id_producto%TYPE;
BEGIN
  IF INSERTING THEN
    action := 'Insert';
    id_tabla := :NEW.id_producto;
  ELSIF UPDATING THEN
    action := 'Update';
    id_tabla := :NEW.id_producto;
  ELSIF DELETING THEN
    action := 'Delete';
    id_tabla := :OLD.id_producto;
  ELSE
    DBMS_OUTPUT.PUT_LINE('This code is not reachable.');
  END IF;
  
  INSERT INTO producto_bu (action_date, action, change_by, table_name, table_id, old_data , new_data)
    VALUES (SYSTIMESTAMP, action,  user, 'producto', id_tabla,  
    (:OLD.nombre_producto ||' ' || :OLD.descripcion_producto ||' '|| :OLD.precio ||' ' || :OLD.cantidad ||' ' || :OLD.id_categoria),
    (:NEW.nombre_producto ||' ' || :NEW.descripcion_producto ||' ' || :NEW.precio ||' ' || :NEW.cantidad ||' ' || :NEW.id_categoria) );
END;


select * from producto_bu;





--TRIGGER TIPO_USUARIO
drop table tipo_usuario_bu;


CREATE TABLE tipo_usuario_bu ( 
action_date TIMESTAMP, 
action VARCHAR2(50),
change_by VARCHAR2 (50),
table_name VARCHAR2 (30),
table_id NUMBER,
old_data VARCHAR2 (300),
new_data VARCHAR2 (300)
);


CREATE OR REPLACE TRIGGER TIPO_USUARIO_BU_TRIGGER
  AFTER INSERT OR UPDATE OR DELETE
  ON tipo_usuario FOR EACH ROW
DECLARE
  action  tipo_usuario_bu.action%TYPE;
  id_tabla tipo_usuario.tipo_usuario%TYPE;
BEGIN
  IF INSERTING THEN
    action := 'Insert';
    id_tabla := :NEW.tipo_usuario;
  ELSIF UPDATING THEN
    action := 'Update';
    id_tabla := :NEW.tipo_usuario;
  ELSIF DELETING THEN
    action := 'Delete';
    id_tabla := :OLD.tipo_usuario;
  ELSE
    DBMS_OUTPUT.PUT_LINE('This code is not reachable.');
  END IF;
  
  INSERT INTO tipo_usuario_bu (action_date, action, change_by, table_name, table_id, old_data , new_data)
    VALUES (SYSTIMESTAMP, action,  user, 'tipo_usuario', id_tabla,  
    (:OLD.tipo_usuario ||' ' || :OLD.descripcion),
    (:NEW.tipo_usuario ||' ' || :NEW.descripcion) );
END;


select * from tipo_usuario_bu;



--TRGGIER USUARIO
drop table usuario_bu;

--Tabla para back up de usuario
CREATE TABLE usuario_bu ( 
action_date TIMESTAMP, 
action VARCHAR2(50),
change_by VARCHAR2 (50),
table_name VARCHAR2 (30),
table_id NUMBER,
old_data VARCHAR2 (300),
new_data VARCHAR2 (300)
);


CREATE OR REPLACE TRIGGER usuario_bu_TRIGGER
  AFTER INSERT OR UPDATE OR DELETE
  ON usuario FOR EACH ROW
DECLARE
  action  usuario_bu.action%TYPE;
  id_tabla usuario.id_usuario%TYPE;
BEGIN
  IF INSERTING THEN
    action := 'Insert';
    id_tabla := :NEW.id_usuario;
  ELSIF UPDATING THEN
    action := 'Update';
    id_tabla := :NEW.id_usuario;
  ELSIF DELETING THEN
    action := 'Delete';
    id_tabla := :OLD.id_usuario;
  ELSE
    DBMS_OUTPUT.PUT_LINE('This code is not reachable.');
  END IF;
  
  INSERT INTO usuario_bu (action_date, action, change_by, table_name, table_id, old_data , new_data)
    VALUES (SYSTIMESTAMP, action,  user, 'usuario', id_tabla,  
    (:OLD.nombre_usuario ||' ' || :OLD.primer_apellido ||' '|| :OLD.segundo_apellido ||' ' || :OLD.tipo_usuario),
    (:NEW.nombre_usuario ||' ' || :NEW.primer_apellido ||' '|| :NEW.segundo_apellido ||' ' || :NEW.tipo_usuario) );
END;


select * from usuario_bu;




--TRGGIER LOGIN
drop table login_bu;

--Tabla para back up de login
CREATE TABLE login_bu ( 
action_date TIMESTAMP, 
action VARCHAR2(50),
change_by VARCHAR2 (50),
table_name VARCHAR2 (30),
table_id NUMBER,
old_data VARCHAR2 (300),
new_data VARCHAR2 (300)
);


CREATE OR REPLACE TRIGGER login_bu_TRIGGER
  AFTER INSERT OR UPDATE OR DELETE
  ON login FOR EACH ROW
DECLARE
  action  login_bu.action%TYPE;
  id_tabla login.id_login%TYPE;
BEGIN
  IF INSERTING THEN
    action := 'Insert';
    id_tabla := :NEW.id_login;
  ELSIF UPDATING THEN
    action := 'Update';
    id_tabla := :NEW.id_login;
  ELSIF DELETING THEN
    action := 'Delete';
    id_tabla := :OLD.id_login;
  ELSE
    DBMS_OUTPUT.PUT_LINE('This code is not reachable.');
  END IF;
  
  INSERT INTO login_bu (action_date, action, change_by, table_name, table_id, old_data , new_data)
    VALUES (SYSTIMESTAMP, action,  user, 'login', id_tabla,  
    (:OLD.id_usuario ||' ' || :OLD.correo ||' '|| :OLD.contrasena),
    (:NEW.id_usuario ||' ' || :NEW.correo ||' '|| :NEW.contrasena) );
END;


select * from login_bu;



--TRIGGER CATEGORIA
drop table categoria_bu;

--Tabla para back up de categoria
CREATE TABLE categoria_bu ( 
action_date TIMESTAMP, 
action VARCHAR2(50),
change_by VARCHAR2 (50),
table_name VARCHAR2 (30),
table_id NUMBER,
old_data VARCHAR2 (300),
new_data VARCHAR2 (300)
);


CREATE OR REPLACE TRIGGER categoria_bu_TRIGGER
  AFTER INSERT OR UPDATE OR DELETE
  ON categoria FOR EACH ROW
DECLARE
  action  categoria_bu.action%TYPE;
  id_tabla categoria.id_categoria%TYPE;
BEGIN
  IF INSERTING THEN
    action := 'Insert';
    id_tabla := :NEW.id_categoria;
  ELSIF UPDATING THEN
    action := 'Update';
    id_tabla := :NEW.id_categoria;
  ELSIF DELETING THEN
    action := 'Delete';
    id_tabla := :OLD.id_categoria;
  ELSE
    DBMS_OUTPUT.PUT_LINE('This code is not reachable.');
  END IF;
  
  INSERT INTO categoria_bu (action_date, action, change_by, table_name, table_id, old_data , new_data)
    VALUES (SYSTIMESTAMP, action,  user, 'categoria', id_tabla,  
    (:OLD.nombre_cat ||' ' || :OLD.descripcion_cat ),
    (:NEW.nombre_cat ||' ' || :NEW.descripcion_cat ) );
END;


select * from categoria_bu;



--TRIGGER SOLICITUD
drop table solicitud_bu;

--Tabla para back up de solicitud
CREATE TABLE solicitud_bu ( 
action_date TIMESTAMP, 
action VARCHAR2(50),
change_by VARCHAR2 (50),
table_name VARCHAR2 (30),
table_id NUMBER,
old_data VARCHAR2 (300),
new_data VARCHAR2 (300)
);


CREATE OR REPLACE TRIGGER solicitud_bu_TRIGGER
  AFTER INSERT OR UPDATE OR DELETE
  ON solicitudTecnica FOR EACH ROW
DECLARE
  action  solicitud_bu.action%TYPE;
  id_tabla solicitudTecnica.id_solicitudTecnica%TYPE;
BEGIN
  IF INSERTING THEN
    action := 'Insert';
    id_tabla := :NEW.id_solicitudTecnica;
  ELSIF UPDATING THEN
    action := 'Update';
    id_tabla := :NEW.id_solicitudTecnica;
  ELSIF DELETING THEN
    action := 'Delete';
    id_tabla := :OLD.id_solicitudTecnica;
  ELSE
    DBMS_OUTPUT.PUT_LINE('This code is not reachable.');
  END IF;
  
  INSERT INTO solicitud_bu (action_date, action, change_by, table_name, table_id, old_data , new_data)
    VALUES (SYSTIMESTAMP, action,  user, 'solicitudTecnica', id_tabla,  
    (:OLD.id_usuario ||' ' || :OLD.descripcion ||' ' || :OLD.fecha_solicitud ),
    (:NEW.id_usuario ||' ' || :NEW.descripcion ||' ' || :NEW.fecha_solicitud ) );
END;


select * from solicitud_bu;


--TRIGGER SOLUCION
drop table solucion_bu;

--Tabla para back up de solucion
CREATE TABLE solucion_bu ( 
action_date TIMESTAMP, 
action VARCHAR2(50),
change_by VARCHAR2 (50),
table_name VARCHAR2 (30),
table_id NUMBER,
old_data VARCHAR2 (300),
new_data VARCHAR2 (300)
);


CREATE OR REPLACE TRIGGER solucion_bu_TRIGGER
  AFTER INSERT OR UPDATE OR DELETE
  ON solucionTecnica FOR EACH ROW
DECLARE
  action  solucion_bu.action%TYPE;
  id_tabla solucionTecnica.id_solucionTecnica%TYPE;
BEGIN
  IF INSERTING THEN
    action := 'Insert';
    id_tabla := :NEW.id_solucionTecnica;
  ELSIF UPDATING THEN
    action := 'Update';
    id_tabla := :NEW.id_solucionTecnica;
  ELSIF DELETING THEN
    action := 'Delete';
    id_tabla := :OLD.id_solucionTecnica;
  ELSE
    DBMS_OUTPUT.PUT_LINE('This code is not reachable.');
  END IF;
  
  INSERT INTO solucion_bu (action_date, action, change_by, table_name, table_id, old_data , new_data)
    VALUES (SYSTIMESTAMP, action,  user, 'solucionTecnica', id_tabla,  
    (:OLD.id_tecnico ||' ' || :OLD.respuesta ||' ' || :OLD.fecha_solucion ||' ' || :OLD.id_solicitud ),
    (:NEW.id_tecnico ||' ' || :NEW.respuesta ||' ' || :NEW.fecha_solucion ||' ' || :NEW.id_solicitud ) );
END;


select * from solucion_bu;


--TRIGGER TARJETA
drop table tarjeta_bu;

--Tabla para back up de solucion
CREATE TABLE tarjeta_bu ( 
action_date TIMESTAMP, 
action VARCHAR2(50),
change_by VARCHAR2 (50),
table_name VARCHAR2 (30),
table_id NUMBER,
old_data VARCHAR2 (300),
new_data VARCHAR2 (300)
);


CREATE OR REPLACE TRIGGER tarjeta_bu_TRIGGER
  AFTER INSERT OR UPDATE OR DELETE
  ON tarjeta FOR EACH ROW
DECLARE
  action  tarjeta_bu.action%TYPE;
  id_tabla tarjeta.numero_tarjeta%TYPE;
BEGIN
  IF INSERTING THEN
    action := 'Insert';
    id_tabla := :NEW.numero_tarjeta;
  ELSIF UPDATING THEN
    action := 'Update';
    id_tabla := :NEW.numero_tarjeta;
  ELSIF DELETING THEN
    action := 'Delete';
    id_tabla := :OLD.numero_tarjeta;
  ELSE
    DBMS_OUTPUT.PUT_LINE('This code is not reachable.');
  END IF;
  
  INSERT INTO tarjeta_bu (action_date, action, change_by, table_name, table_id, old_data , new_data)
    VALUES (SYSTIMESTAMP, action,  user, 'tarjeta', id_tabla,  
    (:OLD.titular_tarjeta ||' ' || :OLD.ccv ||' ' || :OLD.fecha_vencimiento ||' ' || :OLD.id_usuario ),
    (:NEW.titular_tarjeta ||' ' || :NEW.ccv ||' ' || :NEW.fecha_vencimiento ||' ' || :NEW.id_usuario ) );
END;


select * from tarjeta_bu;


--TRIGGER DIRECCION
drop table direccion_bu;

--Tabla para back up de solucion
CREATE TABLE direccion_bu ( 
action_date TIMESTAMP, 
action VARCHAR2(50),
change_by VARCHAR2 (50),
table_name VARCHAR2 (30),
table_id NUMBER,
old_data VARCHAR2 (300),
new_data VARCHAR2 (300)
);


CREATE OR REPLACE TRIGGER direccion_bu_TRIGGER
  AFTER INSERT OR UPDATE OR DELETE
  ON direccion FOR EACH ROW
DECLARE
  action  direccion_bu.action%TYPE;
  id_tabla direccion.id_direccion%TYPE;
BEGIN
  IF INSERTING THEN
    action := 'Insert';
    id_tabla := :NEW.id_direccion;
  ELSIF UPDATING THEN
    action := 'Update';
    id_tabla := :NEW.id_direccion;
  ELSIF DELETING THEN
    action := 'Delete';
    id_tabla := :OLD.id_direccion;
  ELSE
    DBMS_OUTPUT.PUT_LINE('This code is not reachable.');
  END IF;
  
  INSERT INTO  direccion_bu(action_date, action, change_by, table_name, table_id, old_data , new_data)
    VALUES (SYSTIMESTAMP, action,  user, 'direccion', id_tabla,  
    (:OLD.provincia ||' ' || :OLD.canton ||' ' || :OLD.distrito ||' ' || :OLD.datos_extra ||' ' || :OLD.id_usuario ),
    (:NEW.provincia ||' ' || :NEW.canton ||' ' || :NEW.distrito ||' ' || :NEW.datos_extra ||' ' || :NEW.id_usuario ) );
END;


select * from direccion_bu;


--TRIGGER ORDEN
drop table orden_bu;

--Tabla para back up de solucion
CREATE TABLE orden_bu ( 
action_date TIMESTAMP, 
action VARCHAR2(50),
change_by VARCHAR2 (50),
table_name VARCHAR2 (30),
table_id NUMBER,
old_data VARCHAR2 (300),
new_data VARCHAR2 (300)
);


CREATE OR REPLACE TRIGGER orden_bu_TRIGGER
  AFTER INSERT OR UPDATE OR DELETE
  ON orden FOR EACH ROW
DECLARE
  action  orden_bu.action%TYPE;
  id_tabla orden.id_orden%TYPE;
BEGIN
  IF INSERTING THEN
    action := 'Insert';
    id_tabla := :NEW.id_orden;
  ELSIF UPDATING THEN
    action := 'Update';
    id_tabla := :NEW.id_orden;
  ELSIF DELETING THEN
    action := 'Delete';
    id_tabla := :OLD.id_orden;
  ELSE
    DBMS_OUTPUT.PUT_LINE('This code is not reachable.');
  END IF;
  
  INSERT INTO  orden_bu(action_date, action, change_by, table_name, table_id, old_data , new_data)
    VALUES (SYSTIMESTAMP, action,  user, 'orden', id_tabla,  
    (:OLD.fecha_orden ||' ' || :OLD.detalles ||' ' || :OLD.estado ||' ' || :OLD.id_direccion ||' ' || :OLD.id_usuario ),
    (:NEW.fecha_orden ||' ' || :NEW.detalles ||' ' || :NEW.estado ||' ' || :NEW.id_direccion ||' ' || :NEW.id_usuario ) );
END;

select * from orden_bu;



--TRIGGER ORDENXPRODUCTO
drop table ordenxproducto_bu;

--Tabla para back up de solucion
CREATE TABLE ordenxproducto_bu ( 
action_date TIMESTAMP, 
action VARCHAR2(50),
change_by VARCHAR2 (50),
table_name VARCHAR2 (30),
table_id NUMBER,
old_data VARCHAR2 (300),
new_data VARCHAR2 (300)
);


CREATE OR REPLACE TRIGGER ordenxproducto_bu_TRIGGER
  AFTER INSERT OR UPDATE OR DELETE
  ON ordenxproducto FOR EACH ROW
DECLARE
  action  ordenxproducto_bu.action%TYPE;
  id_tabla ordenxproducto.id%TYPE;
BEGIN
  IF INSERTING THEN
    action := 'Insert';
    id_tabla := :NEW.id;
  ELSIF UPDATING THEN
    action := 'Update';
    id_tabla := :NEW.id;
  ELSIF DELETING THEN
    action := 'Delete';
    id_tabla := :OLD.id;
  ELSE
    DBMS_OUTPUT.PUT_LINE('This code is not reachable.');
  END IF;
  
  INSERT INTO  ordenxproducto_bu(action_date, action, change_by, table_name, table_id, old_data , new_data)
    VALUES (SYSTIMESTAMP, action,  user, 'ordenxproducto', id_tabla,  
    (:OLD.id_orden ||' ' || :OLD.id_producto),
    (:NEW.id_orden ||' ' || :NEW.id_producto ) );
END;

select * from ordenxproducto_bu;


--TRIGGER TARJETA
drop table factura_bu;

--Tabla para back up de solucion
CREATE TABLE factura_bu ( 
action_date TIMESTAMP, 
action VARCHAR2(50),
change_by VARCHAR2 (50),
table_name VARCHAR2 (30),
table_id NUMBER,
old_data VARCHAR2 (300),
new_data VARCHAR2 (300)
);


CREATE OR REPLACE TRIGGER factura_bu_TRIGGER
  AFTER INSERT OR UPDATE OR DELETE
  ON factura FOR EACH ROW
DECLARE
  action  factura_bu.action%TYPE;
  id_tabla factura.id_factura%TYPE;
BEGIN
  IF INSERTING THEN
    action := 'Insert';
    id_tabla := :NEW.id_factura;
  ELSIF UPDATING THEN
    action := 'Update';
    id_tabla := :NEW.id_factura;
  ELSIF DELETING THEN
    action := 'Delete';
    id_tabla := :OLD.id_factura;
  ELSE
    DBMS_OUTPUT.PUT_LINE('This code is not reachable.');
  END IF;
  
  INSERT INTO  factura_bu(action_date, action, change_by, table_name, table_id, old_data , new_data)
    VALUES (SYSTIMESTAMP, action,  user, 'factura', id_tabla,  
    (:OLD.fecha_factura ||' ' || :OLD.detalles ||' ' || :OLD.monto ||' ' || :OLD.numero_tarjeta ||' ' || :OLD.id_orden),
    (:NEW.fecha_factura ||' ' || :NEW.detalles ||' ' || :NEW.monto ||' ' || :NEW.numero_tarjeta ||' ' || :NEW.id_orden) );
END;

select * from factura_bu;












