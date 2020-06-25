package com.dardan.rrafshi.vinyl.api.model.serializer;

import java.io.IOException;

import com.dardan.rrafshi.vinyl.api.model.ArtistAlias;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;


public final class ArtistAliasSerializer extends JsonSerializer<ArtistAlias>
{
	@Override
	public void serialize(final ArtistAlias value, final JsonGenerator generator, final SerializerProvider provider)
		throws IOException
	{
		generator.writeString(value.getAlias());
	}
}
