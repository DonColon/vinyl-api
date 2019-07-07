package com.dardan.rrafshi.vinyl.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dardan.rrafshi.vinyl.api.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
	User findByUsername(String username);

	User findByEmail(String email);
}
