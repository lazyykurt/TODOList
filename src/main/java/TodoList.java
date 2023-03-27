import java.util.ArrayList;
import java.util.List;

// 定义待办事项列表类
public class TodoList {
    private List<TodoItem> items; // 待办事项列表

    // 构造函数，创建一个空的待办事项列表
    public TodoList() {
        this.items = new ArrayList<>();
    }

    // 添加新的待办事项到列表中
    public void addTodoItem(TodoItem item) {
        this.items.add(item);
    }

    // 根据ID从列表中删除指定的待办事项
    public void removeTodoItem(int id) {
        for (TodoItem item : this.items) {
            if (item.getId() == id) {
                this.items.remove(item);
                return;
            }
        }
    }

    // 根据ID将指定的待办事项标记为已完成状态
    public void markTodoItemAsCompleted(int id) {
        for (TodoItem item : this.items) {
            if (item.getId() == id) {
                item.markAsCompleted();
                return;
            }
        }
    }

    // 获取待办事项列表
    public List<TodoItem> getTodoItems() {
        return this.items;
    }
}

