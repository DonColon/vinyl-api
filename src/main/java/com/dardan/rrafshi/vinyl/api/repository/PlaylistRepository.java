package com.dardan.rrafshi.vinyl.api.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dardan.rrafshi.vinyl.api.model.Playlist;


@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long>
{
	@Query("select p from Playlist p where p.owner.userID = ?1")
	List<Playlist> findByOwner(long userID, Pageable pagination);

	@Query("select p from Playlist p left join p.subscribers s where s.userID = ?1")
	List<Playlist> findBySubscriber(long userID, Pageable pagination);

	@Query("select p from Playlist p where p.isPublic = 1")
	List<Playlist> findByPublic(Pageable pagination);

	List<Playlist> findByTitleContaining(String title, Pageable pagination);
}
