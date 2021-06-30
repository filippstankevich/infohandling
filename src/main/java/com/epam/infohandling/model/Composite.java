package com.epam.infohandling.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Composite implements Component {
	private static Logger logger = LogManager.getLogger();
	
	private List<Component> components = new ArrayList<Component>();
	private String name;
	private String value;
	private Composite parent; 
	
	public Composite(String name, String value) {
		this.name = name;
		this.value = value;
		logger.info("# composite was created #");
	}

	@Override
	public void add(Component component) {
		component.setParent(this);
		components.add(component);
	}

	@Override
	public void remove(Component component) {
		components.remove(component);
	}

	@Override
	public Object getChild(int index) {
		return components.get(index);
	}

	@Override
	public boolean isLeaf() {
		return false;
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
		int size = components.size();
		return size;
	}
	
	@Override
	public String toString() {
		return components.toString();
	}

	@Override
	public Composite getParent() {
		return parent;
	}

	@Override
	public void setParent(Composite parent) {
		this.parent = parent;
	}

	@Override
	public void setChild(int index, Component component) {
		components.set(index, component);
	}
}