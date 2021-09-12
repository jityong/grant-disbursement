package com.meteor.grant_disbursement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="household")
public class Household {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String type;

    @OneToMany(mappedBy = "household", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<FamilyMember> members = new ArrayList<>();

    public Household() {
    }

    public Household(java.lang.Long id, String type, List members) {
        this.id = id;
        this.type = type;
        this.members = members;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMembers(List members) {
        this.members = members;
    }

    public java.lang.Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public List<FamilyMember> getMembers() {
        return members;
    }

}
