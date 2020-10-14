
//doing the summation in a thread
package maven_pack;

public class para_two {
    private static Integer sum =0;

    public static void main(String[] args) {
        Long start=System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            Runnable r=()-> sum=sum+1; //Runnable interface using lambda expression
           new Thread(r).start();
        }
        // the following code can be write as the above one also using a runnable interface,that make clearer the function
        //for (int i = 0; i < 10000; i++) {
            
        //   new Thread(new Runnable(){
        //       public void run(){
        //           sum =sum+1;
        //       }

        //}).start();
        //}
        Long end=System.currentTimeMillis();
        System.out.println("Execution time=" + (end-start));
        System.out.println("sum is="+sum);
    }
    
}
//here in the out put for the sum value is getting a wrong value,less than 10000
//Implementation is wrong,it get random values.why??
//becuase its going under the race condition.
//here we are creating new threads for each implementing the sum.
//so in here,different threads are using the same integersum
//here theres no grantee one thrad is start after another,since this is parerell
//here time taken is higher than the serial one
//why?? creating a thraed at each time also take some time
//when create thrad it take some time to do background things, like memory allocation for each thread