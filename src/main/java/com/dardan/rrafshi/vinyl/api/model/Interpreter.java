package com.dardan.rrafshi.vinyl.api.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.dardan.rrafshi.vinyl.api.model.serializer.InterpreterSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@Entity
@JsonSerialize(using=InterpreterSerializer.class)
public final class Interpreter implements Serializable
{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private InterpreterID interpreterID;

	@ManyToOne
	@JoinColumn(name="interpreter", nullable=false, insertable=false, updatable=false)
	private Artist interpreter;

	private String role;


	@Override
	public String toString()
	{
		return "Interpreter [interpreterID=" + this.interpreterID + ", role=" + this.role + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if (this == object) return true;
		if (object == null) return false;

		if (this.getClass() != object.getClass())
			return false;

		final Interpreter other = (Interpreter) object;
		return Objects.equals(this.interpreterID, other.interpreterID);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.interpreterID);
	}


	@JsonIgnore
	public InterpreterID getInterpreterID()
	{
		return this.interpreterID;
	}

	public void setInterpreterID(final InterpreterID interpreterID)
	{
		this.interpreterID = interpreterID;
	}

	public Artist getInterpreter()
	{
		return this.interpreter;
	}

	public void setInterpreter(final Artist interpreter)
	{
		this.interpreter = interpreter;
	}

	public InterpreterRole getRole()
	{
		return InterpreterRole.of(this.role);
	}

	public void setRole(final InterpreterRole role)
	{
		this.role = role.getAbbreviation();
	}
}
