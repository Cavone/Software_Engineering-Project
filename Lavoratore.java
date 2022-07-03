public class Lavoratore{
	private String name;
	private String surname;
	private final Date date;
	private final String luogo;
	private String nation;
	private String address;
	private Boolean auto;
	private String license;
	
	
	public Lavoratore(String name, String surname, Date date, 
			String luogo, String nation, String address,
			/* TODO lingue */ 
			String license,
			Boolean auto) { 
		
		this.name = name;
		this.surname = surname;
		this.date = date;
		this.luogo = luogo;
		this.nation = nation;
		this.address = address;
		//TODO lingue parlate
		this.license = license;
		this.auto = auto;
		//TODO Esperienze
		//TODO Disponibilità (orari e comuni)
		//TODO Persona di riferimento
	} 
	
	
	public String toString() {
		//TODO
		return name + surname;
	}
	 
	
	
	public int hashCode() { 
		return (int) (name.hashCode() * surname.hashCode() * date.hashCode());
	}

}