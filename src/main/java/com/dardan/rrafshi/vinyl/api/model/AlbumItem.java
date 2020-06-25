package com.dardan.rrafshi.vinyl.api.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.dardan.rrafshi.vinyl.api.model.serializer.AlbumItemSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@Entity
@JsonSerialize(using=AlbumItemSerializer.class)
public final class AlbumItem implements Serializable
{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AlbumItemID albumItemID;

	@ManyToOne
	@JoinColumn(name="album", nullable=false, insertable=false, updatable=false)
	private Album album;

	private int trackNumber;


	@Override
	public String toString()
	{
		return "AlbumItem [albumItemID=" + this.albumItemID + ", trackNumber=" + this.trackNumber + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if (this == object) return true;
		if (object == null) return false;

		if (this.getClass() != object.getClass())
			return false;

		final AlbumItem other = (AlbumItem) object;
		return Objects.equals(this.albumItemID, other.albumItemID);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.albumItemID);
	}


	@JsonIgnore
	public AlbumItemID getID()
	{
		return this.albumItemID;
	}

	public void setID(final AlbumItemID albumItemID)
	{
		this.albumItemID = albumItemID;
	}

	public Album getAlbum()
	{
		return this.album;
	}

	public void setAlbum(final Album album)
	{
		this.album = album;
	}

	public int getTrackNumber()
	{
		return this.trackNumber;
	}

	public void setTrackNumber(final int trackNumber)
	{
		this.trackNumber = trackNumber;
	}
}
