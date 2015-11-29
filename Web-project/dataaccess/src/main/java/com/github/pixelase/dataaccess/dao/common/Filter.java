package com.github.pixelase.dataaccess.dao.common;

import java.util.HashSet;
import java.util.Set;

public class Filter {
	private Set<FilterProperty> properties;

	private Filter(Set<FilterProperty> properties) {
		super();
		this.properties = properties;
	}

	public Set<FilterProperty> getProperties() {
		return properties;
	}

	public void setProperties(Set<FilterProperty> properties) {
		this.properties = properties;
	}

	public boolean isEmpty() {
		return properties.isEmpty();
	}

	public String toSqlFormat() {
		StringBuilder result = new StringBuilder();

		for (FilterProperty property : properties) {
			result.append(property.toSqlFormat() + " ");
		}

		return result.toString();
	}

	@Override
	public String toString() {
		return "Filter [properties=" + properties + "]";
	}

	public static class Builder {
		private final Set<FilterProperty> properties;

		public Builder() {
			this(new HashSet<FilterProperty>());
		}

		private Builder(Set<FilterProperty> properties) {
			this.properties = properties;
		}

		public Builder add(String columnName, String value) {
			properties.add(new FilterProperty(columnName, value));
			return this;
		}

		public Builder add(FilterProperty property) {
			properties.add(property);
			return this;
		}

		public Set<FilterProperty> getProperties() {
			return properties;
		}

		public Filter build() {
			return new Filter(properties);
		}
	}
}
