import java.io.*;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.Arrays;
class User {
	String name;
	String[] followers = new String[20];
	User() {

	}
	User(String name1, String[] follow) {
		this.name = name;
		this.followers = follow;
	}
    public void addconnector(String follow) {
		String[] data = getFoll();
		followers = Arrays.copyOf(data, followers.length + 1);
		followers[followers.length - 1] = follow;
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
		String[] connect = new String[20];
		boolean x = false;
		for (int i = 0; i < size; i++) {
			if (users[i].getName().equals(name)) {
				connect = users[i].getFoll();
				x = true;
			}
		}
		if (x) {
            System.out.println(Arrays.toString(connect));
		} else {
			System.out.println("Not a user in Network");
		}
	}
    public void addUser(User u1) {
    	User t = new User();
    	users[size++] = u1;
    	for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
    			if (users[i].getName().compareTo(users[j].getName()) > 0) {
    				t = users[i];
    				users[i] = users[j];
    				users[j] = t;
                }
    		}
    	}
    }
    public void network() {
    	int i = 0;
    	for (i = 0; i < size - 1; i++) {
    		System.out.println(users[i].getName()+": "+Arrays.toString(users[i].getFoll())+", ");
    	}
    	System.out.println(users[i].getName()+": "+Arrays.toString(users[i].getFoll()));
    }
	public void addConnections(String name, String foll) {
		for (int i = 0; i < size; i++) {
			if (users[i].getName().equals(name)) {
                users[i].addconnector(foll);
                break;
			}
		}
    }
    public void getcommonconnections(String name1, String name2) {
    	String[] f = new String[20];
    	String[] l = new String[20];
    	String[] co = new String[20];
    	int c = 0;
    		for (int i = 0; i < size; i++) {
			if (users[i].getName().equals(name1)) {
				f = users[i].getFoll();

			}
		}
		for (int j = 0; j < size; j++) {
			if (users[j].getName().equals(name2)) {
				l = users[j].getFoll();
			}
		}
		for (int i = 0; i < f.length; i++) {
			for (int j = 0; j < l.length; j++) {
				if (f[i].equals(l[j])) {
					co[c++] = f[i];
				}
			}
		}
		String[] commonlist1 = new String[c];
		System.arraycopy(co, 0, commonlist1, 0, c);
		System.out.println(Arrays.toString(commonlist1));
		}
    }
public class Solution {
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
        			String[] u = s.split(" is connected to ");
        			String[] fl = u[1].replace(" ","").replace(".","").split(",");
        			System.out.println(fl[2]);
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
