package com.dardan.rrafshi.vinyl.api.storage;

import com.dardan.rrafshi.vinyl.api.storage.model.FileType;
import com.dardan.rrafshi.vinyl.api.storage.model.ImageFile;


public interface FileStorage
{
	void uploadImage(ImageFile file);

	ImageFile downloadImage(String filePath);

	void uploadAudio(String fileName, FileType fileType, byte[] data);
}
