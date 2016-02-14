package HotelInfoApp;


/**
* HotelInfoApp/_HotelInfoStub.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从HotelInfo.idl
* 2015年6月7日 星期日 上午09时21分56秒 CST
*/

public class _HotelInfoStub extends org.omg.CORBA.portable.ObjectImpl implements HotelInfoApp.HotelInfo
{

  public HotelInfoApp.HotelInfoPackage.HotelItem[] getHotelInfo (String dest, String inData, String outData, String type, String user)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getHotelInfo", true);
                $out.write_string (dest);
                $out.write_string (inData);
                $out.write_string (outData);
                $out.write_string (type);
                $out.write_string (user);
                $in = _invoke ($out);
                HotelInfoApp.HotelInfoPackage.HotelItem $result[] = HotelInfoApp.HotelInfoPackage.HotelSeqHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getHotelInfo (dest, inData, outData, type, user        );
            } finally {
                _releaseReply ($in);
            }
  } // getHotelInfo

  public int orderHotel (int id, String dest, String name, String Date, String type, int num, String user)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("orderHotel", true);
                $out.write_long (id);
                $out.write_string (dest);
                $out.write_string (name);
                $out.write_string (Date);
                $out.write_string (type);
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
                return orderHotel (id, dest, name, Date, type, num, user        );
            } finally {
                _releaseReply ($in);
            }
  } // orderHotel

  public HotelInfoApp.HotelInfoPackage.HotelItem[] getOrderInfo (String user)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getOrderInfo", true);
                $out.write_string (user);
                $in = _invoke ($out);
                HotelInfoApp.HotelInfoPackage.HotelItem $result[] = HotelInfoApp.HotelInfoPackage.HotelSeqHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getOrderInfo (user        );
            } finally {
                _releaseReply ($in);
            }
  } // getOrderInfo

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:HotelInfoApp/HotelInfo:1.0"};

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
} // class _HotelInfoStub
