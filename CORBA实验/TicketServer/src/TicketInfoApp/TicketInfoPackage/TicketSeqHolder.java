package TicketInfoApp.TicketInfoPackage;


/**
* TicketInfoApp/TicketInfoPackage/TicketSeqHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从TicketInfo.idl
* 2015年6月7日 星期日 下午08时48分18秒 CST
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
