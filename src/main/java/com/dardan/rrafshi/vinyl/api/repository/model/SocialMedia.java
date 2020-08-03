package com.dardan.rrafshi.vinyl.api.repository.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.dardan.rrafshi.vinyl.api.repository.serializer.SocialMediaSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@Entity
@JsonSerialize(using=SocialMediaSerializer.class)
public final class SocialMedia implements Serializable
{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SocialMediaID socialMediaID;

	@Column(insertable=false, updatable=false)
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


	@JsonIgnore
	public SocialMediaID getID()
	{
		return this.socialMediaID;
	}

	public void setID(final SocialMediaID socialMediaID)
	{
		this.socialMediaID = socialMediaID;
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
