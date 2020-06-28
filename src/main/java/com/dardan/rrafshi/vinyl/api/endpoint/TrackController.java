package com.dardan.rrafshi.vinyl.api.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dardan.rrafshi.vinyl.api.model.Track;
import com.dardan.rrafshi.vinyl.api.repository.TrackRepository;


@RestController
public final class TrackController
{
	@Autowired
	private TrackRepository repository;

	@GetMapping("/tracks")
	public List<Track> retrieveAll()
	{
		return this.repository.findAll();
	}
}
