package com.dardan.rrafshi.vinyl.api.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dardan.rrafshi.vinyl.api.repository.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
	List<User> findByUsernameContaining(String username, Pageable paging);

	List<User> findByEmailContaining(String email, Pageable paging);

	User findByUsername(String username);

	User findByEmail(String email);
}
