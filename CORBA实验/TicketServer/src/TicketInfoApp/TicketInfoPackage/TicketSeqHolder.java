package TicketInfoApp.TicketInfoPackage;


/**
* TicketInfoApp/TicketInfoPackage/TicketSeqHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��TicketInfo.idl
* 2015��6��7�� ������ ����08ʱ48��18�� CST
*/

public final class TicketSeqHolder implements org.omg.CORBA.portable.Streamable
{
  public TicketInfoApp.TicketInfoPackage.TicketItem value[] = null;

  public TicketSeqHolder ()
  {
  }

  public TicketSeqHolder (TicketInfoApp.TicketInfoPackage.TicketItem[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = TicketInfoApp.TicketInfoPackage.TicketSeqHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    TicketInfoApp.TicketInfoPackage.TicketSeqHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return TicketInfoApp.TicketInfoPackage.TicketSeqHelper.type ();
  }

}
