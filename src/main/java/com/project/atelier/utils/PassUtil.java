package com.project.atelier.utils;


import lombok.experimental.UtilityClass;
import org.bouncycastle.util.encoders.Hex;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@UtilityClass
public class PassUtil{


    public static String convertPass(String value) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(
                value.getBytes(StandardCharsets.UTF_8));
        return new String(Hex.encode(hash));
    }
}
