package com.dardan.rrafshi.vinyl.api.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.dardan.rrafshi.vinyl.api.model.serializer.GenreSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@Entity
@JsonSerialize(using=GenreSerializer.class)
public final class Genre implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	private String description;


	@Override
	public String toString()
	{
		return "Genre [description=" + this.description + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if (this == object) return true;
		if (object == null) return false;

		if (this.getClass() != object.getClass())
			return false;

		final Genre other = (Genre) object;
		return Objects.equals(this.description, other.description);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.description);
	}


	public String getDescription()
	{
		return this.description;
	}

	public void setDescription(final String description)
	{
		this.description = description;
	}
}
