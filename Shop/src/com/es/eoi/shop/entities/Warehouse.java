package com.es.eoi.shop.entities;

public class Warehouse {

	private Article[] articles;

	public Warehouse(int size) {
		this.articles = new Article[size];
	}

	public Article[] getArticles() {
		return articles;
	}

	public void setArticles(Article[] articles) {
		this.articles = articles;
	}

	public Article getArticle(Integer code) {
		Article article = null;

		article = articles[code];

		return article;
	}

}
