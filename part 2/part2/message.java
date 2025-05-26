package prog5121_poe_chatapp;

//Code Attribution
//OpenAI. (2025). ChatGPT (April 2025 version) [Large language model].
//https.//chat.openai.com/

import java.util.Random;

public class Message {
    private String messageId;
    private String recipient;
    private String message;
    private static int numMessagesSent = 0;

    public Message(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
        this.messageId = generateMessageId();
        numMessagesSent++;
    }

    private String generateMessageId() {
        Random rand = new Random();
        return String.format("%010d", rand.nextInt(1000000000));
    }

    public boolean checkMessageID() {
        return messageId.length() <= 10;
    }

    public boolean checkRecipientCell() {
        return recipient.length() <= 10 && recipient.startsWith("+");
    }

    public String createMessageHash() {
        String[] words = message.split(" ");
        return String.format("%s:%d:%s%s", messageId.substring(0, 2), numMessagesSent, words[0].toUpperCase(), words[words.length - 1].toUpperCase());
    }

    public String sendMessage() {
        if (checkMessageID() && checkRecipientCell() && message.length() <= 250) {
            return "Message successfully sent.";
        } else {
            return "Message exceeds 250 characters or recipient number is incorrectly formatted.";
        }
    }

    public static int returnTotalMessages() {
        return numMessagesSent;
    }

    public String printMessageDetails() {
        return String.format("Message ID: %s\nRecipient: %s\nMessage: %s\nMessage Hash: %s", messageId, recipient, message, createMessageHash());
    }
}

    
    public static boolean loginUser(String enteredUsername, String enteredPassword, String storedUsername, String storedPassword) {
    return enteredUsername.equals(storedUsername) && enteredPassword.equals(storedPassword);
    }
    
   // Method to return login status
    public static String returnLoginStatus(boolean isAuthenticated, String firstName, String lastName) {
        if (isAuthenticated) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you.";
        } else {
            return "Username or password incorrect, please try again.";
        }
  }

}