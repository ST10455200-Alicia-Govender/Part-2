/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package prog5121_poe_chatapp;

//Code Attribution
//OpenAI. (2025). ChatGPT (April 2025 version) [Large language model].
//https.//chat.openai.com/


import static org.junit.Assert.*;
import org.junit.Test;

public class MessageTest {

    @Test
    public void testMessageLength() {
        Message message = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight");
        assertTrue(message.sendMessage().equals("Message successfully sent."));
        
        message = new Message("+27718693002", "This message is way too long and exceeds the limit of 250 characters. " +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        assertFalse(message.sendMessage().equals("Message successfully sent."));
    }

    @Test
    public void testRecipientFormat() {
        Message message = new Message("+27718693002", "Hello");
        assertTrue(message.checkRecipientCell());

        message = new Message("27718693002", "Hello");
        assertFalse(message.checkRecipientCell());
    }

    @Test
    public void testMessageHash() {
        Message message = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight");
        String expectedHash = message.createMessageHash();
        assertEquals(expectedHash, "00:0:HITHANKS");
    }

    @Test
    public void testTotalMessages() {
        Message.resetTotalMessages(); // Assuming you have a method to reset for testing
        new Message("+27718693002", "Hello");
        new Message("+27718693002", "Hello again");
        assertEquals(2, Message.returnTotalMessages());
    }
}
