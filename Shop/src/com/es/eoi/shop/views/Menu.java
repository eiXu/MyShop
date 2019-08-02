package com.es.eoi.shop.views;

import java.util.Scanner;

import com.es.eoi.shop.Main;
import com.es.eoi.shop.entities.Article;
import com.es.eoi.shop.entities.Electronics;
import com.es.eoi.shop.entities.Food;
import com.es.eoi.shop.entities.Textile;
import com.es.eoi.shop.utils.ArticleFactory;

public class Menu {

	@SuppressWarnings("resource")
	static Scanner scan = new Scanner(System.in);
	
	public static void printMainMenu() {
		System.out.println("Bienvenido a la tienda, introduce una opción:");
		System.out.println("1.- Comprar artículos");
		System.out.println("2.- Listar artículos");
		System.out.println("3.- Gestionar artículos");

		int option = scan.nextInt();

		System.out.println("Has elegido la opcion: " + option);

		switch (option) {
		case 1:

			break;
		case 2:
			Main.articleManager.list();
			break;
		case 3:
			printGestionMenu();
			break;
		}

		printMainMenu();
	}

	public static void printGestionMenu() {

		System.out.println("¿Cómo quieres gestionar los artículos?");
		System.out.println("1.- Agregar un artículo");
		System.out.println("2.- Borrar un artículo");
		System.out.println("3.- Modificar un artículo");

		int option = scan.nextInt();

		switch (option) {
		case 1:
			printAddArticleMenu();
			break;
		case 2:
			printDeleteArticleMenu();
			break;
		case 3:

			break;
		}
	}

	public static void printAddArticleMenu() {

		System.out.println("¿De qué tipo va a ser el nuevo Artículo?");
		System.out.println("1.- Textil");
		System.out.println("2.- Electrónico");
		System.out.println("3.- Alimentación");

		int option = scan.nextInt();
		Article article = null;

		switch (option) {
		case 1:
			article = ArticleFactory.getArticle("textil");
			article = printAddGeneral(article);
			article = printAddTextileMenu(article);
			break;
		case 2:
			article = ArticleFactory.getArticle("electronica");
			article = printAddGeneral(article);
			break;
		case 3:
			article = ArticleFactory.getArticle("alimentacion");
			article = printAddGeneral(article);
			article = printAddFoodMenu(article);
			break;
		}

		Main.articleManager.save(article);

	}
	
	public static Article printAddGeneral(Article article) {
		System.out.print("Introduce el nombre del artículo: ");
		String name = scan.next();
		article.setName(name);
		
		System.out.print("\nIntroduce la descripción del artículo: ");
		String description = scan.next();
		article.setDescription(description);
		
		System.out.print("\nIntroduce el precio del artículo: ");
		double price = scan.nextDouble();
		article.setPrice(price);
		
		System.out.print("\nIntroduce el proveedor del artículo: ");
		String provider = scan.next();
		article.setProvider(provider);
		return article;
	}
	
	public static Article printAddTextileMenu(Article article) {
		
		System.out.print("\nIntroduce el color del artículo: ");
		String colour = scan.next();
		((Textile)article).setColor(colour);
		
		System.out.print("\nIntroduce el tamaño del artículo: ");
		String size = scan.next();
		((Textile)article).setSize(size);
		
		return article;
	}
	
	public static Article printAddElectronicsMenu(Article article) {

		System.out.print("\nIntroduce la fecha de caducidad del artículo: ");
		String power = scan.next();
		((Electronics) article).setPower(power);

		System.out.print("\nIntroduce los alérgenos del artículo: ");
		double guarantee = scan.nextDouble();
		((Electronics)article).setGuarantee(guarantee);
		
		return article;
	}
	
	public static Article printAddFoodMenu(Article article) {
		
		System.out.print("\nIntroduce la fecha de caducidad del artículo: ");
		String expirationDate = scan.next();
		((Food)article).setExpirationDate(expirationDate);
		
		System.out.print("\nIntroduce los alérgenos del artículo: ");
		String allergens = scan.next();
		((Food)article).setAllergens(allergens);
		
		return article;
	}

	public static void printDeleteArticleMenu() {

		System.out.println("¿Qué artículo quieres borrar?");

		int toDeleteArticle = scan.nextInt();
		Article article = Main.articleManager.find(toDeleteArticle);

		if (article != null) {
			System.out.println("¿Quieres borrar el artículo \"" + article.getName() + "\" con código \""
					+ article.getCode() + "\"?");
			System.out.println("1.- Sí");
			System.out.println("2.- No");

			int option = scan.nextInt();

			if (option == 1) {
				Main.articleManager.delete(article);
			}
		}

	}

}
