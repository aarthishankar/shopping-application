package com.saproject.onlineshop.dao;

import java.util.List;
import com.saproject.onlineshop.entity.Product;
import com.saproject.onlineshop.entity.ProductCart;

public interface ProductDAO 
{
	public int saveNewProduct(Product product);
	public boolean doesProductExists(Product product);
	public int saveImage(String productId,String path);
	public boolean deleteProduct(String productId);
	public List<Product> viewProducts();
	public int getProductPriceForId(String productId);
	public int getProductQuantityForId(String productId);
	public boolean checkProductAddedInCart(String productId);
	public int saveProductToCart(ProductCart productCart);
	public int updateProductToCart(ProductCart productCart);
	public boolean deleteProductFromCart(String productId);
	public List<ProductCart> viewProductsCart();
	public boolean checkIsProductsCartEmpty();
	public int updateProduct(Product product);
}
