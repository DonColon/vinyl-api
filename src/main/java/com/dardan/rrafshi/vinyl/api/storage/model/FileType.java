package com.dardan.rrafshi.vinyl.api.storage.model;

public enum FileType
{
	JPEG("JPEG Image", "image/jpeg", ".jpg"),
	PNG("Portable Network Graphics", "image/png", ".png"),
	GIF("Graphics Interchange Format", "image/gif", ".gif"),

	MP3("MPEG Audio", "audio/mpeg", ".mp3"),
	MP4("MPEG-4 Audio", "audio/mp4", ".mp4"),
	;


	private String name;
	private String mediaType;
	private String fileExtension;


	private FileType(final String name, final String mediaType, final String fileExtension)
	{
		this.name = name;
		this.mediaType = mediaType;
		this.fileExtension = fileExtension;
	}


	public static FileType fromMediaType(final String mediaType)
	{
		for(final FileType fileType : FileType.values())
			if(mediaType.startsWith(fileType.mediaType))
				return fileType;

		return null;
	}

	public static FileType fromFileExtension(final String fileName)
	{
		for(final FileType fileType : FileType.values())
			if(fileName.endsWith(fileType.fileExtension))
				return fileType;

		return null;
	}


	public String getName()
	{
		return this.name;
	}

	public String getMediaType()
	{
		return this.mediaType;
	}

	public String getFileExtension()
	{
		return this.fileExtension;
	}
}
