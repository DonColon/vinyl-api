package com.dardan.rrafshi.vinyl.api.repository.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.dardan.rrafshi.vinyl.api.repository.serializer.PlaylistItemSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@Entity
@JsonSerialize(using=PlaylistItemSerializer.class)
public final class PlaylistItem implements Serializable, Comparable<PlaylistItem>
{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PlaylistItemID playlistItemID;

	@ManyToOne
	@JoinColumn(name="track", nullable=false, insertable=false, updatable=false)
	private Track track;

	private int sequence;
	private LocalDateTime addedOn;


	@Override
	public String toString()
	{
		return "PlaylistItem [playlistItemID=" + this.playlistItemID
				+ ", sequence=" + this.sequence + ", addedOn=" + this.addedOn + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if (this == object) return true;
		if (object == null) return false;

		if (this.getClass() != object.getClass())
			return false;

		final PlaylistItem other = (PlaylistItem) object;
		return Objects.equals(this.playlistItemID, other.playlistItemID);
	}

	@Override
	public int compareTo(final PlaylistItem playlistItem)
	{
		if(this.sequence < playlistItem.sequence)
			return -1;
		else if(this.sequence > playlistItem.sequence)
			return 1;
		else
			return 0;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.playlistItemID);
	}


	@JsonIgnore
	public PlaylistItemID getID()
	{
		return this.playlistItemID;
	}

	public void setID(final PlaylistItemID playlistItemID)
	{
		this.playlistItemID = playlistItemID;
	}

	public Track getTrack()
	{
		return this.track;
	}

	public void setTrack(final Track track)
	{
		this.track = track;
	}

	public int getSequence()
	{
		return this.sequence;
	}

	public void setSequence(final int sequence)
	{
		this.sequence = sequence;
	}

	public LocalDateTime getAddedOn()
	{
		return this.addedOn;
	}

	public void setAddedOn(final LocalDateTime addedOn)
	{
		this.addedOn = addedOn;
	}
}
