package com.meteor.grant_disbursement.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

import java.sql.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="family_member")
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class FamilyMember {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private String gender;
    private String maritalStatus;
    @OneToOne
    @JoinColumn(name = "spouse_id")
    private FamilyMember spouse;
    private String occupationType;
    private int annualIncome;
    private Date dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "household_id")
    @JsonManagedReference
    private Household household;

    public java.lang.Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
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

    public void setSpouse(FamilyMember spouseId) {
        this.spouse = spouseId;
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

    public void setHousehold(Household household) {
        this.household = household;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public FamilyMember getSpouse() {
        return spouse;
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

    public Household getHousehold() {
        return household;
    }

    public FamilyMember() {
    }

    public FamilyMember(String name, String gender, String maritalStatus, FamilyMember spouse, String occupationType, int annualIncome, Date dateOfBirth, Household householdId) {
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.spouse = spouse;
        this.occupationType = occupationType;
        this.annualIncome = annualIncome;
        this.dateOfBirth = dateOfBirth;
        this.household = householdId;
    }

    public FamilyMember(java.lang.Long id, String name, String gender, String maritalStatus, FamilyMember spouse, String occupationType,
                        int annualIncome, Date dateOfBirth, Household householdId) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.spouse = spouse;
        this.occupationType = occupationType;
        this.annualIncome = annualIncome;
        this.dateOfBirth = dateOfBirth;
        this.household = householdId;
    }

}
