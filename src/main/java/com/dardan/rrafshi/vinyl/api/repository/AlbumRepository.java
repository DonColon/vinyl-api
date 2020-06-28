package com.dardan.rrafshi.vinyl.api.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dardan.rrafshi.vinyl.api.model.Album;


@Repository
public interface AlbumRepository extends JpaRepository<Album, Long>
{
	@Query("select a from Album a left join a.collaboration c where c.name like ?1")
	List<Album> findByArtist(String artistID, Pageable pagination);

	List<Album> findByTitleContaining(String title, Pageable pagination);

	List<Album> findByYear(String year, Pageable pagination);
}
