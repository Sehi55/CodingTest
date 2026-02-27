-- 코드를 작성해주세요
select e.id, e.genotype, p.genotype as parent_genotype from ECOLI_DATA e join ECOLI_DATA  p on e.parent_id = p.id
where e.genotype &  p.genotype = p.genotype
order by e.id