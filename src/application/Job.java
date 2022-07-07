package application;

public class Job {
	/*
	 Per ogni lavoro svolto vanno
registrati: periodo, nome dell’azienda, mansioni svolte, luogo di lavoro, retribuzione lorda
giornaliera
	 */
	//TODO perido
	private String name;
	private String work;
	private String place;
	private int pay;
	
	public Job (String name, String work, String place, int pay) {
		
		this.name = name;
		this.work = work;
		this.place = place;
		this.pay = pay;
	}
}
