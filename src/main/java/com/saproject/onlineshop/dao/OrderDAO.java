package com.saproject.onlineshop.dao;

import java.util.List;
import com.saproject.onlineshop.entity.OrderDescription;

public interface OrderDAO 
{
		public int saveNewOrder(OrderDescription orderDescription);
		public boolean deleteAllProductFromCart();
		public boolean cancelOrderAndUpdateQuantities(int orderId,String productIds,String productQuantities);
		public boolean updateProductQuantitiesOnCancel(String productId,int productQuantity);
		public boolean orderAndUpdateQuantities(String productIds,String productQuantities);
		public boolean updateProductQuantitiesOnOrder(String productId,int productQuantity);
		public List<OrderDescription> viewOrders();
}
