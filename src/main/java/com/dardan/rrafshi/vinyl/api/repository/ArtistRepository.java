package com.dardan.rrafshi.vinyl.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dardan.rrafshi.vinyl.api.model.Artist;


@Repository
public interface ArtistRepository extends JpaRepository<Artist, String>
{
	List<Artist> findByNameContaining(String name);
}
