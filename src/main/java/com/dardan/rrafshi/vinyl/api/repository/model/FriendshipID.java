package com.dardan.rrafshi.vinyl.api.repository.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;


@Embeddable
public final class FriendshipID implements Serializable
{
	private static final long serialVersionUID = 1L;

	private long requestor;
	private long responser;


	@Override
	public String toString()
	{
		return "FriendshipID [requestor=" + this.requestor + ", responser=" + this.responser + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if (this == object) return true;
		if (object == null) return false;

		if (this.getClass() != object.getClass())
			return false;

		final FriendshipID other = (FriendshipID) object;
		return this.requestor == other.requestor && this.responser == other.responser;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.requestor, this.responser);
	}


	public long getRequestor()
	{
		return this.requestor;
	}

	public void setRequestor(final long requestor)
	{
		this.requestor = requestor;
	}

	public long getResponser()
	{
		return this.responser;
	}

	public void setResponser(final long responser)
	{
		this.responser = responser;
	}
}
