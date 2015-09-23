package entities;

public interface MailListSubject {
	
	public void addObserver(MailListObserver mailListObserver);
	
	public void removeObserver(MailListObserver mailListObserver);
	
	public void doNotify();

}
