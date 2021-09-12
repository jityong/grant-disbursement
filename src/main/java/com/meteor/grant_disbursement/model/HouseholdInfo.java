package com.meteor.grant_disbursement.model;

import jdk.nashorn.internal.ir.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name="household_info")
public class HouseholdInfo {
    @Id
    private Long id;
    @Column(name="total_income")
    private int totalIncome;
    @Column(name="household_size")
    private int householdSize;

    public HouseholdInfo() {
    }

    public Long getId() {
        return id;
    }

    public int getTotalIncome() {
        return totalIncome;
    }

    public int getHouseholdSize() {
        return householdSize;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTotalIncome(int totalIncome) {
        this.totalIncome = totalIncome;
    }

    public void setHouseholdSize(int householdSize) {
        this.householdSize = householdSize;
    }
}
