
class queue{
    int[] q=new int[4];
    int size=q.length;
    int start=-1;
    int end=-1;
    int currsize=0;

    void push(int x){
        if (currsize==size) {
            System.out.println("queue is full");
        }
        if (start==-1 && end==-1) {
            start=end=0;
        }
        else{
            end=(end+1)%size;
        }
        q[end]=x;
        currsize++;
    }
    int pop(){
        if (currsize==0) {
            return -1;
        }
        int x=q[start];
        if (currsize==1) {
            start=end=-1;
        }
        else{
            start=(start+1)%size;
        }
        currsize--;
        return x;
    }
    int top(){
        if (currsize==0) {
            return -1;
        }
        return q[start];
    }
    int size(){
        return currsize;
    }
}
public class Implement_Queue_using_Arrays {
    public static void main(String[] args) {
        queue q=new queue();

        q.push(3);
        q.push(4);
        q.push(5);
    
        System.out.println("pop "+q.pop());
        System.out.println("top "+q.top());
        q.push(8);
        System.out.println("top "+q.top());
        System.out.println("size "+q.size());
        q.push(9);
        System.out.println("size "+q.size());
        System.out.println("pop "+q.pop());
        System.out.println("pop "+q.pop());
        System.out.println("pop "+q.pop());
        System.out.println("top "+q.top());
    }
}
