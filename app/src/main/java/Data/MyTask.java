package Data;

public class MyTask
{
   private String Key;
   private String title;
   private String Subject;
   private int priority;
    private String owner;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }



    public MyTask() {
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    @Override
    public String toString() {
        return "MyTask{" +
                "Key='" + Key + '\'' +
                ", title='" + title + '\'' +
                ", Subject='" + Subject + '\'' +
                ", priority=" + priority +
                '}';
    }
}





