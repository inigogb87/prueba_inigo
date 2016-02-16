-- -----------------------------------------------------------
-- Actualizar bbdd v1.0.0 a v2.0.0
-- 
-- 1. Nueva tabla para ROL + inserts datos
-- 2. Alterar tabla PERSONA, nueva columna 'rol_id' y FK_ROL
-- 3. Nuevos procedimientos almacenados y mejorados
--    3.1 bla bla 
--    3.2 bla bla , vamos los que sean
--
-- ------------------------------------------------------------



-- 1. Nueva tabla para ROL + inserts datos

CREATE TABLE IF NOT EXISTS `rol` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL COMMENT 'nombre del rol',
  `descripcion` varchar(250) DEFAULT NULL COMMENT 'descripcion del campo',
  `codigo` varchar(2) NOT NULL COMMENT 'codigo interno aplicacion',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`),
  UNIQUE KEY `codigo` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf16 COMMENT='Tabla Auxiliar para gestion de Roles de usuarios';


/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` (`id`, `nombre`, `descripcion`, `codigo`) VALUES
	(1, 'Administrador', 'Usuario con todos los permisos', 'AD'),
	(3, 'Usuario', 'Usuario normal', 'US');
	

-- 2. Alterar tabla PERSONA, nueva columna 'rol_id' y FK_ROL

ALTER TABLE `persona`
	ADD COLUMN `rol_id` INT(10) UNSIGNED NOT NULL COMMENT 'clave externa de `rol`' AFTER `fecha_nacimiento`;

	-- actualizar valor en nueva columna
	UPDATE `persona` SET `rol_id`=3;	
	
	-- crear FK_ROL
	ALTER TABLE `persona`
	ADD CONSTRAINT `FK_ROL` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`);
	
	
-- 3. Nuevos procedimientos almacenados y mejorados

DROP PROCEDURE IF EXISTS `getPersonaAll`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `getPersonaAll`()
    COMMENT 'Retorna todas las personas junto con su Rol'
BEGIN

select 
	p.id as 'persona_id',
	p.pass,
	p.nombre,
	p.dni,	
	p.fecha_nacimiento,	
	p.email,
	p.observaciones,
	r.id as 'rol_id',
	r.nombre as 'rol_nombre',
	r.codigo as 'rol_codigo',
	r.descripcion as 'rol_descripcion'

from `persona` as p INNER JOIN  `rol` as r  ON p.rol_id = r.id

order by p.`id` desc 
limit 500;

-- otra sentencias ...

END//
DELIMITER ;


-- Volcando estructura para procedimiento iparsex.getPersonaByDni
DROP PROCEDURE IF EXISTS `getPersonaByDni`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `getPersonaByDni`(IN `pdni` CHAR(9))
    COMMENT 'Buscar una persona por su dni, debe coincidir de forma exacta'
BEGIN

SELECT 
	id,
	pass,
	nombre,
	dni,
	fecha_nacimiento,
	observaciones,
	email
FROM `persona`  
WHERE  
   dni = pdni;

END//
DELIMITER ;


-- Volcando estructura para procedimiento iparsex.getPersonaById
DROP PROCEDURE IF EXISTS `getPersonaById`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `getPersonaById`(IN `pid` INT)
    COMMENT 'Obtien abkaakakal'
BEGIN

select 
	p.id as 'persona_id',
	p.pass,
	p.nombre,
	p.dni,	
	p.fecha_nacimiento,	
	p.email,
	p.observaciones,
	r.id as 'rol_id',
	r.nombre as 'rol_nombre',
	r.codigo as 'rol_codigo',
	r.descripcion as 'rol_descripcion'

from `persona` as p INNER JOIN  `rol` as r  ON p.rol_id = r.id

where p.id = pid;

END//
DELIMITER ;	
	
	
	