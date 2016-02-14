package TicketInfoApp.TicketInfoPackage;


/**
* TicketInfoApp/TicketInfoPackage/TicketItemHelper.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从TicketInfo.idl
* 2015年6月7日 星期日 下午08时48分18秒 CST
*/

abstract public class TicketItemHelper
{
  private static String  _id = "IDL:TicketInfoApp/TicketInfo/TicketItem:1.0";

  public static void insert (org.omg.CORBA.Any a, TicketInfoApp.TicketInfoPackage.TicketItem that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static TicketInfoApp.TicketInfoPackage.TicketItem extract (org.omg.CORBA.Any a)
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
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [8];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[0] = new org.omg.CORBA.StructMember (
            "Id",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "Name",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[2] = new org.omg.CORBA.StructMember (
            "Departure",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[3] = new org.omg.CORBA.StructMember (
            "Destination",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[4] = new org.omg.CORBA.StructMember (
            "StartTime",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[5] = new org.omg.CORBA.StructMember (
            "ArriveTime",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[6] = new org.omg.CORBA.StructMember (
            "Price",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[7] = new org.omg.CORBA.StructMember (
            "Remains",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (TicketInfoApp.TicketInfoPackage.TicketItemHelper.id (), "TicketItem", _members0);
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

  public static TicketInfoApp.TicketInfoPackage.TicketItem read (org.omg.CORBA.portable.InputStream istream)
  {
    TicketInfoApp.TicketInfoPackage.TicketItem value = new TicketInfoApp.TicketInfoPackage.TicketItem ();
    value.Id = istream.read_long ();
    value.Name = istream.read_string ();
    value.Departure = istream.read_string ();
    value.Destination = istream.read_string ();
    value.StartTime = istream.read_string ();
    value.ArriveTime = istream.read_string ();
    value.Price = istream.read_long ();
    value.Remains = istream.read_long ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, TicketInfoApp.TicketInfoPackage.TicketItem value)
  {
    ostream.write_long (value.Id);
    ostream.write_string (value.Name);
    ostream.write_string (value.Departure);
    ostream.write_string (value.Destination);
    ostream.write_string (value.StartTime);
    ostream.write_string (value.ArriveTime);
    ostream.write_long (value.Price);
    ostream.write_long (value.Remains);
  }

}
