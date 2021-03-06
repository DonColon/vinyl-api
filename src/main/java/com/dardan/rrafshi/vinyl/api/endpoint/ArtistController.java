package com.dardan.rrafshi.vinyl.api.endpoint;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dardan.rrafshi.commons.Strings;
import com.dardan.rrafshi.vinyl.api.VinylException;
import com.dardan.rrafshi.vinyl.api.endpoint.parameter.Paging;
import com.dardan.rrafshi.vinyl.api.repository.ArtistRepository;
import com.dardan.rrafshi.vinyl.api.repository.model.Artist;


@RestController
public final class ArtistController
{
	@Autowired
	private ArtistRepository artistRepository;



	@GetMapping("/artists/{artistID}")
	public Artist retrieveArtist(@PathVariable final String artistID)
	{
		final Optional<Artist> entity = this.artistRepository.findById(artistID);

		if(!entity.isPresent())
			throw new VinylException.NotFound("The artist with the ID '" + artistID + "' does not exist");

		return entity.get();
	}

	@GetMapping("/artists")
	public List<Artist> listArtists(final Paging paging)
	{
		final Pageable pageRequest = paging.toPageRequest();
		final Page<Artist> artists = this.artistRepository.findAll(pageRequest);

		return artists.getContent();
	}

	@PostMapping("/search/artists")
	public List<Artist> searchAlbum(@RequestBody final Map<String,String> body, final Paging paging)
	{
		if(!body.containsKey("searchText"))
			throw new VinylException.BadRequest("The json content does not contain a field 'searchText'");

		final String searchText = body.get("searchText");

		if(Strings.isBlank(searchText))
			throw new VinylException.BadRequest("The field 'searchText' should not be blank");

		final Pageable pageRequest = paging.toPageRequest();
		return this.artistRepository.findByNameContaining(searchText, pageRequest);
	}
}
