/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypt {
    
    /*Esta clase se encarga de realizar las diferentes encriptaciones
    para asi poder usar la misma base de datos, con los mismos
    registros, sino se tendrian que crear nuevos con contraseñas
    sin encriptar*/

    public static String MD5 = "MD5";
    private static String SHA1 = "SHA-1";
    private static String SHA256 = "SHA-256";
    private static String SHA384 = "SHA-384";
    private static String SHA512 = "SHA-512";

    private static String toHexadecimal(byte[] digest) {
        String hash = "";
        for (byte aux : digest) {
            int b = aux & 0xff;
            if (Integer.toHexString(b).length() == 1) {
                hash += "0";
            }
            hash += Integer.toHexString(b);
        }
        return hash;
    }

    public static String getStringMessageDigest(String message, String algorithm) {
        byte[] digest = null;
        byte[] buffer = message.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.reset();
            messageDigest.update(buffer);
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Error creando Digest");
        }
        return toHexadecimal(digest);
    }

    /*public static void main(String[] args) {
        String mensaje = "1234";
        System.out.println("Mensaje = " + mensaje);
        System.out.println("MD5 = " + getStringMessageDigest(mensaje, MD5));
    }*/

}