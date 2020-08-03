package com.dardan.rrafshi.vinyl.api.repository.serializer;

import java.io.IOException;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dardan.rrafshi.commons.Strings;
import com.dardan.rrafshi.vinyl.api.repository.model.Playlist;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;


public final class PlaylistSerializer extends JsonSerializer<Playlist>
{
	@Override
	public void serialize(final Playlist value, final JsonGenerator generator, final SerializerProvider provider)
		throws IOException
	{
		generator.writeStartObject();
		generator.writeNumberField("id", value.getID());
		generator.writeStringField("title", value.getTitle());
		generator.writeStringField("description", value.getDescription());

		generator.writeFieldName("owner");
		generator.writeObject(value.getOwner());

		if(Strings.isNotBlank(value.getImagePath())) {
			final String imageUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .pathSegment("playlists")
	                .pathSegment(String.valueOf(value.getID()))
	                .pathSegment("images")
	                .toUriString();

			generator.writeFieldName("imageUrl");
			generator.writeObject(imageUrl);
		}

		generator.writeStringField("creationDate", value.getCreationDate().toString());
		generator.writeBooleanField("public", value.isPublic());

		generator.writeFieldName("tracks");
		generator.writeObject(value.getTracks());
		generator.writeEndObject();
	}
}
