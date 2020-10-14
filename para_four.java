//built in mechanism in java to avoid race conditions

package maven_pack;

public class para_four {
    private static Integer sum =0;//this shared memory is not go under a race condiition
    public static synchronized void sum(){ // this synchonized - becuae of this key word the interger sum resourse in not under a race condition   
        sum++;
    }

    public static void main(String[] args) {
        final Long start=System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            final Runnable r=()-> sum(); 
            final Thread t=new Thread(r);//creating the new thread
            t.start();//straing the new thread

        }
      
        final Long end=System.currentTimeMillis();
        System.out.println("Execution time=" + (end-start));
        System.out.println("sum is="+sum);
    }
}
// here execution time is leass than parrel join thread
