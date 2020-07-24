package com.dardan.rrafshi.vinyl.api.endpoint;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dardan.rrafshi.commons.Strings;
import com.dardan.rrafshi.vinyl.api.VinylException;
import com.dardan.rrafshi.vinyl.api.endpoint.parameter.Adding;
import com.dardan.rrafshi.vinyl.api.endpoint.parameter.Moving;
import com.dardan.rrafshi.vinyl.api.endpoint.parameter.Paging;
import com.dardan.rrafshi.vinyl.api.model.Playlist;
import com.dardan.rrafshi.vinyl.api.model.PlaylistItem;
import com.dardan.rrafshi.vinyl.api.model.Track;
import com.dardan.rrafshi.vinyl.api.model.User;
import com.dardan.rrafshi.vinyl.api.repository.PlaylistRepository;
import com.dardan.rrafshi.vinyl.api.repository.TrackRepository;
import com.dardan.rrafshi.vinyl.api.repository.UserRepository;


@RestController
public final class PlaylistController
{
	@Autowired
	private PlaylistRepository playlistRepository;

	@Autowired
	private TrackRepository trackRepository;

	@Autowired
	private UserRepository userRepository;


	@PostMapping("/users/{userID}/playlists")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Playlist createPlaylist(@PathVariable final long userID, @RequestBody final Playlist body)
	{
		final Optional<User> entity = this.userRepository.findById(userID);

		if(!entity.isPresent())
			throw new VinylException.NotFound("The user with the ID '" + userID + "' does not exist");

		body.setOwner(entity.get());

		return this.playlistRepository.save(body);
	}

	@GetMapping("/playlists/{playlistID}")
	public Playlist retrievePlaylist(@PathVariable final long playlistID)
	{
		final Optional<Playlist> entity = this.playlistRepository.findById(playlistID);

		if(!entity.isPresent())
			throw new VinylException.NotFound("The playlist with the ID '" + playlistID + "' does not exist");

		return entity.get();
	}

	@PutMapping("/playlists/{playlistID}")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Playlist updatePlaylist(@PathVariable final long playlistID, @RequestBody final Playlist body)
	{
		final Optional<Playlist> entity = this.playlistRepository.findById(playlistID);

		if(!entity.isPresent())
			throw new VinylException.NotFound("The playlist with the ID '" + playlistID + "' does not exist");

		final Playlist playlist = entity.get();
		playlist.set(body);

		return this.playlistRepository.save(playlist);
	}

	@DeleteMapping("/users/{userID}/playlists")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void deletePlaylists(@PathVariable final long userID, @RequestBody final List<Long> indices)
	{
		if(!this.userRepository.existsById(userID))
			throw new VinylException.NotFound("The user with the ID '" + userID + "' does not exist");

		final List<Playlist> playlists = this.playlistRepository.findAllById(indices);

		this.playlistRepository.deleteAll(playlists);
	}


	@PostMapping("/playlists/{playlistID}/tracks")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Playlist addTracks(@PathVariable final long playlistID, @RequestBody final Optional<Adding> body)
	{
		final Optional<Playlist> entity = this.playlistRepository.findById(playlistID);

		if(!entity.isPresent())
			throw new VinylException.NotFound("The playlist with the ID '" + playlistID + "' does not exist");

		if(!body.isPresent())
			throw new VinylException.BadRequest("Either define a request body or the query parameters. Both can't be null");

		final Playlist playlist = entity.get();
		final Adding adding = body.get();

		final List<Track> tracks = this.trackRepository.findAllById(adding.getIndices());
		playlist.addTracks(adding.getTo(), tracks);

		return this.playlistRepository.save(playlist);
	}

	@DeleteMapping("/playlists/{playlistID}/tracks")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void deleteTracks(@PathVariable final long playlistID, @RequestBody final List<Long> indices)
	{
		final Optional<Playlist> entity = this.playlistRepository.findById(playlistID);

		if(!entity.isPresent())
			throw new VinylException.NotFound("The playlist with the ID '" + playlistID + "' does not exist");

		final Playlist playlist = entity.get();

		final List<Track> tracks = this.trackRepository.findAllById(indices);
		playlist.removeTracks(tracks);

		this.playlistRepository.save(playlist);
	}

	@PutMapping("/playlists/{playlistID}/tracks")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Playlist reorderTracks(@PathVariable final long playlistID, @RequestBody final Optional<Moving> body)
	{
		final Optional<Playlist> entity = this.playlistRepository.findById(playlistID);

		if(!entity.isPresent())
			throw new VinylException.NotFound("The playlist with the ID '" + playlistID + "' does not exist");

		if(!body.isPresent())
			throw new VinylException.BadRequest("Either define a request body or the query parameters. Both can't be null");

		final Playlist playlist = entity.get();
		final PlaylistItem lastTrack = playlist.getLastTrack();
		final Moving moving = body.get();

		if(moving.getFrom() <= 0 && moving.getFrom() > lastTrack.getSequence())
			throw new VinylException.BadRequest("The parameter 'from' must be in range of the playlist '" + playlistID + "'");

		if(moving.getTo() <= 0 && moving.getTo() > lastTrack.getSequence())
			throw new VinylException.BadRequest("The parameter 'to' must be in range of the playlist '" + playlistID + "'");

		playlist.reorderTracks(moving.getFrom(), moving.getTo(), moving.getRange());

		return this.playlistRepository.save(playlist);
	}


	@GetMapping("/playlists")
	public List<Playlist> listPlaylists(final Paging paging)
	{
		final Pageable pageRequest = paging.toPageRequest();
		return this.playlistRepository.findByPublic(pageRequest);
	}

	@GetMapping("/users/{userID}/playlists")
	public List<Playlist> listByOwner(@PathVariable final long userID, final Paging paging)
	{
		if(!this.userRepository.existsById(userID))
			throw new VinylException.NotFound("The user with the ID '" + userID + "' does not exist");

		final Pageable pageRequest = paging.toPageRequest();
		return this.playlistRepository.findByOwner(userID, pageRequest);
	}

	@GetMapping("/subscribers/{userID}/playlists")
	public List<Playlist> listBySubscriber(@PathVariable final long userID, final Paging paging)
	{
		if(!this.userRepository.existsById(userID))
			throw new VinylException.NotFound("The subscriber with the ID '" + userID + "' does not exist");

		final Pageable pageRequest = paging.toPageRequest();
		return this.playlistRepository.findBySubscriber(userID, pageRequest);
	}

	@PostMapping("/search/playlists")
	public List<Playlist> searchPlaylist(@RequestBody final Map<String,String> body, final Paging paging)
	{
		if(!body.containsKey("searchText"))
			throw new VinylException.BadRequest("The json content does not contain a field 'searchText'");

		final String searchText = body.get("searchText");

		if(Strings.isBlank(searchText))
			throw new VinylException.BadRequest("The field 'searchText' should not be blank");

		final Pageable pageRequest = paging.toPageRequest();
		return this.playlistRepository.findByTitleContaining(searchText, pageRequest);
	}
}
