package com.zuper.tsa.springmvc;

public class Eye {
	private String color;
	private Integer size;

	public Eye() {
		super();
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Eye [color=" + color + ", size=" + size + "]";
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}
}
