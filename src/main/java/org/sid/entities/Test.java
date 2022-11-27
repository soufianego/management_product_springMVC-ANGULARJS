
package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Test {

	@Id
	   @GeneratedValue
		private Long id;
	  
	   
		private String name;


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public Test(Long id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
	   
		public Test() {
			super();
			
		}
	
	   
	   
	   
}

