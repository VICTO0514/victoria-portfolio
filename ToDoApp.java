import java.util.ArrayList;
import java.util.Scanner;
class Task{

private int id;
private String title;
String description;
String status;

Task(int id, String title, String description){
this.id=id;
this.title=title;
this.description=description;
this.status=status;
}

public int getId() { return id; }
public String getTitle() { return title; }

public void setTitle(String title) { this.title=title; }
public void setDescription(String description ) { this.description=description; }
public void setStatus(String status) { this.status=status; }
 
public void display(){
System.out.println("ID: "+id + "| Title: " + title + "| Description: "+description+ "| Status" + status);
}
}


public class ToDoApp{

private static ArrayList<Task> tasks=new ArrayList<> ();
private static Scanner sc=new Scanner(System.in);

public static void main(String[] args){

while(true){

System.out.println("--To Do List Menu--");
System.out.println("1. Add Task");
System.out.println("2. View Task");
System.out.println("3. Update Task");
System.out.println("4. Delete Task");
System.out.println("5. Exit");

System.out.println("Enter choice: ");
int choice=sc.nextInt();
sc.nextLine();

switch(choice){

case 1:
add();
break;

case 2:
view();
break;

case 3:
update();
break;

case 4:
delete();
break;

case 5:
System.out.println("Existing..."); return;

default:
System.out.println("Invalid choice!");
}
}
}

public static void add(){
    System.out.println("Enter title: ");
    String title=sc.nextLine();
    System.out.println("Enter description: ");
    String desc=sc.nextLine();
    
    Task task=new Task(tasks.size()-1, title, desc);
    tasks.add(task);
    System.out.println("Task added Successfully!");
}

public static void view(){
    if(tasks.isEmpty()){
    System.out.println("No tasks available");
    }
    else{
    for(Task t:tasks){
    t.display();
    }
    }
}

public static void update(){
    System.out.println("Enter task Id to update: ");
    int id=sc.nextInt();
    sc.nextLine();
    
    for(Task t:tasks){
       if(t.getId() == id){
       System.out.println("Enter new title: ");
            t.setTitle(sc.nextLine());
                System.out.print("Enter new description: ");
                t.setDescription(sc.nextLine());
                System.out.print("Enter new status (Pending/Completed): ");
                t.setStatus(sc.nextLine());
                System.out.println("Task updated successfully!");
                return;
            }
        }
        System.out.println("Task not found!");
    }

    // 🔹 Delete Task
    public static void delete() {
        System.out.print("Enter task ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Task t : tasks) {
            if (t.getId() == id) {
                tasks.remove(t);
                System.out.println("Task deleted successfully!");
                return;
            }
        }
        System.out.println("Task not found!");
    }
}
    
    



