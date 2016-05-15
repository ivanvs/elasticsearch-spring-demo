package com.ftn.e2.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "USER")
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "$resolved", "$promise", "deleted" })
public class UserEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@Column
	protected String twitterId;

	@Column
	protected String location;

	@Column
	protected String description;

	@Column
	protected Date createdDate;

	@Column
	protected String name;

	@Column
	protected String profilImageUrl;

	@Column
	protected String profileUrl;

	@Column
	protected String screenName;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	protected Set<TweetEntity> tweets = new HashSet<TweetEntity>();

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

	public Set<TweetEntity> getTweets() {
		return tweets;
	}

	public void setTweets(final Set<TweetEntity> tweets) {
		this.tweets = tweets;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || !(o instanceof TweetEntity)) {
			return false;
		}
		if (id == null) {
			return false;
		}
		return id.equals((((TweetEntity) o).getId()));
	}

	@Override
	public int hashCode() {
		if (id != null) {
			return id.hashCode();
		} else {
			return super.hashCode();
		}
	}
}