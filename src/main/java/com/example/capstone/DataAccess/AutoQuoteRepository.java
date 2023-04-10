package com.example.capstone.DataAccess;

import com.example.capstone.POJOS.AutoQuote;
import org.springframework.data.repository.CrudRepository;

public interface AutoQuoteRepository extends CrudRepository<AutoQuote, Integer> {

        /**
        * Get all auto quotes for a user
        * @param userId the ID of the user
        * @return all auto quotes of the user
        */
        Iterable<AutoQuote> getAllByUserId(Integer userId);
}
