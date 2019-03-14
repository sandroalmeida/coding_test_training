package info.sandroalmeida;

public class CountDiv {

    public static int solution(int A, int B, int K) {

        int count = 0;
        for(int i = A; i <= B; i++){
            if(i % K == 0){
                count++;
            }
        }

//        System.out.println((B-A) + " " + ((B-A)/(K*1.0)));
        return count;
    }

    public static int solution2(int A, int B, int K) {

        int firstDiv = -1;
        for(int i = A; i <= B; i++){
            if(i % K == 0){
                firstDiv = i;
                break;
            }
        }
        int rest = (B - firstDiv);
        int calc = rest / K;
        return firstDiv == -1 ? 0 : calc + 1;
    }


}
