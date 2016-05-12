

create table denuncia_bienes_hurtados
(
id_denuncia_bienes_hurtados serial primary key,
id_denuncia integer references denuncia (id_denuncia),
id_clase_bien integer references parametro (id_parametro),
id_tipo_bien integer references parametro (id_parametro),
asegurado bool ,
zona varchar(20),
marca varchar(20),
linea varchar(20),
elemento_estatal bool,
id_institucion integer references parametro (id_parametro),
cantidad integer,
valor_actual numeric,
valor_comercial numeric,
id_destino integer references parametro (id_parametro),
id_autoridad integer references parametro (id_parametro),
id_ciudad_autoridad integer references parametro (id_parametro),
delito_involucrado varchar(50),
id_tipo_novedad integer references parametro (id_parametro)
);
