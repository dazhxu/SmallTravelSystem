import java.sql.*;

import TicketInfoApp.TicketInfoPOA;
import TicketInfoApp.TicketInfoPackage.TicketItem;


public class TicketInfoImpl extends TicketInfoPOA{
	Connection conn;
	Statement statement,statement2;
	
	public TicketInfoImpl() {
		// TODO Auto-generated constructor stub
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/ticketinfo?characterEncoding=utf8";
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
	public TicketItem[] getTicketInfo(String dept, String dest,
			String startTime, String user) {
		// TODO Auto-generated method stub
		TicketItem[] ticketItems = new TicketItem[100];
		
		String sql = "";
		if (startTime == null || startTime.equals("")) {
			sql = "SELECT * FROM ticket WHERE Departure = '"+dept+"' AND Destination = '"+dest+"'";
		} else {
			sql = "SELECT * FROM ticket WHERE Departure = '"+dept+"' AND Destination = '"+dest
					+"' AND StartTime BETWEEN '"+startTime+" 00:00:00' AND '"+startTime+" 23:59:59'";
		}
		
		ResultSet rs;
		int i = 0;
		try {
			rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				ticketItems[i++] = new TicketItem(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		TicketItem[] ticketItems2 = new TicketItem[i];
		for(int j=0;j<i;j++){
			ticketItems2[j] = ticketItems[j];
			System.out.println(ticketItems2[j].Id+" "+ticketItems2[j].Name+" "+ticketItems2[j].Departure
					+" "+ticketItems2[j].Destination+" "+ticketItems2[j].StartTime+" "
					+ticketItems2[j].ArriveTime+" "+ticketItems2[j].Price+" "+ticketItems2[j].Remains);
		}
		
		return ticketItems2;
	}

	@Override
	public int orderTicket(int id, int num, String user) {
		// TODO Auto-generated method stub
		String sql = "UPDATE ticket SET Remains = Remains - "+num+" WHERE ID = "+id;
		String sql2 = "INSERT INTO `order` (TID, Num,Time) VALUES ( "+id+", "+num+", utc_timestamp() )";
		
		System.out.println(sql);
		System.out.println(sql2);
		
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
	public TicketItem[] getTicketOrderInfo(String user) {
		// TODO Auto-generated method stub
		TicketItem[] ticketItems = new TicketItem[100];
		String sql;
		if(user == null|| user.equalsIgnoreCase("")){
			sql = "SELECT * FROM `order` WHERE User = 'default'";
		}else{
			sql = "SELECT * FROM `order` WHERE User = '"+user+"'";
		}
		
		
		ResultSet rs,rs2;
		int i = 0;
		try {
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				String sql2 = "SELECT * FROM ticket where ID = "+rs.getInt(2);
				System.out.println(sql2);
				//int number = rs.getInt(3);
				rs2 = statement2.executeQuery(sql2);
				if(rs2.next())
				{
					ticketItems[i++] = new TicketItem(rs.getInt(1), rs2.getString(2),
							rs2.getString(3), rs2.getString(4),rs2.getString(5), rs2.getString(6),
							rs2.getInt(7),rs.getInt(3));
				}
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		TicketItem[] ticketItems2 = new TicketItem[i];
		for(int j=0;j<i;j++)
		{
			ticketItems2[j]= ticketItems[j];
			
			System.out.println(ticketItems2[j].Id+" "+ticketItems2[j].Name+" "+ticketItems2[j].Departure
					+" "+ticketItems2[j].Destination+" "+ticketItems2[j].StartTime+" "
					+ticketItems2[j].ArriveTime+" "+ticketItems2[j].Price+" "+ticketItems2[j].Remains);
					
		}
		return ticketItems2;

	}
	
	/*public static void main(String args[]){
		TicketInfoImpl ticketInfoImpl = new TicketInfoImpl();
		ticketInfoImpl.getTicketInfo("±±¾©", "Ìì½ò", "2015-06-01", "");
		//ticketInfoImpl.orderTicket(1, 2, ""); 
		ticketInfoImpl.getTicketOrderInfo("Default");
	}*/

}
