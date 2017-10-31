package com.uum._a2;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Aman
 */
public class Keyword {
    
    public static Map<String, Integer> map = new TreeMap<>();
    
    public static void addKeywords(){
        String[] keywordString = {"abstract", "assert", "boolean",
                "break", "byte", "case", "catch", "char", "class",
                "const", "continue", "default", "do", "double",
                "else", "enum", "extends", "for", "final", "finally",
                "float", "goto", "if", "implements", "import", "instanceof",
                "int", "interface", "long", "native", "new", "package",
                "private", "protected", "public", "return", "short",
                "static", "strictfp", "super", "switch", "synchronized",
                "this", "throw", "throws", "transient", "try",
                "void", "volatile", "while", "true", "false", "null"};
        for (String keywordString1 : keywordString) {
            map.put(keywordString1, 0);
        }
    }
    
}
