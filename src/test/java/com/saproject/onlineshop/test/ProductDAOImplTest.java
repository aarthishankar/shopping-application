package com.saproject.onlineshop.test;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.saproject.onlineshop.dao.impl.ProductDAOImpl;
import com.saproject.onlineshop.entity.Product;
import com.saproject.onlineshop.entity.ProductCart;

public class ProductDAOImplTest {

	int intResult;
	boolean booleanResult;
	
	@Test
	public void test_saveNewProduct() {
		ProductDAOImpl productDAOImpl=new ProductDAOImpl();
		Product product=new Product();
		String productId="L100";
		product.setProductId(productId);
		product.setProductName("Test Laptop 100");
		product.setProductPrice(73456);
		product.setProductQuantity(54);
		String imagePath="C:\\Users\\somils\\workspace2\\OnlineShopProject\\src\\main\\webapp\\Image Resources\\Product Images\\code_"+product.getProductId()+".jpg";
		product.setProductImage(imagePath);
		intResult=productDAOImpl.saveNewProduct(product);
		productDAOImpl.deleteProduct(productId);
		Assert.assertEquals(1,intResult);
	}
	
	@Test
	public void test_doesProductExists() {
		ProductDAOImpl productDAOImpl=new ProductDAOImpl();
		Product product=new Product();
		String productId="L100";
		product.setProductId(productId);
		product.setProductName("Test Laptop 100");
		product.setProductPrice(73456);
		product.setProductQuantity(54);
		String imagePath="C:\\Users\\somils\\workspace2\\OnlineShopProject\\src\\main\\webapp\\Image Resources\\Product Images\\code_"+product.getProductId()+".jpg";
		product.setProductImage(imagePath);
		productDAOImpl.saveNewProduct(product);
		booleanResult=productDAOImpl.doesProductExists(product);
		productDAOImpl.deleteProduct(productId);
		Assert.assertEquals(true,booleanResult);
	}
	
	@Test
	public void test_deleteProduct() {
		ProductDAOImpl productDAOImpl=new ProductDAOImpl();
		Product product=new Product();
		String productId="L100";
		product.setProductId(productId);
		product.setProductName("Test Laptop 100");
		product.setProductPrice(73456);
		product.setProductQuantity(54);
		String imagePath="C:\\Users\\somils\\workspace2\\OnlineShopProject\\src\\main\\webapp\\Image Resources\\Product Images\\code_"+product.getProductId()+".jpg";
		product.setProductImage(imagePath);
		productDAOImpl.saveNewProduct(product);
		booleanResult=productDAOImpl.deleteProduct(productId);
		Assert.assertEquals(true,booleanResult);
	}
	
	@Test
	public void test_getProductPriceForId() {
		ProductDAOImpl productDAOImpl=new ProductDAOImpl();
		Product product=new Product();
		String productId="L100";
		product.setProductId(productId);
		product.setProductName("Test Laptop 100");
		product.setProductPrice(73456);
		product.setProductQuantity(54);
		String imagePath="C:\\Users\\somils\\workspace2\\OnlineShopProject\\src\\main\\webapp\\Image Resources\\Product Images\\code_"+product.getProductId()+".jpg";
		product.setProductImage(imagePath);
		productDAOImpl.saveNewProduct(product);
		intResult=productDAOImpl.getProductPriceForId(productId);
		productDAOImpl.deleteProduct(productId);
		Assert.assertEquals(73456,intResult);
	}
	
	@Test
	public void test_getProductQuantityForId() {
		ProductDAOImpl productDAOImpl=new ProductDAOImpl();
		Product product=new Product();
		String productId="L100";
		product.setProductId(productId);
		product.setProductName("Test Laptop 100");
		product.setProductPrice(73456);
		product.setProductQuantity(54);
		String imagePath="C:\\Users\\somils\\workspace2\\OnlineShopProject\\src\\main\\webapp\\Image Resources\\Product Images\\code_"+product.getProductId()+".jpg";
		product.setProductImage(imagePath);
		productDAOImpl.saveNewProduct(product);
		intResult=productDAOImpl.getProductQuantityForId(productId);
		productDAOImpl.deleteProduct(productId);
		Assert.assertEquals(54,intResult);
	}

	@Test
	public void test_updateProduct() {
		ProductDAOImpl productDAOImpl=new ProductDAOImpl();
		Product product=new Product();
		String productId="L100";
		product.setProductId(productId);
		product.setProductName("Test Laptop 100");
		product.setProductPrice(73456);
		product.setProductQuantity(54);
		String imagePath="C:\\Users\\somils\\workspace2\\OnlineShopProject\\src\\main\\webapp\\Image Resources\\Product Images\\code_"+product.getProductId()+".jpg";
		product.setProductImage(imagePath);
		productDAOImpl.saveNewProduct(product);
		product.setProductQuantity(55);
		intResult=productDAOImpl.updateProduct(product);
		productDAOImpl.deleteProduct(productId);
		Assert.assertEquals(1,intResult);
	}
	
	@Test
	public void test_viewProducts() {
		ProductDAOImpl productDAOImpl=new ProductDAOImpl();
		Product product=new Product();
		String productId="L100";
		product.setProductId(productId);
		product.setProductName("Test Laptop 100");
		product.setProductPrice(73456);
		product.setProductQuantity(54);
		String imagePath="C:\\Users\\somils\\workspace2\\OnlineShopProject\\src\\main\\webapp\\Image Resources\\Product Images\\code_"+product.getProductId()+".jpg";
		product.setProductImage(imagePath);
		productDAOImpl.saveNewProduct(product);
		List<Product> pCart=null;
		pCart=productDAOImpl.viewProducts();
		if(pCart.isEmpty())
			booleanResult=false;
		else
			booleanResult=true;
		productDAOImpl.deleteProduct(productId);
		Assert.assertEquals(true,booleanResult);
	}
	
	@Test
	public void test_saveProductToCart() {
		ProductDAOImpl productDAOImpl=new ProductDAOImpl();
		ProductCart productCart=new ProductCart();
		String productId="L100";
		productCart.setProductId(productId);
		productCart.setProductName("Test Laptop 100");
		productCart.setProductPrice(73456);
		productCart.setProductQuantity(4);
		intResult=productDAOImpl.saveProductToCart(productCart);
		productDAOImpl.deleteProductFromCart(productId);
		Assert.assertEquals(1,intResult);
	}
	
	@Test
	public void test_deleteProductToCart() {
		ProductDAOImpl productDAOImpl=new ProductDAOImpl();
		ProductCart productCart=new ProductCart();
		String productId="L100";
		productCart.setProductId(productId);
		productCart.setProductName("Test Laptop 100");
		productCart.setProductPrice(73456);
		productCart.setProductQuantity(4);
		productDAOImpl.saveProductToCart(productCart);
		booleanResult=productDAOImpl.deleteProductFromCart(productId);
		Assert.assertEquals(true,booleanResult);
	}
	
	@Test
	public void test_updateProductToCart() {
		ProductDAOImpl productDAOImpl=new ProductDAOImpl();
		ProductCart productCart=new ProductCart();
		String productId="L100";
		productCart.setProductId(productId);
		productCart.setProductName("Test Laptop 100");
		productCart.setProductPrice(73456);
		productCart.setProductQuantity(4);
		productDAOImpl.saveProductToCart(productCart);
		productCart.setProductQuantity(5);
		intResult=productDAOImpl.updateProductToCart(productCart);
		productDAOImpl.deleteProductFromCart(productId);
		Assert.assertEquals(1,intResult);
	}
	
	@Test
	public void test_checkProductAddedInCart() {
		ProductDAOImpl productDAOImpl=new ProductDAOImpl();
		ProductCart productCart=new ProductCart();
		String productId="L100";
		productCart.setProductId(productId);
		productCart.setProductName("Test Laptop 100");
		productCart.setProductPrice(73456);
		productCart.setProductQuantity(4);
		productDAOImpl.saveProductToCart(productCart);
		booleanResult=productDAOImpl.checkProductAddedInCart(productId);
		productDAOImpl.deleteProductFromCart(productId);
		Assert.assertEquals(true,booleanResult);
	}
	
	@Test
	public void test_checkIsProductsCartEmpty() {
		ProductDAOImpl productDAOImpl=new ProductDAOImpl();
		ProductCart productCart=new ProductCart();
		String productId="L100";
		productCart.setProductId(productId);
		productCart.setProductName("Test Laptop 100");
		productCart.setProductPrice(73456);
		productCart.setProductQuantity(4);
		productDAOImpl.saveProductToCart(productCart);
		booleanResult=productDAOImpl.checkIsProductsCartEmpty();
		productDAOImpl.deleteProductFromCart(productId);
		Assert.assertEquals(false,booleanResult);
	}
	
	@Test
	public void test_viewProductsCart() {
		ProductDAOImpl productDAOImpl=new ProductDAOImpl();
		ProductCart productCart=new ProductCart();
		String productId="L100";
		productCart.setProductId(productId);
		productCart.setProductName("Test Laptop 100");
		productCart.setProductPrice(73456);
		productCart.setProductQuantity(4);
		productDAOImpl.saveProductToCart(productCart);
		List<ProductCart> pCart=null;
		pCart=productDAOImpl.viewProductsCart();
		if(pCart.isEmpty())
			booleanResult=false;
		else
			booleanResult=true;
		productDAOImpl.deleteProductFromCart(productId);
		Assert.assertEquals(true,booleanResult);
	}
	
	
	
}
