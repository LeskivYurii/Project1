package com.leskiv.fileReader;
import java.io.*;

import java.util.Scanner;

import com.leskiv.ChiefCook;
import com.leskiv.Salad;
import com.leskiv.Vegetable;
import com.leskiv.option.Options;

public class InfoFileReader {
	
	public static void readFile(Scanner scanner) throws IOException {
		String fileName;
		Salad salad = new Salad();
		ChiefCook chiefCook = new ChiefCook();
		System.out.println("Ведіть назву файла з розширеням txt");
		fileName = scanner.next();
		FileReader file = new FileReader(fileName);
		Scanner fileScanner = new Scanner(file);
		chiefCook.setName(fileScanner.nextLine());
		salad.setName(fileScanner.nextLine());
		while(fileScanner.hasNextLine()) {
			addFileIngridient(salad,fileScanner);
		}
		chiefCook.setSalad(salad);
		file.close();
		fileScanner.close();
		Options.options(chiefCook);
		
	}
	private static void addFileIngridient(Salad salad,Scanner scanner) {
		Vegetable vegetable = new Vegetable();
		vegetable.setName(scanner.nextLine());
		vegetable.setWeight(Integer.parseInt(scanner.nextLine()));
		vegetable.setCalories(Integer.parseInt(scanner.nextLine()));
		salad.addComponent(vegetable);
	}
}
