package com.dardan.rrafshi.vinyl.api.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Song implements Serializable
{
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int songID;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="artist", nullable=false)
	private Artist artist;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="album")
	private Album album;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="genre")
	private Genre genre;

	private String track;
	private String title;
	private String year;
	private String pathToFile;


	public Song() {}

	public Song(final String track, final String title, final Artist artist,
				final Album album, final Genre genre,
				final String year, final String pathToFile)
	{
		this.track = track;
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.genre = genre;
		this.year = year;
		this.pathToFile = pathToFile;
	}


	@Override
	public String toString()
	{
		return "Song [songID=" + this.songID + ", track=" + this.track
				+ ", title=" + this.title + ", artist=" + this.artist
				+ ", album=" + this.album + ", genre=" + this.genre
				+ ", year=" + this.year + ", filepath=" + this.pathToFile + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if(object == null) return false;
		if(this == object) return true;

		if(this.getClass() != object.getClass())
			return false;

		final Song other = (Song) object;
		return Objects.equals(this.songID, other.songID);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.songID);
	}


	public int getID()
	{
		return this.songID;
	}

	public String getTrack()
	{
		return this.track;
	}

	public void setTrack(final String track)
	{
		this.track = track;
	}

	public String getTitle()
	{
		return this.title;
	}

	public void setTitle(final String title)
	{
		this.title = title;
	}

	public Artist getArtist()
	{
		return this.artist;
	}

	public void setArtist(final Artist artist)
	{
		this.artist = artist;
	}

	public Album getAlbum()
	{
		return this.album;
	}

	public void setAlbum(final Album album)
	{
		this.album = album;
	}

	public Genre getGenre()
	{
		return this.genre;
	}

	public void setGenre(final Genre genre)
	{
		this.genre = genre;
	}

	public String getYear()
	{
		return this.year;
	}

	public void setYear(final String year)
	{
		this.year = year;
	}

	public String getPathToFile()
	{
		return this.pathToFile;
	}

	public void setPathToFile(final String pathToFile)
	{
		this.pathToFile = pathToFile;
	}
}
