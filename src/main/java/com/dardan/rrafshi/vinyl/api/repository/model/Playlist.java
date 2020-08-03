package com.dardan.rrafshi.vinyl.api.repository.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.dardan.rrafshi.vinyl.api.repository.serializer.PlaylistSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@Entity
@JsonSerialize(using=PlaylistSerializer.class)
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
	private List<User> subscribers = new ArrayList<>();

	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="playlist", nullable=false, insertable=false, updatable=false)
	private List<PlaylistItem> tracks = new ArrayList<>();

	private String title;
	private String description;

	private int isPublic;
	private String imagePath;
	private LocalDate creationDate = LocalDate.now();


	public static PlaylistItem createItem(final long playlistID, final Track track, final int sequence)
	{
		final PlaylistItemID itemID = new PlaylistItemID();
		itemID.setPlaylist(playlistID);
		itemID.setTrack(track.getID());

		final PlaylistItem item = new PlaylistItem();
		item.setID(itemID);
		item.setTrack(track);
		item.setSequence(sequence);
		item.setAddedOn(LocalDateTime.now());

		return item;
	}


	public void addTracks(final int startIndex, final List<Track> tracks)
	{
		Collections.sort(this.tracks);
		int sequence = startIndex;

		for(final Track track : tracks) {
			final PlaylistItem item = Playlist.createItem(this.playlistID, track, sequence);

			final int insertIndex = sequence - 1;
			this.tracks.add(insertIndex, item);

			sequence++;
		}

		final int updateIndex = startIndex + tracks.size() - 1;

		for(int i = updateIndex; i < this.tracks.size(); i++) {
			final PlaylistItem track = this.tracks.get(i);
			track.setSequence(i + 1);
		}
	}

	public void removeTracks(final List<Track> tracks)
	{
		for(final Track track : tracks) {
			for(final PlaylistItem item : this.tracks) {
				final PlaylistItemID itemID = item.getID();

				if(itemID.getTrack() == track.getID()) {
					this.tracks.remove(item);
					break;
				}
			}
		}

		Collections.sort(this.tracks);

		for(int i = 0; i < this.tracks.size(); i++) {
			final PlaylistItem item = this.tracks.get(i);
			item.setSequence(i + 1);
		}
	}

	public void reorderTracks(final int from, final int to, final int range)
	{
		if(from == to) return;
		if(from + range == to) return;
		if(to > from && to < from + range) return;

		final int insertIndex = (to > from) ? to - range - 1 : to - 1;

		final int startIndex = from - 1;
		final int endIndex = from + range - 1;

		Collections.sort(this.tracks);
		final List<PlaylistItem> selectedItems = new ArrayList<>(this.tracks.subList(startIndex, endIndex));

		this.tracks.removeAll(selectedItems);
		this.tracks.addAll(insertIndex, selectedItems);

		for(int i = 0; i < this.tracks.size(); i++) {
			final PlaylistItem item = this.tracks.get(i);
			item.setSequence(i + 1);
		}
	}

	public void addSubscriber(final User user)
	{
		this.subscribers.add(user);
	}

	public void removeSubscriber(final User user)
	{
		this.subscribers.remove(user);
	}


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


	public void set(final Playlist other)
	{
		this.title = other.title;
		this.description = other.description;
		this.isPublic = other.isPublic;
	}

	@JsonProperty
	public long getID()
	{
		return this.playlistID;
	}

	@JsonIgnore
	public void setID(final long playlistID)
	{
		this.playlistID = playlistID;
	}

	@JsonProperty
	public User getOwner()
	{
		return this.owner;
	}

	@JsonIgnore
	public void setOwner(final User owner)
	{
		this.owner = owner;
	}

	@JsonIgnore
	public List<User> getSubscribers()
	{
		return this.subscribers;
	}

	@JsonIgnore
	public void setSubscribers(final List<User> subscribers)
	{
		this.subscribers = subscribers;
	}

	@JsonProperty
	public List<PlaylistItem> getTracks()
	{
		return this.tracks;
	}

	@JsonIgnore
	public PlaylistItem getFirstTrack()
	{
		Collections.sort(this.tracks);
		return this.tracks.get(0);
	}

	@JsonIgnore
	public PlaylistItem getLastTrack()
	{
		Collections.sort(this.tracks);
		return this.tracks.get(this.tracks.size() - 1);
	}

	@JsonIgnore
	public void setTracks(final List<PlaylistItem> tracks)
	{
		this.tracks = tracks;
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

	@JsonIgnore
	public String getImagePath()
	{
		return this.imagePath;
	}

	@JsonIgnore
	public void setImagePath(final String imagePath)
	{
		this.imagePath = imagePath;
	}

	@JsonProperty
	public LocalDate getCreationDate()
	{
		return this.creationDate;
	}

	@JsonIgnore
	public void setCreationDate(final LocalDate creationDate)
	{
		this.creationDate = creationDate;
	}
}
