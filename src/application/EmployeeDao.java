package application;

import java.io.EOFException;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmployeeDao implements Serializable{

	 private List<Lavoratore> lavoratori;
	
	    public EmployeeDao(List<Lavoratore> list) throws ClassNotFoundException, IOException {
	        this.lavoratori = list;
	    }
	 
    public List<Lavoratore> getAllEmployees() {
        return lavoratori;
    }
    
    public void addNew(Lavoratore emp) {
        lavoratori.add(emp);
    }
    
    public String toString() {
        return lavoratori.toString();
    }
    
    public void delete(Lavoratore emp) {
        lavoratori.remove(emp);
    }
 
    public void update(Lavoratore Lav, Lavoratore newLav) {
        for(Lavoratore i : lavoratori) {
            if(i.equals(Lav)) {
                i = newLav;   //TODO da aggiustare
                break;
            }
        } 
    }

    public ObservableList<Lavoratore>  search(Lavoratore likeThat){
        ObservableList<Lavoratore> result = FXCollections.observableArrayList();
		for(Lavoratore i: lavoratori)
			result.add(i);
        return result;
    }

    

}
