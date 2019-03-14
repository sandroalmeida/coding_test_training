package info.sandroalmeida;

public class RotateMatrix {

    public static char[][] solution(char[][] matrix){

        int row, column;
        int width = matrix[0].length, heigh = matrix.length;

        char[][] rotateMatrix = new char[width][heigh];
        for(column = 0; column < width; column++){
            for(row = 0; row < heigh; row++){
                rotateMatrix[column][row] = matrix[row][column];
            }
        }

        return rotateMatrix;
    }

    public static char[][] createMatrix(String str){

        int width = 0, heigh = 0;
        char[] chars = str.toCharArray();

        // calc width
        for(char c : chars){
            if(c != '\n'){
                width++;
            }else{
                break;
            }
        }
        // calc heigh
        for(char c : chars){
            if(c == '\n'){
                heigh++;
            }
        }
        heigh++;

        char[][] matrix = new char[heigh][width];
        int h = 0, w = 0;

        for(char c : chars){
            if(c != '\n'){
                matrix[h][w] = c;
                w++;
            } else{
                h++;
                w = 0;
            }
        }

        return matrix;

    }

    public static String showMatrix(char[][] matrix){

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < matrix.length; i++){
            for(int z = 0; z < matrix[i].length; z++){
                sb.append(matrix[i][z]);
            }
            sb.append('\n');
        }
        return sb.toString();
    }

}
