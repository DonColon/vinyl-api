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
import com.dardan.rrafshi.vinyl.api.endpoint.parameter.Pagination;
import com.dardan.rrafshi.vinyl.api.model.Album;
import com.dardan.rrafshi.vinyl.api.model.Artist;
import com.dardan.rrafshi.vinyl.api.repository.AlbumRepository;
import com.dardan.rrafshi.vinyl.api.repository.ArtistRepository;


@RestController
public final class AlbumController
{
	@Autowired
	private AlbumRepository albumRepository;

	@Autowired
	private ArtistRepository artistRepository;


	@GetMapping("/albums")
	public List<Album> listAlbums(final Pagination pagination)
	{
		final Pageable pageRequest = pagination.toPageRequest();
		final Page<Album> albums = this.albumRepository.findAll(pageRequest);

		return albums.getContent();
	}

	@GetMapping("/albums/{albumID}")
	public Album retrieveAlbum(@PathVariable final long albumID)
	{
		final Optional<Album> entity = this.albumRepository.findById(albumID);

		if(!entity.isPresent())
			throw new VinylException.NotFound("The album with the ID '" + albumID + "' does not exist");

		return entity.get();
	}

	@GetMapping("/artists/{artistID}/albums}")
	public List<Album> retrieveByArtist(@PathVariable final String artistID, final Pagination pagination)
	{
		final Optional<Artist> entity = this.artistRepository.findById(artistID);

		if(!entity.isPresent())
			throw new VinylException.NotFound("The artist with the ID '" + artistID + "' does not exist");

		final Pageable pageRequest = pagination.toPageRequest();
		return this.albumRepository.findByArtist(artistID, pageRequest);
	}

	@PostMapping("/search/albums")
	public List<Album> searchAlbum(@RequestBody final Map<String,String> body, final Pagination pagination)
	{
		if(body.containsKey("searchText"))
			throw new VinylException.BadRequest("The json content does not contain a field 'searchText'");

		final String searchText = body.get("searchText");

		if(Strings.isBlank(searchText))
			throw new VinylException.BadRequest("The field 'searchText' should not be blank");

		final Pageable pageRequest = pagination.toPageRequest();
		return this.albumRepository.findByTitleContaining(searchText, pageRequest);
	}
}
