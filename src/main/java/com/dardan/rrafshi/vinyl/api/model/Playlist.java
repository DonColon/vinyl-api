package com.dardan.rrafshi.vinyl.api.model;

import java.io.Serializable;
import java.time.LocalDate;
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
public final class Playlist implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long playlistID;

	@ManyToOne
	@JoinColumn(name="owner", nullable=false)
	private User owner;

	@ManyToMany
	@JoinTable(name="Subscription", joinColumns={@JoinColumn(name="playlist")},
		inverseJoinColumns={@JoinColumn(name="subscriber")})
	private List<User> subscribers;

	private String title;
	private String description;

	private int isPublic;
	private String imagePath;
	private LocalDate creationDate;


	@Override
	public String toString()
	{
		return "Playlist [playlistID=" + this.playlistID + ", title=" + this.title
				+ ", description=" + this.description + ", isPublic=" + this.isPublic
				+ ", imagePath=" + this.imagePath + ", creationDate=" + this.creationDate + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if (this == object) return true;
		if (object == null) return false;

		if (this.getClass() != object.getClass())
			return false;

		final Playlist other = (Playlist) object;
		return this.playlistID == other.playlistID;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.playlistID);
	}


	public long getID()
	{
		return this.playlistID;
	}

	public void setID(final long playlistID)
	{
		this.playlistID = playlistID;
	}

	public User getOwner()
	{
		return this.owner;
	}

	public void setOwner(final User owner)
	{
		this.owner = owner;
	}

	public List<User> getSubscribers()
	{
		return this.subscribers;
	}

	public void setSubscribers(final List<User> subscribers)
	{
		this.subscribers = subscribers;
	}

	public String getTitle()
	{
		return this.title;
	}

	public void setTitle(final String title)
	{
		this.title = title;
	}

	public String getDescription()
	{
		return this.description;
	}

	public void setDescription(final String description)
	{
		this.description = description;
	}

	public boolean isPublic()
	{
		return this.isPublic == 1;
	}

	public void setPublic(final boolean isPublic)
	{
		if(isPublic)
			this.isPublic = 1;
		else
			this.isPublic = 0;
	}

	public String getImagePath()
	{
		return this.imagePath;
	}

	public void setImagePath(final String imagePath)
	{
		this.imagePath = imagePath;
	}

	public LocalDate getCreationDate()
	{
		return this.creationDate;
	}

	public void setCreationDate(final LocalDate creationDate)
	{
		this.creationDate = creationDate;
	}
}
