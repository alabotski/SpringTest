package by.lesharb.springtest.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hobby")
public class Hobby implements Serializable {

	private static final long serialVersionUID = -675073036461715965L;

	private String hobbyId;
	private Set<Contact> contacts = new HashSet<Contact>();

	public Hobby() {
	}

	public Hobby(String hobbyId) {
		this.hobbyId = hobbyId;
	}

	public Hobby(String hobbyId, Set<Contact> contacts) {
		this.hobbyId = hobbyId;
		this.contacts = contacts;
	}

	@Id
	@Column(name = "HOBBY_ID")
	public String getHobbyId() {
		return this.hobbyId;
	}

	public void setHobbyId(String hobbyId) {
		this.hobbyId = hobbyId;
	}

	@ManyToMany(cascade = CascadeType.ALL, mappedBy="hobbies")
	public Set<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	public String toString() {
		return "Hobby :" + getHobbyId();
	}
}
