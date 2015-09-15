package mfidececchi.services;

public class TextService {

	private static TextService ts;
	private String text = "This is a text provided by TextService";

	public TextService() {
		
	}
	
	public static TextService getInstance() {
		if (ts == null) {
			ts = new TextService();
		}
		return ts;
	}

	public String getText() {
		return text;		
	}

}
