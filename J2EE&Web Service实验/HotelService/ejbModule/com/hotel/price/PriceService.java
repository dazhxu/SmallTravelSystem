package com.hotel.price;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 * Session Bean implementation class PriceService
 */
@Stateless
@Remote({PriceServiceRemote.class})
@WebService
public class PriceService implements PriceServiceRemote {

	private static final double singlePrice = 150;
	private static final double doublePrice = 300;
	private static final double suitesPrice = 500;
    /**
     * Default constructor. 
     */
    public PriceService() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public double getPrice(String type) {
		// TODO Auto-generated method stub
		if(type.equalsIgnoreCase("single"))
			return singlePrice;
		if(type.equalsIgnoreCase("double"))
			return doublePrice;
		if(type.equalsIgnoreCase("suites"))
			return suitesPrice;
		return 9999;
	}
    

}
