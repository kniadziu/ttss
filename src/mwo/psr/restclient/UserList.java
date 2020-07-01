package mwo.psr.restclient;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

@XmlRootElement(name = "allUsers")
@JsonPropertyOrder({ "allUsers" })
public class UserList implements Serializable
{

	private static final long serialVersionUID = 1L;
	private List<User> users1;

	public UserList()
	{	
	}

	public UserList(List<User> u)
	{
		users1 = u;
	}

	@JsonGetter("allUsers")
	public List<User> getUsers4()
	{
		System.out.println("getUsers");
		return users1;
	}
	
	@JsonSetter("allUsers")
	public void setUsers5(List<User> list)
	{
		users1 = list;
		System.out.println("setUsers");
	}
}
