package com.example.capstone.DataAccess;

import com.example.capstone.POJOS.HomePolicy;
import org.springframework.data.repository.CrudRepository;

public interface HomePolicyRepository extends CrudRepository<HomePolicy, Integer> {

    /**
     * Get all home policies for a user
     * @param userId the ID of the user
     * @return all home policies of the user
     */
    Iterable<HomePolicy> getAllByUserId(Integer userId);
}
