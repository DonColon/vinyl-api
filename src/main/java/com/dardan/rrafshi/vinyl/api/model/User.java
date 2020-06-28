package com.dardan.rrafshi.vinyl.api.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


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

	private LocalDate entryDate = LocalDate.now();


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

	public void set(final User other)
	{
		this.firstname = other.firstname;
		this.familyname = other.familyname;
		this.gender = other.gender;
		this.birthday = other.birthday;
		this.username = other.username;
		this.email = other.email;
		this.password = other.password;
	}


	@JsonProperty
	public long getID()
	{
		return this.userID;
	}

	@JsonIgnore
	public void setID(final long userID)
	{
		this.userID = userID;
	}

	@JsonIgnore
	public String getFirstname()
	{
		return this.firstname;
	}

	@JsonProperty
	public void setFirstname(final String firstname)
	{
		this.firstname = firstname;
	}

	@JsonIgnore
	public String getFamilyname()
	{
		return this.familyname;
	}

	@JsonProperty
	public void setFamilyname(final String familyname)
	{
		this.familyname = familyname;
	}

	@JsonIgnore
	public Gender getGender()
	{
		return Gender.of(this.gender);
	}

	@JsonProperty
	public void setGender(final Gender gender)
	{
		this.gender = gender.getAbbreviation();
	}

	@JsonIgnore
	public LocalDate getBirthday()
	{
		return this.birthday;
	}

	@JsonProperty
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

	@JsonIgnore
	public String getEmail()
	{
		return this.email;
	}

	@JsonProperty
	public void setEmail(final String email)
	{
		this.email = email;
	}

	@JsonIgnore
	public String getPassword()
	{
		return this.password;
	}

	@JsonProperty
	public void setPassword(final String password)
	{
		this.password = password;
	}

	@JsonProperty
	public LocalDate getEntryDate()
	{
		return this.entryDate;
	}

	@JsonIgnore
	public void setEntryDate(final LocalDate entryDate)
	{
		this.entryDate = entryDate;
	}
}
