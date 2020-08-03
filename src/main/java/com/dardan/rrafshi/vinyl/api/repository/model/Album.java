package com.dardan.rrafshi.vinyl.api.repository.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public final class Album implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long albumID;

	@ManyToMany
	@JoinTable(name="Collaboration", joinColumns={@JoinColumn(name="album")},
		inverseJoinColumns={@JoinColumn(name="artist")})
	private List<Artist> collaboration = new ArrayList<>();

	private String title;
	private String year;
	private String type;
	private String imagePath;


	@Override
	public String toString()
	{
		return "Album [albumID=" + this.albumID + ", title=" + this.title
				+ ", year=" + this.year + ", type=" + this.type
				+ ", imagePath=" + this.imagePath + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if (this == object) return true;
		if (object == null) return false;

		if (this.getClass() != object.getClass())
			return false;

		final Album other = (Album) object;
		return this.albumID == other.albumID;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.albumID);
	}


	public long getID()
	{
		return this.albumID;
	}

	public void setID(final long albumID)
	{
		this.albumID = albumID;
	}

	@JsonIgnore
	public List<Artist> getArtists()
	{
		return this.collaboration;
	}

	public void setArtists(final List<Artist> collaboration)
	{
		this.collaboration = collaboration;
	}

	public void addArtist(final Artist artist)
	{
		this.collaboration.add(artist);
	}

	public void removeArtist(final Artist artist)
	{
		this.collaboration.remove(artist);
	}

	public String getTitle()
	{
		return this.title;
	}

	public void setTitle(final String title)
	{
		this.title = title;
	}

	public String getYear()
	{
		return this.year;
	}

	public void setYear(final String year)
	{
		this.year = year;
	}

	public AlbumType getType()
	{
		return AlbumType.of(this.type);
	}

	public void setType(final AlbumType type)
	{
		this.type = type.getDescription();
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
