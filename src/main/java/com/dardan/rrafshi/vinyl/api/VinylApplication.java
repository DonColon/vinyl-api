package com.dardan.rrafshi.vinyl.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.dardan.rrafshi.vinyl.api.configuration.AppConfiguration;
import com.dardan.rrafshi.vinyl.api.configuration.StorageConfiguration;


@SpringBootApplication
@EnableConfigurationProperties({
	AppConfiguration.class,
    StorageConfiguration.class
})
public class VinylApplication
{
	public static void main(final String[] args)
	{
		SpringApplication.run(VinylApplication.class, args);
	}
}
