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
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public final class Track implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long trackID;

	@OneToMany
	@JoinColumn(name="track", nullable=false, insertable=false, updatable=false)
	private List<Interpreter> interpreters = new ArrayList<>();

	@OneToMany
	@JoinColumn(name="track", nullable=false, insertable=false, updatable=false)
	private List<AlbumItem> albums = new ArrayList<>();

	@ManyToMany
	@JoinTable(name="MusicStyle", joinColumns={@JoinColumn(name="track")},
		inverseJoinColumns={@JoinColumn(name="genre")})
	private List<Genre> genres = new ArrayList<>();

	@ManyToMany
	@JoinTable(name="Favorite", joinColumns={@JoinColumn(name="track")},
		inverseJoinColumns={@JoinColumn(name="user")})
	private List<User> favorites = new ArrayList<>();

	private String title;
	private String duration;
	private String audioPath;


	@Override
	public String toString()
	{
		return "Track [trackID=" + this.trackID + ", title=" + this.title
				+ ", duration=" + this.duration + ", audioPath=" + this.audioPath + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if (this == object) return true;
		if (object == null) return false;

		if (this.getClass() != object.getClass())
			return false;

		final Track other = (Track) object;
		return this.trackID == other.trackID;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.trackID);
	}


	public long getID()
	{
		return this.trackID;
	}

	public void setID(final long trackID)
	{
		this.trackID = trackID;
	}

	public List<Interpreter> getInterpreters()
	{
		return this.interpreters;
	}

	public void setInterpreters(final List<Interpreter> interpreters)
	{
		this.interpreters = interpreters;
	}

	public void addInterpreter(final Interpreter interpreter)
	{
		this.interpreters.add(interpreter);
	}

	public void removeInterpreter(final Interpreter interpreter)
	{
		this.interpreters.remove(interpreter);
	}

	public List<AlbumItem> getAlbums()
	{
		return this.albums;
	}

	public void setAlbums(final List<AlbumItem> albums)
	{
		this.albums = albums;
	}

	public void addAlbum(final AlbumItem albumItem)
	{
		this.albums.add(albumItem);
	}

	public void removeAlbum(final AlbumItem albumItem)
	{
		this.albums.remove(albumItem);
	}

	public List<Genre> getGenres()
	{
		return this.genres;
	}

	public void setGenres(final List<Genre> genres)
	{
		this.genres = genres;
	}

	public void addGenre(final Genre genre)
	{
		this.genres.add(genre);
	}

	public void removeGenre(final Genre genre)
	{
		this.genres.remove(genre);
	}

	@JsonIgnore
	public List<User> getFavorites()
	{
		return this.favorites;
	}

	public void setFavorites(final List<User> favorites)
	{
		this.favorites = favorites;
	}

	public void addFavorite(final User user)
	{
		this.favorites.add(user);
	}

	public void removeFavorite(final User user)
	{
		this.favorites.remove(user);
	}

	public String getTitle()
	{
		return this.title;
	}

	public void setTitle(final String title)
	{
		this.title = title;
	}

	public String getDuration()
	{
		return this.duration;
	}

	public void setDuration(final String duration)
	{
		this.duration = duration;
	}

	public String getAudioPath()
	{
		return this.audioPath;
	}

	public void setAudioPath(final String audioPath)
	{
		this.audioPath = audioPath;
	}
}
