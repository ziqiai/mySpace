package com.demo.model;

public class Item {
	private int product_id;
	private int quantity;
	private String image;

	public Item() {

	}

	public Item(int product_id, int quantity, String image) {
		super();
		this.product_id = product_id;
		this.quantity = quantity;
		this.image = image;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Item [product_id=" + product_id + ", quantity=" + quantity + ", image=" + image + "]";
	}

}
