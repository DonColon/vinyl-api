package com.dardan.rrafshi.vinyl.api;

import java.util.Arrays;
import java.util.List;

public final class Constants
{
	public static final int MIN_RANGE = 1;
	public static final int MIN_PAGE = 1;
	public static final int MIN_PAGE_SIZE = 12;
	public static final int MAX_PAGE_SIZE = 60;
	public static final String DEFAULT_SORT_ORDER = "asc";

	public static final String FILE_ATTACHMENT = "attachment; filename=\"%s\"";

	public static final List<String> SUPPORTED_IMAGE_TYPES = Arrays.asList(
			"image/jpeg",
			"image/png",
			"image/gif"
	);

	public static final List<String> SUPPORTED_AUDIO_TYPES = Arrays.asList(
			"audio/mpeg",
			"audio/mp4"
	);

	private Constants() {}
}
