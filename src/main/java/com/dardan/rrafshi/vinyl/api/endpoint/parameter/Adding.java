package com.dardan.rrafshi.vinyl.api.endpoint.parameter;

import java.util.ArrayList;
import java.util.List;


public final class Adding
{
	private List<Long> indices = new ArrayList<>();
	private int to;


	@Override
	public String toString()
	{
		return "Adding [indices=" + this.indices + ", to=" + this.to + "]";
	}


	public List<Long> getIndices()
	{
		return this.indices;
	}

	public void setIndices(final List<Long> indices)
	{
		this.indices = indices;
	}

	public int getTo()
	{
		return this.to;
	}

	public void setTo(final int to)
	{
		this.to = to;
	}
}
