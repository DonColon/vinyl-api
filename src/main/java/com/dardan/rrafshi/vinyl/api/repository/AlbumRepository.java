package com.dardan.rrafshi.vinyl.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dardan.rrafshi.vinyl.api.model.Album;


@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer>
{
	List<Album> findByName(String albumName);
}
