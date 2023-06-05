/*
 *
 * Axis Saksham Java Client SDK
 * This is the java SDK to consume Axis Sakham APIs. This reduces the boiler plate coding required to make API calls
 * and hence speeds up the developers to integrate with Saksham API in faster and productive way.
 *
 * 2023 Eclatian Technologies Pvt. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eclatian.oss.axis.saksham.client.utils;

import com.eclatian.oss.axis.saksham.client.SakshamManager;
import com.eclatian.oss.axis.saksham.client.base.Request;
import com.eclatian.oss.axis.saksham.client.base.SakshamClientException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@code EncryptionUtil} class provides utility methods for encrypting and decrypting data using AES encryption. It
 * supports AES/CBC/PKCS5PADDING algorithm for encryption and decryption operations.
 *
 * <p>
 * <strong>Example Usage:</strong></p>
 * <pre>{@code
 * String plainText = "This is a secret message.";
 *
 * // Encrypt the plain text
 * String encryptedText = EncryptionUtil.aes128Encrypt(plainText);
 * System.out.println("Encrypted Text: " + encryptedText);
 *
 * // Decrypt the encrypted text
 * String decryptedText = EncryptionUtil.aes128Decrypt(encryptedText);
 * System.out.println("Decrypted Text: " + decryptedText);
 * }</pre>
 *
 * <p>
 * This class uses the {@code Cipher} class and AES algorithm for encryption and decryption operations.</p>
 *
 * @since 1.0
 * @see Cipher
 * @see SecretKeySpec
 * @see Base64
 * @see SakshamManager
 * @see Request
 * @author Abhideep Chakravarty
 */
public class EncryptionUtil {

    protected static final Logger logger = LoggerFactory.getLogger(EncryptionUtil.class.getName());

    private static final String ALGORITHM = "AES";
    private static final String CIPHER_ALGORITHAM = "AES/CBC/PKCS5PADDING";
    //private static final String KEY = "29C1EB633ECAB0CA0F52B588AE92EA31";

    /**
     * Encrypts the given plain text using AES-128 encryption with a provided key.
     *
     * @param plainText the plain text to encrypt
     * @return the encrypted text
     * @throws SakshamClientException if an error occurs during encryption
     */
    private static String aes128Encrypt(String plainText) throws SakshamClientException {
        String encryptedResult = null;
        try {

            byte[] iv = new byte[]{(byte) 0x8E, 0x12, 0x39, (byte) 0x9C, 0x07,
                0x72, 0x6F, 0x5A, (byte) 0x8E, 0x12, 0x39, (byte) 0x9C, 0x07,
                0x72, 0x6F, 0x5A};

            AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
            /**
             * Generate a secret key from the hex string as key
             */
            SecretKeySpec skeySpec = getSecretKeySpecFromHexString(ALGORITHM, SakshamManager.INSTANCE.getOptions().getKey());
            /**
             * Creating a cipher instance with the algorithm and padding
             */

            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHAM);
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, paramSpec);

            /**
             * generating the encrypted result
             */
            byte[] encrypted = cipher.doFinal(plainText.getBytes("UTF-8"));
            // To add iv in encrypted string.
            byte[] encryptedWithIV = copyIVAndCipher(encrypted, iv);
            encryptedResult
                = Base64.encodeBase64String(encryptedWithIV);

        } catch (Exception ex) {
            throw new SakshamClientException("Could not encrypt the data.", ex);
        }
        return encryptedResult;
    }

    /**
     * Decrypts the given encrypted text using AES-128 decryption with a provided key.
     *
     * @param encryptedText the encrypted text to decrypt
     * @return the decrypted text
     * @throws SakshamClientException if an error occurs during decryption
     */
    public static String aes128Decrypt(String encryptedText) throws SakshamClientException {

        String decryptedResult = null;
        SecretKeySpec skeySpec = getSecretKeySpecFromHexString(ALGORITHM, SakshamManager.INSTANCE.getOptions().getKey());
        byte[] encryptedIVandTextAsBytes = Base64.decodeBase64(encryptedText);
        /**
         * First 16 bytes are always the IV
         */
        byte[] iv = Arrays.copyOf(encryptedIVandTextAsBytes, 16);
        byte[] ciphertextByte = Arrays.copyOfRange(encryptedIVandTextAsBytes, 16,
            encryptedIVandTextAsBytes.length);

// Decrypt the message
        Cipher cipher;
        try {
            cipher = Cipher.getInstance(CIPHER_ALGORITHAM);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, new IvParameterSpec(iv));
            byte[] decryptedTextBytes = cipher.doFinal(ciphertextByte);
            decryptedResult = new String(decryptedTextBytes, "UTF-8");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException 
            | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException 
            | UnsupportedEncodingException ex) {
            throw new SakshamClientException("Could not decrypt the given data.", ex);
        }

        return decryptedResult;
    }

    /**
     * Retrieves a {@code SecretKeySpec} object from a hexadecimal key string for the specified algorithm.
     *
     * @param algoCommonName the common name of the algorithm
     * @param hexString the hexadecimal key string
     * @return the {@code SecretKeySpec} object
     */
    private static SecretKeySpec getSecretKeySpecFromHexString(String algoCommonName, String hexString) {

        byte[] encodedBytes = hexStrToByteArray(hexString);
        return new SecretKeySpec(encodedBytes, algoCommonName);
    }

    /**
     * Converts a hexadecimal string to a byte array.
     *
     * @param hex the hexadecimal string
     * @return the byte array
     */
    private static byte[] hexStrToByteArray(String hex) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(hex.length() / 2);
        for (int i = 0; i < hex.length(); i += 2) {
            String output = hex.substring(i, i + 2);
            int decimal = Integer.parseInt(output, 16);
            baos.write(decimal);
        }
        return baos.toByteArray();
    }

    /**
     * Copies the initialization vector (IV) and the cipher into a single byte array.
     *
     * @param encryptedText the encrypted text
     * @param iv the initialization vector (IV)
     * @return the byte array containing IV and cipher
     * @throws Exception if an error occurs during the copying process
     */
    private static byte[] copyIVAndCipher(byte[] encryptedText, byte[] iv) throws Exception {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        os.write(iv);
        os.write(encryptedText);

        return os.toByteArray();
    }

    /**
     * Retrieves the encrypted body of a {@code Request} object.
     *
     * @param request the {@code Request} object
     * @return the encrypted body
     * @throws SakshamClientException if an error occurs during the encrypted request body creation.
     */
    public static String getEncryptedBody(Request request) throws SakshamClientException {
        //this.sdkafhdskfh();
        //ChecksumUtil.setChecksum(request);
        logger.debug("Pre enc = " + request);
        ObjectMapper obj = new ObjectMapper();
        String json = null;
        String encryptedBody = null;
        try {
            json = obj.writeValueAsString(request);
            logger.debug("Pre Enc JSON : " + json);
            encryptedBody = EncryptionUtil.aes128Encrypt(json);
        } catch (JsonProcessingException ex) {
            throw new SakshamClientException("failed to create encrypted body for request.", ex);
        } 
        return encryptedBody;
    }
}
