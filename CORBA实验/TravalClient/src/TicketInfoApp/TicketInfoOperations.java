package TicketInfoApp;


/**
* TicketInfoApp/TicketInfoOperations.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从TicketInfo.idl
* 2015年6月7日 星期日 下午08时48分18秒 CST
*/

public interface TicketInfoOperations 
{
  TicketInfoApp.TicketInfoPackage.TicketItem[] getTicketInfo (String dept, String dest, String startTime, String user);
  int orderTicket (int id, int num, String user);
  TicketInfoApp.TicketInfoPackage.TicketItem[] getTicketOrderInfo (String user);
} // interface TicketInfoOperations
