package com.dardan.rrafshi.vinyl.api.repository.serializer;

import java.io.IOException;

import com.dardan.rrafshi.vinyl.api.repository.model.Genre;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;


public final class GenreSerializer extends JsonSerializer<Genre>
{
	@Override
	public void serialize(final Genre value, final JsonGenerator generator, final SerializerProvider provider)
		throws IOException
	{
		generator.writeString(value.getDescription());
	}
}
