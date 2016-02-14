package HotelInfoApp;

/**
* HotelInfoApp/HotelInfoHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��HotelInfo.idl
* 2015��6��7�� ������ ����09ʱ21��56�� CST
*/

public final class HotelInfoHolder implements org.omg.CORBA.portable.Streamable
{
  public HotelInfoApp.HotelInfo value = null;

  public HotelInfoHolder ()
  {
  }

  public HotelInfoHolder (HotelInfoApp.HotelInfo initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = HotelInfoApp.HotelInfoHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    HotelInfoApp.HotelInfoHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return HotelInfoApp.HotelInfoHelper.type ();
  }

}
