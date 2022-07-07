package application;
public class Lavoratore extends Persona{
	private String name;
	private String surname;
	private final Date date;
	private final String luogo;
	private final String telephone;
	private final String email;
    private String[] languages;	
    private String nation;
	private String address;
	private Boolean isAutomunito;
	private String license;
	private ContattoDiEmergenza contatto;
	private Job job;
	
	/*
	 I responsabili del servizio, dipendenti dell’agenzia, inseriscono i dati dei lavoratori. Per ogni
lavoratore vengono memorizzati i dati anagrafici (nome, cognome, luogo e data di nascita,
nazionalità), indirizzo, recapito telefonico personale (se presente), email, le eventuali
specializzazioni/esperienze precedenti (bagnino, barman, istruttore di nuoto, viticultore,
floricultore), lingue parlate, il tipo di patente di guida e se automunito. Sono inoltre memorizzati i
periodi e le zone (comuni), per i quali il lavoratore è disponibile. Di ogni lavoratore si memorizzano
anche le informazioni di almeno una persona da avvisare in caso di urgenza: nome, cognome,
telefono, indirizzo email.
	 */
	public Lavoratore(String name, String surname, Date date, 
			String luogo,String telephone,String email,String[] languages, String nation, String address,
			String license,
			Boolean isAutomunito, ContattoDiEmergenza contatto) { 
		
		this.name = name;
		this.surname = surname;
		this.date = date;
		this.luogo = luogo;
		this.telephone = telephone;
		this.email = email;
		this.nation = nation;
		this.address = address;
		this.languages = languages;
		this.license = license;
		this.isAutomunito = isAutomunito;
		this.contatto = contatto;
		//TODO Esperienze
		//TODO Disponibilit� (orari e comuni)
	} 
	
	
	public String toString() {
		//TODO
		return name + surname;
	}
	 
	
	
	public int hashCode() { 
		return (int) (name.hashCode() * surname.hashCode() * date.hashCode());
	}

}