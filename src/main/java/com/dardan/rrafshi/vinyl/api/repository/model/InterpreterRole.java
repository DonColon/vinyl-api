package com.dardan.rrafshi.vinyl.api.repository.model;

public enum InterpreterRole
{
	FEAT("Ft."),
	AND("&"),
	;

	private String abbreviation;

	private InterpreterRole(final String abbreviation)
	{
		this.abbreviation = abbreviation;
	}

	public static InterpreterRole of(final String abbreviation)
	{
		for(final InterpreterRole role : InterpreterRole.values())
			if(role.abbreviation.equals(abbreviation))
				return role;

		return null;
	}

	public String getAbbreviation()
	{
		return this.abbreviation;
	}
}
