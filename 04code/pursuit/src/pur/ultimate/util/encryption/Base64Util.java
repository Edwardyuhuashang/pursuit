package pur.ultimate.util.encryption;

import java.io.IOException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Util {
    	public static void main(String[] args) {
        		String strbefore = "java1@2345";
        		String strafter = null;
        		String encbefore = null;
        		String encafter = null;
        		strafter = new BASE64Encoder().encode(strbefore.getBytes());
        		System.out.println("加密前:"+strbefore+" 加密后:"+strafter);
        		try {
        			encafter = new String(new BASE64Decoder().decodeBuffer(strafter));
        		} catch (IOException e) {
        			e.printStackTrace();
        		}
    		    System.out.println("解密前:"+strafter+" 解密后:"+encafter);
    		    
    		    
    		    
    		    encbefore = "mytests12";
    		    try {
					String adc =new String(new BASE64Decoder().decodeBuffer(encbefore));
					System.out.println(new BASE64Encoder().encode(new BASE64Decoder().decodeBuffer(encbefore)));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		    
    	}
}