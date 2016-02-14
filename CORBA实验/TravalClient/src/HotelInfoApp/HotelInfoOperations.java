package HotelInfoApp;


/**
* HotelInfoApp/HotelInfoOperations.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从HotelInfo.idl
* 2015年6月7日 星期日 上午09时21分56秒 CST
*/

public interface HotelInfoOperations 
{
  HotelInfoApp.HotelInfoPackage.HotelItem[] getHotelInfo (String dest, String inData, String outData, String type, String user);
  int orderHotel (int id, String dest, String name, String Date, String type, int num, String user);
  HotelInfoApp.HotelInfoPackage.HotelItem[] getOrderInfo (String user);
} // interface HotelInfoOperations
