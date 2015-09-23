package entities;

import java.util.HashMap;
import java.util.Map;

public class Photo {
	
	private String name;
	private String format;
	private Map<String, User> likes; //Map that stores likes
	
	public Photo(String name, String format) {
		this.name = name;
		this.format = format;
		this.likes = new HashMap<String, User>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLink() {
		return format;
	}
	public void setLink(String link) {
		this.format = link;
	}
	
	public void addLike(User user) {
		this.likes.put(user.getUsername(), user);
	}
	
	public void removeLike(User user) {
		this.likes.remove(user.getUsername());
	}
	
	public Map<String, User> getLikes() {
		return this.likes;
	}

}
