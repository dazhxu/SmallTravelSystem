package TicketInfoApp.TicketInfoPackage;


/**
* TicketInfoApp/TicketInfoPackage/TicketItem.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��TicketInfo.idl
* 2015��6��7�� ������ ����08ʱ48��18�� CST
*/

public final class TicketItem implements org.omg.CORBA.portable.IDLEntity
{
  public int Id = (int)0;
  public String Name = null;
  public String Departure = null;
  public String Destination = null;
  public String StartTime = null;
  public String ArriveTime = null;
  public int Price = (int)0;
  public int Remains = (int)0;

  public TicketItem ()
  {
  } // ctor

  public TicketItem (int _Id, String _Name, String _Departure, String _Destination, String _StartTime, String _ArriveTime, int _Price, int _Remains)
  {
    Id = _Id;
    Name = _Name;
    Departure = _Departure;
    Destination = _Destination;
    StartTime = _StartTime;
    ArriveTime = _ArriveTime;
    Price = _Price;
    Remains = _Remains;
  } // ctor

} // class TicketItem
