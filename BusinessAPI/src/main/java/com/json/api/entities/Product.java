package com.json.api.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "products")
@Proxy(lazy = false)
public class Product 
{
	@Id
	private int id;
	@Override
	public String toString() {
		return "Product [id=" + id + ", product_category=" + product_category + ", product_label=" + product_label
				+ ", downloadURL=" + downloadURL + ", weight=" + weight + "]";
	}
	private int product_category;
	private String product_label;
	private String downloadURL;
	private String weight;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProduct_category() {
		return product_category;
	}
	public void setProduct_category(int product_category) {
		this.product_category = product_category;
	}
	public String getProduct_label() {
		return product_label;
	}
	public void setProduct_label(String product_label) {
		this.product_label = product_label;
	}
	public String getDownloadURL() {
		return downloadURL;
	}
	public void setDownloadURL(String downloadURL) {
		this.downloadURL = downloadURL;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	public Product()
	{
		
	}
	public Product(int id, int product_category, String product_label, String downloadURL, String weight)
	{
		this.id = id;
		this.product_category = product_category;
		this.product_label = product_label;
		this.downloadURL = downloadURL;
		this.weight = weight;
	}
	public Product Product(Product product)
	{
		return new Product(product.getId(), product.getProduct_category(), product.getProduct_label(), product.getDownloadURL(), product.getDownloadURL());
	}
}
