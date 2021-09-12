package com.meteor.grant_disbursement.controller;

import com.meteor.grant_disbursement.model.*;
import com.meteor.grant_disbursement.model.dto.FamilyMemberDTO;
import com.meteor.grant_disbursement.model.dto.GrantsResponse;
import com.meteor.grant_disbursement.model.dto.HouseholdDTO;
import com.meteor.grant_disbursement.service.FamilyMemberDTOTransformer;
import com.meteor.grant_disbursement.service.GrantsResponseTransformer;
import com.meteor.grant_disbursement.service.HouseholdDTOTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class GrantController {
    HouseholdDTOTransformer householdDTOTransformer;
    FamilyMemberDTOTransformer familyMemberDTOTransformer;
    HouseholdRepository householdRepository;
    FamilyMemberRepositoryCustomImpl familyMemberRepositoryCustomImpl;
    FamilyMemberRepository familyMemberRepository;
    GrantsResponseTransformer grantsResponseTransformer;

    @Autowired
    public GrantController(HouseholdDTOTransformer householdDTOTransformer, FamilyMemberDTOTransformer familyMemberDTOTransformer,
                           FamilyMemberRepository familyMemberRepository, HouseholdRepository householdRepository,
                           FamilyMemberRepositoryCustomImpl familyMemberRepositoryCustomImpl, GrantsResponseTransformer grantsResponseTransformer) {
        this.householdDTOTransformer = householdDTOTransformer;
        this.familyMemberDTOTransformer = familyMemberDTOTransformer;
        this.householdRepository = householdRepository;
        this.familyMemberRepository = familyMemberRepository;
        this.familyMemberRepositoryCustomImpl = familyMemberRepositoryCustomImpl;
        this.grantsResponseTransformer = grantsResponseTransformer;
    }

    @PostMapping("/createHousehold")
    public HouseholdDTO createHousehold(@RequestBody HouseholdDTO householdDTO) {
        Household household = householdDTOTransformer.transformToEntity(householdDTO);
        household = householdRepository.save(household);
        return householdDTOTransformer.transformToDTO(household);
    }

    @PostMapping("/addFamilyMember")
    public FamilyMemberDTO addFamilyMember(@RequestBody FamilyMemberDTO familyMemberDTO) {
        FamilyMember familyMember = familyMemberDTOTransformer.transformToEntity(familyMemberDTO);
        familyMember = familyMemberRepository.save(familyMember);
        return familyMemberDTOTransformer.transformToDTO(familyMember);
    }

    @GetMapping("/getFamilyMember")
    public FamilyMemberDTO getFamilyMember(@RequestParam Long id) {
        Optional<FamilyMember> familyMember = familyMemberRepository.findById(id);
        return familyMemberDTOTransformer.transformToDTO(familyMember.get());
    }

    @GetMapping("/getAllHouseholds")
    public List<HouseholdDTO> getAllHousehold() {
        Iterable<Household> households = householdRepository.findAll();
        List<HouseholdDTO> result = new ArrayList<>();
        for (Household household : households) {
            result.add(householdDTOTransformer.transformToDTO(household));
        }
        return result;
    }

    @GetMapping("/getHousehold")
    public HouseholdDTO getHousehold(@RequestParam Long householdId) {
        Optional<Household> household = householdRepository.findById(householdId);
        if (!household.isPresent()) {
            // throw error
            return null;
        } else {
            HouseholdDTO householdDTO = householdDTOTransformer.transformToDTO(household.get());
            return householdDTO;
        }
    }

    @GetMapping("/getGrant")
    public GrantsResponse getGrant(@RequestParam (required = false) String householdSize,
                                       @RequestParam (required = false) String householdIncome) {
        GrantsResponse grantsResponse = new GrantsResponse();
        List<FamilyMember> familyMembers = familyMemberRepositoryCustomImpl.getEligibleFamilyTogetherScheme(householdSize, householdIncome);
        grantsResponse.setFamilyTogethernessScheme(grantsResponseTransformer.createHouseholdDTOs(familyMembers));

        familyMembers = familyMemberRepositoryCustomImpl.getEligibleStudentEncouragementBonus(householdSize, householdIncome);
        grantsResponse.setStudentEncouragementBonus(grantsResponseTransformer.createHouseholdDTOs(familyMembers));

        familyMembers = familyMemberRepositoryCustomImpl.getEligibleElderBonus(householdSize, householdIncome);
        grantsResponse.setElderBonus(grantsResponseTransformer.createHouseholdDTOs(familyMembers));

        familyMembers = familyMemberRepositoryCustomImpl.getEligibleBabySunshineBonus(householdSize, householdIncome);
        grantsResponse.setBabySunshineGrant(grantsResponseTransformer.createHouseholdDTOs(familyMembers));

        familyMembers = familyMemberRepositoryCustomImpl.getEligibleYoloGST(householdSize, householdIncome);
        grantsResponse.setYoloGSTGrant(grantsResponseTransformer.createHouseholdDTOs(familyMembers));

        return grantsResponse;
    }
}
