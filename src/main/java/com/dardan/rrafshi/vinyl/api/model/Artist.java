package com.dardan.rrafshi.vinyl.api.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Artist implements Serializable
{
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int artistID;

	private String name;


	public Artist() {}

	public Artist(final String name)
	{
		this.name = name;
	}


	@Override
	public String toString()
	{
		return "Artist [artistID=" + this.artistID + ", name=" + this.name + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if(object == null) return false;
		if(this == object) return true;

		if(this.getClass() != object.getClass())
			return false;

		final Artist other = (Artist) object;
		return Objects.equals(this.artistID, other.artistID)
			&& Objects.equals(this.name, other.name);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.artistID, this.name);
	}


	public int getID()
	{
		return this.artistID;
	}

	public String getName()
	{
		return this.name;
	}
}
