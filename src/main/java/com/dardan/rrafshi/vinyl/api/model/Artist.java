package com.dardan.rrafshi.vinyl.api.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public final class Artist implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	private String name;

	@ManyToMany
	@JoinTable(name="Member", joinColumns={@JoinColumn(name="artist")},
		inverseJoinColumns={@JoinColumn(name="member")})
	private List<Artist> members;

	private String description;
	private String imagePath;


	@Override
	public String toString()
	{
		return "Artist [name=" + this.name + ", description=" + this.description
				+ ", imagePath=" + this.imagePath + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if (this == object) return true;
		if (object == null) return false;

		if (this.getClass() != object.getClass())
			return false;

		final Artist other = (Artist) object;
		return Objects.equals(this.name, other.name);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.name);
	}


	public String getName()
	{
		return this.name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public List<Artist> getMembers()
	{
		return this.members;
	}

	public void setMembers(final List<Artist> members)
	{
		this.members = members;
	}

	public String getDescription()
	{
		return this.description;
	}

	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getImagePath()
	{
		return this.imagePath;
	}

	public void setImagePath(final String imagePath)
	{
		this.imagePath = imagePath;
	}
}
