package test;

import libbox.core.Book;
import libbox.core.Lease;
import libbox.core.Library;
import libbox.core.Person;

public class Main {
	public static void main(String[] args){
		Library l = new Library();
		
		Person p = new Person();
		p.setFullname("Mohammad Nasifiar");
		p.setId(123);
	

		Book b = new Book();
		b.setAuthor("chomsky");
		b.setName("languages");
		b.setId(666);

		Book b2 = new Book();
		b2.setAuthor("compilers");
		b2.setName("aho");
		b2.setId(124);
		
		Lease lease = new Lease();
		lease.setBookId(b2.getId());
		lease.setPersonId(p.getId());
		lease.setExpirationTime(System.currentTimeMillis()+2);
		
		l.AddPerson(p);
		l.AddBook(b);
		l.AddBook(b2);
		
		l.lease(lease);
		
		Long now = System.currentTimeMillis();
		System.out.println("now : "  + now);
		
		System.out.println(l.getBooks());
		System.out.println(l.getMembers());
		System.out.println(l.getOverdue(now));
	}
}
