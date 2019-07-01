
package systemsecurity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



public class Systemsecurity {

    public static void main(String[] args) {
    
        String hash,new_hash,new_val="";
        int flag=0;
        hash="e3251075554389fe91d17a794861d47b"; 
        hash=hash.toLowerCase();

        for (int i=0000; i<10000;i++) 
        {
            String val=String.valueOf(i);
            new_hash=getMD5EncryptedValue(val);
            if(hash.equals(new_hash))
            {                
                flag=1;
                new_val=val;
                break;
            }
        }
        
        if(flag==1)
        {
            System.out.println("Orginal Value is: "+new_val);
        }
        else
        {
            new_hash=getMD5EncryptedValue("0000");
            if(hash.equals(new_hash))
            {                
                System.out.println("Orginal Value is: 0000");
            }
        }
    }
    
    public static String getMD5EncryptedValue(String password) {
        final byte[] defaultBytes = password.getBytes();
        try {
            final MessageDigest md5MsgDigest = MessageDigest.getInstance("MD5");
            md5MsgDigest.reset();
            md5MsgDigest.update(defaultBytes);
            final byte messageDigest[] = md5MsgDigest.digest();
            final StringBuffer hexString = new StringBuffer();
            for (final byte element : messageDigest) {
                final String hex = Integer.toHexString(0xFF & element);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            password = hexString + "";
        } catch (final NoSuchAlgorithmException nsae) {
            nsae.printStackTrace();
        }
        return password;
    }

}
        



