package com.dardan.rrafshi.vinyl.api.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;


@Embeddable
public final class PlaylistItemID implements Serializable
{
	private static final long serialVersionUID = 1L;

	private int playlist;
	private int track;


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


	public int getPlaylist()
	{
		return this.playlist;
	}

	public void setPlaylist(final int playlist)
	{
		this.playlist = playlist;
	}

	public int getTrack()
	{
		return this.track;
	}

	public void setTrack(final int track)
	{
		this.track = track;
	}
}
