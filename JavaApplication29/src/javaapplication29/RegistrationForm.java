import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationForm extends JFrame{
    private JTextField nameField,mobileField,dobField;
    private JTextArea addressArea;
    private JRadioButton maleButton,femaleButton;
    private JButton submitButton;
    
    public RegistrationForm() {
        setTitle("Registration Form");
        setSize(400, 400);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));
        add(new JLabel("Name:"));
        nameField=new JTextField();
        add(nameField);
        add(new JLabel("Mobile:"));
        nameField=new JTextField();
        add(mobileField);
        add(new JLabel("Gender:"));
        maleButton=new JRadioButton("Male");
        femaleButton=new JRadioButton("Female");
        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        add(maleButton);
        add(femaleButton);
        
        add(new JLabel("DOB:"));
        dobField=new JTextField();
        add(dobField);
        add(new JLabel("Address:"));
        addressArea=new JTextArea();
        add(addressArea);
        
        submitButton=new JButton("Submit");
        add(submitButton);
        submitButton.addActionListener(new ActionListener) {
        public void actionPerformed(ActionEvent e) {
           
          String name =nameField.getText();
            String mobile =mobileField.getText();
            String gender=maleButton.isSelected() ?"Male" :"Female";
            String dob=dobField.getText();
            String address=addressArea.getText();
            
            storeData(name,mobile,gender,dob,address);
            JOptionPane.showMessageDialog(null, "Datasubmitted:\n") +
                    "Name: " +name +"\n" +
                    "Mobile: " +mobile +"\n" +
                    "Gender: " +gender +"\n" +
                    "DOB: " +dob +"\n" +
                    "Address: " +address);         
    }

    private void storeData(String name, String mobile, String gender, String dob, String address) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    });
}
private void storeData(String name,String mobile,String dob,String address){
String url ="jdbc:mysql://localhost:127.0.0.1/registration_db";
String user ="root";
String password ="";

try(Connection conn=DriverManager.getConnection(url,user,password)){
String query ="INSERT INTO registrartion (name,mobile,gender,dob,address) VALUES (? ? ? ? ?)";
PreparedStatement stmt=conn.prepareStatement(query);
stmt.setString(1,name);
stmt.setString(2,mobile);
stmt.setString(3,gender);
stmt.setString(4,java.sql.Date.valueOf(dob));
stmt.setString(5,address);
stmt.executeUpdate();}
catch (SQLException e){
e.printStackTrace();
}
}
public static void main(String[]args){
SwingUtilities.invokeLater(() ->{
RegistrationForm form=new RegistrationForm();
form.setVisible(true);
});
}
}