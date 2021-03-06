
public class ChatUser extends User{

	public ChatUser(String name) {
		super(name);
	}
	
	@Override
	public void send(String msg) {
		
		if(chat != null)
		{
			System.out.println(username + ": " + msg);
			chat.sendMessage(this, msg);
		}
		else
		{
			System.out.println(username + " hasn't joined a chat room yet");
		}
	}

	@Override
	public void receive(String msg) {
		
		if(chat != null)
		{
			System.out.println(username + " has recieved the message: " + msg);
		}
	}

	@Override
	public void joinChat(Mediator chat) {
		
		chat.join(this);
		this.chat = chat;
		System.out.println(username + " has joined the chat room: " + chat.getChatName());
		
	}

	@Override
	public void leaveChat(Mediator chat) {
		
		chat.leave(this);
		this.chat = null;
		System.out.println(username + " has left the chat room: " + chat.getChatName());
		
	}

	@Override
	public String getUsername() 
	{
		return username;
	}

}
