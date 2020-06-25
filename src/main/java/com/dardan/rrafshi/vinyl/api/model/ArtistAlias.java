package com.dardan.rrafshi.vinyl.api.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.dardan.rrafshi.vinyl.api.model.serializer.ArtistAliasSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@Entity
@JsonSerialize(using=ArtistAliasSerializer.class)
public final class ArtistAlias implements Serializable
{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ArtistAliasID artistAliasID;

	@Column(insertable=false, updatable=false)
	private String alias;


	@Override
	public String toString()
	{
		return "ArtistAlias [artistAliasID=" + this.artistAliasID + ", alias=" + this.alias + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if (this == object) return true;
		if (object == null) return false;

		if (this.getClass() != object.getClass())
			return false;

		final ArtistAlias other = (ArtistAlias) object;
		return Objects.equals(this.artistAliasID, other.artistAliasID);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.artistAliasID);
	}


	@JsonIgnore
	public ArtistAliasID getID()
	{
		return this.artistAliasID;
	}

	public void setID(final ArtistAliasID artistAliasID)
	{
		this.artistAliasID = artistAliasID;
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
