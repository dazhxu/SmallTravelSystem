package HotelInfoApp;


/**
* HotelInfoApp/HotelInfoPOA.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从HotelInfo.idl
* 2015年6月7日 星期日 上午09时21分56秒 CST
*/

public abstract class HotelInfoPOA extends org.omg.PortableServer.Servant
 implements HotelInfoApp.HotelInfoOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("getHotelInfo", new java.lang.Integer (0));
    _methods.put ("orderHotel", new java.lang.Integer (1));
    _methods.put ("getOrderInfo", new java.lang.Integer (2));
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
       case 0:  // HotelInfoApp/HotelInfo/getHotelInfo
       {
         String dest = in.read_string ();
         String inData = in.read_string ();
         String outData = in.read_string ();
         String type = in.read_string ();
         String user = in.read_string ();
         HotelInfoApp.HotelInfoPackage.HotelItem $result[] = null;
         $result = this.getHotelInfo (dest, inData, outData, type, user);
         out = $rh.createReply();
         HotelInfoApp.HotelInfoPackage.HotelSeqHelper.write (out, $result);
         break;
       }

       case 1:  // HotelInfoApp/HotelInfo/orderHotel
       {
         int id = in.read_long ();
         String dest = in.read_string ();
         String name = in.read_string ();
         String Date = in.read_string ();
         String type = in.read_string ();
         int num = in.read_long ();
         String user = in.read_string ();
         int $result = (int)0;
         $result = this.orderHotel (id, dest, name, Date, type, num, user);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 2:  // HotelInfoApp/HotelInfo/getOrderInfo
       {
         String user = in.read_string ();
         HotelInfoApp.HotelInfoPackage.HotelItem $result[] = null;
         $result = this.getOrderInfo (user);
         out = $rh.createReply();
         HotelInfoApp.HotelInfoPackage.HotelSeqHelper.write (out, $result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:HotelInfoApp/HotelInfo:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public HotelInfo _this() 
  {
    return HotelInfoHelper.narrow(
    super._this_object());
  }

  public HotelInfo _this(org.omg.CORBA.ORB orb) 
  {
    return HotelInfoHelper.narrow(
    super._this_object(orb));
  }


} // class HotelInfoPOA
