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

import com.dardan.rrafshi.vinyl.api.model.Album;
import com.dardan.rrafshi.vinyl.api.repository.AlbumRepository;


@RestController
public final class AlbumController
{
	@Autowired
	private AlbumRepository repository;


	@PostMapping("/album")
	public Album create(@RequestBody final Map<String, String> body)
	{
		final String name = body.get("name");
		return this.repository.save(new Album(name));
	}

	@GetMapping("/album/{albumID}")
	public Album retrieve(@PathVariable final String albumID)
	{
		final int id =  Integer.parseInt(albumID);
		return this.repository.findById(id).get();
	}

	@PutMapping("/album/{albumID}")
	public Album update(@PathVariable final String albumID, @RequestBody final Map<String, String> body)
	{
		final int id = Integer.parseInt(albumID);

		final Album album = this.repository.findById(id).get();
		album.setName(body.get("name"));

		return this.repository.save(album);
	}

	@DeleteMapping("/album/{albumID}")
	public void delete(@PathVariable final String albumID)
	{
		final int id = Integer.parseInt(albumID);
		this.repository.deleteById(id);
	}

	@GetMapping("/album")
	public List<Album> list()
	{
		return this.repository.findAll();
	}

	@PostMapping("/album/search")
	public List<Album> listByName(@RequestBody final Map<String, String> body)
	{
		return this.repository.findByName(body.get("searchText"));
	}
}
