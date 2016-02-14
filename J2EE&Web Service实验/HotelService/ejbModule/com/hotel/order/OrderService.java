package com.hotel.order;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;




/**
 * Session Bean implementation class OrderService
 */
@Stateless
@Remote({OrderServiceRemote.class})
@WebService
public class OrderService implements OrderServiceRemote {

	private File orderFile = new File("./order.txt");;
	private BufferedWriter out;
    /**
     * Default constructor. 
     */
    public OrderService() {
        // TODO Auto-generated constructor stub
    		try {
    			out = new BufferedWriter(new FileWriter(orderFile));
    			out.write("OrderID:Type:Price:Number:Total\n");
    			out.flush();
    			out.close();
    		} catch (Exception e) {
    			// TODO: handle exception
    			e.printStackTrace();
    		}
    }

	@Override
	public String createOrder(String type, double price, int num) {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String orderID = format.format(new Date());
		double total = price*num;
		String orderItem = orderID+":"+type+":"+price+":"+num+":"+total;
		try {
			orderFile.createNewFile();
			out = new BufferedWriter(new FileWriter(orderFile));
			out.write(orderItem+"\n");
			out.flush();
			out.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return orderItem;
	}

	@Override
	public String getOrder(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
