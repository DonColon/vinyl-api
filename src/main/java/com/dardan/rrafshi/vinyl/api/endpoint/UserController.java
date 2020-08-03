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
import com.dardan.rrafshi.vinyl.api.endpoint.parameter.Paging;
import com.dardan.rrafshi.vinyl.api.repository.UserRepository;
import com.dardan.rrafshi.vinyl.api.repository.model.User;


@RestController
public final class UserController
{
	@Autowired
	private UserRepository userRepository;


	@PostMapping("/users")
	@ResponseStatus(code=HttpStatus.CREATED)
	public User createUser(@RequestBody final User body)
	{
		return this.userRepository.save(body);
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
	public User updateUser(@PathVariable final long userID, @RequestBody final User body)
	{
		final Optional<User> entity = this.userRepository.findById(userID);

		if(!entity.isPresent())
			throw new VinylException.NotFound("The user with the ID '" + userID + "' does not exist");

		final User user = entity.get();
		user.set(body);

		return this.userRepository.save(user);
	}

	@DeleteMapping("/users/{userID}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable final long userID)
	{
		if(!this.userRepository.existsById(userID))
			throw new VinylException.NotFound("The user with the ID '" + userID + "' does not exist");

		this.userRepository.deleteById(userID);
	}

	@PostMapping("/search/users")
	public List<User> searchUser(@RequestBody final Map<String,String> body, final Paging paging)
	{
		if(!body.containsKey("searchText"))
			throw new VinylException.BadRequest("The json content does not contain a field 'searchText'");

		final String searchText = body.get("searchText");

		if(Strings.isBlank(searchText))
			throw new VinylException.BadRequest("The field 'searchText' should not be blank");

		final Pageable pageRequest = paging.toPageRequest();
		return this.userRepository.findByUsernameContaining(searchText, pageRequest);
	}
}
