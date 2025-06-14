class stack{
    int[] st=new int[10];
    int top=-1;

    void push(int x){
        top++;
        st[top]=x;
    }
    int pop(){
        int x=st[top];
        top--;
        return x;
    }
    int top(){
        return st[top];
    }
    int size(){
        return top+1;
    }
}

class Implement_Stack_using_Arrays {
    public static void main(String[] args) {
        stack s=new stack();

        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println("top "+s.top());
        s.pop();
        System.out.println("top "+s.top());
        s.push(6);
        System.out.println("top "+s.top());
        System.out.println("size "+s.size());
    }
}