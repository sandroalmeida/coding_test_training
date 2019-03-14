package info.sandroalmeida;

public class BinaryGap {

    public static int binaryGap(int number){

        String binaryStr = Integer.toBinaryString(number);
        System.out.println(binaryStr);

        char values[] = binaryStr.toCharArray();
        int gap = 0;
        int count = 0;
        boolean startCount = false;

        for (char c: values) {
            if(c == '1' && startCount == false){
                startCount = true;
            } else if(c == '1' && startCount){
                if(count > gap){
                    gap = count;
                }
                count = 0;
            } else if(startCount && c == '0'){
                count++;
            }
        }
        return gap;
    }


}
