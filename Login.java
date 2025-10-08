import javax.swing.*;
import java.awt.event.*;

class Login extends JFrame {

    JLabel l1, l2, l3, l4;
    JButton b1, b2;
    JTextField t1;
    JPasswordField t2; 

    Login(String s1) {
        super(s1);
    }

    Login() {
    }

    void setComponents() {
     
        l1 = new JLabel("Welcome");
        l2 = new JLabel("Username:");
        l3 = new JLabel("Password:");
        l4 = new JLabel(""); // for messages (like errors)

        // Create text fields
        t1 = new JTextField();
        t2 = new JPasswordField();

        // Create buttons
        b1 = new JButton("Log In");
        b2 = new JButton("Clear");

        // Set layout
        setLayout(null);

        // Add components
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(t1);
        add(t2);
        add(b1);
        add(b2);

        // -------- Coordinates (x, y, width, height) --------
        // Label “Welcome” at top
        l1.setBounds(150, 30, 200, 30);

        // Username label and text field
        l2.setBounds(50, 80, 100, 30);
        t1.setBounds(150, 80, 200, 30);

        // Password label and text field
        l3.setBounds(50, 130, 100, 30);
        t2.setBounds(150, 130, 200, 30);

        // Buttons
        b1.setBounds(100, 200, 100, 30);
        b2.setBounds(220, 200, 100, 30);

        // Message label (for success/error)
        l4.setBounds(150, 250, 200, 30);
		
		
	    log listener = new log(this);
        b1.addActionListener(listener);
        b2.addActionListener(listener);
    }
	
 public static void main(String args[]) {
        Login frame = new Login("Welcome to Java Programming");
        frame.setComponents();
        frame.setSize(400, 350);
        frame.setLocationRelativeTo(null); // center on screen
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class log implements ActionListener {

    Login ref; // reference to LoginS object

    log(Login ref) {
        this.ref = ref; // link this listener to the frame
    }

//Override the ActionListener instance method//
    public void actionPerformed(ActionEvent e1) {
        Object src = e1.getSource();

        if (src == ref.b1) {
            String user = ref.t1.getText();
            String pass = new String(ref.t2.getPassword());

            if (user.equals("java") && pass.equals("123")) {
                ref.l4.setText("Login Successful!");
            } else {
                ref.l4.setText("Incorrect Information");
            }
        }

        if (src == ref.b2) {
            ref.t1.setText("");
            ref.t2.setText("");
            ref.l4.setText("");
        }
    }
}