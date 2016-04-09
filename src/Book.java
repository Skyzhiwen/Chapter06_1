import java.io.Serializable;
public class Book implements Serializable{
	private static final long serialVersionUID=1L;
	private String name;
	private String id ;
	public void Book(){}
	
	public Book(String id , String name){
		this.id = id ;
		this.name=name;
	}
	public String getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	public void setName(String name){
		this.name=name;
	}
	

}
