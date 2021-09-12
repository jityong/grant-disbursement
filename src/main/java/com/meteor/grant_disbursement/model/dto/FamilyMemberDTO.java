package com.meteor.grant_disbursement.model.dto;

import java.sql.Date;

public class FamilyMemberDTO {
    private Long id;
    private String name;
    private String gender;
    private String maritalStatus;
    private Long spouseId;
    private String occupationType;
    private int annualIncome;
    private Date dateOfBirth;
    private Long householdId;

    public FamilyMemberDTO() {
    }

    public void setHouseholdId(Long householdId) {
        this.householdId = householdId;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void setSpouseId(Long spouseId) {
        this.spouseId = spouseId;
    }

    public void setOccupationType(String occupationType) {
        this.occupationType = occupationType;
    }

    public void setAnnualIncome(int annualIncome) {
        this.annualIncome = annualIncome;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public Long getSpouseId() {
        return spouseId;
    }

    public String getOccupationType() {
        return occupationType;
    }

    public int getAnnualIncome() {
        return annualIncome;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Long getHouseholdId() {
        return householdId;
    }
}
