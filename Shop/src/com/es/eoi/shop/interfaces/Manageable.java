package com.es.eoi.shop.interfaces;

public interface Manageable<Type> {

	public void save(Type object);
	public void delete(Type object);
	public void modify(Type object);
	public void list();
	public Type find(int number);
	
}
