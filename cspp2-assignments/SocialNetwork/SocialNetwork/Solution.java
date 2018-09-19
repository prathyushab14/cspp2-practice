import java.util.*;
class User {
	String name;
	String[] followers;
	User() {

	}
	User(String name1, String[] follow) {
		this.name = name;
		this.followers = follow;
	}
	public String getName() {
		return name;
	}
	public String[] getFoll() {
		return followers;
	}
}
class Social {
	User[] users;
	int size;
	Social() {
		users = new User[20];
		size = 0;
    }
	public void getConnections(String name) {
		for (int i = 0; i < size; i++) {
			if (users[i].getName().equals(name)) {
				System.out.println(users[i].getFoll());
			}
		}
	}
    public void addUser(User u1) {
    	User t = new User();
    	for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
    			if (users[i].getName().compareTo(users[j].getName()) > 0) {
    				t = users[i];
    				users[i] = users[j];
    				users[j] = t;
                }
    		}
    	}
    }
	public void addConnections(User u) {
		boolean y = false;
		for (int i = 0; i < size; i++) {
			if (users[i].getName().equals(u.name)) {
				for (int j = 0; j < size; j++) {
                    users[i].getFoll().add(u[j].getFoll());
                    y = true;
				}
		    }
        }
        if (!y) {
        	users.add(u);
        }
	}
}
class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Social so = new Social();
		Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
        	String line = sc.nextLine();
        	String[] tokens = line.split(" ");
        	switch (tokens[0]) {
        		case "Create":
        		int no = Integer.parseInt(tokens[1]);
        		for (int i = 0; i < no; i++) {
        			String s = sc.nextLine();
        			String u = s.split(" is connected to ");
        			String fl = u[1].replace(" "," ").replace(".","").split(",");
        			so.addUser(new User(u[0], fl));
        		}
        		break;
                case "Network":
                so.network();
                break;
                case "addConnections":
                so.addConnections(tokens[1], tokens[2]);
                break;
                case "getConnections":
                so.getConnections(tokens[1]);
                break;
                case "CommonConnections":
                so.getcommonconnections(tokens[1], tokens[2]);
                break;
                default:
                break;
                }
        	}
        }
    }