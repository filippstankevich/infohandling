package com.epam.infohandling.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Leaf implements Component {
	private static Logger logger = LogManager.getLogger();

	private String value;
	private String name;
	private Composite parent; 
	
	public Leaf(String name, String value) {
		this.name = name;
		this.value = value;
		logger.info("# leaf was created #");
	}
	
	public Leaf(String value) {
		this.value = value;
		logger.info("# leaf was created #");
	}
	
	@Override
	public void add(Component component) {
		System.out.println("Leaf -> add. Doing nothing");
		throw new UnsupportedOperationException();
	}

	@Override
	public void remove(Component component) {
		System.out.println("Leaf -> remove. Doing nothing");
		throw new UnsupportedOperationException();
	}

	@Override
	public Object getChild(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isLeaf() {
		return true;
	}

	@Override
	public Object getValue() {
		return value;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int childrenCount() {
		return 0;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Leaf other = (Leaf) obj;
		if (value == null) {
			if (other.value != null) {
				return false;
			}
		} else if (!value.equals(other.value)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return value.toString();
	}
	
	@Override
	public Composite getParent() {
		return parent;
	}
	
	public void setParent(Composite parent) {
		this.parent = parent;
	}

	@Override
	public void setChild(int index, Component component) {
		System.out.println("I am a Leaf. I don't have any children");
	}
}