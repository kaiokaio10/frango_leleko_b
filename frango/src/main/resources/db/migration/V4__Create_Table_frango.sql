CREATE TABLE IF NOT EXISTS `frango_vendido` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `quantidade` double,
  `valor` double,
  `vendidos` double,
  `nao_vendidos` double,
  `data` varchar(80),
  PRIMARY KEY (`id`)
);