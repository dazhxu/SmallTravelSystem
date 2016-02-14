package HotelInfoApp.HotelInfoPackage;

/**
* HotelInfoApp/HotelInfoPackage/HotelItemHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从HotelInfo.idl
* 2015年6月7日 星期日 上午09时21分56秒 CST
*/

public final class HotelItemHolder implements org.omg.CORBA.portable.Streamable
{
  public HotelInfoApp.HotelInfoPackage.HotelItem value = null;

  public HotelItemHolder ()
  {
  }

  public HotelItemHolder (HotelInfoApp.HotelInfoPackage.HotelItem initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = HotelInfoApp.HotelInfoPackage.HotelItemHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    HotelInfoApp.HotelInfoPackage.HotelItemHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return HotelInfoApp.HotelInfoPackage.HotelItemHelper.type ();
  }

}
