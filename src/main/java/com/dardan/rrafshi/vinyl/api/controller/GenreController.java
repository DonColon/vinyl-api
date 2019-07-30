package com.dardan.rrafshi.vinyl.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dardan.rrafshi.vinyl.api.model.Genre;
import com.dardan.rrafshi.vinyl.api.repository.GenreRepository;


@RestController
public final class GenreController
{
	@Autowired
	private GenreRepository repository;


	@PostMapping("/genre")
	public Genre create(@RequestBody final Map<String, String> body)
	{
		final String description = body.get("description");
		return this.repository.save(new Genre(description));
	}

	@GetMapping("/genre/{genreID}")
	public Genre retrieve(@PathVariable final String genreID)
	{
		final int id = Integer.parseInt(genreID);
		return this.repository.findById(id).get();
	}

	@PutMapping("/genre/{genreID}")
	public Genre update(@PathVariable final String genreID, @RequestBody final Map<String, String> body)
	{
		final int id = Integer.parseInt(genreID);

		final Genre genre = this.repository.findById(id).get();
		genre.setDescription(body.get("description"));

		return this.repository.save(genre);
	}

	@DeleteMapping("/genre/{genreID}")
	public void delete(@PathVariable final String genreID)
	{
		final int id = Integer.parseInt(genreID);
		this.repository.deleteById(id);
	}

	@GetMapping("/genre")
	public List<Genre> list(@RequestParam final int page, @RequestParam final int pageSize, @RequestParam final String sortBy)
	{
		final Sort sortCriteria = new Sort(Sort.DEFAULT_DIRECTION, sortBy);
		final Pageable pageRequest = PageRequest.of(page, pageSize, sortCriteria);
		return this.repository.findAll(pageRequest).getContent();
	}
}
