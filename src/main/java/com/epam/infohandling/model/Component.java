package com.epam.infohandling.model;

public interface Component {
	
	int childrenCount();
	
	boolean isLeaf();
	Object getValue();
	void operation();
	void add(Component component);
	void remove(Component component);
	Object getChild (int index);
	String getName();
}
