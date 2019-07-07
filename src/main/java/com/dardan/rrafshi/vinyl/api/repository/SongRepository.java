package com.dardan.rrafshi.vinyl.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dardan.rrafshi.vinyl.api.model.Song;


@Repository
public interface SongRepository extends JpaRepository<Song, Integer>
{
	List<Song> findByTitle(String title);

	List<Song> findByArtist(int artistID);

	List<Song> findByAlbum(int albumID);

	List<Song> findByGenre(int genreID);

	List<Song> findByYear(String year);
}
