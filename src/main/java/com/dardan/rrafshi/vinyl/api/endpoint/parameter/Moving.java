package com.dardan.rrafshi.vinyl.api.endpoint.parameter;

import com.dardan.rrafshi.vinyl.api.Constants;

public final class Moving
{
	private int from;
	private int to;
	private int range = Constants.MIN_RANGE;


	@Override
	public String toString()
	{
		return "Moving [from=" + this.from + ", to=" + this.to
			 + ", range=" + this.range + "]";
	}


	public int getFrom()
	{
		return this.from;
	}

	public void setFrom(final int from)
	{
		this.from = from;
	}

	public int getTo()
	{
		return this.to;
	}

	public void setTo(final int to)
	{
		this.to = to;
	}

	public int getRange()
	{
		return this.range;
	}

	public void setRange(final int range)
	{
		this.range = range;
	}
}
