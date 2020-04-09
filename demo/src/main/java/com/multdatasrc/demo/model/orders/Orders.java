package com.multdatasrc.demo.model.orders;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Orders")
public class Orders {
	
	@Id
	private int transacId;
	
	private String userName;
	private String orderName;
	
	

}
