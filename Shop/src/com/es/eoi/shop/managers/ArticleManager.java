package com.es.eoi.shop.managers;

import com.es.eoi.shop.entities.Article;
import com.es.eoi.shop.entities.Warehouse;
import com.es.eoi.shop.interfaces.Manageable;

public class ArticleManager implements Manageable<Article> {

	private Warehouse warehouse;

	public ArticleManager(Warehouse warehouse) {
		super();
		this.warehouse = warehouse;
	}

	@Override
	public void save(Article newArticle) {

		int counter = 0;

		for (Article article : warehouse.getArticles()) {

			if (article == null) {
				article = newArticle;
				article.setCode(counter);
				warehouse.getArticles()[counter] = article;
				break;
			}
			counter++;
		}
	}

	@Override
	public void delete(Article deleteArticle) {

		int counter = 0;
		for (Article article : warehouse.getArticles()) {

			if (article.equals(deleteArticle)) {
				warehouse.getArticles()[counter]= null;
				break;
			}
			counter++;
		}

	}

	@Override
	public void modify(Article modifyArticle) {
		// TODO Auto-generated method stub

	}

	@Override
	public void list() {
		for (Article article : warehouse.getArticles()) {
			if (article != null) {
				System.out.println(article);
			}
		}
	}

	@Override
	public Article find(int number) {
		Article article = warehouse.getArticles()[number];
		return article;
	}

}
