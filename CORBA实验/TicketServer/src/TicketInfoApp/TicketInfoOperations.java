package TicketInfoApp;


/**
* TicketInfoApp/TicketInfoOperations.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��TicketInfo.idl
* 2015��6��7�� ������ ����08ʱ48��18�� CST
*/

public interface TicketInfoOperations 
{
  TicketInfoApp.TicketInfoPackage.TicketItem[] getTicketInfo (String dept, String dest, String startTime, String user);
  int orderTicket (int id, int num, String user);
  TicketInfoApp.TicketInfoPackage.TicketItem[] getTicketOrderInfo (String user);
} // interface TicketInfoOperations
