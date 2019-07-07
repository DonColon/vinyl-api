package com.dardan.rrafshi.vinyl.api.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User implements Serializable
{
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userID;

	private String firstname;
	private String familyname;
	private String username;
	private String email;
	private String password;


	public User() {}

	public User(final String firstname, final String familyname,
				final String username, final String email, final String password)
	{
		this.firstname = firstname;
		this.familyname = familyname;
		this.username = username;
		this.email = email;
		this.password = password;
	}


	@Override
	public String toString()
	{
		return "User [userID=" + this.userID + ", firstname=" + this.firstname + ", familyname=" + this.familyname
				+ ", username=" + this.username + ", email=" + this.email + ", password=" + this.password + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if(object == null) return false;
		if(this == object) return true;

		if(this.getClass() != object.getClass())
			return false;

		final User other = (User) object;
		return Objects.equals(this.userID, other.userID);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.userID);
	}


	public int getID()
	{
		return this.userID;
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
}
