package com.example.capstone.DataAccess;

import com.example.capstone.POJOS.Home;
import org.springframework.data.repository.CrudRepository;

public interface HomeRepository extends CrudRepository<Home, Integer> {

    /**
     * Get all homes for a user
     * @param userId the ID of the user
     * @return all homes of the user
     */
    Iterable<Home> getAllByUserId(Integer userId);

}
