package com.hotel.remains;


import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;


/**
 * Session Bean implementation class RemainsService
 */
@Stateless
@Remote({RemainsServiceRemote.class})
@WebService
public class RemainsService implements RemainsServiceRemote {

	private static int singleRemains = 100;
	private static int doubleRemains = 80;
	private static int suitesRemains = 50;
    /**
     * Default constructor. 
     */
    public RemainsService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int getRemains(String type) {
		// TODO Auto-generated method stub
		if(type.equalsIgnoreCase("single"))
			return singleRemains;
		if(type.equalsIgnoreCase("double"))
			return doubleRemains;
		if(type.equalsIgnoreCase("suites"))
			return suitesRemains;
		return 0;
	}

	@Override
	public boolean setRemains(String type, int num) {
		// TODO Auto-generated method stub
		if(type.equalsIgnoreCase("single")&&(singleRemains >= num)){
			singleRemains -= num;
			return true;
		}
		if(type.equalsIgnoreCase("double")&&(doubleRemains >= num)){
			doubleRemains -= num;
			return true;
		}
		if(type.equalsIgnoreCase("suites")&&(suitesRemains >= num)){
			suitesRemains -= num;
			return true;
		}
		
		return false;
	}

}
