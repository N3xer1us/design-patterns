
public class Main {
	
	public static void main(String[] args) 
	{
		User user1 = new User("Ivan");
        User user2 = new User("Todor");
        User user3 = new User("MartoV");

        user1.addFriend(user2);
        user2.addFriend(user1);

        user1.addFriend(user3);
        user3.addFriend(user1);

        user1.createPost("Hi everyone");
        user1.editPost("Hi !!!!");
	}
}
