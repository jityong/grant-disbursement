package com.meteor.grant_disbursement.service;

import com.meteor.grant_disbursement.model.FamilyMember;
import com.meteor.grant_disbursement.model.Household;
import com.meteor.grant_disbursement.model.dto.FamilyMemberDTO;
import com.meteor.grant_disbursement.model.dto.HouseholdDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HouseholdDTOTransformer {
    ModelMapper modelMapper;
    FamilyMemberDTOTransformer familyMemberDTOTransformer;
    @Autowired
    public HouseholdDTOTransformer(ModelMapper modelMapper, FamilyMemberDTOTransformer familyMemberDTOTransformer) {
        this.modelMapper = modelMapper;
        this.familyMemberDTOTransformer = familyMemberDTOTransformer;
    }

    public Household transformToEntity(HouseholdDTO householdDTO) {
        Household household = modelMapper.map(householdDTO, Household.class);
        return household;
    }

    public HouseholdDTO transformToDTO(Household household) {
        HouseholdDTO householdDTO = new HouseholdDTO();
        householdDTO.setId(household.getId());
        householdDTO.setType(household.getType());
        List<FamilyMemberDTO> familyMemberDTOList = new ArrayList<>();
        for (FamilyMember familyMember: household.getMembers()) {
            familyMemberDTOList.add(familyMemberDTOTransformer.transformToDTO(familyMember));
        }
        householdDTO.setMembers(familyMemberDTOList);
        return householdDTO;
    }
}
