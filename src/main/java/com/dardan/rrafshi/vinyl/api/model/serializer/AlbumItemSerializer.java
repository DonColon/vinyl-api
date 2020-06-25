package com.dardan.rrafshi.vinyl.api.model.serializer;

import java.io.IOException;

import com.dardan.rrafshi.vinyl.api.model.Album;
import com.dardan.rrafshi.vinyl.api.model.AlbumItem;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;


public final class AlbumItemSerializer extends JsonSerializer<AlbumItem>
{
	@Override
	public void serialize(final AlbumItem value, final JsonGenerator generator, final SerializerProvider provider)
		throws IOException
	{
		final Album album = value.getAlbum();

		generator.writeStartObject();
		generator.writeNumberField("id", album.getID());
		generator.writeStringField("title", album.getTitle());
		generator.writeStringField("year", album.getYear());
		generator.writeStringField("type", album.getType().name());
		generator.writeStringField("imagePath", album.getImagePath());
		generator.writeNumberField("trackNumber", value.getTrackNumber());
		generator.writeEndObject();
	}
}
