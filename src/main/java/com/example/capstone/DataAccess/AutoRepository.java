package com.example.capstone.DataAccess;

import com.example.capstone.POJOS.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface AutoRepository extends CrudRepository<Vehicle, Integer> {

    /**
     * Get all vehicles for a user
     * @param userId the ID of the user
     * @return all vehicles of the user
     */
    Iterable<Vehicle> getAllByUserId(Integer userId);
}
