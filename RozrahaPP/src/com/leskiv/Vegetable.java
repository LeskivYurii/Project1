package com.leskiv;

import java.io.Serializable;

public class Vegetable implements Serializable  {

	private static final long serialVersionUID = 1L;
	private String name;
	private int calories;
	private int weight;
	
	public Vegetable(){
		
	}
	
	public Vegetable(String name, int calories, int weight) {
		super();
		this.name = name;
		this.calories=calories;
		this.weight = weight;
	}
	 
	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return name + " містить "+ calories+" калорій, вага якого складає "+ weight+" грамів";
	}
	
	
}
