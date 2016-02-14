import javax.xml.bind.DataBindingException;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import HotelInfoApp.*;
import HotelInfoApp.HotelInfoPackage.*;

public class HotelServer {
	
	public HotelServer() throws Exception {
		// TODO Auto-generated constructor stub
		String args[] = new String[2];
		args[0] = "-ORBInitialPort";
		args[1] = "1050";
		
		java.util.Properties p = new java.util.Properties();  
		p.setProperty("com.sun.CORBA.codeset.charsets", "0x05010001, 0x00010109"); // UTF-8, UTF-16  
		p.setProperty("com.sun.CORBA.codeset.wcharsets", "0x00010109, 0x05010001"); // UTF-16, UTF-8 
		ORB orb = ORB.init(args, p);
		System.out.println("开始初始化ORB!");
		
		org.omg.CORBA.Object obj = orb.resolve_initial_references("RootPOA");
		System.out.println("取根POA引用");
		
		
		POA rootPoa = POAHelper.narrow(obj);
		rootPoa.the_POAManager().activate();
		
		HotelInfoImpl hotelInfoImpl = new HotelInfoImpl();
		/*HotelItem[] hotelItems = new HotelItem[100];
		hotelItems = hotelInfoImpl.getHotelInfo("1", "2", "3", "4");
		int i=0;
		while(hotelItems[i] != null){
			System.out.println(hotelItems[i].Id+" "+hotelItems[i].Destination+" "+hotelItems[i].Name+
					" "+hotelItems[i].Type+" "+hotelItems[i].price+" "+hotelItems[i].Remains);
			i++;
		}
		System.out.println(i);
		*/
		System.out.println("创建一个接口的实例!");
		
		org.omg.CORBA.Object ref = rootPoa.servant_to_reference(hotelInfoImpl);
		HotelInfo href = HotelInfoHelper.narrow(ref);
		System.out.println("从服务中提取对象的引用");
		
		org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
		NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
		System.out.println("得到根名称的上下文!");
		
		String name = "HotelInfo";
		NameComponent path[] = ncRef.to_name(name);
		ncRef.rebind(path, href);
		System.out.println("在根名称的上下文绑定实例对象!");
		System.out.println("启动线程服务等待客户端调用!");
		orb.run();
		
	}
	
	public static void main(String args[]){
		try {
			HotelServer server = new HotelServer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
