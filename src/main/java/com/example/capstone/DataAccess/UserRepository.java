package com.example.capstone.DataAccess;

import com.example.capstone.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
