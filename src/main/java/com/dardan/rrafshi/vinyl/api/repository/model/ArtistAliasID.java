package com.dardan.rrafshi.vinyl.api.repository.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;


@Embeddable
public final class ArtistAliasID implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String artist;
	private String alias;


	@Override
	public String toString()
	{
		return "ArtistAliasID [artist=" + this.artist + ", alias=" + this.alias + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if (this == object) return true;
		if (object == null) return false;

		if (this.getClass() != object.getClass())
			return false;

		final ArtistAliasID other = (ArtistAliasID) object;
		return Objects.equals(this.alias, other.alias)
			&& Objects.equals(this.artist, other.artist);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.alias, this.artist);
	}


	public String getArtist()
	{
		return this.artist;
	}

	public void setArtist(final String artist)
	{
		this.artist = artist;
	}

	public String getAlias()
	{
		return this.alias;
	}

	public void setAlias(final String alias)
	{
		this.alias = alias;
	}
}
