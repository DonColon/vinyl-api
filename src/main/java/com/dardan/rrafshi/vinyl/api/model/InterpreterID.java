package com.dardan.rrafshi.vinyl.api.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;


@Embeddable
public final class InterpreterID implements Serializable
{
	private static final long serialVersionUID = 1L;

	private long track;
	private String interpreter;


	@Override
	public String toString()
	{
		return "InterpreterID [track=" + this.track + ", interpreter=" + this.interpreter + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if (this == object) return true;
		if (object == null) return false;

		if (this.getClass() != object.getClass())
			return false;

		final InterpreterID other = (InterpreterID) object;
		return Objects.equals(this.interpreter, other.interpreter)
			&& this.track == other.track;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.interpreter, this.track);
	}


	public long getTrack()
	{
		return this.track;
	}

	public void setTrack(final long track)
	{
		this.track = track;
	}

	public String getInterpreter()
	{
		return this.interpreter;
	}

	public void setInterpreter(final String interpreter)
	{
		this.interpreter = interpreter;
	}
}
