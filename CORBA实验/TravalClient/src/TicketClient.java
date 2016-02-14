import java.awt.event.ItemEvent;
import java.util.ArrayList;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.*;

import HotelInfoApp.HotelInfoHelper;
import HotelInfoApp.HotelInfoPackage.HotelItem;
import TicketInfoApp.*;
import TicketInfoApp.TicketInfoPackage.*;

public class TicketClient {
	public static TicketInfo ticketInfo;
	
	static{
		System.out.println("客户端初始化配置开始！");
		String[] args = new String[4];
		args[0] = "-ORBInitialHost";
		args[1] = "127.0.0.1";
		args[2] = "-ORBInitialPort";
		args[3] = "1050";
		
		java.util.Properties p = new java.util.Properties();  
		p.setProperty("com.sun.CORBA.codeset.charsets", "0x05010001, 0x00010109"); // UTF-8, UTF-16  
		p.setProperty("com.sun.CORBA.codeset.wcharsets", "0x00010109, 0x05010001"); // UTF-16, UTF-8  		
		ORB orb = ORB.init(args, p);
		org.omg.CORBA.Object objRef = null;
		try {
			objRef = orb.resolve_initial_references("NameService");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		NamingContextExt neRef = NamingContextExtHelper.narrow(objRef);
		String name = "TicketInfo";
		
		try {
			ticketInfo = TicketInfoHelper.narrow(neRef.resolve_str(name));
		} catch (NotFound e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (CannotProceed e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (org.omg.CosNaming.NamingContextPackage.InvalidName e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
		System.out.println("客户端初始化完毕");
	}

	public ArrayList<TicketItem> dealTicketInfo(String departure,
			String destination, String startTime, String user) {
		// TODO Auto-generated method stub
		ArrayList<TicketItem> arrayList = new ArrayList<TicketItem>();
		TicketItem[] ticketItems = new TicketItem[100];
		ticketItems = ticketInfo.getTicketInfo(departure, destination, startTime, user);
		System.out.println(ticketItems.length);
		int i = 0;
		while(i<ticketItems.length){			
			arrayList.add(ticketItems[i]);
			i++;
		}
		
		/*for(HotelItem h : arrayList){
			System.out.println(h.Id+" "+h.Destination+" "+h.Name+
					" "+h.Type+" "+h.price+" "+h.Remains);
		}
		*/
		return arrayList;
	}

	public int order(int id, String name, String departure, String destination,
			String startTime, String stopTime, int price, int num, String user) {
		// TODO Auto-generated method stub
		int order = ticketInfo.orderTicket(id, num, user);
		return order;
	}

	public ArrayList<TicketItem> getOrder(String user) {
		// TODO Auto-generated method stub
		ArrayList<TicketItem> arrayList = new ArrayList<TicketItem>();
		TicketItem[] ticketItems = new TicketItem[100];
		ticketItems = ticketInfo.getTicketOrderInfo(user);
		System.out.println(ticketItems.length);
		int i = 0;
		while(i<ticketItems.length){			
			arrayList.add(ticketItems[i]);
			i++;
		}
		
		/*for(HotelItem h : arrayList){
			System.out.println(h.Id+" "+h.Destination+" "+h.Name+
					" "+h.Type+" "+h.price+" "+h.Remains);
		}
		*/
		return arrayList;
	}

}
