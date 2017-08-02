CREATE SEQUENCE usuario_seq;
CREATE SEQUENCE carona_seq;
CREATE SEQUENCE pontos_seq;

CREATE TABLE usuario
(
  idUsuario integer NOT NULL DEFAULT nextval('usuario_seq'::regclass),
  nome character varying(50) NOT NULL,
  email character varying(30) NOT NULL,
  dataDeNascimento Date NOT NULL,
  sexo varchar (10) NOT NULL,
  senha varchar (20) NOT NULL,
  telefone varchar (20) NOT NULL,
  PRIMARY KEY (idUsuario)
);

CREATE TABLE carona
(
  idCarona integer NOT NULL DEFAULT nextval('carona_seq'::regclass),
  idUsuario integer NOT NULL,
  origem geommetry NOT NULL,
  destino  geommetry NOT NULL,
  horasaida character varying(10) NOT NULL,
  data Date NOT NULL,
  ajudadecusto integer (10) NOT NULL,
  PRIMARY KEY (idCarona)
  FOREIGN KEY (idUsuario) REFERENCES usuario (idUsuario)
);

CREATE TABLE pontos_adicinais
(
  idPontos integer NOT NULL DEFAULT nextval('pontos_seq'::regclass),
  idCarona integer NOT NULL,
  ponto geommetry NOT NULL,
  PRIMARY KEY (idPontos)
  FOREIGN KEY (idCarona) REFERENCES carona (idCarona)
);

