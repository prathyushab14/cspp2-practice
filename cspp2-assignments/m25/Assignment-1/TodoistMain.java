import java.util.Scanner;
import java.util.Arrays;

/**
  * write your code below this comment
  */
class Task {
	String title;
	String name;
	int time;
	boolean imp;
	boolean urg;
	String status;
    Task() {

	}
	Task(String title1, String name1, int time1, boolean imp1, boolean urg1, String status1) {
		title = title1;
		name = name1;
		time = time1;
		imp = imp1;
		urg = urg1;
		status = status1;
    }
    public String toString() {
    	String s = "";
    	String i = "";
    	String u = "";
    	try {
    		if (time < 0) {
    			throw new Exception("Invalid timeToComplete"+" "+time);
    		}
    	}
    		 catch(Exception e) {
    			return (e.getMessage());
    		}
    	try {
    		if (title.equals("")) {
    			throw new Exception("Title not provided");
    		}
    	}catch (Exception e) {
    		return (e.getMessage());
    	}
    	try {
        	if (status.equals("todo") || status.equals("done")) {
        		if (imp) {
    		        i = "Important";
                } else {
        	        i = "Not Important";
                }
                if (urg) {
        	        u = "Urgent";
                } else {
        	       u = "Not Urgent";
                } 
                s += title+", "+name+", "+time+", "+i+", "+u+", "+status;
    	        return s;
            } else {
            	throw new Exception ("Invalid status"+" "+status);
            } 
        }catch (Exception e) {
        	return (e.getMessage());
        } 
    }
}
class Todoist {
	Task[] tasks;
	int size;
	Todoist() {
		tasks = new Task[20];
		size = 0;
	}
	public void addTask(Task t) {
		tasks[size++] = t;
	}
}

/**
 * Class for todoist main.
 */
public class TodoistMain {

    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        Task t = new Task();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
                case "task":
                    testTask(tokens);
                break;
                case "add-task":
                    testAddTask(todo, tokens);
                break;
                // case "print-todoist":
                //     System.out.println(todo);
                // break;
                // case "get-next":
                //     System.out.println(todo.getNextTask(tokens[1]));
                // break;
                // case "get-next-n":
                //     int n = Integer.parseInt(tokens[2]);
                //     Task[] tasks = todo.getNextTask(tokens[1], n);
                //     System.out.println(Arrays.deepToString(tasks));
                // break;
                // case "total-time":
                //     System.out.println(todo.totalTime4Completion());
                // break;
                default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    public static void testAddTask(final Todoist todo, final String[] tokens) {
        try {
            todo.addTask(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
        String title = tokens[1];
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[3]);
        boolean important = tokens[4].equals("y");
        boolean urgent = tokens[5].equals("y");
        String status = tokens[6];
            return new Task(
                title, assignedTo, timeToComplete, important, urgent, status);
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}
