package com.meteor.grant_disbursement.service;

import com.meteor.grant_disbursement.error.InvalidFamilyMemberException;
import com.meteor.grant_disbursement.error.InvalidHouseholdException;
import com.meteor.grant_disbursement.model.FamilyMember;
import com.meteor.grant_disbursement.model.dao.FamilyMemberRepository;
import com.meteor.grant_disbursement.model.Household;
import com.meteor.grant_disbursement.model.dao.HouseholdRepository;
import com.meteor.grant_disbursement.model.dto.FamilyMemberDTO;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class FamilyMemberDTOTransformer {
    HouseholdRepository householdRepository;
    FamilyMemberRepository familyMemberRepository;

    public FamilyMemberDTOTransformer(HouseholdRepository householdRepository,
                                      FamilyMemberRepository familyMemberRepository) {
        this.householdRepository = householdRepository;
        this.familyMemberRepository = familyMemberRepository;
    }

    public FamilyMember transformToEntity(FamilyMemberDTO familyMemberDTO) {
        // get required values
        Long householdId = familyMemberDTO.getHouseholdId();
        Long spouseId = familyMemberDTO.getSpouseId();
        Optional<Household> household = Optional.empty();
        if (!Objects.isNull(householdId)) {
            household = householdRepository.findById(householdId);
            if (!household.isPresent()) {
                throw new InvalidHouseholdException("Invalid Household ID.");
            }
        }
        else {
            throw new InvalidHouseholdException("Household ID cannot be empty");
        }
        FamilyMember spouse = null;
        if (!Objects.isNull(spouseId)) {
            Optional<FamilyMember> opSpouse = familyMemberRepository.findById(spouseId);
            if (!opSpouse.isPresent()) {
                throw new InvalidFamilyMemberException("Invalid Spouse ID.");
            } else {
                spouse = opSpouse.get();
            }
        }
        return createFamilyMember(familyMemberDTO, household.get(), spouse);
    }

    public FamilyMemberDTO transformToDTO(FamilyMember familyMember) {
        FamilyMemberDTO familyMemberDTO = new FamilyMemberDTO();
        familyMemberDTO.setId(familyMember.getId());
        familyMemberDTO.setName(familyMember.getName());
        familyMemberDTO.setGender(familyMember.getGender());
        familyMemberDTO.setMaritalStatus(familyMember.getMaritalStatus());
        familyMemberDTO.setSpouseId(getSpouseId(familyMember));
        familyMemberDTO.setOccupationType(familyMember.getOccupationType());
        familyMemberDTO.setAnnualIncome(familyMember.getAnnualIncome());
        familyMemberDTO.setDateOfBirth(familyMember.getDateOfBirth());
        familyMemberDTO.setHouseholdId(familyMember.getHousehold().getId());

        return familyMemberDTO;
    }

    private FamilyMember createFamilyMember(FamilyMemberDTO familyMemberDTO, Household household, FamilyMember spouse) {
        FamilyMember familyMember = new FamilyMember();
        familyMember.setName(familyMemberDTO.getName());
        familyMember.setGender(familyMemberDTO.getGender());
        familyMember.setMaritalStatus(familyMemberDTO.getMaritalStatus());
        familyMember.setSpouse(spouse);
        familyMember.setOccupationType(familyMemberDTO.getOccupationType());
        familyMember.setAnnualIncome(familyMemberDTO.getAnnualIncome());
        familyMember.setDateOfBirth(familyMemberDTO.getDateOfBirth());
        familyMember.setHousehold(household);

        return familyMember;
    }

    private Long getSpouseId(FamilyMember familyMember) {
        if (Objects.nonNull(familyMember.getSpouse())) {
            return familyMember.getSpouse().getId();
        }
        return null;
    }
}
