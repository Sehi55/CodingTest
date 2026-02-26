-- 코드를 작성해주세요
select e.id from ecoli_data e join ecoli_data p on e.parent_id = p.id 
join ecoli_data gp on p.parent_id = gp.id where gp.parent_id is null
order by id asc;