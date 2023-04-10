package com.example.capstone.DataAccess;

import com.example.capstone.POJOS.AutoPolicy;
import org.springframework.data.repository.CrudRepository;

public interface AutoPolicyRepository extends CrudRepository<AutoPolicy, Integer> {

    /**
     * Get all auto policies for a user
     * @param userId the ID of the user
     * @return all auto policies of the user
     */
    Iterable<AutoPolicy> getAllByUserId(Integer userId);
}
