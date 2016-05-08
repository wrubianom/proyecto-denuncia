create table parametro
(
id_parametro serial primary key,
codigo_parametro varchar(20),
tipo_parametro varchar(20),
nombre_parametro varchar(230)
);
create table persona
(
id_persona serial primary key,
numero_documento varchar(20),
lugar_expedicion varchar(20),
primer_nombre varchar(20),
segundo_nombre varchar(20),
primer_apellido varchar(20),
segundo_apellido varchar(20),
sexo integer references parametro (id_parametro),
fecha_nacimiento date,
lugar_nacimiento integer references parametro (id_parametro),
corre_electronico varchar(50),
id_estado_civil integer references parametro (id_parametro),
id_nivel_academico integer references parametro (id_parametro),
id_clase_empleado integer references parametro (id_parametro),
id_profesion integer references parametro (id_parametro)
);
create table usuario
(
id_usuario serial primary key,
login varchar(50) not null,
clave varchar(50) not null,
tipo_identificacion integer references parametro (id_parametro),
numero_documento varchar(20),
lugar_expedicion varchar(20),
primer_nombre varchar(20),
segundo_nombre varchar(20),
primer_apellido varchar(20),
segundo_apellido varchar(20),
sexo integer references parametro (id_parametro),
fecha_nacimiento date,
lugar_nacimiento integer references parametro (id_parametro),
corre_electronico varchar(50)
);


create table denuncia
(
id_denuncia serial primary key,
id_usuario integer references usuario (id_usuario),
id_tipo_delito integer references parametro (id_parametro),
id_delito integer references parametro (id_parametro),
fecha_delito date,
otro_delito varchar (250),
unidad_investigativa integer references parametro (id_parametro),
modalidad integer references parametro (id_parametro),
arma_empleada integer references parametro (id_parametro),
movil_agreado integer references parametro (id_parametro),
movil_victima integer references parametro (id_parametro)
);

create table denuncia_persona
(
id_denuncia_persona serial primary key,
id_persona integer references persona(id_persona),
id_denuncia integer references denuncia(id_denuncia),
agresor_identificado boolean,
id_relaccion_agresor integer references parametro (id_parametro),
observaciones text
);

create table denuncia_delito
(
id_denuncia_delito serial primary key,
id_denuncia integer references denuncia (id_denuncia),
latitud numeric,
longitud numeric,
id_municipio integer references parametro (id_parametro),
id_barrio integer references parametro (id_parametro),
clase_sitio varchar(20),
zona varchar(20),
tipo_direccion varchar (20),
com1 varchar(20),
letra1 varchar(20),
tipo_direccion2 varchar(20),
com2 varchar(20),
letra2 varchar(20),
punto_cardenal varchar(20)
);

