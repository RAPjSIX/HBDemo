package com.queries;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name = "ClientTbl")
@NamedNativeQueries({
		@NamedNativeQuery(name = "findbyname", query = "select*from ClientTbl", resultClass = Client.class) })
public class Client {
	@Id
	private int clientId;
	private String clientName;
	

	public Client(int clientId, String clientName) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientName=" + clientName + "]";
	}

	public Client() {
		super();
	}
	

}
