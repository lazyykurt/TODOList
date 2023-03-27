import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

// 定义TODO List应用程序类
public class TodoApp {
    private final TodoList todoList; // 待办事项列表
    private final Scanner scanner; // 用于读取用户输入的Scanner对象
    private final HashMap<String, Runnable> options = new HashMap<>(); // 功能选项

    // 构造函数，创建一个空的待办事项列表和一个Scanner对象
    public TodoApp() {
        scanner = new Scanner(System.in);
        todoList = new TodoList();
    }

    private void setOptions() {
        options.put("add", this::addTodoItem);
        options.put("mark", this::markTodoItemAsCompleted);
        options.put("del", this::removeTodoItem);
        options.put("show", this::displayTodoItems);
        options.put("quit", this::quit);
    }

    // 运行TODO List应用程序
    public void run() {
        // 前置加载
        setOptions();
        printMenu();
        // 主程序逻辑
        boolean quit = false;
        while (!quit) {
            String choice = scanner.next();
            scanner.nextLine();
            Runnable action = options.get(choice);
            if (action == null) {
                System.out.println("无效选项，请重新选择！");
            } else {
                action.run();
            }
        }
    }

    // 显示菜单
     public void printMenu() {
         System.out.println("----------TODO List----------");
         System.out.println("Please choose an action:");
         System.out.println("[add]   Add to-do items");
         System.out.println("[mark]  Mark the to-do as done");
         System.out.println("[del]   Delete to-do items");
         System.out.println("[show]  Show all todos");
         System.out.println("[quit]  Exit the app");
         System.out.println("-----------------------------");
    }

    // 添加待办事项
    private void addTodoItem() {
        System.out.println("Please enter the content of the to-do list:");
        String content = scanner.nextLine();
        TodoItem item = new TodoItem(todoList.getTodoItems().size() + 1, content);
        todoList.addTodoItem(item);
        System.out.println("Added successfully!");
    }

    // 标记待办事项为已完成
    private void markTodoItemAsCompleted() {
        System.out.println("Please enter the ID of the to-do item:");
        int id = scanner.nextInt();
        scanner.nextLine();
        todoList.markTodoItemAsCompleted(id);
        System.out.println("Marked successfully!");
    }

    // 删除待办事项
    private void removeTodoItem() {
        System.out.println("Please enter the ID of the to-do item:");
        int id = scanner.nextInt();
        scanner.nextLine();
        todoList.removeTodoItem(id);
        System.out.println("Successfully deleted!");
    }

    // 显示所有待办事项
    private void displayTodoItems() {
        List<TodoItem> items = todoList.getTodoItems();
        if (items.size() == 0) {
            System.out.println("There are currently no todos!");
            return;
        }
        System.out.println("Current todo:");
        for (TodoItem item : items) {
            String status = item.isCompleted() ? "completed" : "undone";
            System.out.printf("%d. %s [%s]\n", item.getId(), item.getContent(), status);
        }
    }

    // 退出程序
    private void quit() {
        System.out.println("Bye ~");
        System.exit(0);
    }
}
