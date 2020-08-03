package com.dardan.rrafshi.vinyl.api.file;

public class MediaFile
{
	protected String name;
	protected FileType type;
	protected byte[] body;


	public String getName()
	{
		return this.name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public FileType getType()
	{
		return this.type;
	}

	public void setType(final FileType type)
	{
		this.type = type;
	}

	public String getMediaType()
	{
		return this.type.getMediaType();
	}

	public String getFileExtension()
	{
		return this.type.getFileExtension();
	}

	public byte[] getBody()
	{
		return this.body;
	}

	public void setBody(final byte[] body)
	{
		this.body = body;
	}

	public int getFileSize()
	{
		return this.body.length;
	}
}
