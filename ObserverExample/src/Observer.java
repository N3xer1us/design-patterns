
public interface Observer {

	void update();
    void followPost(Observable post);
    void unfollowPost(Observable post);
    void createPost(String postContent);
    void removePost();
	
}
