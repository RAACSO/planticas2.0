-- DELETE CASCADE: elimina en cascada, es decir si eliminas una fila de la tabla independiente(externa) tambien se eliminaran 
--                 las filas de la tabla dependiente (interna) que la estaban usando
-- UPDATE CASCADE: actualiza en cascada, es decir si actualizas el PK de una fila de la tabla independiente(externa) tambien se 
--                 actualizará estas referencias en las filas de la tabla dependiente (interna) que las necesita para su definicion.
--
-- NOTA: 
-- 1.    es comun modificar todos los campos de la tabla independiente (externa) excepto el PK, mientras no modifiquemos la llave,
--       los cambios no afectaran en absoluto a las tablas dependiente (internas) por lo que en estos casos UPDATE CASCADE no seria 
--       no seria necesario.
-- 2.    estas restricciones se añaden en la tabla dependiente al definir la FK que hace referencia a la tabla independiente.

DROP DATABASE IF EXISTS ShoesForMen;
CREATE DATABASE  ShoesForMen;
USE ShoesForMen;


CREATE TABLE distrito(
cod_distrito    char(4),
descripcion     varchar(25) NOT NULL,
PRIMARY KEY (cod_distrito),
UNIQUE INDEX distrito_unicos (descripcion ASC)
);

CREATE TABLE estado(
cod_estado     char(1),
descripcion    varchar(25) NOT NULL,
PRIMARY KEY(cod_estado),
UNIQUE INDEX estado_unicos (descripcion ASC)
);

CREATE TABLE rol(
cod_rol         char(4),
nombre          varchar(20),
PRIMARY KEY (cod_rol),
UNIQUE INDEX nombre_unico (nombre ASC)
);

CREATE TABLE empleado(
cod_empleado    char(7),
cod_distrito    char(4),
cod_estado      char(1),
nombre          varchar(25) NOT NULL,-- CHECK (nombre != "") ,
apellidos       varchar(25) NOT NULL,
dni             char(8) NOT NULL,
direccion       varchar(45),
telefono        varchar(12),
email           varchar(45),
usuario         varchar(25) NOT NULL,
contrasena      varchar(100) NOT NULL,
PRIMARY KEY (cod_empleado),
UNIQUE INDEX empleado_unicos (dni ASC, email ASC, usuario ASC),
FOREIGN KEY (cod_distrito) references distrito(cod_distrito) ON DELETE CASCADE,
FOREIGN KEY (cod_estado) references estado(cod_estado) ON DELETE CASCADE
);

CREATE TABLE empleado_rol(
cod_rol         char(4),
cod_empleado    char(7),
PRIMARY KEY (cod_rol, cod_empleado),
FOREIGN KEY (cod_rol) references rol(cod_rol) ON DELETE CASCADE,
FOREIGN KEY (cod_empleado) references empleado(cod_empleado) ON DELETE CASCADE
);

