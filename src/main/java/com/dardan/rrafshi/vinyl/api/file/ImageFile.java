package com.dardan.rrafshi.vinyl.api.file;

public final class ImageFile extends MediaFile
{
	private int width;
	private int height;


	public int getWidth()
	{
		return this.width;
	}

	public void setWidth(final int width)
	{
		this.width = width;
	}

	public int getHeight()
	{
		return this.height;
	}

	public void setHeight(final int height)
	{
		this.height = height;
	}
}
