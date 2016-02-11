package libbox.core;

/**
 * @author colonelmo
 * 
 */
public class Book {
	private String name;
	private String author;
	private Integer id ;
	
	@Override
	public String toString() {
		return name + " by " + author + " with id " + id;
	}
	
	public Book(){
		
	}
	
	public void setAuthor(String author){
		this.author = author;
	}
	
	public String getAuthor(){
		return this.author;
	}
	
	public void setId(Integer id){
		this.id = id ;
	}
	
	public Integer getId(){
		return this.id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
}
