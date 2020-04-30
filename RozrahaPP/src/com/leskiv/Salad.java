package com.leskiv;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.leskiv.comparators.CaloriesComparator;
import com.leskiv.comparators.NameComparator;
import com.leskiv.comparators.WeightComparator;

public class Salad implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	List<Vegetable> salad = new ArrayList<Vegetable>();

	public Salad() {
		name = "Без назви";
	}
	
	public List<Vegetable> getSalad() {
		return salad;
	}
	
	public void setSalad(List<Vegetable> salad) {
		this.salad = salad;
	}
	
	public String getName() {
		return name;
	}

	public Salad setName(String name) {
		this.name = name;
		return this;
	}
	
	public void addComponent(Vegetable v) {
		this.salad.add(v);
	}

	public int saladCalories() {
		int v = 0;
		for (Vegetable c : salad) {
			v += Math.round((double) c.getWeight() * c.getCalories() / 100);
		}
		return v;
	}
	
	public void showRecipe() {
		System.out.println("Салат " + name + " містить:");
		for (Vegetable vegetable : salad) {
			System.out.println(vegetable.toString());
		}
		System.out.println("Салат містить: " + saladCalories() + " калорій");
	}
	
	public void sortIngredientsByCalories() {
		Collections.sort(salad, new CaloriesComparator());
	}
	
	public void sortIngredientsByWeight() {
		Collections.sort(salad, new WeightComparator());
	}
	
	public void sortIngredientsByName() {
		Collections.sort(salad, new NameComparator());
	}
	
	public void LimitInCalories(Scanner scanner) {
		int calories;
		int lowLimit;
		int upLimit;
		
		System.out.println("Ведіть спочатку менше значення діапазону а потім більше");
		lowLimit = scanner.nextInt();
		upLimit = scanner.nextInt();
		System.out.println("Інгрідієнти в діапазоні з ["+ lowLimit + ", " + upLimit + "]");
		
		for (Vegetable vegetable : salad) {
			calories = vegetable.getCalories();
			if (calories >= lowLimit && calories <= upLimit) {
				System.out.println(vegetable.getName() + ", "
						+ vegetable.getCalories() + " каллорій");
			}
		}
	}
}
