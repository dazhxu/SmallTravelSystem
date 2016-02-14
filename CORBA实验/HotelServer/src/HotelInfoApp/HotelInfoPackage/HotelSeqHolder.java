package HotelInfoApp.HotelInfoPackage;


/**
* HotelInfoApp/HotelInfoPackage/HotelSeqHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��HotelInfo.idl
* 2015��6��7�� ������ ����09ʱ21��56�� CST
*/

public final class HotelSeqHolder implements org.omg.CORBA.portable.Streamable
{
  public HotelInfoApp.HotelInfoPackage.HotelItem value[] = null;

  public HotelSeqHolder ()
  {
  }

  public HotelSeqHolder (HotelInfoApp.HotelInfoPackage.HotelItem[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = HotelInfoApp.HotelInfoPackage.HotelSeqHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    HotelInfoApp.HotelInfoPackage.HotelSeqHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return HotelInfoApp.HotelInfoPackage.HotelSeqHelper.type ();
  }

}
