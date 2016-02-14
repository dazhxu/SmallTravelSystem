package HotelInfoApp.HotelInfoPackage;


/**
* HotelInfoApp/HotelInfoPackage/HotelSeqHelper.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从HotelInfo.idl
* 2015年6月7日 星期日 上午09时21分56秒 CST
*/

abstract public class HotelSeqHelper
{
  private static String  _id = "IDL:HotelInfoApp/HotelInfo/HotelSeq:1.0";

  public static void insert (org.omg.CORBA.Any a, HotelInfoApp.HotelInfoPackage.HotelItem[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static HotelInfoApp.HotelInfoPackage.HotelItem[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = HotelInfoApp.HotelInfoPackage.HotelItemHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (HotelInfoApp.HotelInfoPackage.HotelSeqHelper.id (), "HotelSeq", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static HotelInfoApp.HotelInfoPackage.HotelItem[] read (org.omg.CORBA.portable.InputStream istream)
  {
    HotelInfoApp.HotelInfoPackage.HotelItem value[] = null;
    int _len0 = istream.read_long ();
    value = new HotelInfoApp.HotelInfoPackage.HotelItem[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = HotelInfoApp.HotelInfoPackage.HotelItemHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, HotelInfoApp.HotelInfoPackage.HotelItem[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      HotelInfoApp.HotelInfoPackage.HotelItemHelper.write (ostream, value[_i0]);
  }

}
