package com.meteor.grant_disbursement.model.dto;

import java.util.List;

public class GrantsResponse {
    private List<HouseholdDTO> studentEncouragementBonus;
    private List<HouseholdDTO> familyTogethernessScheme;
    private List<HouseholdDTO> elderBonus;
    private List<HouseholdDTO> babySunshineGrant;
    private List<HouseholdDTO> yoloGSTGrant;

    public List<HouseholdDTO> getStudentEncouragementBonus() {
        return studentEncouragementBonus;
    }

    public List<HouseholdDTO> getFamilyTogethernessScheme() {
        return familyTogethernessScheme;
    }

    public List<HouseholdDTO> getElderBonus() {
        return elderBonus;
    }

    public List<HouseholdDTO> getBabySunshineGrant() {
        return babySunshineGrant;
    }

    public List<HouseholdDTO> getYoloGSTGrant() {
        return yoloGSTGrant;
    }

    public void setStudentEncouragementBonus(List<HouseholdDTO> studentEncouragementBonus) {
        this.studentEncouragementBonus = studentEncouragementBonus;
    }

    public void setFamilyTogethernessScheme(List<HouseholdDTO> familyTogethernessScheme) {
        this.familyTogethernessScheme = familyTogethernessScheme;
    }

    public void setElderBonus(List<HouseholdDTO> elderBonus) {
        this.elderBonus = elderBonus;
    }

    public void setBabySunshineGrant(List<HouseholdDTO> babySunshineGrant) {
        this.babySunshineGrant = babySunshineGrant;
    }

    public void setYoloGSTGrant(List<HouseholdDTO> yoloGSTGrant) {
        this.yoloGSTGrant = yoloGSTGrant;
    }
}
