package com.ftn.e2.elastic.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.ftn.e2.model.TweetEntity;

@Document(indexName = "es_demo", type = "tweet")
public class TweetEsEntity implements Serializable {

	@Id
	protected Long id;

	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	protected String text;

	@Field(type = FieldType.Date, store = true)
	protected Date createdAt;

	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	protected String languageCode;

	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	protected String source;

	@Field(type = FieldType.Nested, store = true)
	protected UserEsEntity user;

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

	public UserEsEntity getUser() {
		return user;
	}

	public void setUser(final UserEsEntity user) {
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
