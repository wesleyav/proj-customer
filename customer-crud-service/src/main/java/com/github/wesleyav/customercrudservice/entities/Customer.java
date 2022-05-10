package com.github.wesleyav.customercrudservice.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Long id;

	@Column(name = "first_name")
	@NotNull
	private String firstName;

	@Column(name = "last_name")
	@NotNull
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "active")
	@NotNull
	private Boolean active;

	@Column(name = "create_date")
	@NotNull
	private Instant createDate;

	@Column(name = "last_update")
	private Instant lastUpdate;

}
