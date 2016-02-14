package HotelInfoApp.HotelInfoPackage;


/**
* HotelInfoApp/HotelInfoPackage/HotelItemHelper.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从HotelInfo.idl
* 2015年6月7日 星期日 上午09时21分56秒 CST
*/

abstract public class HotelItemHelper
{
  private static String  _id = "IDL:HotelInfoApp/HotelInfo/HotelItem:1.0";

  public static void insert (org.omg.CORBA.Any a, HotelInfoApp.HotelInfoPackage.HotelItem that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static HotelInfoApp.HotelInfoPackage.HotelItem extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [7];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[0] = new org.omg.CORBA.StructMember (
            "Id",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "Destination",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[2] = new org.omg.CORBA.StructMember (
            "Name",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[3] = new org.omg.CORBA.StructMember (
            "Type",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[4] = new org.omg.CORBA.StructMember (
            "price",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[5] = new org.omg.CORBA.StructMember (
            "Remains",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[6] = new org.omg.CORBA.StructMember (
            "date",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (HotelInfoApp.HotelInfoPackage.HotelItemHelper.id (), "HotelItem", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static HotelInfoApp.HotelInfoPackage.HotelItem read (org.omg.CORBA.portable.InputStream istream)
  {
    HotelInfoApp.HotelInfoPackage.HotelItem value = new HotelInfoApp.HotelInfoPackage.HotelItem ();
    value.Id = istream.read_long ();
    value.Destination = istream.read_string ();
    value.Name = istream.read_string ();
    value.Type = istream.read_string ();
    value.price = istream.read_long ();
    value.Remains = istream.read_long ();
    value.date = istream.read_string ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, HotelInfoApp.HotelInfoPackage.HotelItem value)
  {
    ostream.write_long (value.Id);
    ostream.write_string (value.Destination);
    ostream.write_string (value.Name);
    ostream.write_string (value.Type);
    ostream.write_long (value.price);
    ostream.write_long (value.Remains);
    ostream.write_string (value.date);
  }

}
