package com.dardan.rrafshi.vinyl.api.repository.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;


@Embeddable
public final class AlbumItemID implements Serializable
{
	private static final long serialVersionUID = 1L;

	private long album;
	private long track;


	@Override
	public String toString()
	{
		return "AlbumItemID [album=" + this.album + ", track=" + this.track + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if (this == object) return true;
		if (object == null) return false;

		if (this.getClass() != object.getClass())
			return false;

		final AlbumItemID other = (AlbumItemID) object;
		return this.album == other.album && this.track == other.track;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.album, this.track);
	}


	public long getAlbum()
	{
		return this.album;
	}

	public void setAlbum(final long album)
	{
		this.album = album;
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
