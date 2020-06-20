package com.dardan.rrafshi.vinyl.api.model;

public enum AlbumType
{
	ALBUM("album"),
	EP("ep"),
	SINGLE("single")
	;

	private String description;

	private AlbumType(final String description)
	{
		this.description = description;
	}

	public static AlbumType of(final String description)
	{
		for(final AlbumType gender : AlbumType.values())
			if(gender.description.equals(description))
				return gender;

		return null;
	}

	public String getDescription()
	{
		return this.description;
	}
}
