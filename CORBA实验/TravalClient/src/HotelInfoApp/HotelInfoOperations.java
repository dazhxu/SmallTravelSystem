package HotelInfoApp;


/**
* HotelInfoApp/HotelInfoOperations.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��HotelInfo.idl
* 2015��6��7�� ������ ����09ʱ21��56�� CST
*/

public interface HotelInfoOperations 
{
  HotelInfoApp.HotelInfoPackage.HotelItem[] getHotelInfo (String dest, String inData, String outData, String type, String user);
  int orderHotel (int id, String dest, String name, String Date, String type, int num, String user);
  HotelInfoApp.HotelInfoPackage.HotelItem[] getOrderInfo (String user);
} // interface HotelInfoOperations
