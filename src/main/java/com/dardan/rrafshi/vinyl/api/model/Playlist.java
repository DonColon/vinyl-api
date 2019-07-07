package com.dardan.rrafshi.vinyl.api.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Playlist implements Serializable
{
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int playlistID;

	@ManyToOne
	@JoinColumn(name="owner", nullable=false)
	private User owner;

	@ManyToMany
	@JoinTable(name="Playback", joinColumns={@JoinColumn(name="playlist")},
			inverseJoinColumns={@JoinColumn(name="song")})
	private List<Song> songs;

	@ManyToMany
	@JoinTable(name="Subscription", joinColumns={@JoinColumn(name="playlist")},
			inverseJoinColumns={@JoinColumn(name="subscriber")})
	private List<User> subscriber;

	private String visibility;
	private String name;
	private LocalDate creationdate;


	public Playlist() {}

	public Playlist(final String name, final User owner, final boolean visibility)
	{
		this.name = name;
		this.creationdate = LocalDate.now();
		this.owner = owner;
		this.songs = new ArrayList<>();
		this.visibility = Boolean.toString(visibility);
		this.subscriber = new ArrayList<>();
	}


	@Override
	public String toString()
	{
		return "Playlist [playlistID=" + this.playlistID + ", name=" + this.name
				+ ", creationdate=" + this.creationdate + ", owner=" + this.owner
				+ ", songs=" + this.songs + ", visibility=" + this.visibility + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if(object == null) return false;
		if(this == object) return true;

		if(this.getClass() != object.getClass())
			return false;

		final Playlist other = (Playlist) object;
		return Objects.equals(this.playlistID, other.playlistID)
			&& Objects.equals(this.creationdate, other.creationdate)
			&& Objects.equals(this.owner, other.owner);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.playlistID, this.creationdate, this.owner);
	}


	public int getID()
	{
		return this.playlistID;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public LocalDate getCreationdate()
	{
		return this.creationdate;
	}

	public User getOwner()
	{
		return this.owner;
	}

	public List<Song> getSongs()
	{
		return Collections.unmodifiableList(this.songs);
	}

	public void addSong(final Song song)
	{
		this.songs.add(song);
	}

	public void removeSong(final Song song)
	{
		this.songs.remove(song);
	}

	public boolean isVisibile()
	{
		final Boolean visibility = Boolean.valueOf(this.visibility);
		return visibility.booleanValue();
	}

	public void setVisibility(final boolean visibility)
	{
		this.visibility = Boolean.toString(visibility);
	}

	public List<User> getSubscriber()
	{
		return Collections.unmodifiableList(this.subscriber);
	}

	public void subscribe(final User user)
	{
		this.subscriber.add(user);
	}

	public void unsubscribe(final User user)
	{
		this.subscriber.remove(user);
	}
}
