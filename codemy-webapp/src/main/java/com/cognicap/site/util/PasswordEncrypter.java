package com.cognicap.site.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncrypter {
	private String hash;

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String encryptToMD5(String text) {
		MessageDigest md = null;
		byte[] encryptMsg = null;

		try {
			md = MessageDigest.getInstance("MD5"); // getting a 'MD5-Instance'
			encryptMsg = md.digest(text.getBytes()); // solving the MD5-Hash
		} catch (NoSuchAlgorithmException e) {
			System.out.println("No Such Algorithm Exception!");
		}

		String swap = ""; // swap-string for the result
		String byteStr = ""; // swap-string for current hex-value of byte
		StringBuffer strBuf = new StringBuffer();

		for (int i = 0; i <= encryptMsg.length - 1; i++) {

			byteStr = Integer.toHexString(encryptMsg[i]); // swap-string for
															// current hex-value
															// of byte

			switch (byteStr.length()) {
			case 1: // if hex-number length is 1, add a '0' before
				swap = "0" + Integer.toHexString(encryptMsg[i]);
				break;

			case 2: // correct hex-letter
				swap = Integer.toHexString(encryptMsg[i]);
				break;

			case 8: // get the correct substring
				swap = (Integer.toHexString(encryptMsg[i])).substring(6, 8);
				break;
			}
			strBuf.append(swap); // appending swap to get complete hash-key
		}
		hash = strBuf.toString(); // String with the MD5-Hash

		return hash; // returns the MD5-Hash
	}
}
