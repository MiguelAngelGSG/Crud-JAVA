import java.util.Scanner;

public class ToDoListApp {
    // Máximo número de tareas
    private static final int MAX_TASKS = 100;
    // Arreglo para almacenar las tareas
    private static String[] tasks = new String[MAX_TASKS];
    // Arreglo para almacenar el estado de las tareas (completadas o no)
    private static boolean[] completed = new boolean[MAX_TASKS];
    // Contador de tareas
    private static int taskCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("To-Do List:");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Eliminar tarea");
            System.out.println("3. Listar tareas");
            System.out.println("4. Marcar tarea como completada");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (option) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    removeTask(scanner);
                    break;
                case 3:
                    listTasks();
                    break;
                case 4:
                    markTaskAsCompleted(scanner);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (option != 5);
    }

    private static void addTask(Scanner scanner) {
        if (taskCount >= MAX_TASKS) {
            System.out.println("La lista de tareas está llena.");
            return;
        }
        System.out.print("Ingrese la descripción de la tarea: ");
        String task = scanner.nextLine();
        tasks[taskCount] = task;
        completed[taskCount] = false;
        taskCount++;
        System.out.println("Tarea agregada.");
    }

    private static void removeTask(Scanner scanner) {
        System.out.print("Ingrese el número de la tarea a eliminar: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        if (taskNumber < 1 || taskNumber > taskCount) {
            System.out.println("Número de tarea no válido.");
            return;
        }
        for (int i = taskNumber - 1; i < taskCount - 1; i++) {
            tasks[i] = tasks[i + 1];
            completed[i] = completed[i + 1];
        }
        tasks[taskCount - 1] = null;
        completed[taskCount - 1] = false;
        taskCount--;
        System.out.println("Tarea eliminada.");
    }

    private static void listTasks() {
        if (taskCount == 0) {
            System.out.println("No hay tareas en la lista.");
            return;
        }
        for (int i = 0; i < taskCount; i++) {
            System.out.printf("%d. %s [%s]%n", i + 1, tasks[i], completed[i] ? "Completada" : "Pendiente");
        }
    }

    private static void markTaskAsCompleted(Scanner scanner) {
        System.out.print("Ingrese el número de la tarea a marcar como completada: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        if (taskNumber < 1 || taskNumber > taskCount) {
            System.out.println("Número de tarea no válido.");
            return;
        }
        completed[taskNumber - 1] = true;
        System.out.println("Tarea marcada como completada.");
    }
}
