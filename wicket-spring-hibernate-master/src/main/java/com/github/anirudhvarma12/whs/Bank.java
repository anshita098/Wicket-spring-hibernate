package com.github.anirudhvarma12.whs;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="userbank")
public class Bank {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="custid_generator")
	@SequenceGenerator(name="custid_generator",sequenceName="bank_id",allocationSize=1)
	@Column(name="id",updatable=false,nullable=false)
	
private int id;
	
	@Column(name="firstname")
	private String firstname;
	
	//@Size(min=6)
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;

	private static final Map<Long, Bank> idToBook = new HashMap<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	private void add(final Bank book)
    {
        boolean hit = false;
        for (Bank value : idToBook.values())
        {
            if (value.toString().equals(book.toString()))
            {
                book.id = value.id;
                hit = true;
                break;
            }
        }

        if (hit == false)
        {
            idToBook.put((long) book.id, book);
        }
    }
	public static Bank get(final long id)
    {
        return idToBook.get(id);
    }
	@Override
	public String toString() {
		return "Bank [id=" + id + ", firstname=" + firstname + ", password=" + password + ", email=" + email + "]";
	}
}
