package com.hotel.order;

import javax.ejb.Remote;

@Remote
public interface OrderServiceRemote {

	public String createOrder(String type,double price,int num);
	public String getOrder(String orderID);
}
