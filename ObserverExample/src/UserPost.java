import java.util.ArrayList;

public class UserPost implements Observable {

	private String postAuthor;
    private String content;
    private ArrayList<Observer> postFollowers;

    public UserPost(String content , String author)
    {
        this.postAuthor = author;
        this.content = content;
        postFollowers = new ArrayList<Observer>();
    }

    public void attach(Observer user)
    {
        user.followPost(this);
        postFollowers.add(user);
    }

    public void detach(Observer user)
    {
        user.unfollowPost(this);
        postFollowers.remove(user);
    }

    public String getUpdate()
    {
        return content;
    }

    public void notifyUsers()
    {
        for(int i=0;i<postFollowers.size();i++)
        {
        	postFollowers.get(i).update();
        }
    }

    public String getAuthor()
    {
        return postAuthor;
    }

    public void changeContent(String newContent)
    {
        this.content = newContent;
        notifyUsers();
    }
	
}
