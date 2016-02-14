package HotelInfoApp.HotelInfoPackage;

/**
* HotelInfoApp/HotelInfoPackage/HotelItemHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��HotelInfo.idl
* 2015��6��7�� ������ ����09ʱ21��56�� CST
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
