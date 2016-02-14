package HotelInfoApp.HotelInfoPackage;


/**
* HotelInfoApp/HotelInfoPackage/HotelItem.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��HotelInfo.idl
* 2015��6��7�� ������ ����09ʱ21��56�� CST
*/

public final class HotelItem implements org.omg.CORBA.portable.IDLEntity
{
  public int Id = (int)0;
  public String Destination = null;
  public String Name = null;
  public String Type = null;
  public int price = (int)0;
  public int Remains = (int)0;
  public String date = null;

  public HotelItem ()
  {
  } // ctor

  public HotelItem (int _Id, String _Destination, String _Name, String _Type, int _price, int _Remains, String _date)
  {
    Id = _Id;
    Destination = _Destination;
    Name = _Name;
    Type = _Type;
    price = _price;
    Remains = _Remains;
    date = _date;
  } // ctor

} // class HotelItem
