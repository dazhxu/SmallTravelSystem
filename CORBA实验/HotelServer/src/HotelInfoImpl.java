import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import HotelInfoApp.*;
import HotelInfoApp.HotelInfoPackage.*;

public class HotelInfoImpl extends HotelInfoPOA{
	Connection conn;
	Statement statement,statement2;
	
	public HotelInfoImpl() {
		// TODO Auto-generated constructor stub
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/hotelinfo?characterEncoding=utf8";
		String user = "root";
		String passwd = "123456";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, passwd);
			if(!conn.isClosed()){
				System.out.println("Success Connect!");
			}
			statement = conn.createStatement();	
			statement2 = conn.createStatement();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Connection failed!");
		}
	}

	
	@Override
	public HotelItem[] getHotelInfo(String dest, String inData, String outData,
			String type,String user) {
		// TODO Auto-generated method stub
		HotelItem[] hotelItems = new HotelItem[100];
		String sql = "";
		if(inData != null && !inData.equalsIgnoreCase("") 
				&& outData != null && !outData.equalsIgnoreCase("")){
			try {
				sql = "SELECT * FROM hotel WHERE Destination = '"+dest+"' AND Type = '"+type+"' "
						+ "AND Date >= '"+inData+"' AND Date < '"+outData
						+"' ORDER BY Name,Date";
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				sql = "SELECT * FROM hotel WHERE Destination = '"+dest+"' AND Type = '"+type
						+"' ORDER BY Name,Date";
			}
		} else {
			sql = "SELECT * FROM hotel WHERE Destination = '"+dest+"' AND Type = '"+type
					+"' ORDER BY Name,Date";
			//sql = "SELECT * FROM hotel WHERE ID = 101";
		}
		
		ResultSet rs;
		int i = 0;
		try {
			//sql = new String(sql.getBytes(), "UTF-8");	
			//System.out.println(dest+"	"+inData+"	"+outData+"	"+type);
			//System.out.println(sql);
			
			rs = statement.executeQuery(sql);
					
			while (rs.next()) {
				hotelItems[i++] = new HotelItem(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4),rs.getInt(5), rs.getInt(6),rs.getString(7));
				/*System.out.println(hotelItems[i].Id+" "+hotelItems[i].Destination+" "+hotelItems[i].Name+
						" "+hotelItems[i].Type+" "+hotelItems[i].price+" "
						+hotelItems[i].Remains+" "+hotelItems[i].date);*/
						
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//System.out.println("tiaomu: "+i);
		HotelItem[] hotelItems2 = new HotelItem[i];
		for(int j=0;j<i;j++)
		{
			hotelItems2[j]= hotelItems[j];
			/*
			System.out.println(hotelItems2[j].Id+" "+hotelItems2[j].Destination+" "+hotelItems2[j].Name+
					" "+hotelItems2[j].Type+" "+hotelItems2[j].price+" "
					+hotelItems2[j].Remains+" "+hotelItems2[j].date);
					*/
		}
		return hotelItems2;
	}


	@Override
	public int orderHotel(int id, String dest, String name, String Date,
			String type, int num,String user) {
		// TODO Auto-generated method stub
		String sql = "UPDATE hotel SET Remains = Remains - "+num+" WHERE ID = "+id;
		String sql2 = "INSERT INTO `order` ( HID, Number,Time) VALUES ( "+id+", "+num+", utc_timestamp() )";
		//System.out.println(sql);
		//System.out.println(sql2);
		
		try {
			statement.execute(sql);
			statement.execute(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		return 1;
	}


	@Override
	public HotelItem[] getOrderInfo(String user) {
		// TODO Auto-generated method stub
		HotelItem[] hotelItems = new HotelItem[100];
		String sql = "SELECT * FROM order WHERE User = '"+user+"'";
		ResultSet rs,rs2;
		int i = 0;
		try {
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				String sql2 = "SELECT * FROM hotel where ID = "+rs.getInt(2);
				rs2 = statement2.executeQuery(sql2);
				if(rs2.next())
				{
					hotelItems[i++] = new HotelItem(rs2.getInt(1), rs2.getString(2),
							rs2.getString(3), rs2.getString(4),rs2.getInt(5), rs.getInt(4),rs2.getString(7));
				}
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		HotelItem[] hotelItems2 = new HotelItem[i];
		for(int j=0;j<i;j++)
		{
			hotelItems2[j]= hotelItems[j];
			/*
			System.out.println(hotelItems2[j].Id+" "+hotelItems2[j].Destination+" "+hotelItems2[j].Name+
					" "+hotelItems2[j].Type+" "+hotelItems2[j].price+" "
					+hotelItems2[j].Remains+" "+hotelItems2[j].date);
					*/
		}
		return hotelItems2;
	}


}
