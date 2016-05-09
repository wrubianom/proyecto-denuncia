
alter table persona add column id_tipo_documento integer;

ALTER TABLE persona ADD CONSTRAINT id_tipo_documentofk FOREIGN KEY (id_tipo_documento) REFERENCES parametro (id_parametro) MATCH FULL;

insert into parametro (id_parametro,codigo_parametro,tipo_parametro,nombre_parametro)
values
(nextval('parametro_id_parametro_seq'),'CC','RelacionAgresor','Hermano');

insert into parametro (id_parametro,codigo_parametro,tipo_parametro,nombre_parametro)
values
(nextval('parametro_id_parametro_seq'),'CC','RelacionAgresor','Hijo');

insert into parametro (id_parametro,codigo_parametro,tipo_parametro,nombre_parametro)
values
(nextval('parametro_id_parametro_seq'),'CC','RelacionAgresor','Padre');


insert into parametro (id_parametro,codigo_parametro,tipo_parametro,nombre_parametro)
values
(nextval('parametro_id_parametro_seq'),'CC','EstadoCivil','Casado');

insert into parametro (id_parametro,codigo_parametro,tipo_parametro,nombre_parametro)
values
(nextval('parametro_id_parametro_seq'),'CC','EstadoCivil','Soltero');


insert into parametro (id_parametro,codigo_parametro,tipo_parametro,nombre_parametro)
values
(nextval('parametro_id_parametro_seq'),'CC','NivelAcademico','Bachiller');

insert into parametro (id_parametro,codigo_parametro,tipo_parametro,nombre_parametro)
values
(nextval('parametro_id_parametro_seq'),'CC','NivelAcademico','Pregrado');

insert into parametro (id_parametro,codigo_parametro,tipo_parametro,nombre_parametro)
values
(nextval('parametro_id_parametro_seq'),'CC','NivelAcademico','PosGrado');

insert into parametro (id_parametro,codigo_parametro,tipo_parametro,nombre_parametro)
values
(nextval('parametro_id_parametro_seq'),'CC','NivelAcademico','Primaria');


insert into parametro (id_parametro,codigo_parametro,tipo_parametro,nombre_parametro)
values
(nextval('parametro_id_parametro_seq'),'CC','ClaseEmpleado','Policia');



insert into parametro (id_parametro,codigo_parametro,tipo_parametro,nombre_parametro)
values
(nextval('parametro_id_parametro_seq'),'CC','Profesion','Investigador');
