package com.ftn.e2.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "TWEET")
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "$resolved", "$promise", "deleted" })
public class TweetEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@Column
	protected String text;

	@Column
	protected Date createdAt;

	@Column
	protected String languageCode;

	@Column
	protected String source;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "user")
	protected UserEntity user;

	public Long getId() {
		return id;
	}

	public void setId(final Long newId) {
		id = newId;
	}

	public String getText() {
		return text;
	}

	public void setText(final String newtext) {
		text = newtext;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(final Date newCreatedAt) {
		createdAt = newCreatedAt;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(final String newLanguageCode) {
		languageCode = newLanguageCode;
	}

	public String getSource() {
		return languageCode;
	}

	public void setSource(final String newSource) {
		source = newSource;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(final UserEntity user) {
		this.user = user;
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