package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;

public class Controller {
	
	//sistema di login e  logout
	@FXML
	private Button loginButton;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private Label wronglogin;
	@FXML
	private Button logoutButton;
	@FXML
	private Button registerButton;
	@FXML
	private Button searchButton;
	@FXML
	public void userLogin(ActionEvent event) throws IOException {
	        checkLogin();
	}
		@FXML
    private void checkLogin() throws IOException {
       // Main m = new Main();           	
           String line = "";
           String user = username.getText().toString();
           String pass = password.getText().toString();
           Boolean done = false;
           if(username.getText().isEmpty() && password.getText().isEmpty()) {
               wronglogin.setText("Please enter your data.");
               return;
           }
          try{
		        BufferedReader br = new BufferedReader(new FileReader("password.csv"));
		        line = br.readLine();
		        while ((line = br.readLine()) != null){
		            String[] check = line.split(",");
		            System.out.println(check[0] + " " + check[1] +"\n" + pass);
		            System.out.println(pass.equals(check[1]));
		
		            if(user.equals(check[0]) && pass.equals(check[1])) {
		                wronglogin.setText("Success!");
		                done = true;
		                Main m = new Main();
		                m.changeScene("scelta.fxml");
		                break;
		                
		
		            }
		        }
          } catch (FileNotFoundException e) {
            e.printStackTrace();
          }
          if(!done) {
                wronglogin.setText("Wrong username or password. Retry.");
          }
    }
	@FXML
	private void userLogout(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Main.fxml");
		
	}
	
}
	
