package com.dardan.rrafshi.vinyl.api.endpoint;

import java.io.IOException;
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
import com.dardan.rrafshi.vinyl.api.endpoint.parameter.Pagination;
import com.dardan.rrafshi.vinyl.api.model.User;
import com.dardan.rrafshi.vinyl.api.repository.UserRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public final class UserController
{
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ObjectMapper mapper;


	@PostMapping("/users")
	@ResponseStatus(code=HttpStatus.CREATED)
	public User createUser(@RequestBody final String body)
	{
		try {
			final User user = this.mapper.readValue(body, User.class);
			return this.userRepository.save(user);

		} catch (final JsonParseException exception) {
			throw new VinylException.BadRequest("Invalid json format", exception);

		} catch (final JsonMappingException exception) {
			throw new VinylException.BadRequest("The json content does not match the entity structure", exception);

		} catch (final IOException exception) {
			throw new VinylException.InternalServerError("Unexpected I/O problem", exception);
		}
	}

	@GetMapping("/users/{userID}")
	public User retrieveUser(@PathVariable final long userID)
	{
		final Optional<User> entity = this.userRepository.findById(userID);

		if(!entity.isPresent())
			throw new VinylException.NotFound("The user with the ID '" + userID + "' does not exist");

		return entity.get();
	}

	@PutMapping("/users/{userID}")
	@ResponseStatus(code=HttpStatus.CREATED)
	public User updateUser(@PathVariable final long userID, @RequestBody final String body)
	{
		try {
			final Optional<User> entity = this.userRepository.findById(userID);

			if(!entity.isPresent())
				throw new VinylException.NotFound("The user with the ID '" + userID + "' does not exist");

			final User other = this.mapper.readValue(body, User.class);
			final User user = entity.get();

			user.set(other);

			return this.userRepository.save(user);

		} catch (final JsonParseException exception) {
			throw new VinylException.BadRequest("Invalid json format", exception);

		} catch (final JsonMappingException exception) {
			throw new VinylException.BadRequest("The json content does not match the entity structure", exception);

		} catch (final IOException exception) {
			throw new VinylException.InternalServerError("Unexpected I/O problem", exception);
		}
	}

	@DeleteMapping("/users/{userID}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable final long userID)
	{
		final Optional<User> entity = this.userRepository.findById(userID);

		if(!entity.isPresent())
			throw new VinylException.NotFound("The user with the ID '" + userID + "' does not exist");

		this.userRepository.deleteById(userID);
	}

	@PostMapping("/search/users")
	public List<User> searchUser(@RequestBody final Map<String,String> body, final Pagination pagination)
	{
		if(body.containsKey("searchText"))
			throw new VinylException.BadRequest("The json content does not contain a field 'searchText'");

		final String searchText = body.get("searchText");

		if(Strings.isBlank(searchText))
			throw new VinylException.BadRequest("The field 'searchText' should not be blank");

		final Pageable pageRequest = pagination.toPageRequest();
		return this.userRepository.findByUsernameContaining(searchText, pageRequest);
	}
}
