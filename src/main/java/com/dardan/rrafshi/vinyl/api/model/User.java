package com.dardan.rrafshi.vinyl.api.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public final class User implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long userID;

	private String firstname;
	private String familyname;
	private String gender;
	private LocalDate birthday;

	private String username;
	private String email;
	private String password;
	private LocalDate entryDate;


	@Override
	public String toString()
	{
		return "User [userID=" + this.userID + ", firstname=" + this.firstname
				+ ", familyname=" + this.familyname + ", gender=" + this.gender
				+ ", birthday=" + this.birthday + ", username=" + this.username
				+ ", email=" + this.email + ", password=" + this.password
				+ ", entryDate=" + this.entryDate + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if (this == object) return true;
		if (object == null) return false;

		if (this.getClass() != object.getClass())
			return false;

		final User other = (User) object;
		return this.userID == other.userID;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.userID);
	}


	public long getID()
	{
		return this.userID;
	}

	public void setID(final long userID)
	{
		this.userID = userID;
	}

	public String getFirstname()
	{
		return this.firstname;
	}

	public void setFirstname(final String firstname)
	{
		this.firstname = firstname;
	}

	public String getFamilyname()
	{
		return this.familyname;
	}

	public void setFamilyname(final String familyname)
	{
		this.familyname = familyname;
	}

	public Gender getGender()
	{
		return Gender.of(this.gender);
	}

	public void setGender(final Gender gender)
	{
		this.gender = gender.getAbbreviation();
	}

	public LocalDate getBirthday()
	{
		return this.birthday;
	}

	public void setBirthday(final LocalDate birthday)
	{
		this.birthday = birthday;
	}

	public String getUsername()
	{
		return this.username;
	}

	public void setUsername(final String username)
	{
		this.username = username;
	}

	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(final String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(final String password)
	{
		this.password = password;
	}

	public LocalDate getEntryDate()
	{
		return this.entryDate;
	}

	public void setEntryDate(final LocalDate entryDate)
	{
		this.entryDate = entryDate;
	}
}
