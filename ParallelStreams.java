package maven_pack;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import scala.jdk.Accumulator;


public class ParallelStreams {

	public static long iterativeSum(long n)
    {
        long result =0;
        for (int i = 0; i <=n; i++)//for looop is a sequentinal algorthim
        {
            result +=i;//in 1 st interation 1=1,2nd iteration i=2 and result=3,in 2rd iteration i=3 and result =6 like wise
        }
        return result;
    }

    public static long sequentinalSum(long n)
    {
        return Stream.iterate(1L, i->i+1).limit(n).reduce(Long::sum).get();
    }

    public static long parallelSum(long n)
    {
        return Stream.iterate(1L, i->i+1).limit(n).parallel().reduce(Long::sum).get(); 
    }

    public static long rangedSum(long n)
    {
        return LongStream.rangeClosed(1, n).reduce(Long::sum).getAsLong();
    }

    public static long parallelRangedSum(long n)
    {
        return LongStream.rangeClosed(1, n).parallel().reduce(Long::sum).getAsLong();
    }

    public static long sideEffectSum(long n)
    { 
        Accumulator accumulator= new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }

    public static long sideEffectParallelSum(long n)
    {
        Accumulator accumulator= new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }
    
    
    public static class Accumulator{
        private long total =0;
        public void add(long value)
        {
            total +=value;
        }
    }
 
}
