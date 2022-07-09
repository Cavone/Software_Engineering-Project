package application;

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
        Main m = new Main();
        if(username.getText().toString().equals("user") && password.getText().toString().equals("123")){
            wronglogin.setText("Success!");
            m.changeScene("scelta.fxml");
           // String line = "";
          //  String splitBy = ",";
            	/*
              try (BufferedReader br = new BufferedReader(new FileReader("users.csv"))) {
                while ((line = br.readLine()) != null)
                  {
                    String[] check = line.split(splitBy);
                    if(check[0] == username && check[1] == password)
                        return true;  //Entra
                  }
                return false;    //Non entra
            }
            
             */
            
        }

        else if(username.getText().isEmpty() && password.getText().isEmpty()) {
            wronglogin.setText("Please enter your data.");
        }


        else {
            wronglogin.setText("Wrong username or password!");
        }
        
    }
	@FXML
	private void userLogout(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Main.fxml");
		
	}
	
}
	
