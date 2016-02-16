SELECT 
 e.nombre,
 e.apellido,
 e.salario,
 d.nombre 
FROM empleado as e , departamento as d
WHERE e.departamento_id = d.id 