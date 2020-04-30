package com.leskiv.fileReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.leskiv.ChiefCook;
import com.leskiv.option.Options;

public class Serializabl {

	public static void Save(ChiefCook chief) {
	try(ObjectOutputStream oos =
			new ObjectOutputStream(
					new FileOutputStream(
							new File("save.save")))){
		oos.writeObject(chief);
		Options.options(chief);
	}catch(IOException e) {
		e.printStackTrace();
	}
	
		
	}
	public static void readFile() {
		try(ObjectInputStream ois =
				new ObjectInputStream(
						new FileInputStream(
								new File("save.save")))){
			try {
				ChiefCook chief =(ChiefCook) ois.readObject();
				Options.options(chief);
			} catch (ClassNotFoundException e) {
				System.out.println("У файл нічого незаписано");
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
