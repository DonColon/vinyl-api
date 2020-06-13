package com.dardan.rrafshi.vinyl.api.model;

public enum Gender
{
	DIVERSE("D", "Diverse"),
	FEMALE("F", "Female"),
	MALE("M", "Male")
	;

	private final String abbreviation;
	private final String description;

	private Gender(final String abbreviation, final String description)
	{
		this.abbreviation = abbreviation;
		this.description = description;
	}

	public static Gender of(final String abbreviation)
	{
		for(final Gender gender : Gender.values())
			if(abbreviation.equals(gender.abbreviation))
				return gender;

		return null;
	}

	public String getAbbreviation()
	{
		return this.abbreviation;
	}

	public String getDescription()
	{
		return this.description;
	}
}
