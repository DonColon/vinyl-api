package com.dardan.rrafshi.vinyl.api.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*create table if not exists SocialMedia(
		artist varchar(64),
	    url varchar(256),
	    primary key(artist, url)
);*/

@Entity
public final class SocialMedia implements Serializable
{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SocialMediaID socialMediaID;

	@ManyToOne
	@JoinColumn(name="artist", nullable=false)
	private Artist artist;

	private String url;


	@Override
	public String toString()
	{
		return "SocialMedia [socialMediaID=" + this.socialMediaID + ", url=" + this.url + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if (this == object) return true;
		if (object == null) return false;

		if (this.getClass() != object.getClass())
			return false;

		final SocialMedia other = (SocialMedia) object;
		return Objects.equals(this.socialMediaID, other.socialMediaID);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.socialMediaID);
	}


	public SocialMediaID getID()
	{
		return this.socialMediaID;
	}

	public void setID(final SocialMediaID socialMediaID)
	{
		this.socialMediaID = socialMediaID;
	}

	public Artist getArtist()
	{
		return this.artist;
	}

	public void setArtist(final Artist artist)
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
