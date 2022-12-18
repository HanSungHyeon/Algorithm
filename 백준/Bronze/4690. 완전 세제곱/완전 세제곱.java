public class Main {
    public static void main(String[] args) {
        int a = 2, b = 2;
        String output = "Cube = ";
        String output2 = ", Triple = ";

        for (int i = a; i <= 100; i++) {
            for (int j = b; j < i; j++) {
                for (int k = j + 1; k < i; k++) {
                    for (int z = k + 1; z < i; z++) {
                        if(Math.pow(i,3) == Math.pow(j,3) + Math.pow(k,3) + Math.pow(z,3))
                            System.out.println(output + i + output2 + "(" + j +"," + k + "," + z + ")");
                    }
                }
            }
        }
    }
}