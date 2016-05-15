package com.ftn.e2.elastic.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

public class UserEsEntity implements Serializable {

	@Id
	protected Long id;

	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	protected String twitterId;

	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	protected String location;

	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	protected String description;

	@Field(type = FieldType.Date, store = true)
	protected Date createdDate;

	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	protected String name;

	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	protected String profilImageUrl;

	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	protected String profileUrl;

	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	protected String screenName;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getTwitterId() {
		return twitterId;
	}

	public void setTwitterId(final String twitterId) {
		this.twitterId = twitterId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(final String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(final Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getProfilImageUrl() {
		return profilImageUrl;
	}

	public void setProfilImageUrl(final String profilImageUrl) {
		this.profilImageUrl = profilImageUrl;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(final String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(final String screenName) {
		this.screenName = screenName;
	}

}