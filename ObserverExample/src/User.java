import java.util.ArrayList;

public class User implements Observer{

	private Observable myPost;

    private ArrayList<Observable> followedPosts;

    private ArrayList<Observer> friends;

    private String username;

    public User(String username)
    {
        this.username = username;
        followedPosts = new ArrayList<Observable>();
        friends = new ArrayList<Observer>();
    }

    public void update()
    {
        if(followedPosts.size() == 0)
        {
            System.out.println(username + " hasn't followed any posts");
            return;
        }
        else
        {
            for(int i=0; i< followedPosts.size();i++)
            {
                String postUpdate = followedPosts.get(i).getUpdate();
                System.out.println(username + " has received an update on a followed post by " + followedPosts.get(i).getAuthor() + ": " + postUpdate);
            }
        }

    }


    public void followPost(Observable post)
    {
        followedPosts.add(post);
    }

    public void unfollowPost(Observable post)
    {
        followedPosts.remove(post);
    }

    public void createPost(String postContent)
    {

        myPost = new UserPost(postContent, username);;

        for(int i=0;i<friends.size();i++)
        {
            myPost.attach(friends.get(i));
        }
        
        myPost.notifyUsers();
        
    }

    public void removePost()
    {
        
        for(int i=0;i<friends.size();i++)
        {
            myPost.detach(friends.get(i));
        }
        
        myPost = null;
        
    }
    
    public void editPost(String newContent)
    {
    	myPost.changeContent(newContent);
    }
	

    public void addFriend(Observer friend)
    {
        friends.add(friend);

        if(myPost!=null)
        {
        	myPost.attach(friend);
        }
        
    }

    public void removeFriend(Observer friend)
    {
        friends.remove(friend);

        if(myPost!=null)
        {
        	myPost.detach(friend);
        }

    }

}
