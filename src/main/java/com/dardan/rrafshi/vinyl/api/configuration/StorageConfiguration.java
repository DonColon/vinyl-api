package com.dardan.rrafshi.vinyl.api.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix="storage")
public final class StorageConfiguration
{
	private String rootPath;
	private String imagePath;
	private String audioPath;


	public String getRootPath()
	{
		return this.rootPath;
	}

	public void setRootPath(final String rootPath)
	{
		this.rootPath = rootPath;
	}

	public String getImagePath()
	{
		return this.imagePath;
	}

	public void setImagePath(final String imagePath)
	{
		this.imagePath = imagePath;
	}

	public String getAudioPath()
	{
		return this.audioPath;
	}

	public void setAudioPath(final String audioPath)
	{
		this.audioPath = audioPath;
	}
}
