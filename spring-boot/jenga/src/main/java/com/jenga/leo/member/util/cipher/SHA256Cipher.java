package com.jenga.leo.member.util.cipher;


import org.springframework.stereotype.Component;

import java.security.MessageDigest;

@Component
public class SHA256Cipher {
    private static volatile SHA256Cipher INSTANCE;
    
    
    public static SHA256Cipher getInstance(){
        if(INSTANCE==null){
            synchronized(SHA256Cipher.class){
                if(INSTANCE==null)
                    INSTANCE=new SHA256Cipher();
            }
        }
        return INSTANCE;
    }
    
    public String getEncSHA256(String txt) throws Exception{
        StringBuffer sbuf = new StringBuffer();
         
        MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
        mDigest.update(txt.getBytes());
         
        byte[] msgStr = mDigest.digest() ;
         
        for(int i=0; i < msgStr.length; i++){
            byte tmpStrByte = msgStr[i];
            String tmpEncTxt = Integer.toString((tmpStrByte & 0xff) + 0x100, 16).substring(1);
             
            sbuf.append(tmpEncTxt) ;
        }
         
        return sbuf.toString();
    }
}
