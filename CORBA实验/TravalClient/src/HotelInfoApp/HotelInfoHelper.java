package HotelInfoApp;


/**
* HotelInfoApp/HotelInfoHelper.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��HotelInfo.idl
* 2015��6��7�� ������ ����09ʱ21��56�� CST
*/

abstract public class HotelInfoHelper
{
  private static String  _id = "IDL:HotelInfoApp/HotelInfo:1.0";

  public static void insert (org.omg.CORBA.Any a, HotelInfoApp.HotelInfo that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static HotelInfoApp.HotelInfo extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (HotelInfoApp.HotelInfoHelper.id (), "HotelInfo");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static HotelInfoApp.HotelInfo read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_HotelInfoStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, HotelInfoApp.HotelInfo value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static HotelInfoApp.HotelInfo narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof HotelInfoApp.HotelInfo)
      return (HotelInfoApp.HotelInfo)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      HotelInfoApp._HotelInfoStub stub = new HotelInfoApp._HotelInfoStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static HotelInfoApp.HotelInfo unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof HotelInfoApp.HotelInfo)
      return (HotelInfoApp.HotelInfo)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      HotelInfoApp._HotelInfoStub stub = new HotelInfoApp._HotelInfoStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
