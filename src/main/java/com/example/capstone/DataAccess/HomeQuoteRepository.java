package com.example.capstone.DataAccess;

import com.example.capstone.POJOS.HomeQuote;
import org.springframework.data.repository.CrudRepository;

public interface HomeQuoteRepository extends CrudRepository<HomeQuote, Integer>{
    /**
     * Get all home quotes for a user
     * @param userId the ID of the user
     * @return all home quotes of the user
     */
    Iterable<HomeQuote> getAllByUserId(Integer userId);
}
