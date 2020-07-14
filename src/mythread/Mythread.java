package mythread;

public class Mythread extends Thread{

    public void run(){
        int i = 0;
        while (true){
            if(isInterrupted()){
                break;
            }
            System.out.println(++i);
        }
    }

    public static void main(String[] args)  {
        Mythread mythread = new Mythread();
        mythread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mythread.interrupt();  // sets a flag to interrupt

        System.out.println(mythread.isAlive());


    }
}
