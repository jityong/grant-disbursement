package com.meteor.grant_disbursement.model;

import java.util.List;

public interface FamilyMemberRepositoryCustom {
    List<FamilyMember> getEligibleStudentEncouragementBonus(String householdSize, String householdIncome);
}
