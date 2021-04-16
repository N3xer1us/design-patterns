
public interface Observable {

	void attach(Observer user);
    void detach(Observer user);

    void notifyUsers();
    String getUpdate();

    String getAuthor();
	void changeContent(String content);
	
}
