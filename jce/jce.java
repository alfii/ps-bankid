import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

class Test_JCE {

private static boolean testSHA256() {
        MessageDigest md;
        try {
                md = MessageDigest.getInstance("SHA-256");
                System.out.println("SHA-256 algorithm is present.");
                return true;
        } catch (NoSuchAlgorithmException e) {
                System.out.println("SHA-256 algorithm not present.");
                return false;
        }
}

private static boolean testAES(final int keySize)
throws NoSuchAlgorithmException, NoSuchPaddingException {
        final String prefix = "AES with " + keySize + "-bit key";
        // key, contents are irrelevant
        final byte[] keyValue = new byte[keySize/8];
        final Key key =  new SecretKeySpec(keyValue, "AES");
        final Cipher c1 = Cipher.getInstance("AES");
        try {
                c1.init(Cipher.ENCRYPT_MODE, key);
                System.out.println(prefix + " OK.");
                return true;
        } catch (final InvalidKeyException e) {
                System.out.println(prefix + " not permitted.");
                return false;
        }
}

public static void main(String[] args) throws Exception {
        System.out.println("Testing for cryptographic policies.\n");

        if (!testSHA256())
                System.exit(1);

        if (!testAES(128))
                System.exit(1);

        if (!testAES(256))
                System.exit(1);

        System.out.println("\nTests complete.");
        System.exit(0);
}

}
