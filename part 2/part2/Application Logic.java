package prog5121_poe_chatapp;

//Code Attribution
//OpenAI. (2025). ChatGPT (April 2025 version) [Large language model].
//https.//chat.openai.com/


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class QuickChat {
    private static List<Message> messages = new ArrayList<>();

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to QuickChat.");
        int numMessages = Integer.parseInt(JOptionPane.showInputDialog("How many messages would you like to send?"));

        for (int i = 0; i < numMessages; i++) {
            String recipient = JOptionPane.showInputDialog("Enter recipient's cell number:");
            String messageContent = JOptionPane.showInputDialog("Enter your message:");

            Message message = new Message(recipient, messageContent);
            String result = message.sendMessage();

            if (result.equals("Message successfully sent.")) {
                messages.add(message);
                JOptionPane.showMessageDialog(null, message.printMessageDetails());
            } else {
                JOptionPane.showMessageDialog(null, result);
            }
        }

        JOptionPane.showMessageDialog(null, "Total messages sent: " + Message.returnTotalMessages());
    }
}


        // Cell phone
        System.out.print("Enter your cell phone number (e.g., +27831234567): ");
        String cellNumber = input.nextLine();
        if (Login.checkCellPhoneNumber(cellNumber)) {
            System.out.println("Cell phone number successfully added.");
        } else {
            System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
            return; // Stop the registration process if cell number is invalid
        }

        // Proceed to login only if all inputs are valid
        System.out.println("\n--- LOGIN ---");
        System.out.print("Enter your username: ");
        String loginUsername = input.nextLine();

        System.out.print("Enter your password: ");
        String loginPassword = input.nextLine();

        // Authenticate the user
        boolean isAuthenticated = Login.loginUser(loginUsername, loginPassword, username, password);
        
        // Return login status message
        String statusMessage = Login.returnLoginStatus(isAuthenticated, firstName, lastName);
        System.out.println(statusMessage);

        input.close();
    }
}
