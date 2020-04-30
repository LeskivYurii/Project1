package com.leskiv;
import java.io.Serializable;
import java.util.Scanner;

public class ChiefCook implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Salad salad;
	
	public ChiefCook() {
		name = "Юрій";
		salad = new Salad();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
	public Salad getSalad() {
		return salad;
	}

	public void setSalad(Salad salad) {
		this.salad = salad;
	}

	public Vegetable getIngredient(Scanner scanner) {
		String ingredientName;
		int weight;
		int calories;
		Vegetable vegetable;
		
		System.out.println("Ведіть назву овоча:");
		ingredientName = scanner.next();
		
		System.out.println("Ведіть вагу продукту (в грамах):");
		weight = scanner.nextInt();
		
		System.out.println("Ведіть кількість калорій на 100 грам");
		calories=scanner.nextInt();
		vegetable = new Vegetable(ingredientName,calories,weight);
		return vegetable;
	}
	
}