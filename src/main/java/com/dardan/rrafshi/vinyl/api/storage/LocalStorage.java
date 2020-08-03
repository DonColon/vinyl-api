package com.dardan.rrafshi.vinyl.api.storage;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dardan.rrafshi.commons.Strings;
import com.dardan.rrafshi.vinyl.api.VinylException;
import com.dardan.rrafshi.vinyl.api.configuration.StorageConfiguration;
import com.dardan.rrafshi.vinyl.api.storage.model.FileType;
import com.dardan.rrafshi.vinyl.api.storage.model.ImageFile;


@Service("localStorage")
public final class LocalStorage implements FileStorage
{
	private final Path imageLocation;
	private final Path audioLocation;


	@Autowired
	public LocalStorage(final StorageConfiguration configuration)
	{
		final Path storageLocation = Paths.get(configuration.getRootPath());

		this.imageLocation = storageLocation.resolve(configuration.getImagePath());
		this.audioLocation = storageLocation.resolve(configuration.getAudioPath());

		try {
			Files.createDirectories(this.imageLocation);
			Files.createDirectories(this.audioLocation);

		} catch(final IOException exception) {

			throw new VinylException.InternalServerError("Could not create the upload directory");
		}
	}


	@Override
	public void uploadImage(final ImageFile file)
	{
		if(Strings.contains(file.getName(), ".."))
			throw new VinylException.InternalServerError("File name contains an invalid path sequence");

		final Path outputPath = this.imageLocation.resolve(file.getName())
				.toAbsolutePath()
				.normalize();

		try {
			Files.write(outputPath, file.getBody(), StandardOpenOption.CREATE);

			// Processing of Image File
			final BufferedImage image = ImageIO.read(outputPath.toFile());
			System.out.println(image.getWidth());
			System.out.println(image.getHeight());

		} catch(final IOException exception) {

			throw new VinylException.InternalServerError("Could not upload File '" + file.getName() + "'", exception);
		}
	}

	@Override
	public ImageFile downloadImage(final String filePath)
	{
		if(Strings.contains(filePath, ".."))
			throw new VinylException.InternalServerError("File name contains an invalid path sequence");

		final Path inputPath = this.imageLocation.resolve(filePath)
				.toAbsolutePath()
				.normalize();

		try {
			final byte[] data = Files.readAllBytes(inputPath);

			final FileType type = FileType.fromFileExtension(filePath);

			final ImageFile file = new ImageFile();
			file.setName(filePath);
			file.setType(type);
			file.setBody(data);

			return file;

		} catch(final IOException exception) {

			throw new VinylException.InternalServerError("Could not download File '" + filePath + "'", exception);
		}
	}

	@Override
	public void uploadAudio(final String fileName, final FileType fileType, final byte[] data)
	{
		if(Strings.contains(fileName, ".."))
			throw new VinylException.InternalServerError("File name contains an invalid path sequence");

		final Path outputPath = this.audioLocation.resolve(fileName + fileType.getFileExtension())
				.toAbsolutePath()
				.normalize();

		try {
			Files.write(outputPath, data, StandardOpenOption.CREATE);

			// Processing of Audio File

		} catch(final IOException exception) {

			throw new VinylException.InternalServerError("Could not upload File '" + outputPath + "'", exception);
		}
	}
}
