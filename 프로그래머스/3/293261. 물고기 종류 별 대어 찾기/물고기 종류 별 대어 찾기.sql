-- 코드를 작성해주세요
select  id, fish_name, length from fish_info f
join fish_name_info n on f.fish_type = n.fish_type
where(f.fish_type, length ) in 
(
    select f.fish_type, max(f.length) as length 
    from fish_info f
    where length is not null
    group by f.fish_type
) 
order by id;