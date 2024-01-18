SELECT * FROM `springbootp3.1`.measurement_size;
SELECT ms.measurement_id,  m.code_name,m.tolerance, 
MAX(CASE when ms.size_id=1 then ms.measurement end) as L,
MAX(CASE when ms.size_id=2 then ms.measurement end) as M,
MAX(CASE when ms.size_id=4 then ms.measurement end) as XS
FROM `springbootp3.1`.measurement_size ms join `springbootp3.1`.measurement m on ms.measurement_id = m.id where ms.style_id=1 group by ms.measurement_id, m.code_name, m.tolerance ;

SELECT ms.measurement_id,  m.code_name,m.tolerance, 
MAX(CASE when ms.size_id=sz.size_id then ms.measurement end) as L,
MAX(CASE when ms.size_id=2 then ms.measurement end) as M,
MAX(CASE when ms.size_id=4 then ms.measurement end) as XS
FROM `springbootp3.1`.measurement m join `springbootp3.1`.measurement_size ms on m.id= ms.measurement_id join `springbootp3.1`.style_size sz on ms.size_id= sz.size_id  where ms.style_id=1 group by ms.measurement_id, m.code_name, m.tolerance ;