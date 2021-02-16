package com.blog.tutorial.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private long id;

	    @Column(name = "name")
	    private String name;

	    @Column(name = "city")
	    private String city;

	    @Column(name = "email")
	    private String email;

		public User() {
			super();
		}

		public User(long id, String name, String city, String email) {
			super();
			this.id = id;
			this.name = name;
			this.city = city;
			this.email = email;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

}
