SELECT 
 e.nombre,
 e.apellido,
 e.salario,
 d.nombre 
FROM empleado as e JOIN  departamento as d
ON e.departamento_id = d.id 