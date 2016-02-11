package libbox.core;

import java.util.ArrayList;

import libbox.datasource.action.Action;
import libbox.datasource.action.Command;
import libbox.datasource.action.result.ReadResult;
import libbox.datasource.condition.EqualCondition;
import libbox.datasource.condition.GreaterCondition;
import libbox.datasource.condition.LessCondition;
import libbox.datasource.condition.OneFieldCondition;
import libbox.datasource.exception.CRUDException;
import libbox.datasource.inmemory.InMemoryDatabase;
import libbox.datasource.inmemory.InMemoryDatabaseSchema;
import libbox.datasource.structure.CRUDDatasource;

/**
 * @author colonelmo
 * Contains core library functionality
 */
public class Library {
	private CRUDDatasource members;
	private CRUDDatasource books;
	private CRUDDatasource leases;
	
	public Library(){
		InMemoryDatabaseSchema membersSchema = new InMemoryDatabaseSchema();
		membersSchema.add("fullname");
		membersSchema.add("id");
		membersSchema.setPrimaryKey("id");
		members= new InMemoryDatabase(membersSchema);
		
		InMemoryDatabaseSchema booksSchema = new InMemoryDatabaseSchema();
		booksSchema.add("name");
		booksSchema.add("id");
		booksSchema.add("author");
		booksSchema.setPrimaryKey("id");
		books = new InMemoryDatabase(booksSchema);

		InMemoryDatabaseSchema leasesSchema = new InMemoryDatabaseSchema();
		leasesSchema.add("expirationTime");
		leasesSchema.add("bookId");
		leasesSchema.add("personId");
		leasesSchema.setPrimaryKey("bookId");
		leases = new InMemoryDatabase(leasesSchema);
	}
	
	public void AddPerson(Person p){
		Command c = new Command(Action.CREATE);
		c.addData(InMemoryDatabase.serialize(p));
		try {
			members.query(c);
		} catch (CRUDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Person getPerson(String fullname){
		Command c = new Command(Action.READ);
		OneFieldCondition nameEqual = new EqualCondition("fullname", fullname);
		c.addOneFieldCondition(nameEqual);
		try {
			ReadResult r = (ReadResult) members.query(c);
			ArrayList<Person> results = r.convert(new Person());
			if(results.size() == 1){
				return results.get(0);
			}
		} catch (CRUDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null ;
	}
	
	public Book AddBook(Book b){
		Command c = new Command(Action.CREATE);
		c.addData(InMemoryDatabase.serialize(b));
		try {
			books.query(c);
		} catch (CRUDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	
	public void lease(Lease l){
		Command c = new Command(Action.CREATE);
		c.addData(InMemoryDatabase.serialize(l));
		try {
			leases.query(c);
		} catch (CRUDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Lease> getOverdue(Long time){
		Command c = new Command(Action.READ);
		OneFieldCondition cond = new GreaterCondition("expirationTime", time);
		c.addOneFieldCondition(cond);
		try {
			return ((ReadResult)leases.query(c)).convert(new Lease());
		} catch (CRUDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Lease>();
	}
	
	public ArrayList<Person> getMembers(){
		Command c = new Command(Action.READ);
		try {
			return ((ReadResult)members.query(c)).convert(new Person());
		} catch (CRUDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Person>();
	}
	
	public ArrayList<Book> getBooks(){
		Command c = new Command(Action.READ);
		try {
			return ((ReadResult)books.query(c)).convert(new Book());
		} catch (CRUDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Book>();
	}
	
}
