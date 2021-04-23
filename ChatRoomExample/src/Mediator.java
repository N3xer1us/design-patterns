
public interface Mediator {
	
	void join(User user);
	void kick(User user);
	void leave(User user);
	
	void sendMessage(User user , String text);
	String getChatName();
}
