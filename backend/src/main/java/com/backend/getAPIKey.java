package com.backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class getAPIKey {
    public enum KeyType{
        DictKey,
        SearchId,
        SearchSecret
    }
    public String GetKey(KeyType type){
        String key = "";
		try {
            int ch;
			FileInputStream fi = new FileInputStream("../key.txt");
			while((ch = fi.read()) != -1){
				key += Character.toString((char)ch);
			}
			fi.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
        } 
        return key.split(",")[type.ordinal()].split(":")[1].trim();
    }
}
