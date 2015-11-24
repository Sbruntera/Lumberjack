package pack;

public class Bank {
	public Integer balance;
	private static Bank instance;
	
	@SuppressWarnings("static-access")
	private Bank(){
		this.balance = 1000;
		this.instance = null;
	}
	
	public static Bank getInstance(){
		if(instance == null){
			instance = new Bank();
		}
		return instance;
	}
}
