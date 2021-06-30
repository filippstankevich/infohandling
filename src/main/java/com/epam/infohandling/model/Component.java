package com.epam.infohandling.model;

public interface Component {
	
	int childrenCount();
	boolean isLeaf();
	Object getValue();
	void add(Component component);
	void remove(Component component);
	Object getChild (int index);
	String getName();
	Composite getParent();
	void setParent(Composite parent);
	void setChild(int index, Component component);
}
