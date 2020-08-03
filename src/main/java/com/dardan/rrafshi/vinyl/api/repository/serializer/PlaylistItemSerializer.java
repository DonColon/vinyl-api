package com.dardan.rrafshi.vinyl.api.repository.serializer;

import java.io.IOException;

import com.dardan.rrafshi.vinyl.api.repository.model.PlaylistItem;
import com.dardan.rrafshi.vinyl.api.repository.model.Track;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;


public final class PlaylistItemSerializer extends JsonSerializer<PlaylistItem>
{
	@Override
	public void serialize(final PlaylistItem value, final JsonGenerator generator, final SerializerProvider provider)
		throws IOException
	{
		final Track track = value.getTrack();

		generator.writeStartObject();
		generator.writeNumberField("id", track.getID());
		generator.writeStringField("title", track.getTitle());
		generator.writeStringField("duration", track.getDuration());
		generator.writeStringField("audioPath", track.getAudioPath());
		generator.writeStringField("addedOn", value.getAddedOn().toString());
		generator.writeNumberField("sequence", value.getSequence());

		if(track.getInterpreters().size() != 0) {
			generator.writeFieldName("interpreters");
			generator.writeObject(track.getInterpreters());
		}

		if(track.getAlbums().size() != 0) {
			generator.writeFieldName("albums");
			generator.writeObject(track.getAlbums());
		}

		if(track.getGenres().size() != 0) {
			generator.writeFieldName("genres");
			generator.writeObject(track.getGenres());
		}

		generator.writeEndObject();
	}
}
