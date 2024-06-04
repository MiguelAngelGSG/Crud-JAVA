package listtask;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
                List<String> tasks = new ArrayList<>();
                Scanner scanner = new Scanner(System.in);

                while (true) {
                    System.out.println("\n¿What action do you want to perform?");
                    System.out.println("1. Add Task");
                    System.out.println("2. Delete Task");
                    System.out.println("3. List Tasks");
                    System.out.println("4. Mark Task as Complete");
                    System.out.println("5. Go out");
 		    System.out.print("Select an option: ");
                    
		    int option = scanner.nextInt();
                    scanner.nextLine();

                    switch (option) {
                        case 1:
                            System.out.print("Enter the new task: ");
                            String newTask = scanner.nextLine();
                           addTask(tasks, newTask);
                            break;
                        case 2:
                            System.out.print("Enter the index of the task to delete: ");
                            int indexDelete = scanner.nextInt();
                           removeTask(tasks, indexDelete);
                            break;
                        case 3:
                            listTask(tasks);
                            break;
                        case 4:
                            System.out.print("Enter the index of the completed task: ");
                            int indexCompleted = scanner.nextInt();
                            taskCompleted(tasks, indexCompleted);
                            break;
                        case 5:
                            System.out.println("¡bye bye!");
                            return;
                        default:
                            System.out.println("Invalid option. Try again.");
                    }
                    scanner.close();
                }
            }
            
            private static void taskCompleted(List<String> tasks, int index) {
                if (index >= 0 && index < tasks.size()) {
                    tasks.set(index, "[COMPLETED] " + tasks.get(index));
                    System.out.println("Task marked as completed.");
                } else {
                    System.out.println("Invalid index. The task does not exist.");
                }
            }  
                   
        }