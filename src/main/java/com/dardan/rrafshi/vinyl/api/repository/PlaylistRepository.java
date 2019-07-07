package com.dardan.rrafshi.vinyl.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dardan.rrafshi.vinyl.api.model.Playlist;


@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Integer>
{
	List<Playlist> findByVisibility(String visibility);

	List<Playlist> findByName(String playlistName);

	List<Playlist> findByOwner(int ownerID);

	List<Playlist> findBySubscriber(int subcriberID);
}
