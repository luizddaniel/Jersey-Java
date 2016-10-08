package br.com.estudo;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Task {

	private Integer id;
	private String data_inicio;
	private String descripition;
	private String status;
	private String data_fim;

	public Task() {
		super();
	}

	public Task(Integer id, String data_inicio, String descripition,
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
