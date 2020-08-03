package com.dardan.rrafshi.vinyl.api.storage;

import org.springframework.http.MediaType;

import com.dardan.rrafshi.commons.Strings;
import com.dardan.rrafshi.vinyl.api.repository.model.Album;
import com.dardan.rrafshi.vinyl.api.repository.model.Playlist;
import com.dardan.rrafshi.vinyl.api.storage.model.FileType;
import com.dardan.rrafshi.vinyl.api.storage.model.ImageFile;


public final class MediaFiles
{
	private MediaFiles() {}


	public static ImageFile createPlaylistImageFile(final Playlist playlist, final MediaType mediaType, final byte[] body)
	{
		final FileType type = FileType.fromMediaType(mediaType.toString());

		final String name = Strings.lowerKebabCase(playlist.getTitle() + " " + playlist.getID()) + type.getFileExtension();

		final ImageFile file = new ImageFile();
		file.setName(name);
		file.setType(type);
		file.setBody(body);

		return file;
	}

	public static ImageFile createAlbumImageFile(final Album album, final MediaType mediaType, final byte[] body)
	{
		final FileType type = FileType.fromMediaType(mediaType.toString());

		final String name = Strings.lowerKebabCase(album.getTitle() + " " + album.getID()) + type.getFileExtension();

		final ImageFile file = new ImageFile();
		file.setName(name);
		file.setType(type);
		file.setBody(body);

		return file;
	}
}
