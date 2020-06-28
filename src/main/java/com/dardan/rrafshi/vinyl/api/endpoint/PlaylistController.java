package com.dardan.rrafshi.vinyl.api.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dardan.rrafshi.vinyl.api.model.Playlist;
import com.dardan.rrafshi.vinyl.api.repository.PlaylistRepository;


@RestController
public final class PlaylistController
{
	@Autowired
	private PlaylistRepository repository;

	@GetMapping("/playlists")
	public List<Playlist> retrieveAll()
	{
		return this.repository.findAll();
	}
}
