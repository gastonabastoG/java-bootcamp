import java.util.ArrayList;

public class TransactionManager {

	private static TransactionManager transactionManager;
	private ArrayList<Transaction> transactions;
	private int lastTransactionNumber;

	private TransactionManager() {
		transactions = new ArrayList<Transaction>();
		lastTransactionNumber = 0;
	}

	public static TransactionManager getInstance() {
		if (transactionManager == null) {
			transactionManager = new TransactionManager();
		}
		return transactionManager;
	}

	public void addTransaction(Transaction transaction) {
		transaction.setNumberTransaction(lastTransactionNumber + 1);
		transactions.add(transaction);
		lastTransactionNumber += 1;
	}

	public void printTransactions() {
		System.out.println("Transaction number // Time // Payment type // Total");
		for (Transaction t : transactions) {
			System.out.println(+t.getNumberTransaction() + " // " + t.getTimeTransaction() + " // "
					+ t.getPaymentType().getClass().getName() + " // $" + t.getTotal());
		}
	}
}
