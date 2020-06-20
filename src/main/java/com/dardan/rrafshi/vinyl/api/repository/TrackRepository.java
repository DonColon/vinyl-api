package com.dardan.rrafshi.vinyl.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dardan.rrafshi.vinyl.api.model.Track;


@Repository
public interface TrackRepository extends JpaRepository<Track, Long>
{
	@Query("select t from Track t left join t.albums a where a.album.albumID = ?1")
	List<Track> findByAlbum(long albumID);

	@Query("select t from Track t left join t.interpreters i where i.interpreterID.interpreter like ?1")
	List<Track> findByArtist(String name);

	@Query("select t from Track t left join t.genres g where g.description like ?1")
	List<Track> findByGenre(String description);

	@Query("select t from Track t left join t.favorites f where f.userID = ?1")
	List<Track> findByUser(long userID);

	List<Track> findByTitleContaining(String title);
}
