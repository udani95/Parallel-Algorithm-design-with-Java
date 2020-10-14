//stream API,really powerful parrel mechanism
//with of use of this we can do more parell comouting under java
//stream api- abstract over the hard ware parallism 
package maven_pack;

import java.util.stream.LongStream;

public class para_five {
    private static Integer sum =0;//this shared memory is not go under a race condiition
    public static synchronized void sum(){ // this synchonized - becuae of this key word the interger sum resourse in not under a race condition   
        sum++;
    }

    public static void main(String[] args) {
        final Long start=System.currentTimeMillis();
        long sum2 = LongStream.range(0,10000).count();
        final Long end=System.currentTimeMillis();
        System.out.println("Execution time=" + (end-start));
        System.out.println("sum is="+sum2);
    }
}
//execution time is less here