package com.epam.infohandling.model;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
	private List<Component> components = new ArrayList<Component>();
	private String name;
	private String value;
	
	public Composite(String name, String value) {
		this.name = name;
		this.value = value;
	}

	@Override
	public void operation() {
		//System.out.println("Composite -> Call children operations");
		int size = components.size();
		for (Component component : components) {
			component.operation();
		}
	}

	@Override
	public void add(Component component) {
		//System.out.println("Composite -> Adding component " + component.getName() + " " + component.getValue() );
		components.add(component);
	}

	@Override
	public void remove(Component component) {
		//System.out.println("Composite -> Removing component");
		components.remove(component);
	}

	@Override
	public Object getChild(int index) {
		//System.out.println("Composite -> Getting component");
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
}