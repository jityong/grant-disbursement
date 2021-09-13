 CREATE VIEW household_info AS
 SELECT household.id,
    sum(family_member.annual_income) AS total_income,
    count(family_member.id) AS household_size
   FROM household
     JOIN family_member ON household.id = family_member.household_id
  GROUP BY household.id;