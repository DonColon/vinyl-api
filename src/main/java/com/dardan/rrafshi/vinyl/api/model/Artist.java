package com.dardan.rrafshi.vinyl.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;


@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public final class Artist implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	private String name;

	@ManyToMany
	@JoinTable(name="Member", joinColumns={@JoinColumn(name="artist")},
		inverseJoinColumns={@JoinColumn(name="member")})
	private List<Artist> members = new ArrayList<>();

	@OneToMany
	@JoinColumn(name="artist", nullable=false, insertable=false, updatable=false)
	private List<ArtistAlias> aliases = new ArrayList<>();

	@OneToMany
	@JoinColumn(name="artist", nullable=false, insertable=false, updatable=false)
	private List<SocialMedia> urls = new ArrayList<>();

	private String description;
	private String imagePath;


	@Override
	public String toString()
	{
		return "Artist [name=" + this.name + ", description=" + this.description
				+ ", imagePath=" + this.imagePath + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if (this == object) return true;
		if (object == null) return false;

		if (this.getClass() != object.getClass())
			return false;

		final Artist other = (Artist) object;
		return Objects.equals(this.name, other.name);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.name);
	}


	public String getName()
	{
		return this.name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public List<Artist> getMembers()
	{
		return this.members;
	}

	public void setMembers(final List<Artist> members)
	{
		this.members = members;
	}

	public void addMember(final Artist artist)
	{
		this.members.add(artist);
	}

	public void removeMember(final Artist artist)
	{
		this.members.remove(artist);
	}

	public List<ArtistAlias> getAliases()
	{
		return this.aliases;
	}

	public void setAliases(final List<ArtistAlias> aliases)
	{
		this.aliases = aliases;
	}

	public void addAlias(final ArtistAlias alias)
	{
		this.aliases.add(alias);
	}

	public void removeAlias(final ArtistAlias alias)
	{
		this.aliases.remove(alias);
	}

	public List<SocialMedia> getUrls()
	{
		return this.urls;
	}

	public void setUrls(final List<SocialMedia> urls)
	{
		this.urls = urls;
	}

	public void addUrl(final SocialMedia url)
	{
		this.urls.add(url);
	}

	public void removeUrl(final SocialMedia url)
	{
		this.urls.remove(url);
	}

	public String getDescription()
	{
		return this.description;
	}

	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getImagePath()
	{
		return this.imagePath;
	}

	public void setImagePath(final String imagePath)
	{
		this.imagePath = imagePath;
	}
}
