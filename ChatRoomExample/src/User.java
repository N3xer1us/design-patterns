
public abstract class User {

	protected String username;
	protected Mediator chat;
	
	public User(String username) {
		this.username = username;
	}
	
	public abstract void send(String msg);
	public abstract void receive(String msg);
	public abstract void joinChat(Mediator chat);
	public abstract void leaveChat(Mediator chat);
	public abstract String getUsername();
	
}
