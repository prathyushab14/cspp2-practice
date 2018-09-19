import java.util.*;
class User {
	String name;
	ArrayList<String> followers;
	User(String name1, ArrayList<String> follow) {
		this.name = name;
		this.followers = follow;
	}
}
class Social {
	ArrayList<User> users;
	Social() {
		users = new ArrayList<User>();
	}
	public void getConnections(User u) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).name.equals(u.name)) {
				System.out.println(users.get(i).followers);
			}
		}
	}
	public void addConnections(User u) {
		boolean y = false;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).name.equals(u.name)) {
				for (int j = 0; j < u.followers.size(); j++) {
                    users.get(i).followers.add(u.followers.get(j));
                    y = true;
				}
		    }
        }
        if (!y) {
        	users.add(u);
        }
	}
}