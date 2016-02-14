package com.hotel.price;

import javax.ejb.Remote;

@Remote
public interface PriceServiceRemote {
	public double getPrice(String type);
}
