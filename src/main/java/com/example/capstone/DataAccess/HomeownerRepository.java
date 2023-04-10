package com.example.capstone.DataAccess;

import com.example.capstone.POJOS.HomeOwner;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface HomeownerRepository extends CrudRepository<HomeOwner, Integer> {

    /**
     * Get all homeowners for a user
     * @param userId the ID of the user
     * @return all drivers of the user
     */
    Iterable<HomeOwner> getAllByUserId(Integer userId);

    /**
     * Get a homeowner by user ID
     * @param userId the ID of the user
     * @return the homeowner of the user
     */
    Optional<HomeOwner> getHomeOwnerByUserId(Integer userId);
}