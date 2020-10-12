ALTER SESSION SET CURRENT_SCHEMA = TIENDAGG
        






--Tabla provincia
CREATE TABLE provincia (
    id_provincia      NUMBER NOT NULL,
    nombre_provincia  VARCHAR2(10 CHAR) NOT NULL
);

 
ALTER TABLE provincia ADD CONSTRAINT provincia_pk PRIMARY KEY ( id_provincia );
        






--Tabla canton
CREATE TABLE canton (
    id_canton      NUMBER NOT NULL,
    nombre_canton  VARCHAR2(25 CHAR) NOT NULL,
    id_provincia   NUMBER NOT NULL
);

ALTER TABLE canton ADD CONSTRAINT canton_pk PRIMARY KEY ( id_canton );

ALTER TABLE canton
    ADD CONSTRAINT canton_provincia_fk FOREIGN KEY ( id_provincia )
        REFERENCES provincia ( id_provincia );
             





  
--Tabla distrito
CREATE TABLE distrito (
    id_distrito      NUMBER NOT NULL,
    nombre_distrito  VARCHAR2(25 CHAR) NOT NULL,
    id_canton        NUMBER NOT NULL
);

ALTER TABLE distrito ADD CONSTRAINT distrito_pk PRIMARY KEY ( id_distrito );

ALTER TABLE distrito
    ADD CONSTRAINT distrito_canton_fk FOREIGN KEY ( id_canton )
        REFERENCES canton ( id_canton );
        






--Tabla TipoUsuario
CREATE TABLE tipo_usuario (
    tipo_usuario      NUMBER(1) NOT NULL,
    descripcion  VARCHAR2(20) NOT NULL
);

ALTER TABLE tipo_usuario ADD CONSTRAINT tipo_usuario_pk PRIMARY KEY ( tipo_usuario );
        






--Tabla Usuario
CREATE TABLE usuario (
    id_usuario        NUMBER,
    nombre_usuario    VARCHAR2(35 CHAR) NOT NULL,
    primer_apellido   VARCHAR2(35 CHAR) NOT NULL,
    segundo_apellido  VARCHAR2(35 CHAR) NOT NULL,
    tipo_usuario      NUMBER NOT NULL
);

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( id_usuario );

ALTER TABLE usuario
    ADD CONSTRAINT usuario_tipo_usuario_fk FOREIGN KEY ( tipo_usuario )
        REFERENCES tipo_usuario ( tipo_usuario );
        






--Tabla direccion
CREATE TABLE direccion (
    id_direccion  NUMBER GENERATED ALWAYS AS IDENTITY,
    provincia VARCHAR2(30 CHAR) NOT NULL,
    canton VARCHAR2(30 CHAR) NOT NULL,
    distrito VARCHAR2(30 CHAR) NOT NULL,
    datos_extra   VARCHAR2(255 CHAR) NOT NULL,
    id_usuario NUMBER
);

ALTER TABLE direccion ADD CONSTRAINT direccion_pk PRIMARY KEY ( id_direccion );

ALTER TABLE direccion
    ADD CONSTRAINT usuarioxdireccionfk FOREIGN KEY ( id_usuario )
        REFERENCES usuario ( id_usuario );
        


--Tabla tarjeta

CREATE TABLE tarjeta (
    numero_tarjeta     VARCHAR2(50 CHAR) NOT NULL,
    titular_tarjeta    VARCHAR2(50 CHAR) NOT NULL,
    ccv                NUMBER NOT NULL,
    fecha_vencimiento  VARCHAR2(50 CHAR) NOT NULL,
    id_usuario         NUMBER NOT NULL
);

ALTER TABLE tarjeta ADD CONSTRAINT tarjeta_pk PRIMARY KEY ( numero_tarjeta );

ALTER TABLE tarjeta
    ADD CONSTRAINT tarjeta_usuario_fk FOREIGN KEY ( id_usuario )
        REFERENCES usuario ( id_usuario );




--TablaUusarioxDireccion
CREATE TABLE usuarioxdireccion (
    direccion_id_direccion  NUMBER NOT NULL,
    usuario_id_usuario      NUMBER NOT NULL
);

ALTER TABLE usuarioxdireccion ADD CONSTRAINT usuarioxdireccion_pk PRIMARY KEY ( direccion_id_direccion,
                                                                                usuario_id_usuario );

ALTER TABLE usuarioxdireccion
    ADD CONSTRAINT usuarioxdireccion_direccion_fk FOREIGN KEY ( direccion_id_direccion )
        REFERENCES direccion ( id_direccion );

ALTER TABLE usuarioxdireccion
    ADD CONSTRAINT usuarioxdireccion_usuario_fk FOREIGN KEY ( usuario_id_usuario )
        REFERENCES usuario ( id_usuario );
        





--TablaUsuarioXLogin
CREATE TABLE login (
    id_login NUMBER GENERATED ALWAYS AS IDENTITY,
    id_usuario  NUMBER NOT NULL,
    correo      varchar2(50) NOT NULL,
    contrasena  varchar2(20) NOT NULL
);

ALTER TABLE login ADD CONSTRAINT login_pk PRIMARY KEY ( id_login );

ALTER TABLE login
    ADD CONSTRAINT login_fk FOREIGN KEY ( id_usuario )
        REFERENCES usuario ( id_usuario );


--Tabla categoria
CREATE TABLE categoria (
    id_categoria     NUMBER GENERATED ALWAYS AS IDENTITY,
    nombre_cat       VARCHAR2(40 CHAR) NOT NULL,
    descripcion_cat  VARCHAR2(100 CHAR) NOT NULL
);

ALTER TABLE categoria ADD CONSTRAINT categoria_pk PRIMARY KEY ( id_categoria );



--Tabla producto
CREATE TABLE producto(
    id_producto           NUMBER NOT NULL,
    nombre_producto       VARCHAR2(40 CHAR) NOT NULL,
    descripcion_producto  VARCHAR2(100 CHAR) NOT NULL,
    precio                FLOAT NOT NULL,
    cantidad              NUMBER NOT NULL,
    id_categoria          NUMBER
);

ALTER TABLE producto ADD CONSTRAINT producto_pk PRIMARY KEY ( id_producto );


ALTER TABLE producto
    ADD CONSTRAINT productoxcategoria_fk FOREIGN KEY ( id_categoria )
        REFERENCES categoria ( id_categoria );
        
        
--Tabla solicitud
CREATE TABLE solicitudTecnica(
    id_solicitudTecnica      NUMBER GENERATED ALWAYS AS IDENTITY,
    id_usuario            NUMBER NOT NULL,
    descripcion           VARCHAR2(400 CHAR) NOT NULL,
    fecha_solicitud       VARCHAR2(50 CHAR) NOT NULL
);

ALTER TABLE solicitudTecnica ADD CONSTRAINT solicitudTecnica_pk PRIMARY KEY ( id_solicitudTecnica );


ALTER TABLE solicitudTecnica
    ADD CONSTRAINT solicitudtxcliente_fk FOREIGN KEY ( id_usuario )
        REFERENCES usuario ( id_usuario );
    
        
        
CREATE TABLE solucionTecnica(
    id_solucionTecnica    NUMBER GENERATED ALWAYS AS IDENTITY,
    id_tecnico            NUMBER NOT NULL,
    respuesta             VARCHAR2(400 CHAR) NOT NULL,
    fecha_solucion        VARCHAR2(50 CHAR) NOT NULL,
    id_solicitud          NUMBER NOT NULL
);

ALTER TABLE solucionTecnica ADD CONSTRAINT solucionTecnica_pk PRIMARY KEY ( id_solucionTecnica );

ALTER TABLE solucionTecnica
    ADD CONSTRAINT solucionTecnicaxtecnico_fk FOREIGN KEY ( id_tecnico )
        REFERENCES usuario ( id_usuario );
    
      