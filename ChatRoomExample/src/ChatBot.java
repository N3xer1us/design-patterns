import java.util.ArrayList;

public class ChatBot {
	
	private static ChatBot instance;
	
	private ArrayList<String> bannedWords;
	private boolean isActive;
	
	public ChatBot() {
		bannedWords = new ArrayList<String>();
		isActive = false;
	}
	
	public static ChatBot getInstance() {
		
		if(instance == null)
		{
			instance = new ChatBot();
		}
		
		return instance;
		
	}
	
	public void addBannedWord(String word) 
	{
		bannedWords.add(word);
	}
	
	public void removeBannedWord(String word) 
	{
		bannedWords.remove(word);
	}
	
	public void activateBot() {
		this.isActive = true;
	}
	
	public void deactivateBot() {
		this.isActive = false;
	}
	
	public boolean getStatus() {
		return isActive;
	}
	
	public boolean checkMessage(String msg) {
		
		for(int i = 0 ; i < bannedWords.size() ; i++)
		{
			if(msg.contains(bannedWords.get(i).toString()))
			{
				return true;
			}
		}
		
		return false;
		
	}
	
}
