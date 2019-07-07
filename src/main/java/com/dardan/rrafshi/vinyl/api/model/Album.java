package com.dardan.rrafshi.vinyl.api.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Album implements Serializable
{
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int albumID;

	private String name;


	public Album() {}

	public Album(final String name)
	{
		this.name = name;
	}


	@Override
	public String toString()
	{
		return "Album [albumID=" + this.albumID + ", name=" + this.name + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if(object == null) return false;
		if(this == object) return true;

		if(this.getClass() != object.getClass())
			return false;

		final Album other = (Album) object;
		return Objects.equals(this.albumID, other.albumID)
			&& Objects.equals(this.name, other.name);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.albumID, this.name);
	}


	public int getID()
	{
		return this.albumID;
	}

	public String getName()
	{
		return this.name;
	}
}
