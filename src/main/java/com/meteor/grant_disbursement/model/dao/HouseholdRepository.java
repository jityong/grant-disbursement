package com.meteor.grant_disbursement.model.dao;

import com.meteor.grant_disbursement.model.Household;
import org.springframework.data.repository.CrudRepository;


public interface HouseholdRepository extends CrudRepository<Household, Long> {
}
