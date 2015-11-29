package com.github.pixelase.dataaccess.dao.common;

import java.util.HashSet;
import java.util.Set;

public class Filter {
	private Set<FilterProperty> properties;

	public Filter(FilterProperty... props) {
		properties = new HashSet<>();

		if (props.length != 0) {
			for (FilterProperty property : props) {
				properties.add(property);
			}
		}
	}

	public Set<FilterProperty> getProperties() {
		return properties;
	}

	public void setProperties(Set<FilterProperty> properties) {
		this.properties = properties;
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

}
