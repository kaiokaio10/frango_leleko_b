CREATE TABLE IF NOT EXISTS `log_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(80) ,
  `quantidade` double,
  `valor` double,
  `medida` varchar(80) ,
  PRIMARY KEY (`id`)
);