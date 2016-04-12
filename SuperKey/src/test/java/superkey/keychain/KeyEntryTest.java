/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superkey.keychain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ico
 */
public class KeyEntryTest {
    private KeyEntry entryA, entryEmpty;
    
    public KeyEntryTest() {
    }
    
    @Before
    public void setUp() {
        entryA = new KeyEntry();
        entryA.setApplicationName("appx");
        entryA.setUsername("xx");
        entryA.setPassword("secret@@@");
    }
    
    @After
    public void tearDown() {
    }

   
    @Test( expected = IllegalArgumentException.class)
    public void testSetApplicationNameWithNull() {
        entryA.setApplicationName( null);
    }
    
    @Test( expected = IllegalArgumentException.class)
    public void testSetApplicationNameWithEmpty() {
        entryA.setApplicationName("");
    }
    
    @Test
    public void testKey() {
        // the key is the application name
        assertEquals("failed to get existing key field", entryA.getApplicationName(), "appx");
    }

    @Test
    public void testFormatAsCsv() {
        String expects = "appx" + KeyEntry.FIELDS_DELIMITER + "xx" + KeyEntry.FIELDS_DELIMITER + "secret@@@";
        assertEquals("failed to format entry to delimited string", entryA.formatAsCsv(), expects);
    }

    @Test
    public void testToString() {
        String test = entryA.getApplicationName() + "\t"
                        + entryA.getUsername() + "\t"
                        + entryA.getPassword();
        assertEquals(test, entryA.toString());
    }

    @Test
    public void testParse() {
        String test = "applicationName;username;password";
        String toString = "applicationName\t"
                        + "username\t"
                        + "password";
        entryEmpty = KeyEntry.parse(test);
        assertEquals(toString, entryEmpty.toString());
    }
    
    @Test
    public void testGetPassword(){
        assertEquals(entryA.getPassword(), "secret@@@");
    }
    
    @Test
    public void testSetPassword(){
        String newPass = "superPass";
        entryEmpty = new KeyEntry();
        entryEmpty.setPassword(newPass);
        assertEquals(entryEmpty.getPassword(), newPass);
    }
    
    @Test( expected = IllegalArgumentException.class)
    public void testSetPasswordNameWithNull() {
        entryA.setPassword(null);
    }
    
    @Test( expected = IllegalArgumentException.class)
    public void testSetPasswordNameWithEmpty() {
        entryA.setPassword("");
    }
    
    @Test
    public void testGetUsername(){
        assertEquals(entryA.getUsername(), "xx");
    }
    
     @Test
    public void testSetUsername(){
        String newUser = "yy";
        entryEmpty = new KeyEntry();
        entryEmpty.setUsername(newUser);
        assertEquals(entryEmpty.getUsername(), newUser);
    }
    
    @Test( expected = IllegalArgumentException.class)
    public void testSetUsernameWithNull() {
        entryA.setApplicationName(null);
    }
    
    @Test( expected = IllegalArgumentException.class)
    public void testSetUsernameWithEmpty() {
        entryA.setApplicationName("");
    }
    
    @Test
    public void testGetApplicationName(){
        assertEquals(entryA.getApplicationName(), "appx");
    }
    
    @Test
    public void testSetApplicationName(){
        String newApp = "appy";
        entryEmpty = new KeyEntry();
        entryEmpty.setApplicationName(newApp);
        assertEquals(newApp, entryEmpty.getApplicationName());
    }
}