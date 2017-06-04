/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bcn
 */
public class Ticket_ControllerTest {
    
    public Ticket_ControllerTest() {
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
     * Test of agregarTicket method, of class Ticket_Controller.
     */
    @Test
    public void testAgregarTicket_11args() throws Exception {
        System.out.println("agregarTicket");
        String id_ticket = "";
        String status = "";
        String block_by = "";
        String created_by = "";
        String status_1 = "";
        String block_datails = "";
        String tipo = "";
        String sepacial_details = "";
        String aditional_details = "";
        int valor = 0;
        String funcionario_id_funcionario = "";
        Ticket_Controller instance = new Ticket_Controller();
        boolean expResult = false;
        boolean result = instance.agregarTicket(id_ticket, status, block_by, created_by, status_1, block_datails, tipo, sepacial_details, aditional_details, valor, funcionario_id_funcionario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarTicket method, of class Ticket_Controller.
     */
    @Test
    public void testAgregarTicket_String() {
        System.out.println("agregarTicket");
        String idFuncionario = "";
        Ticket_Controller instance = new Ticket_Controller();
        boolean expResult = false;
        boolean result = instance.agregarTicket(idFuncionario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
