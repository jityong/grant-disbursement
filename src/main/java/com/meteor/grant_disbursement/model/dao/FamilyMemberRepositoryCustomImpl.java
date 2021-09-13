package com.meteor.grant_disbursement.model.dao;

import com.meteor.grant_disbursement.model.FamilyMember;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Objects;

@Repository
public class FamilyMemberRepositoryCustomImpl implements FamilyMemberRepositoryCustom {
    @PersistenceContext
    EntityManager em;

    public List<FamilyMember> getEligibleStudentEncouragementBonus(String householdSize, String householdIncome) {
        String query = "SELECT family_member.id as id, * FROM household JOIN family_member ON (household.id = family_member.household_id)" +
                " JOIN household_info ON (household.id = household_info.id) WHERE age(family_member.date_of_birth) " +
                "< INTERVAL '16 years' AND household_info.total_income < 150000";

        String addConds = getAddConds(householdSize, householdIncome);
        query += addConds;
        return em.createNativeQuery(query, FamilyMember.class).getResultList();
    }

    public List<FamilyMember> getEligibleFamilyTogetherScheme(String householdSize, String householdIncome) {
        String query =
                "SELECT family_member1.id as id, *" +
                "FROM household JOIN family_member as family_member1 ON (household.id = family_member1.household_id)" +
                "WHERE family_member1.spouse_id IS NOT NULL " +
                "AND EXISTS ( " +
                    "SELECT 1 " +
                    "FROM family_member as family_member2 " +
                    "WHERE family_member2.household_id = household.id AND family_member2.id = family_member1.spouse_id  " +
                        "AND family_member2.spouse_id = family_member1.id " +
                ") " +
                "AND EXISTS ( " +
                    "SELECT 1 " +
                    "FROM family_member as family_member3 " +
                    "WHERE family_member3.household_id = household.id " +
                            "  AND age(family_member3.date_of_birth) < INTERVAL '16 years'" +
                ")";

        String addConds = getAddConds(householdSize, householdIncome);
        query += addConds;
        return em.createNativeQuery(query, FamilyMember.class).getResultList();
    }

    private String getAddConds(String householdSize, String householdIncome) {
        String addConds = "";
        if (Objects.nonNull(householdSize)) {
            addConds += " AND household_info.household_size = " + householdSize;
        }
        if (Objects.nonNull(householdIncome)) {
            addConds += " AND household_info.total_income = " + householdIncome;
        }
        return addConds;
    }

    public List<FamilyMember> getEligibleElderBonus(String householdSize, String householdIncome) {
        String query = "SELECT * FROM family_member WHERE age(family_member.date_of_birth) > INTERVAL '50 years'";

        String addConds = getAddConds(householdSize, householdIncome);
        query += addConds;
        return em.createNativeQuery(query, FamilyMember.class).getResultList();
    }

    public List<FamilyMember> getEligibleBabySunshineBonus(String householdSize, String householdIncome) {
        String query = "SELECT * FROM family_member WHERE age(family_member.date_of_birth) < INTERVAL '5 years'";

        String addConds = getAddConds(householdSize, householdIncome);
        query += addConds;
        return em.createNativeQuery(query, FamilyMember.class).getResultList();
    }

    public List<FamilyMember> getEligibleYoloGST(String householdSize, String householdIncome) {
        String query = "SELECT family_member.id as id, * " +
                "FROM family_member JOIN household_info ON (family_member.household_id = household_info.id) " +
                "WHERE household_info.total_income < 100000";

        String addConds = getAddConds(householdSize, householdIncome);
        query += addConds;
        return em.createNativeQuery(query, FamilyMember.class).getResultList();
    }
}

