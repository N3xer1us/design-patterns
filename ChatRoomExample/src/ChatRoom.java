import java.util.ArrayList;

public class ChatRoom implements Mediator {

	private String chatName;
	private ArrayList<User> users;
	private ChatBot bot;
	
	public ChatRoom(String name) {
		this.chatName = name;
		users = new ArrayList<User>();
		bot = bot.getInstance();
	}
	
	public String getChatName() {
		return chatName;
	}
	
	@Override
	public void join(User user) {
		
		users.add(user);
		
	}
	

	@Override
	public void leave(User user) {
		
		users.remove(user);

	}

	@Override
	public void sendMessage(User user, String text) {

		if(text.startsWith("/")) 
		{
			String[] command = text.split(" ");
			
			if(command[0].equals("/startBot")) 
			{
				bot.activateBot();
				System.out.println("The chat bot is ON");
				return;
			}
			else if(command[0].equals("/stopBot"))
			{
				bot.deactivateBot();
				System.out.println("The chat bot is OFF");
				return;
			}
			else if(command[0].equals("/help"))
			{
				System.out.println("Chat Bot commands:\r\n" + 
						"1. /startBot - start the bot\r\n" + 
						"2. /stopBot - stop the bot\r\n" + 
						"3. /bot addWord <word> - add a banned word\r\n" + 
						"4. /bot removeWord <word> - remove a banned word");
				return;
			}
			else if(command[0].equals("/bot"))
			{
				if(command[1].equals("addWord"))
				{
					bot.addBannedWord(command[2]);
					System.out.println("The word: " + command[2] + " is banned , saying it will result in a kick");
					return;
				}
				if(command[1].equals("removeWord"))
				{
					bot.removeBannedWord(command[2]);
					System.out.println("The word: " + command[2] + " is no longer banned");
					return;
				}
			}
			
			System.out.println("Invalid command , use /help to see the bot commands");
		}
		else
		{
			if(bot.getStatus())
			{
				if(bot.checkMessage(text)) 
				{
					kick(user);
					return;
				}
			}

			for(int i = 0 ; i< users.size() ; i++)
			{
				if(users.get(i) != user)
				{
						users.get(i).receive(text);
				}
			}
		}
	}

	

	@Override
	public void kick(User user) {
		
		user.receive("You have been kicked from " + chatName);
		
		for(int i = 0 ; i< users.size() ; i++)
		{
			if(users.get(i) != user)
			{
				users.get(i).receive(user.getUsername() + " has been kicked from the group because he said a banned word");
			}
		}
		
		user.leaveChat(this);

	}
	
}
