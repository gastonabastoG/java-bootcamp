package topic_1.key6;



public class Main {

	public static void main(String[] args) {
		MailingList ml=new MailingList();
		IObserver ob=new EMail();
		
		ml.attach(ob);
		ml.notify("PRICE_CHANGED");
		ml.notify("TRANSACTION_DONE");
		
	}

}
