package com.uum._a2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aman
 */
public class FormTest {

    public FormTest() {
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
     * Test of CreateForm method, of class Form.
     *
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testCreateForm() throws FileNotFoundException, IOException {
        System.out.println("CreateForm");
        Form instance = new Form();
        HSSFWorkbook result = instance.CreateForm();
        InputStream testxls;
        testxls = new FileInputStream("Input_for_test/Test_Table.xls");
        HSSFWorkbook expResult = new HSSFWorkbook(testxls);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(result.getSheet("sheet0").getRow(i) != null){
                    if (result.getSheet("sheet0").getRow(i).getCell(j) != null) {
                        assertEquals(expResult.getSheet("sheet0").getRow(i).getCell(j).toString(),result.getSheet("sheet0").getRow(i).getCell(j).toString());
                    }
                }
            }
        }
    }
}
