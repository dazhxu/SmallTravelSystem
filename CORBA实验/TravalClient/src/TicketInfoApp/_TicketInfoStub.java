package TicketInfoApp;


/**
* TicketInfoApp/_TicketInfoStub.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从TicketInfo.idl
* 2015年6月7日 星期日 下午08时48分18秒 CST
*/

public class _TicketInfoStub extends org.omg.CORBA.portable.ObjectImpl implements TicketInfoApp.TicketInfo
{

  public TicketInfoApp.TicketInfoPackage.TicketItem[] getTicketInfo (String dept, String dest, String startTime, String user)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getTicketInfo", true);
                $out.write_string (dept);
                $out.write_string (dest);
                $out.write_string (startTime);
                $out.write_string (user);
                $in = _invoke ($out);
                TicketInfoApp.TicketInfoPackage.TicketItem $result[] = TicketInfoApp.TicketInfoPackage.TicketSeqHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getTicketInfo (dept, dest, startTime, user        );
            } finally {
                _releaseReply ($in);
            }
  } // getTicketInfo

  public int orderTicket (int id, int num, String user)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("orderTicket", true);
                $out.write_long (id);
                $out.write_long (num);
                $out.write_string (user);
                $in = _invoke ($out);
                int $result = $in.read_long ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return orderTicket (id, num, user        );
            } finally {
                _releaseReply ($in);
            }
  } // orderTicket

  public TicketInfoApp.TicketInfoPackage.TicketItem[] getTicketOrderInfo (String user)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getTicketOrderInfo", true);
                $out.write_string (user);
                $in = _invoke ($out);
                TicketInfoApp.TicketInfoPackage.TicketItem $result[] = TicketInfoApp.TicketInfoPackage.TicketSeqHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getTicketOrderInfo (user        );
            } finally {
                _releaseReply ($in);
            }
  } // getTicketOrderInfo

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:TicketInfoApp/TicketInfo:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _TicketInfoStub
