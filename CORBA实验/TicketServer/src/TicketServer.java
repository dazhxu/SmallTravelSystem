import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import TicketInfoApp.*;
import TicketInfoApp.TicketInfoPackage.*;

public class TicketServer {
	
	public TicketServer() throws Exception{
		// TODO Auto-generated constructor stub
		String args[] = new String[2];
		args[0] = "-ORBInitialPort";
		args[1] = "1050";
		
		java.util.Properties p = new java.util.Properties();  
		p.setProperty("com.sun.CORBA.codeset.charsets", "0x05010001, 0x00010109"); // UTF-8, UTF-16  
		p.setProperty("com.sun.CORBA.codeset.wcharsets", "0x00010109, 0x05010001"); // UTF-16, UTF-8 
		ORB orb = ORB.init(args, p);
		System.out.println("��ʼ��ʼ��ORB!");
		
		org.omg.CORBA.Object obj = orb.resolve_initial_references("RootPOA");
		System.out.println("ȡ��POA����");
		
		
		POA rootPoa = POAHelper.narrow(obj);
		rootPoa.the_POAManager().activate();
		
		TicketInfoImpl ticketInfoImpl = new TicketInfoImpl();
		System.out.println("����һ���ӿڵ�ʵ��!");
		
		org.omg.CORBA.Object ref = rootPoa.servant_to_reference(ticketInfoImpl);
		TicketInfo href = TicketInfoHelper.narrow(ref);
		System.out.println("�ӷ�������ȡ���������");
		
		org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
		NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
		System.out.println("�õ������Ƶ�������!");
		
		String name = "TicketInfo";
		NameComponent path[] = ncRef.to_name(name);
		ncRef.rebind(path, href);
		System.out.println("�ڸ����Ƶ������İ�ʵ������!");
		System.out.println("�����̷߳���ȴ��ͻ��˵���!");
		orb.run();
		
	}
	
	public static void main(String args[]){
		try {
			TicketServer server = new TicketServer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
