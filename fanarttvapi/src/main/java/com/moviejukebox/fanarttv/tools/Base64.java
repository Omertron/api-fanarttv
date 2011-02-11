/*
 *      Copyright (c) 2004-2011 YAMJ Members
 *      http://code.google.com/p/moviejukebox/people/list 
 *  
 *      Web: http://code.google.com/p/moviejukebox/
 *  
 *      This software is licensed under a Creative Commons License
 *      See this page: http://code.google.com/p/moviejukebox/wiki/License
 *  
 *      For any reuse or distribution, you must make clear to others the 
 *      license terms of this work.  
 */

package com.moviejukebox.fanarttv.tools;

public class Base64 {
    private static String base64code = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
         "abcdefghijklmnopqrstuvwxyz" + "0123456789" + "+/";

    public static String base64Encode(String originalString) {
        String unencoded = originalString;
        StringBuffer encoded = new StringBuffer();
        
        // determine how many padding bytes to add to the output
        int paddingCount = (3 - (unencoded.length() % 3)) % 3;
        
        // add any necessary padding to the input
        unencoded += "\0\0".substring(0, paddingCount);
        
        // process 3 bytes at a time, churning out 4 output bytes
        // worry about CRLF insertions later
        for (int i = 0; i < unencoded.length(); i += 3) {
            int j = (unencoded.charAt(i) << 16) + (unencoded.charAt(i + 1) << 8) + unencoded.charAt(i + 2);
            encoded.append(base64code.charAt((j >> 18) & 0x3f) +
                base64code.charAt((j >> 12) & 0x3f) +
                base64code.charAt((j >> 6) & 0x3f) +
                base64code.charAt(j & 0x3f) );
        }
        // replace encoded padding nulls with "="
        // return encoded;
        return "Basic " + encoded;
    }
}