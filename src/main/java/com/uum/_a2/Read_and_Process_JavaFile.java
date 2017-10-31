//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #236174
//Name: #Wang Bo


package com.uum._a2;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/**
 *
 * @author Aman
 */
public class Read_and_Process_JavaFile {

    static int classcount = 0;
    static int codeLines = 0;
    static int commentLines = 0;
    static int blankLines = 0;
    static String semester;
    static String course;
    static String group;
    static String task;
    static String matrik;
    static String name;
    
    public static void main(String[] args) throws Exception { 
        
        Form form = new Form();
        HSSFWorkbook wb = form.CreateForm();
        HSSFSheet sheet=wb.getSheet("sheet0");
        
        File f = new File("Input"); // 目录
        
        Read.treeFile(f,sheet);
        
        FileOutputStream output=new FileOutputStream("Output/output.xls");
        wb.write(output); 
        output.flush();
    }
}