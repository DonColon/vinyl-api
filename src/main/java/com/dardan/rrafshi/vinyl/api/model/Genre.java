package com.dardan.rrafshi.vinyl.api.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Genre implements Serializable
{
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int genreID;

	private String description;


	public Genre() {}

	public Genre(final String description)
	{
		this.description = description;
	}


	@Override
	public String toString()
	{
		return "Genre [genreID=" + this.genreID
				+ ", description=" + this.description + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if(object == null) return false;
		if(this == object) return true;

		if(this.getClass() != object.getClass())
			return false;

		final Genre other = (Genre) object;
		return Objects.equals(this.genreID, other.genreID)
			&& Objects.equals(this.description, other.description);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.genreID, this.description);
	}


	public int getID()
	{
		return this.genreID;
	}

	public String getDescription()
	{
		return this.description;
	}
}
