ALTER SESSION SET CURRENT_SCHEMA = TIENDAGG
        
--Creacion de la tabla que almacenara los datos temporalmente        
CREATE TABLE datos_temporal_juegos(
    ID      NUMBER GENERATED ALWAYS AS IDENTITY,
    temporal_id_nombre_pro varchar2(500),
    temporal_descripcion varchar2(500),
    temporal_precio varchar2(500),
    temporal_cantidad varchar2(500),
    temporal_nombre_descripcion_cat varchar2(500)
);


INSERT INTO datos_temporal_juegos (temporal_id_nombre_pro, temporal_descripcion, temporal_precio, temporal_cantidad, temporal_nombre_descripcion_cat) 
values 
('10333, Zelda Ocarina of time', 'Juego de zelda clásico', '10000', '4', 'Juegos N64, Juegos de Nintendo 64 clásicos');

INSERT INTO datos_temporal_juegos (temporal_id_nombre_pro, temporal_descripcion, temporal_precio, temporal_cantidad, temporal_nombre_descripcion_cat) 
values 
('10334, Zelda Majoras Mask', 'Segunda entrega de la serie zelda', '12500', '5', 'Juegos N64, Juegos de Nintendo 64 clásicos');

INSERT INTO datos_temporal_juegos (temporal_id_nombre_pro, temporal_descripcion, temporal_precio, temporal_cantidad, temporal_nombre_descripcion_cat) 
values 
('20884, Gears of war 2', 'Segunda entrega de la serie gears of war exclusiva de Xbox 360', '20000', '5', 'Juegos Xbox 360 adultos, Juegos de Xbox 360 para adultos');


INSERT INTO datos_temporal_juegos (temporal_id_nombre_pro, temporal_descripcion, temporal_precio, temporal_cantidad, temporal_nombre_descripcion_cat) 
values 
('20882, Devil may cry 5 xbox one', 'Juego lanzado para Xbox one ', '30000', '100', 'Juegos de Xbox One adultos, Juegos para Xbox One clasificados para adultos');


select * from datos_temporal_juegos;


--Inserta categoria
CREATE or REPLACE FUNCTION inserta_categoria_pt(v_name varchar2, v_descripcion varchar2) RETURN NUMBER IS 
idTemp NUMBER;
BEGIN
    SELECT id_categoria INTO idTemp FROM categoria WHERE nombre_cat = trim(v_name);
    RETURN (idTemp);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        INSERT INTO categoria(nombre_cat,descripcion_cat)
        VALUES(v_name, v_descripcion);
        
        SELECT id_categoria INTO idTemp FROM categoria WHERE nombre_cat = trim(v_name);
        RETURN (idTemp);
END;
        


--Proceso
create or replace NONEDITIONABLE PROCEDURE  normalize_data AS
t_idProducto number;
t_nombreProducto VARCHAR2(50);
t_descripcionProducto VARCHAR2(100);
t_precio number;
t_cantidad number;
t_nombreCategoria VARCHAR2(50);
t_descripcionCategoria VARCHAR2(100);

idCategoria NUMBER;
v_count number := 0;

CURSOR cursor_temp IS
SELECT temporal_descripcion, temporal_precio, temporal_cantidad,
regexp_substr(temporal_id_nombre_pro, '(\S*)(\s)',1) as t_idproducto,
regexp_substr(temporal_id_nombre_pro, '(\s).+',1) as t_nombreproducto,
regexp_substr(temporal_nombre_descripcion_cat, '[^,]+',1) as t_nombreCategoria,
regexp_substr(temporal_nombre_descripcion_cat, '(\,)((\s).+)',1,1,NULL,2) as t_descripcionCategoria         --Capturar el grupo 2 del resultado de la expresion regular
FROM datos_temporal_juegos
connect by regexp_substr(temporal_id_nombre_pro, '(\S*)(\s)',1,level) is not null and
regexp_substr(temporal_id_nombre_pro, '(\s).+',1,level) is not null and
regexp_substr(temporal_nombre_descripcion_cat, '[^,]+',1,level) is not null and
regexp_substr(temporal_nombre_descripcion_cat, '(\,)((\s).+)',1,level) is not null;
        
BEGIN 
    FOR item IN cursor_temp
    LOOP
        t_idProducto := trim(item.t_idproducto);
        t_nombreProducto := trim(item.t_nombreproducto);
        t_descripcionProducto := trim(item.temporal_descripcion);
        t_precio := trim(item.temporal_precio);
        t_cantidad := trim(item.temporal_cantidad);
        t_nombreCategoria := trim(item.t_nombreCategoria);
        t_descripcionCategoria := trim(item.t_descripcionCategoria);
        
        idCategoria := inserta_categoria_pt(trim(t_nombreCategoria), trim(t_descripcionCategoria));
        
        DBMS_OUTPUT.PUT_LINE (t_idProducto || ' nombre= ' || t_nombreProducto || 'descripprod= ' || t_descripcionProducto || 'prec= ' || t_precio || ' cant= ' || t_cantidad || ' nomcat= ' || t_nombreCategoria || ' descat= ' || t_descripcionCategoria || ' idcat= ' || idCategoria);
        
        SELECT COUNT(*) INTO v_count FROM producto WHERE id_producto = t_idProducto;
            if v_count = 0 then
                INSERT INTO producto(id_producto, nombre_producto, descripcion_producto, precio, cantidad, id_categoria)
                VALUES (t_idProducto, t_nombreProducto, t_descripcionProducto, t_precio, t_cantidad, idCategoria);
            end if;
    END LOOP;
END;


SET SERVEROUTPUT ON
EXECUTE normalize_data;



