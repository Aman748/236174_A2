package com.uum._a2;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author Aman
 */
public class Form {
   
    public HSSFWorkbook CreateForm(){
        
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("sheet0");
        
        HSSFRow Semester = sheet.createRow(0);
        Semester.createCell(0).setCellValue("Semester");
        
        HSSFRow Course = sheet.createRow(1);
        Course.createCell(0).setCellValue("Course");
        
        HSSFRow Group = sheet.createRow(2);
        Group.createCell(0).setCellValue("Group");
        
        HSSFRow Task = sheet.createRow(3);
        Task.createCell(0).setCellValue("Task");
        
        HSSFRow Keyword = sheet.createRow(5);
        Keyword.createCell(5).setCellValue("java keyword");
        
        HSSFRow Type = sheet.createRow(6);
        Type.createCell(0).setCellValue("Matrik");
        Type.createCell(1).setCellValue("LOC");
        Type.createCell(2).setCellValue("Blank");
        Type.createCell(3).setCellValue("Comment");
        Type.createCell(4).setCellValue("ActualLOC");
        
        return wb;
    }
}
