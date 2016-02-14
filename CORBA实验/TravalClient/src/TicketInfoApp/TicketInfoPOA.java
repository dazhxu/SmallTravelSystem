package TicketInfoApp;


/**
* TicketInfoApp/TicketInfoPOA.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从TicketInfo.idl
* 2015年6月7日 星期日 下午08时48分18秒 CST
*/

public abstract class TicketInfoPOA extends org.omg.PortableServer.Servant
 implements TicketInfoApp.TicketInfoOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("getTicketInfo", new java.lang.Integer (0));
    _methods.put ("orderTicket", new java.lang.Integer (1));
    _methods.put ("getTicketOrderInfo", new java.lang.Integer (2));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // TicketInfoApp/TicketInfo/getTicketInfo
       {
         String dept = in.read_string ();
         String dest = in.read_string ();
         String startTime = in.read_string ();
         String user = in.read_string ();
         TicketInfoApp.TicketInfoPackage.TicketItem $result[] = null;
         $result = this.getTicketInfo (dept, dest, startTime, user);
         out = $rh.createReply();
         TicketInfoApp.TicketInfoPackage.TicketSeqHelper.write (out, $result);
         break;
       }

       case 1:  // TicketInfoApp/TicketInfo/orderTicket
       {
         int id = in.read_long ();
         int num = in.read_long ();
         String user = in.read_string ();
         int $result = (int)0;
         $result = this.orderTicket (id, num, user);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 2:  // TicketInfoApp/TicketInfo/getTicketOrderInfo
       {
         String user = in.read_string ();
         TicketInfoApp.TicketInfoPackage.TicketItem $result[] = null;
         $result = this.getTicketOrderInfo (user);
         out = $rh.createReply();
         TicketInfoApp.TicketInfoPackage.TicketSeqHelper.write (out, $result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:TicketInfoApp/TicketInfo:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public TicketInfo _this() 
  {
    return TicketInfoHelper.narrow(
    super._this_object());
  }

  public TicketInfo _this(org.omg.CORBA.ORB orb) 
  {
    return TicketInfoHelper.narrow(
    super._this_object(orb));
  }


} // class TicketInfoPOA
