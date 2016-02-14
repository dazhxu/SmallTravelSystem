package TicketInfoApp;

/**
* TicketInfoApp/TicketInfoHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��TicketInfo.idl
* 2015��6��7�� ������ ����08ʱ48��18�� CST
*/

public final class TicketInfoHolder implements org.omg.CORBA.portable.Streamable
{
  public TicketInfoApp.TicketInfo value = null;

  public TicketInfoHolder ()
  {
  }

  public TicketInfoHolder (TicketInfoApp.TicketInfo initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = TicketInfoApp.TicketInfoHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    TicketInfoApp.TicketInfoHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return TicketInfoApp.TicketInfoHelper.type ();
  }

}
