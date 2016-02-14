import java.awt.event.ItemEvent;
import java.util.ArrayList;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.*;

import HotelInfoApp.HotelInfo;
import HotelInfoApp.HotelInfoHelper;
import HotelInfoApp.HotelInfoPackage.HotelItem;



public class HotelClient {
	public static HotelInfo hotelInfo;
	
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
		String name = "HotelInfo";
		
		try {
			hotelInfo = HotelInfoHelper.narrow(neRef.resolve_str(name));
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
	
	public ArrayList<HotelItem> dealHotelInfo(String destination, String inData,
			String outData, String type,String user) {				
		// TODO Auto-generated method stub
		ArrayList<HotelItem> arrayList = new ArrayList<HotelItem>();
		HotelItem[] hotelItems = new HotelItem[100];
		hotelItems = hotelInfo.getHotelInfo(destination, inData, outData, type,user);
		System.out.println(hotelItems.length);
		int i = 0;
		while(i<hotelItems.length){			
			arrayList.add(hotelItems[i]);
			i++;
		}
		
		/*for(HotelItem h : arrayList){
			System.out.println(h.Id+" "+h.Destination+" "+h.Name+
					" "+h.Type+" "+h.price+" "+h.Remains);
		}
		*/
		return arrayList;
		
	}

	public int order(int id, String destination, String hotelName,
			String type, String date,int num,String user) {
		// TODO Auto-generated method stub
		System.out.println(id+" "+destination+" "+hotelName+" "+type+" "+date+" "+num);
		int order = hotelInfo.orderHotel(id, destination, hotelName, date, type, num,user);
		return order;
		
	}

	public ArrayList<HotelItem> getOrder(String user) {
		// TODO Auto-generated method stub
		ArrayList<HotelItem> arrayList = new ArrayList<HotelItem>();
		HotelItem[] hotelItems = new HotelItem[100];
		hotelItems = hotelInfo.getOrderInfo(user);
		System.out.println(hotelItems.length);
		int i = 0;
		while(i<hotelItems.length){			
			arrayList.add(hotelItems[i]);
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
