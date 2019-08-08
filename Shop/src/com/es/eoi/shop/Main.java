package com.es.eoi.shop;

import com.es.eoi.shop.entities.Article;
import com.es.eoi.shop.entities.Warehouse;
import com.es.eoi.shop.managers.ArticleManager;
import com.es.eoi.shop.utils.ArticleFactory;
import com.es.eoi.shop.views.Menu;

public class Main {

	public static Warehouse warehouse;
	public static ArticleManager articleManager;

	public static void main(String[] args) {

		initWarehouse();

		Menu.printMainMenu();

	}

	public static void initWarehouse() {

		warehouse = new Warehouse(100);
		articleManager = new ArticleManager(warehouse);

		Article article = null;
		for (int i = 0; i < 5; i++) {
			article = ArticleFactory.getArticle("textil");
			article.setCode(i);
			warehouse.getArticles()[i] = article;
		}
		for (int i = 5; i < 10; i++) {
			article = ArticleFactory.getArticle("alimentacion");
			article.setCode(i);
			warehouse.getArticles()[i] = article;
		}

	}

}
