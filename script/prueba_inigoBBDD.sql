-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.17 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.3.0.5027
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para inigo
CREATE DATABASE IF NOT EXISTS `inigo` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `inigo`;


-- Volcando estructura para tabla inigo.libro
CREATE TABLE IF NOT EXISTS `libro` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id del libro',
  `nombre` varchar(200) COLLATE utf8_unicode_ci DEFAULT 'ANONIMO' COMMENT 'nombre del libro',
  `editorial` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'editorial del libro',
  `autor` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'autor del libro',
  `argumento` varchar(1000) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT 'argumento del libro',
  `paginas` varchar(6) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'paginas del libro',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='personas de la libreria';

-- Volcando datos para la tabla inigo.libro: ~5 rows (aproximadamente)
DELETE FROM `libro`;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
INSERT INTO `libro` (`id`, `nombre`, `editorial`, `autor`, `argumento`, `paginas`) VALUES
	(1, 'don quijote de la mancha', 'anaya', 'miguel de cervantes', 'Lorem Ipsum \r\n', '517'),
	(2, 'el principito', 'andina', 'Antoine de Saint-Exupery', 'Lorem Ipsum ', '120'),
	(3, 'historias de nueva orleans', 'alfaguara', 'william faulkner', 'Lorem Ipsum ', '186'),
	(4, 'diplomacia', 's.m', 'henry kissinger', 'Lorem Ipsum ', '825'),
	(5, 'el ultimo emperador', 'caralt', 'pu-yi', 'Lorem Ipsum ', '353');
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
