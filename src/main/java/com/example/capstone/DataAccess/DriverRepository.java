package com.example.capstone.DataAccess;

import com.example.capstone.POJOS.Driver;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DriverRepository extends CrudRepository<Driver, Integer> {

    /**
     * Get all drivers for a user
     * @param userId the ID of the user
     * @return all drivers of the user
     */
    Iterable<Driver> getAllByUserId(Integer userId);

    /**
     * Get a driver by user ID
     * @param userId the ID of the user
     * @return the driver of the user
     */
    Optional<Driver> getDriverByUserId(Integer userId);
}
