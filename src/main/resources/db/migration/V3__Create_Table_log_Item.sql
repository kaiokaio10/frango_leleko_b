CREATE TABLE IF NOT EXISTS log_item (
  id SERIAL,
  nome varchar(80) ,
  quantidade numeric,
  valor numeric,
  medida varchar(80) ,
  PRIMARY KEY (id)
);