-- Generado por Oracle SQL Developer Data Modeler 24.3.1.351.0831
--   en:        2026-05-16 23:36:33 CLT
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE Cliente 
    ( 
     rut              NUMBER (8)  NOT NULL , 
     dv               NUMBER (1)  NOT NULL , 
     nombre_cliente   VARCHAR2 (9)  NOT NULL , 
     fecha_nacimiento DATE  NOT NULL , 
     papellido        VARCHAR2 (15)  NOT NULL , 
     mapellido        VARCHAR2 (15)  NOT NULL , 
     Tipo_cliente_id  NUMBER (5)  NOT NULL 
    ) 
;

ALTER TABLE Cliente 
    ADD CONSTRAINT Cliente_PK PRIMARY KEY ( rut ) ;

CREATE TABLE Detalle_venta 
    ( 
     id_detalle_venta   NUMBER (15)  NOT NULL , 
     precio_original    NUMBER (7)  NOT NULL , 
     descuento_aplicado NUMBER (5)  NOT NULL , 
     Ventas_id_venta    NUMBER (12)  NOT NULL , 
     Ropa_id_ropa       NVARCHAR2 (8)  NOT NULL 
    ) 
;

CREATE TABLE Empleado 
    ( 
     id_empleado          NUMBER (8)  NOT NULL , 
     run                  NUMBER (8)  NOT NULL , 
     dv                   VARCHAR2 (1)  NOT NULL , 
     nombre               VARCHAR2 (15)  NOT NULL , 
     papellido            VARCHAR2 (8)  NOT NULL , 
     mapellido            VARCHAR2 (8)  NOT NULL , 
     fecha_contrato       DATE  NOT NULL , 
     salario              NUMBER (7)  NOT NULL , 
     cargo                VARCHAR2 (15)  NOT NULL , 
     Sucursal_Sucursal_ID NUMBER  NOT NULL 
    ) 
;

ALTER TABLE Empleado 
    ADD CONSTRAINT Empleado_PK PRIMARY KEY ( id_empleado ) ;

CREATE TABLE Region 
    ( 
     id_region     NUMBER (8)  NOT NULL , 
     nombre_region VARCHAR2 (20)  NOT NULL 
    ) 
;

ALTER TABLE Region 
    ADD CONSTRAINT Region_PK PRIMARY KEY ( id_region ) ;

CREATE TABLE Ropa 
    ( 
     id_ropa           NVARCHAR2 (8)  NOT NULL , 
     cuidados          VARCHAR2 (80)  NOT NULL , 
     descripcion       NVARCHAR2 (80)  NOT NULL , 
     Tipo_ropa_id_ropa NUMBER (8)  NOT NULL 
    ) 
;

ALTER TABLE Ropa 
    ADD CONSTRAINT Ropa_PK PRIMARY KEY ( id_ropa ) ;

CREATE TABLE Sucursal 
    ( 
     id_sucursal      NUMBER (8)  NOT NULL , 
     nombre_sucursal  NVARCHAR2 (15)  NOT NULL , 
     ciudad           VARCHAR2 (20)  NOT NULL , 
     Region_id_region NUMBER (8)  NOT NULL , 
     Sucursal_ID      NUMBER  NOT NULL 
    ) 
;

ALTER TABLE Sucursal 
    ADD CONSTRAINT Sucursal_PK PRIMARY KEY ( Sucursal_ID ) ;

CREATE TABLE Tipo_cliente 
    ( 
     id                NUMBER (5)  NOT NULL , 
     categoria_cliente VARCHAR2 (8)  NOT NULL , 
     fecha_registro    DATE  NOT NULL , 
     puntos            NUMBER (9)  NOT NULL 
    ) 
;

ALTER TABLE Tipo_cliente 
    ADD CONSTRAINT Tipo_cliente_PK PRIMARY KEY ( id ) ;

CREATE TABLE Tipo_ropa 
    ( 
     id_ropa       NUMBER (8)  NOT NULL , 
     diseño        NVARCHAR2 (1)  NOT NULL , 
     estilo        VARCHAR2 (15)  NOT NULL , 
     color         VARCHAR2 (20)  NOT NULL , 
     composicion   VARCHAR2 (50)  NOT NULL , 
     detalles      VARCHAR2 (20)  NOT NULL , 
     tipo_prenda   VARCHAR2 (30)  NOT NULL , 
     genero        VARCHAR2 (8)  NOT NULL , 
     talla         NVARCHAR2 (15)  NOT NULL , 
     marca         NVARCHAR2 (30)  NOT NULL , 
     estado_prenda VARCHAR2 (18)  NOT NULL 
    ) 
;

ALTER TABLE Tipo_ropa 
    ADD CONSTRAINT Tipo_ropa_PK PRIMARY KEY ( id_ropa ) ;

CREATE TABLE Ventas 
    ( 
     id_venta             NUMBER (12)  NOT NULL , 
     boleta               VARCHAR2 (30)  NOT NULL , 
     carrito              NUMBER (8)  NOT NULL , 
     Cliente_rut          NUMBER (8)  NOT NULL , 
     Empleado_id_empleado NUMBER (8)  NOT NULL 
    ) 
;

ALTER TABLE Ventas 
    ADD CONSTRAINT Ventas_PK PRIMARY KEY ( id_venta ) ;

ALTER TABLE Cliente 
    ADD CONSTRAINT Cliente_Tipo_cliente_FK FOREIGN KEY 
    ( 
     Tipo_cliente_id
    ) 
    REFERENCES Tipo_cliente 
    ( 
     id
    ) 
;

ALTER TABLE Detalle_venta 
    ADD CONSTRAINT Detalle_venta_Ropa_FK FOREIGN KEY 
    ( 
     Ropa_id_ropa
    ) 
    REFERENCES Ropa 
    ( 
     id_ropa
    ) 
;

ALTER TABLE Detalle_venta 
    ADD CONSTRAINT Detalle_venta_Ventas_FK FOREIGN KEY 
    ( 
     Ventas_id_venta
    ) 
    REFERENCES Ventas 
    ( 
     id_venta
    ) 
;

ALTER TABLE Empleado 
    ADD CONSTRAINT Empleado_Sucursal_FK FOREIGN KEY 
    ( 
     Sucursal_Sucursal_ID
    ) 
    REFERENCES Sucursal 
    ( 
     Sucursal_ID
    ) 
;

ALTER TABLE Ropa 
    ADD CONSTRAINT Ropa_Tipo_ropa_FK FOREIGN KEY 
    ( 
     Tipo_ropa_id_ropa
    ) 
    REFERENCES Tipo_ropa 
    ( 
     id_ropa
    ) 
;

ALTER TABLE Sucursal 
    ADD CONSTRAINT Sucursal_Region_FK FOREIGN KEY 
    ( 
     Region_id_region
    ) 
    REFERENCES Region 
    ( 
     id_region
    ) 
;

ALTER TABLE Ventas 
    ADD CONSTRAINT Ventas_Cliente_FK FOREIGN KEY 
    ( 
     Cliente_rut
    ) 
    REFERENCES Cliente 
    ( 
     rut
    ) 
;

ALTER TABLE Ventas 
    ADD CONSTRAINT Ventas_Empleado_FK FOREIGN KEY 
    ( 
     Empleado_id_empleado
    ) 
    REFERENCES Empleado 
    ( 
     id_empleado
    ) 
;

CREATE SEQUENCE Sucursal_Sucursal_ID_SEQ 
START WITH 1 
    NOCACHE 
    ORDER ;

CREATE OR REPLACE TRIGGER Sucursal_Sucursal_ID_TRG 
BEFORE INSERT ON Sucursal 
FOR EACH ROW 
WHEN (NEW.Sucursal_ID IS NULL) 
BEGIN 
    :NEW.Sucursal_ID := Sucursal_Sucursal_ID_SEQ.NEXTVAL; 
END;
/



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             9
-- CREATE INDEX                             0
-- ALTER TABLE                             16
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           1
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          1
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
