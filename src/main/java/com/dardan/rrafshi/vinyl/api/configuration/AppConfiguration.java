package com.dardan.rrafshi.vinyl.api.configuration;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties("app")
public final class AppConfiguration
{
	private List<String> supportedImageTypes;
	private List<String> supportedAudioTypes;


	public List<String> getSupportedImageTypes()
	{
		return this.supportedImageTypes;
	}

	public void setSupportedImageTypes(final List<String> supportedImageTypes)
	{
		this.supportedImageTypes = supportedImageTypes;
	}

	public List<String> getSupportedAudioTypes()
	{
		return this.supportedAudioTypes;
	}

	public void setSupportedAudioTypes(final List<String> supportedAudioTypes)
	{
		this.supportedAudioTypes = supportedAudioTypes;
	}
}
