import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	public int count=10;
	@ManyToOne
	private Author author;
	@ManyToMany
	private List<Member> members=new ArrayList<Member>();
	public Book(String name,Author author)
	{
		this.name=name;
		this.author=author;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setAuthor()
	{
		this.author=author;
	}
	public Author getAuthor()
	{
		return author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount()
	{
		return count;
	}
	
	public List<Member> getMembers()
	{
		return members;
	}
	
}
