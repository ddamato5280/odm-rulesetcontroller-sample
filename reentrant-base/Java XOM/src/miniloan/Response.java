package miniloan;

import java.util.Vector;

public class Response {
	private String status;
	private Vector<String> messages = new Vector<String>();
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Vector<String> getMessages() {
		return messages;
	}
	public void setMessages(Vector<String> messages) {
		this.messages = messages;
	}
	public void addMessage(String message) {
		this.messages.add(message);
	}

}
