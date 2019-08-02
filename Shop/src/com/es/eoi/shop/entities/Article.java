package com.es.eoi.shop.entities;

import com.es.eoi.shop.interfaces.Prizable;

public class  Article implements Prizable {
	
	private String name;
	private String description;
	private double vat;
	private double price;
	private String provider;
	private int stock;
	private String category;
	private int code;
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	private static final Double DEFAULT_VAT=1.21;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		this.vat = vat;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public static Double getDefaultVat() {
		return DEFAULT_VAT;
	}

	@Override
	public Double getTotalPrice() {
		return price*DEFAULT_VAT;
	}
	
	@Override
	public String toString() {
		return "Código: "+code+" | Nombre: "+name+" | Precio: "+price+" | Categoría: "+category;
	}

}
