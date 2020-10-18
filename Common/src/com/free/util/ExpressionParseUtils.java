package com.free.util;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 表达式转换工具类
 */
public class ExpressionParseUtils {
    public static String[] splitKey(String key) {
        if(StringUtils.isEmpty(key)) return null;

        String[] keys = null;
        List<String> stringList = new ArrayList<String>();

        key = key.trim();
        int stringBegin = 0;
        int funcCount = 0 ;
        boolean constantStart =false;
        char[] keyChars = key.toCharArray();

        for(int i=0; i<keyChars.length; i++){
            switch (keyChars[i]){
                case '\'':
                    constantStart = !constantStart;
                    break;
                case '(':
                    funcCount++;
                    break;
                case ',':
                    if(funcCount == 0 && !constantStart){
                        if(i>stringBegin){
                            stringList.add(String.valueOf(keyChars, stringBegin, i-stringBegin).trim());
                        }
                        stringBegin = i+1;
                    }
                    break;
                case ')':
                    funcCount--;
                    break;
            }
        }

        if(keyChars.length> stringBegin){
            stringList.add(String.valueOf(keyChars,stringBegin,keyChars.length-stringBegin).trim());
        }
        if(CollectionUtils.isNotEmpty(stringList))keys = stringList.toArray(new String[0]);
        return keys;
    }
}
