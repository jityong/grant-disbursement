package com.meteor.grant_disbursement.model.dto;

import java.util.ArrayList;
import java.util.List;

public class HouseholdDTO {
    private Long id;
    private String type;

    private List members = new ArrayList<FamilyMemberDTO>();

    public HouseholdDTO() {
    }

    public HouseholdDTO(Long id, String type, List members) {
        this.id = id;
        this.type = type;
        this.members = members;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMembers(List members) {
        this.members = members;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public List getMembers() {
        return members;
    }
}
