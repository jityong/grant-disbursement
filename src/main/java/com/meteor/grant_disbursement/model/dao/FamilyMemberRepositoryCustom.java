package com.meteor.grant_disbursement.model.dao;

import com.meteor.grant_disbursement.model.FamilyMember;

import java.util.List;

public interface FamilyMemberRepositoryCustom {
    List<FamilyMember> getEligibleStudentEncouragementBonus(String householdSize, String householdIncome);
}
