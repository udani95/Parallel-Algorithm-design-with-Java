package maven_pack;
import java.util.function.Function;

public class App {
    public static void main(final String[] args){
            System.out.println(
                "Iterative sum done in: "+ measurePerf(ParallelStreams::iterativeSum, 10_000_000L) + " msecs");
        
            System.out.println(
                "Sequential sum done in: "+ measurePerf(ParallelStreams::sequentinalSum, 10_000_000L) + " msecs");

            System.out.println(
                "Parallel folk joinsum sum done in: "+ measurePerf(ParallelStreams::parallelSum, 10_000_000L) + " msecs");   

            System.out.println(
                "Range folkJoinsum done in: "+ measurePerf(ParallelStreams::rangedSum, 10_000_000L) + " msecs");   
            
            System.out.println(
                "Parallel  Range folkJoinsum done in: "+ measurePerf(ParallelStreams::parallelRangedSum, 10_000_000L) + " msecs");   

            System.out.println(
                "Side effect sum sum done in: "+ measurePerf(ParallelStreams::sideEffectSum, 10_000_000L) + " msecs");   

            System.out.println(
                "Parallel Side effect sum done in: "+ measurePerf(ParallelStreams::sideEffectParallelSum, 10_000_000L) + " msecs");   
    }


//when we measure the performance of a alogirth,this tell how moch time does it take
        // in measurePerf function we are taking a function as a parameter, input=num of items we are applying
        //alogtithm run 10 times
    public static<T,R>long measurePerf(Function<T,R>f,T input){
        long fastest=Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            R result = f.apply(input);
            long duration = (System.nanoTime()-start)/1000000;
            //System.out.println("Result:"+result);
            if (duration<fastest)
                fastest=duration;
        }
        return fastest;
    }
}
