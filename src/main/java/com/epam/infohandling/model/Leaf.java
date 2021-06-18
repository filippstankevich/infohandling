package com.epam.infohandling.model;

public class Leaf implements Component {
	
	private String value;
	private String name; 
	
	public Leaf(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	@Override
	public void operation() {
		System.out.println("Leaf -> Performing operation");
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
}