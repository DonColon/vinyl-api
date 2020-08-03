package com.dardan.rrafshi.vinyl.api.file.storage;

import com.dardan.rrafshi.vinyl.api.file.FileType;
import com.dardan.rrafshi.vinyl.api.file.ImageFile;


public interface FileStorage
{
	void uploadImage(ImageFile file);

	ImageFile downloadImage(String filePath);

	void uploadAudio(String fileName, FileType fileType, byte[] data);
}
