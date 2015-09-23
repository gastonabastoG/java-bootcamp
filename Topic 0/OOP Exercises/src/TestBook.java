
public class TestBook {
	
	public static void main (String args[]) {
		Author a1 = new Author("Leandro Pross", "leacap10@gmail.com", 'm');
		Book b1 = new Book("Scott Pilgrim", a1, 15.50, 500);
		System.out.println(b1);
		System.out.println(b1.getAuthor().getName());	
	}
	                                  

}
