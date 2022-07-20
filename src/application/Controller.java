package application;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.*;

public class Controller implements Initializable{
	
	@FXML private TableView<Lavoratore> tableView;
	@FXML private TableColumn<Lavoratore, String> nameColumn;
	@FXML private TableColumn<Lavoratore, String> surnameColumn;
	@FXML private TableColumn<Lavoratore, LocalDate> dateColumn;
	
	@FXML private Button loginButton;
	@FXML private PasswordField password;
	@FXML private Label wronglogin;
	@FXML private Button logoutButton;
	@FXML private Button registerButton;
	@FXML private Button searchButton;
	
	
	//sistema di login e  logout

	@FXML private TextField username;
	@FXML private TextField Nome;
	@FXML private TextField Cognome;
	@FXML private TextField Residenza;
	@FXML private DatePicker DataDiNascita;
	
	// TODO finire i campi e collegarli
	


	private static EmployeeDao book;
	
	public void userLogin(ActionEvent event) throws IOException, ClassNotFoundException {
	        checkLogin();
	}
	
		@FXML
    private void checkLogin() throws IOException, ClassNotFoundException {
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
		        BufferedReader br = new BufferedReader(new FileReader("users.csv"));
		        line = br.readLine();
		        while ((line = br.readLine()) != null){
		            String[] check = line.split(",");
		            System.out.println(pass.equals(check[1]));
		
		            if(user.equals(check[0]) && pass.equals(check[1])) {
		                wronglogin.setText("Success!");
		                done = true;
		                /*
		                List<Lavoratore> test = new ArrayList<Lavoratore>();
		                test.add(new Lavoratore("Ramon", "Carella", null, "123"));
		                save(new EmployeeDao(test));
		                */
		                Controller.book = new EmployeeDao(readFromFile());
		                System.out.println(this.book);
		                
		        		
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
	
	@FXML
	private void register(ActionEvent event) throws IOException {
		Lavoratore toAdd = input();
		Controller.book.addNew(toAdd);
		save(Controller.book);
		System.out.println(Controller.book);
}
	
	@FXML
	private void searchBy(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("search.fxml");
	}


	private Lavoratore input() {
		String nome = Nome.getText().toString();
        String cognome = Cognome.getText().toString();
        LocalDate date = DataDiNascita.getValue();
        String residenza = Residenza.getText().toString();
		return new Lavoratore(nome, cognome, date, residenza);
	}
	
	private void save(EmployeeDao toSave) throws IOException {
		 try {
	            FileOutputStream fileOutputStream = new FileOutputStream("objects.txt");
	            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
	            
	            objectOutputStream.writeObject(toSave.getAllEmployees());
	            fileOutputStream.close();
	            objectOutputStream.close();
	            
	        }catch(Exception e){
	            System.out.println(e);
	        }
	}
	
	
	private List<Lavoratore> readFromFile() throws IOException, ClassNotFoundException {
		 try{
	            FileInputStream fileInputStream
	                    = new FileInputStream("objects.txt");
	            ObjectInputStream objectInputStream
	                    = new ObjectInputStream(fileInputStream);
	            return (List<Lavoratore>) objectInputStream.readObject();
	        }
	        catch(EOFException e){
	            return new ArrayList<Lavoratore>();
	        }
	        catch(IOException e){
	            System.out.println(e);
	            return new ArrayList<Lavoratore>();
	        }
	        catch(ClassNotFoundException e){
	            System.out.println(e);
	        }
		 
	        return null;
        
	
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nameColumn.setCellValueFactory(new PropertyValueFactory<Lavoratore, String>("Nome"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<Lavoratore, String>("Cognome"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Lavoratore, LocalDate>("Data di nascita"));
        
      
        tableView.setItems(book.search(input()));
		
	}
	


	
}

