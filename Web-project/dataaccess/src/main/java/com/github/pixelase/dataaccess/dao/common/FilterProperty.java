package com.github.pixelase.dataaccess.dao.common;

public class FilterProperty {
	private String columnName;
	private String value;

	public FilterProperty(String columnName, String value) {
		super();
		this.columnName = columnName;
		this.value = value;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((columnName == null) ? 0 : columnName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof FilterProperty))
			return false;
		FilterProperty other = (FilterProperty) obj;
		if (columnName == null) {
			if (other.columnName != null)
				return false;
		} else if (!columnName.equals(other.columnName))
			return false;
		return true;
	}

	public String toSqlFormat() {
		return String.format("%s = \'%s\'", columnName, value);
	}

	@Override
	public String toString() {
		return "FilterProperty [columnName=" + columnName + ", value=" + value + "]";
	}

}
