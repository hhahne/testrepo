package com.henrik.service.createcollectible.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class CollectibleEntity {
	private Integer id;
	private String name;
	private String description;

	public static final CollectibleEntity NULL_OBJECT = new CollectibleEntity(
			null, null);

	public CollectibleEntity(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		CollectibleEntity candidate = (CollectibleEntity) obj;
		return new EqualsBuilder()
		.append(name, candidate.name)
		.append(description,candidate.description).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(name).append(description).toHashCode();
	}

}
