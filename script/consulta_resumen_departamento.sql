-- ------------------------------------------
-- Resumen salarios por departamento
-- muestra numero empleados, maximo, minimo y media
-- ------------------------------------------
SELECT 
	d.nombre as 'departamento',
	COUNT( e.id ) as 'personas',
	MAX(e.salario) as 'maximo',
	MIN(e.salario) as 'minimo',
	ROUND( avg(e.salario), 2 ) as 'media'
FROM 
	`empleado` as e RIGHT JOIN `departamento` as d 
	ON e.departamento_id = d.id
	
GROUP BY  d.id
	
	
