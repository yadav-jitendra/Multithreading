package mythread;

public class Task extends Thread {
    String name;

    Task(String name){
        this.name = name;
    }

    public void run(){
        Thread.currentThread().setName(name);
        for(int i=0; i<20; i++){
            System.out.println("print: "+i+" from " +Thread.currentThread().getName());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Task task = new Task("Thread 1");
        task.start();

        System.out.println("starting Thread 1 ");

        Task task2 = new Task("Thread 2");
        task2.start();


        System.out.println("starting Thread 2 ");


    }

}
