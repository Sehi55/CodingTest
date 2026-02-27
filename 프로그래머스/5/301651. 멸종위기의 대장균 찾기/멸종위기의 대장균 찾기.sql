with recursive ecoli_generation as (
    SELECT e.id as id, 1 AS GENERATION from ecoli_data e 
    where e.parent_id is null
    
    union all
    
    select e.id, eg.generation+1 as generation from ecoli_data e
    join ecoli_generation eg on eg.id = e.parent_id
    )
select count(*) as count, eg.generation from ecoli_data e join ecoli_generation eg
on e.id = eg.id
where e.id not in (
    select distinct parent_id from ecoli_data
    where parent_id is not null
)
group by eg.generation
order by eg.generation