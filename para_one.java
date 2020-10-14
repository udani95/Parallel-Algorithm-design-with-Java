//simple serial programming summation function

package maven_pack;

public class para_one {

    private static Integer sum =0;//increment this sum value one by one,through the main method in serioly,not paralley

    public static void main(String[] args) {
        Long start=System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            sum = sum +1;
        }
        Long end=System.currentTimeMillis();
        System.out.println("Execution time=" + (end-start));
        System.out.println("sum is="+sum);
    }
    
}
