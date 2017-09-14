package com.zen.autumn.learn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharsetCollection {
    
    public static final String COMPANY_NAME_REGEX = "([\u4e00-\u9fa5]|（|）|\\(|\\))+";


    
    public static void main(String[] args) {
        
        Pattern pattern = Pattern.compile(COMPANY_NAME_REGEX);
        Matcher m = pattern.matcher("陕西遨来鑫贸易有限公司  ttttt");
        while(m.find()){
            System.err.println(m.group());
        }
        
        
    }
}
