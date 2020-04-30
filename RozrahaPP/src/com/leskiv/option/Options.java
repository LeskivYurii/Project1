package com.leskiv.option;

import java.io.IOException;
import java.util.Scanner;

import com.leskiv.ChiefCook;
import com.leskiv.Vegetable;
import com.leskiv.fileReader.InfoFileReader;
import com.leskiv.fileReader.Serializabl;

public class Options {
	public static void options(ChiefCook chief) {
	Scanner scanner = new Scanner(System.in);
	int choice = 0;
	Vegetable vegetable = null;
	
	System.out.println("Добрий день! Моє ім'я " +chief.getName() + " і сьогодні я буду вашим кухаром.");
	System.out.println("Що вам приготувати сьогодні?");
	
	while (choice != -1) {
		System.out.println("\nВиберіть один з варіантів:");
		System.out.println("1. Перейменувати салат");
		System.out.println("2. Показати рецепт салату");
		System.out.println("3. Додати інгредієнт до салатку");
		System.out.println("4. Посортувати інгредієнти по назві");
		System.out.println("5. Посортувати інгредієнти по калоріях");
		System.out.println("6. Посортувати інгредієнти по вазі");
		System.out.println("7. Вивести інгредієнти в заданому діапазоні");
		System.out.println("8. Записати в файл Serializable");
		System.out.println("9. Зчитати з файла Serializable");
		System.out.println("10. Зчитати з файла txt");
		System.out.println("0. Exit");
		choice = scanner.nextInt();
		if(choice > 11) {
			System.out.println("Такої опції в меню нема");
			scanner.nextInt();
			choice = -1;
		}
		
		switch(choice) {
		case 1:
			System.out.println("Ведіть назву вашого салату:");
			chief.getSalad().setName(scanner.next());
			break;
			
		case 2:
			chief.getSalad().showRecipe();
			break;
			
		case 3:
			vegetable = chief.getIngredient(scanner);
			if (vegetable != null) {
				chief.getSalad().addComponent(vegetable);
			}
			break;
			
		case 4:
			chief.getSalad().sortIngredientsByName();
			
		case 5:
			chief.getSalad().sortIngredientsByCalories();
			break;
			
		case 6:
			chief.getSalad().sortIngredientsByWeight();
			break;
			
		case 7:
			chief.getSalad().LimitInCalories(scanner);
			break;
			
		case 8:
			Serializabl.Save(chief);
			break;
			
		case 9:
			Serializabl.readFile();
			break;
		
		case 10:
			try {
				InfoFileReader.readFile(scanner);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 0:
			System.exit(0);
			break;
		default:
			break;
		}
	}
	
	scanner.close();
	}
}
