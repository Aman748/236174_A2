package com.uum._a2;

import static com.uum._a2.Keyword.map;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

/**
 *
 * @author Aman
 */
public class Read {
    
    public static void treeFile(File f,HSSFSheet sheet) throws Exception {
        
        int blankLines;
        int commentLines;
        int codeLines;
        
        int classCount=0;
        
        String semester=null;
        String course=null;
        String group=null;
        String task=null;
        String matrik=null;
        String name=null;
        HSSFRow Semester = sheet.getRow(0);
        HSSFRow Course = sheet.getRow(1);
        HSSFRow Group = sheet.getRow(2);
        HSSFRow Task = sheet.getRow(3);
        
        File[] childs = f.listFiles();
        for (File child : childs) {
//            Read read = new Read();
//            Map lines = read.Read_Lines(child);
            File file = child;
            if (!file.isDirectory()) {
                if (file.getName().endsWith(".java")) {
                    
                    blankLines=0;
                    commentLines=0;
                    codeLines=0;
                    classCount++;
                    
                    BufferedReader br;
                    boolean comment = false;
                    br = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = br.readLine()) != null) {
                        line = line.trim();
                        if (line.matches("^[//s&&[^//n]]*$")) {
                            blankLines++;
                        } else if (line.startsWith("/*")
                                && !line.endsWith("*/")) {
                            commentLines++;
                            comment = true;
                        } else if (true == comment) {
                            commentLines++;
                            if (line.endsWith("*/")) {
                                comment = false;
                            }
                        } else if (line.startsWith("//")) {
                            commentLines++;
                            if(line.startsWith("//Semester: #")){
                                semester = line.substring(13);
                            } else if(line.startsWith("//Course: #")){
                                course = line.substring(11);
                            } else if(line.startsWith("//Group: #")){
                                group = line.substring(10);
                            } else if(line.startsWith("//Task: #")){
                                task = line.substring(9);
                            } else if(line.startsWith("//Matrik: #")){
                                matrik = line.substring(11);
                            } else if(line.startsWith("//Name: #")){
                                name = line.substring(9);
                            }  
                        } else {
                            codeLines++;
                        }
                    }
                    
                    HSSFRow student=sheet.createRow(6+classCount);
                    student.createCell(0).setCellValue(matrik);
                    student.createCell(1).setCellValue(blankLines+commentLines+codeLines);
                    student.createCell(2).setCellValue(blankLines);
                    student.createCell(3).setCellValue(commentLines);
                    student.createCell(4).setCellValue(codeLines);
                    
                    String sb = "";
                    try (Scanner input = new Scanner(child)) {
                        while(input.hasNextLine()) {
                            sb += input.nextLine()+"\n";
                            
                            Keyword.addKeywords();//把关键字加入到Map中
                            String[] strs = sb.split("[\n .,;:!?(){}]");
                            //遍历每个单词 如果是关键字就++
                            for (String str : strs) {
                                if (map.containsKey(str)) {
                                    int value = map.get(str) + 1;
                                    map.put(str, value);
                                }
                            }
                            
                            HSSFRow Type = sheet.getRow(6);
                            //遍历一下map 如果value>0 就output
                            Set<Map.Entry<String, Integer>> set = map.entrySet();
                            int c=0,total=0;
                            for(Map.Entry<String, Integer> entry : set) {
                                if(entry.getValue() > 0) {
                                    c++;
                                    total+=entry.getValue();
                                    Type.createCell(4+c).setCellValue(entry.getKey());
                                    student.createCell(4+c).setCellValue(entry.getValue());
                                }
                            }
                            Type.createCell(5+c).setCellValue("Total");
                            student.createCell(5+c).setCellValue(codeLines+total);
                        }           
                    }                   
                    Semester.createCell(1).setCellValue(semester);
                    Course.createCell(1).setCellValue(course);
                    Group.createCell(1).setCellValue(group);
                    Task.createCell(1).setCellValue(task);
                }
            } else {
                treeFile(child,sheet);
            }
        } 
    }
}