CREATE TABLE `carga-acoes`.`acao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `data` DATE NULL,
  `valor_fechamento` DOUBLE NULL,
  `valor_abertura` DOUBLE NULL,
  `valor_retorno` DOUBLE NULL,
  `volume` DOUBLE NULL,
  PRIMARY KEY (`id`));