package com.uum._a2;

import java.io.File;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Aman
 */
public class ReadTest {
    
    public ReadTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of treeFile method, of class Read.
     * @throws java.lang.Exception
     */
    @Test
    public void testTreeFile() throws Exception {
        System.out.println("treeFile");
        
        File f = new File("Input_for_test");
        
        Form form = new Form();
        HSSFWorkbook wb = form.CreateForm();
        HSSFSheet sheet=wb.getSheet("sheet0");
        
        Read.treeFile(f, sheet);
        
        assertEquals(sheet.getRow(3).getCell(1).toString(),"Assignment2");
        assertEquals(sheet.getRow(7).getCell(0).toString(),"236174");
        assertEquals(Double.valueOf(sheet.getRow(7).getCell(1).toString()).intValue(),46);
        assertEquals(Double.valueOf(sheet.getRow(7).getCell(2).toString()).intValue(),9);
        assertEquals(Double.valueOf(sheet.getRow(7).getCell(3).toString()).intValue(),10);
        assertEquals(Double.valueOf(sheet.getRow(7).getCell(4).toString()).intValue(),27);
        int cla = 5;
        while(!(sheet.getRow(6).getCell(cla).toString()).equals("class")){
            cla++;
        }
        assertEquals(Double.valueOf(sheet.getRow(7).getCell(cla).toString()).intValue(),1);
        int pub = 5;
        while(!(sheet.getRow(6).getCell(pub).toString()).equals("public")){
            pub++;
        }
        assertEquals(Double.valueOf(sheet.getRow(7).getCell(pub).toString()).intValue(),2);
        int sta = 5;
        while(!(sheet.getRow(6).getCell(sta).toString()).equals("static")){
            sta++;
        }
        assertEquals(Double.valueOf(sheet.getRow(7).getCell(sta).toString()).intValue(),11);
        int imp = 5;
        while(!(sheet.getRow(6).getCell(imp).toString()).equals("import")){
            imp++;
        }
        assertEquals(Double.valueOf(sheet.getRow(7).getCell(imp).toString()).intValue(),4);
    }
    
}