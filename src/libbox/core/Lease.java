package libbox.core;

public class Lease {
	private Integer bookId;
	private Long expirationTime;
	private Integer personId;
	
	@Override
	public String toString() {
		return personId + " has borrowed " + bookId + " and has to return it until " + expirationTime;
	}
	
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Long getExpirationTime() {
		return expirationTime;
	}
	public void setExpirationTime(Long l) {
		this.expirationTime = l;
	}
	
}
