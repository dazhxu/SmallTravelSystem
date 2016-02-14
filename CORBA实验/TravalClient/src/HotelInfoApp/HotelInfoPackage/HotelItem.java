package HotelInfoApp.HotelInfoPackage;


/**
* HotelInfoApp/HotelInfoPackage/HotelItem.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从HotelInfo.idl
* 2015年6月7日 星期日 上午09时21分56秒 CST
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
