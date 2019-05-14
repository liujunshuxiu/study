package study.icop;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DESUtils {
	private final static Logger logger = LoggerFactory.getLogger(DESUtils.class);
	private static Key key;
	private static String KEY_STR = "tenant";

	public static String encrypt(String src) {
		try {
			byte[] src_byte = src.getBytes("UTF-8");
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(1, key);
			byte[] final_byte = cipher.doFinal(src_byte);
			return Base64Util.encode(final_byte);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static String decrypt(String src) {
		try {
			byte[] src_byte = Base64Util.decode(src);
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(2, key);
			byte[] decrypt_byte = cipher.doFinal(src_byte);
			return new String(decrypt_byte, "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	static {
		try {
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(KEY_STR.getBytes());
			KeyGenerator generator = KeyGenerator.getInstance("DES");
			generator.init(secureRandom);
			key = generator.generateKey();
			generator = null;
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	
	public static void main(String[] args){
		System.out.println(DESUtils.encrypt("a12345678"));
	}
}
