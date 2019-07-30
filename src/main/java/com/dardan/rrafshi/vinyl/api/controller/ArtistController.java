package com.dardan.rrafshi.vinyl.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dardan.rrafshi.vinyl.api.model.Artist;
import com.dardan.rrafshi.vinyl.api.repository.ArtistRepository;


@RestController
public final class ArtistController
{
	@Autowired
	private ArtistRepository repository;


	@PostMapping("/artist")
	public Artist create(@RequestBody final Map<String, String> body)
	{
		final String name = body.get("name");
		return this.repository.save(new Artist(name));
	}

	@GetMapping("/artist/{artistID}")
	public Artist retrieve(@PathVariable final String artistID)
	{
		final int id = Integer.parseInt(artistID);
		return this.repository.findById(id).get();
	}

	@PutMapping("/artist/{artistID}")
	public Artist update(@PathVariable final String artistID, @RequestBody final Map<String, String> body)
	{
		final int id = Integer.parseInt(artistID);

		final Artist artist = this.repository.findById(id).get();
		artist.setName(body.get("name"));

		return this.repository.save(artist);
	}

	@DeleteMapping("/artist/{artistID}")
	public void delete(@PathVariable final String artistID)
	{
		final int id = Integer.parseInt(artistID);
		this.repository.deleteById(id);
	}

	@GetMapping("/artist")
	public List<Artist> list()
	{
		return this.repository.findAll();
	}
}
