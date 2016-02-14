package TicketInfoApp;

/**
* TicketInfoApp/TicketInfoHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从TicketInfo.idl
* 2015年6月7日 星期日 下午08时48分18秒 CST
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
