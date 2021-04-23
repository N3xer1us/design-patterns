
public class ChatRoomMain {

	public static void main(String[] args) {
		
		ChatUser user1 = new ChatUser("Ivan");
		ChatUser user2 = new ChatUser("Gosho");
		ChatUser user3 = new ChatUser("Sasho");
		
		ChatRoom chat = new ChatRoom("Friend Chat");
		
		
		
		user1.joinChat(chat);
		user2.joinChat(chat);
		user3.joinChat(chat);
		
		user1.send("/startBot");
		user1.send("/bot addWord cat");
		
		user2.send("cat");
		
		user2.send("hi");
		user1.send("hi");
		
		user1.send("/stopBot");
		
		user2.joinChat(chat);
		user1.send("cat");
		
		/*
		Chat Bot commands:
		1. /startBot - start the bot
		2. /stopBot - stop the bot
		3. /bot addWord <word> - add a banned word
		4. /bot removeWord <word> - remove a banned word
		5. /help - show commands
		
		
		user2.send("cat");
		
		user1.send("/startBot");
		user1.send("/bot addWord cat");
		
		user2.send("cat");
		
		user2.send("hi");
		user1.send("hi");
		
		user1.send("/stopBot");
		
		user2.joinChat(chat);
		user1.send("cat");
		
		*/
		
		user1.send("/help");
		
	}

}
