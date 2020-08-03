package com.dardan.rrafshi.vinyl.api.repository.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;


@Embeddable
public final class PlaylistItemID implements Serializable
{
	private static final long serialVersionUID = 1L;

	private long playlist;
	private long track;


	@Override
	public String toString()
	{
		return "PlaylistItemID [playlist=" + this.playlist + ", track=" + this.track + "]";
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.playlist, this.track);
	}

	@Override
	public boolean equals(final Object object)
	{
		if (this == object) return true;
		if (object == null) return false;

		if (this.getClass() != object.getClass())
			return false;

		final PlaylistItemID other = (PlaylistItemID) object;
		return this.playlist == other.playlist
			&& this.track == other.track;
	}


	public long getPlaylist()
	{
		return this.playlist;
	}

	public void setPlaylist(final long playlist)
	{
		this.playlist = playlist;
	}

	public long getTrack()
	{
		return this.track;
	}

	public void setTrack(final long track)
	{
		this.track = track;
	}
}
