import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
	public static void setBooks(Member m,Book b)
	{
		if(b.count==0)
		{
			System.out.println("Book "+b.getName()+" out of stock.");		
			return;
		}
		m.setBooks(b); 
		b.count--;
	}
	public static void getBooks(Member m)
	{
		List<Book> books=m.getBooks();
		if (books.isEmpty()) 
		{
		    System.out.println("No books with member " + m.getName()+".");
		} 
		else 
		{
		    System.out.println("The books with member " + m.getName() + " are: ");
		    for (Book b : books) {
		        System.out.println("- " + b.getName());
		    }
		}

	}
	public static void returnBook(Member m,Book b)
	{
		m.removeBook(b);
		System.out.println("After returning book");
		getBooks(m);
	}
	public static void main(String args[]) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("EmployeePU");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		//creating authors
		Author a1=new Author("prabhas");
		Author a2=new Author("chandra");
		Author a3=new Author("damu");
		em.persist(a1);
		em.persist(a2);
		em.persist(a3);
		//creating books
		Book b1=new Book("C",a1);
		Book b2=new Book("cpp",a2);
		Book b3=new Book("java",a3);
		Book b4=new Book("python",a1);
		em.persist(b1);
		em.persist(b2);
		em.persist(b3);
		em.persist(b4);
		//creating members
		Member m1=new Member("chimtu");
		em.persist(m1);
		em.getTransaction().commit();
		setBooks(m1,b1);
		setBooks(m1,b2);
		getBooks(m1);
		returnBook(m1,b1);
		
		
		em.close();
	}
}
