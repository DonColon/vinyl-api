package com.dardan.rrafshi.vinyl.api.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public final class Friendship implements Serializable
{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FriendshipID friendshipID;

	@ManyToOne
	@JoinColumn(name="requestor", nullable=false)
	private User requestor;

	@ManyToOne
	@JoinColumn(name="responser", nullable=false)
	private User responser;

	private LocalDate startDate;


	@Override
	public String toString()
	{
		return "Friendship [friendshipID=" + this.friendshipID + ", startDate=" + this.startDate + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if (this == object) return true;
		if (object == null) return false;

		if (this.getClass() != object.getClass())
			return false;

		final Friendship other = (Friendship) object;
		return Objects.equals(this.friendshipID, other.friendshipID);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.friendshipID);
	}


	public FriendshipID getID()
	{
		return this.friendshipID;
	}

	public void setID(final FriendshipID friendshipID)
	{
		this.friendshipID = friendshipID;
	}

	public User getRequestor() {
		return this.requestor;
	}

	public void setRequestor(final User requestor)
	{
		this.requestor = requestor;
	}

	public User getResponser()
	{
		return this.responser;
	}

	public void setResponser(final User responser)
	{
		this.responser = responser;
	}

	public LocalDate getStartDate()
	{
		return this.startDate;
	}

	public void setStartDate(final LocalDate startDate)
	{
		this.startDate = startDate;
	}
}
