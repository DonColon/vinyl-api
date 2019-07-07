package com.dardan.rrafshi.vinyl.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dardan.rrafshi.vinyl.api.model.Genre;


@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer>
{
	Genre findByDescription(String description);
}
