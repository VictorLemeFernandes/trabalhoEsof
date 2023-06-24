create table requisitos(
    id bigint not null auto_increment,
    idResponsavel bigint not null,
    titulo varchar(50) not null,
    conteudo varchar(1000) not null,
    emailFuncionario varchar(30) not null,
    comentario varchar(500),
    status varchar(25) not null,
    primary key(id)
);