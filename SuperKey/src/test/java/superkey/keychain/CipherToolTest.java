/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superkey.keychain;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author renat
 */
public class CipherToolTest {
    private static File target;
    private static CipherTool instance;
    private static String masterkey = "thisIsETest";
    
    public CipherToolTest() {
    }
    
    
    @BeforeClass
    public static void setUpClass() {
        target = new File("testFile.txt");
        instance = new CipherTool(masterkey);
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

    @Test
    public void testWriteProtectedKeychain() throws Exception {
        String allChain = "test";
        File file = target;
        PrintWriter writer = new PrintWriter(file);
        writer.print("");
        writer.close();
        instance.writeProtectedKeychain(allChain, target);
        Scanner scf = new Scanner(file);
        assertTrue(scf.hasNextLine());
    }

    /*@Test
    public void testReadProtectedKeychain() throws Exception {
        File file = target;
        KeyChain chain = new KeyChain(target, instance);
        
        PrintWriter writer = new PrintWriter(file);
        writer.print("app,app,9vbap81mtf73ermc3k");
        writer.close();
       
       instance.readProtectedKeychain(chain, target);
       KeyEntry test = chain.find("9vbap81mtf73ermc3k");
        assertNotNull(test);
    }*/
    
}
