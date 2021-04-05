import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingWithMD5 {

     public String getMD5Hash(String body) throws NoSuchAlgorithmException {

         MessageDigest messageDigest = MessageDigest.getInstance("MD5");

         byte [] bodyDigest = messageDigest.digest(body.getBytes());

         BigInteger number = new BigInteger(1, bodyDigest);

         String hashtext = number.toString(16);
         while (hashtext.length() < 32) {
             hashtext = "0" + hashtext;
         }
         return hashtext;


     }

}
