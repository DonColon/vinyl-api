package com.dardan.rrafshi.vinyl.api.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dardan.rrafshi.vinyl.api.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
	List<User> findByUsernameContaining(String username, Pageable pagination);

	List<User> findByEmailContaining(String email, Pageable pagination);

	User findByUsername(String username);

	User findByEmail(String email);
}
