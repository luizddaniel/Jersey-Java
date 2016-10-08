package br.com.estudo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class TaskEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	@Column
	private String data_inicio;

	@Column
	private String descripition;

	@Column
	private String status;

	@Column
	private String data_fim;

	public TaskEntity(String data_inicio, String descripition, String status,
			String data_fim) {
		this.data_inicio = data_inicio;
		this.descripition = descripition;
		this.status = status;
		this.data_fim = data_fim;
	}

	public TaskEntity() {
		super();
	}

	public TaskEntity(Integer id, String data_inicio, String descripition,
			String status, String data_fim) {
		this.id = id;
		this.data_inicio = data_inicio;
		this.descripition = descripition;
		this.status = status;
		this.data_fim = data_fim;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(String data_inicio) {
		this.data_inicio = data_inicio;
	}

	public String getDescripition() {
		return descripition;
	}

	public void setDescripition(String descripition) {
		this.descripition = descripition;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getData_fim() {
		return data_fim;
	}

	public void setData_fim(String data_fim) {
		this.data_fim = data_fim;
	}

}
