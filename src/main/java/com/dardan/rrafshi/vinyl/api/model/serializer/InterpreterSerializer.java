package com.dardan.rrafshi.vinyl.api.model.serializer;

import java.io.IOException;

import com.dardan.rrafshi.vinyl.api.model.Artist;
import com.dardan.rrafshi.vinyl.api.model.Interpreter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;


public final class InterpreterSerializer extends JsonSerializer<Interpreter>
{
	@Override
	public void serialize(final Interpreter value, final JsonGenerator generator, final SerializerProvider provider)
		throws IOException
	{
		final Artist artist = value.getInterpreter();

		generator.writeStartObject();
		generator.writeStringField("name", artist.getName());
		generator.writeStringField("description", artist.getDescription());
		generator.writeStringField("imagePath", artist.getImagePath());

		if(artist.getAliases().size() != 0) {
			generator.writeFieldName("aliases");
			generator.writeObject(artist.getAliases());
		}

		if(artist.getUrls().size() != 0) {
			generator.writeFieldName("urls");
			generator.writeObject(artist.getUrls());
		}

		if(artist.getMembers().size() != 0) {
			generator.writeFieldName("members");
			generator.writeObject(artist.getMembers());
		}

		if(value.getRole() != null)
			generator.writeStringField("role", value.getRole().getAbbreviation());
		else
			generator.writeStringField("role", "");

		generator.writeEndObject();
	}
}
