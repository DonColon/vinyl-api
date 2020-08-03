package com.dardan.rrafshi.vinyl.api.repository.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;


@Embeddable
public final class SocialMediaID implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String artist;
	private String url;


	@Override
	public String toString()
	{
		return "SocialMediaID [artist=" + this.artist + ", url=" + this.url + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if (this == object) return true;
		if (object == null) return false;

		if (this.getClass() != object.getClass())
			return false;

		final SocialMediaID other = (SocialMediaID) object;
		return Objects.equals(this.artist, other.artist) && Objects.equals(this.url, other.url);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.artist, this.url);
	}


	public String getArtist()
	{
		return this.artist;
	}

	public void setArtist(final String artist)
	{
		this.artist = artist;
	}

	public String getUrl()
	{
		return this.url;
	}

	public void setUrl(final String url)
	{
		this.url = url;
	}
}
