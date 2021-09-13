package com.meteor.grant_disbursement.service;

import com.meteor.grant_disbursement.model.FamilyMember;
import com.meteor.grant_disbursement.model.Household;
import com.meteor.grant_disbursement.model.dao.HouseholdRepository;
import com.meteor.grant_disbursement.model.dto.HouseholdDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Service
public class GrantsResponseTransformer {
    HouseholdRepository householdRepository;
    HouseholdDTOTransformer householdDTOTransformer;

    @Autowired
    public GrantsResponseTransformer(HouseholdRepository householdRepository, HouseholdDTOTransformer householdDTOTransformer) {
        this.householdRepository = householdRepository;
        this.householdDTOTransformer = householdDTOTransformer;
    }

    public List<HouseholdDTO> createHouseholdDTOs(List<FamilyMember> familyMembers) {
        HashMap<Long, HashSet<FamilyMember>> test = new HashMap<>();
        for (FamilyMember familyMember: familyMembers) {
            Long householdId = familyMember.getHousehold().getId();
            if (!test.containsKey(householdId)) {
                test.put(householdId, new HashSet<FamilyMember>(){{add(familyMember);}});
            } else {
                test.get(householdId).add(familyMember);
            }
        }
        List<HouseholdDTO> results = new ArrayList<>();
        for (Long householdId: test.keySet()) {
            Household household = householdRepository.findById(householdId).get();
            household.setMembers(new ArrayList(test.get(householdId)));
            HouseholdDTO householdDTO = householdDTOTransformer.transformToDTO(household);
            results.add(householdDTO);
        }
        return results;
    }
}
