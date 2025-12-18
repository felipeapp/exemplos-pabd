drop database if exists controle_acesso;
create database controle_acesso;

use controle_acesso;

create table usuario (
	id int primary key not null auto_increment,
    nome varchar(200) not null,
    endereco varchar(500) not null,
    cadastra datetime not null default now(),
    index(nome)
);

create table sala (
	id int primary key not null auto_increment,
    numero int unique not null,
    nome varchar(200) unique not null,
    cadastra datetime not null default now()
);

create table permissao (
	id_usuario int not null,
    id_sala int not null,
    horario datetime not null,
    primary key(id_usuario, id_sala),
    foreign key(id_usuario) references usuario(id) on delete restrict on update cascade,
	foreign key(id_sala) references sala(id) on delete restrict on update cascade
);
