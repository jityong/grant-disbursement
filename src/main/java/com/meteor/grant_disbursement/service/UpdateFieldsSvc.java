package com.meteor.grant_disbursement.service;

import com.meteor.grant_disbursement.model.FamilyMember;
import com.meteor.grant_disbursement.model.dao.FamilyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.Objects;
import java.util.Optional;

@Service
public class UpdateFieldsSvc {
    FamilyMemberRepository familyMemberRepository;

    @Autowired
    public UpdateFieldsSvc(FamilyMemberRepository familyMemberRepository) {
        this.familyMemberRepository = familyMemberRepository;
    }

    public void updateFamilyMemberFields(FamilyMember familyMember, String name,
                                         String gender, Long spouseId, String occupationType, Integer annualIncome, Date dateOfBirth) {
        if (Objects.nonNull(name)) {
            familyMember.setName(name);
        }
        if (Objects.nonNull(gender)) {
            familyMember.setGender(gender);
        }
        if (Objects.nonNull(spouseId)) {
            Optional<FamilyMember> opSpouse = familyMemberRepository.findById(spouseId);
            if (!opSpouse.isPresent()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Spouse ID.");
            }
            familyMember.setSpouse(opSpouse.get());
        }
        if (Objects.nonNull(occupationType)) {
            familyMember.setOccupationType(occupationType);
        }
        if (Objects.nonNull(annualIncome)) {
            familyMember.setAnnualIncome(annualIncome);
        }
        if (Objects.nonNull(dateOfBirth)) {
            familyMember.setDateOfBirth(dateOfBirth);
        }
        familyMemberRepository.save(familyMember);
    }
}
