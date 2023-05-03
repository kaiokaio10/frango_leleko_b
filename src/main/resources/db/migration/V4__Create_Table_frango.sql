CREATE TABLE IF NOT EXISTS frango_vendido (
  id SERIAL,
  quantidade numeric,
  valor numeric,
  vendidos numeric,
  nao_vendidos numeric,
  data varchar(80),
  PRIMARY KEY (id)
);