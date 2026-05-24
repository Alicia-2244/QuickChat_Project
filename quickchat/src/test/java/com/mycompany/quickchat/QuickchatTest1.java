/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.quickchat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rikha
 */
public class QuickchatTest {
    
    public QuickchatTest() {
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
     * Test of main method, of class Quickchat.
     */
    

    /**
     * Test of loginUser method, of class Quickchat.
     */
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        String username = "Mike";
        String password = "1234";
        boolean expResult = true;
        boolean result = Quickchat.loginUser(username, password);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of createMessageHash method, of class Quickchat.
     */
    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        String recipient = "+27718693002";
        int messageNumber = 1;
        String message = "Hi Mike, can you join us for dinner tonight";
        String expResult = "+2:1:HI TONIGHT";
        String result = Quickchat.createMessageHash(recipient, messageNumber, message);
        assertEquals(expResult, result);
       
    }
    /**
     * Test of createMessageHash method, of class Quickchat.
     */
    @Test
    public void test2CreateMessageHash() {
        System.out.println("createMessageHash");
        String recipient = "08575975889";
        int messageNumber = 2;
        String message = "Hi Keegan,did you receive the payment";
        String expResult = "08:2:HI PAYMENT";
        String result = Quickchat.createMessageHash(recipient, messageNumber, message);
        assertEquals(expResult, result);
       
    }
}
