// 定义待办事项类
public class TodoItem {
    private final int id; // 待办事项ID
    private final String content; // 待办事项内容
    private boolean completed; // 是否已完成

    // 构造函数，新建待办事项时自动生成ID，并默认为未完成状态
    public TodoItem(int id, String content) {
        this.id = id;
        this.content = content;
        this.completed = false;
    }

    // 获取待办事项ID
    public int getId() {
        return id;
    }

    // 获取待办事项内容
    public String getContent() {
        return content;
    }

    // 获取待办事项完成状态
    public boolean isCompleted() {
        return completed;
    }

    // 标记待办事项为已完成状态
    public void markAsCompleted() {
        this.completed = true;
    }
}
