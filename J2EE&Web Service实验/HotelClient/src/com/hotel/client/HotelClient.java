package com.hotel.client;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.hotel.orderprocess.*;

public class HotelClient {	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HotelorderProcessService service = new HotelorderProcessService();
		HotelorderProcess hotelOrderProcess = service.getHotelorderProcessPort();
		String type = null;
		int number = 0;
		System.out.println("Please input type of room(single OR double OR suites):");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			type = br.readLine();
			//System.out.println(type);
			System.out.println("Please input ordering number of room:");
			number = Integer.parseInt(br.readLine());
			//System.out.println(number);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HotelorderProcessRequest request = new HotelorderProcessRequest();
		request.setType(type);
		request.setNumber(number);
		HotelorderProcessResponse response = hotelOrderProcess.process(request);
		String order = response.getResult();
		//System.out.println(order);
		String[] result = order.split(":");
		System.out.println("Room Ordered:"+
				"\n\tOrderID:"+result[0]+
				"\n\tType:"+result[1]+
				"\n\tPrice:"+result[2]+
				"\n\tNumber:"+result[3]+
				"\n\tTotal:"+result[4]);		
	}

}
