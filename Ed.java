public class Ed {
    public static void main(String[] args){
        String s1 = "Casablanca";
        String s2 = "Portentoso";

        String s11 = "Maven, a Yiddish word meaning accumulator of knowledge, began as an attempt to " +
				"simplify the build processes in the Jakarta Turbine project. There were several" + 
				" projects, each with their own Ant build files, that were all slightly different." +
				"JARs were checked into CVS. We wanted a standard way to build the projects, a clear "+ 
				"definition of what the project consisted of, an easy way to publish project information" +
				"and a way to share JARs across several projects. The result is a tool that can now be" +
				"used for building and managing any Java-based project. We hope that we have created " +
				"something that will make the day-to-day work of Java developers easier and generally help " +
				"with the comprehension of any Java-based project.";
        String s22 = "This post is not about deep learning. But it could be might as well. This is the power of " +
				"kernels. They are universally applicable in any machine learning algorithm. Why you might" +
				"ask? I am going to try to answer this question in this article." + 
			        "Go to the profile of Marin Vlastelica Pogančić" + 
			        "Marin Vlastelica Pogančić Jun";

        System.out.println("fb1:");
        long start = System.nanoTime();
        System.out.println(edFunc(s1,s2,s1.length()-1,s2.length()-1));
        long end =  System.nanoTime();
        System.out.println("MilliSec => " + (end - start)/1000000.0);
        
        System.out.println(edFuncDina(s11,s22,s11.length(),s22.length()));
       //System.out.println(edFuncDina("casa","pai",4,3));
    }

    public static int edFunc(String S, String T, int i, int j){
        if(i==-1 && j==-1){
            return 0;
        } else if (i==-1){
            return j;
        } else if (j==-1){
            return i;
        }

        if(S.charAt(i)==T.charAt(j)){
            return edFunc(S, T, i-1, j-1);
        } else {
            return Integer.min(edFunc(S, T, i-1, j-1) + 1, Integer.min( edFunc(S, T, i, j-1) + 1,edFunc(S, T, i-1, j) + 1));
        }

    }


    public static int edFuncDina(String S, String T,int m, int n){
        int[][] matriz = new int[m+1][n+1];

        for(int i = 1; i<=m;i++){
            matriz[i][0] = matriz[i-1][0]+1;
        }

        for(int j = 1; j<=n;j++){
            matriz[0][j] = matriz[j-1][0]+1;
        }
        
        int custoEx = 0;
        for(int i = 1; i<=m;i++){
            for(int j = 1; j<=n;j++){
                
                if(S.charAt(i-1)==T.charAt(j-1)){
                    custoEx = 0;
                }
                else{
                    custoEx = 1;
                }
                //printMatrix(matriz);
                matriz[i][j] = Integer.min(matriz[i-1][j] +1, Integer.min(matriz[i][j-1] +1,
                matriz[i-1][j-1] + custoEx));
            }
        }
        return matriz[m][n];
    }

    public static void printMatrix(int[][] matrix){
        System.out.println("#------------------#");
        for(int i =0; i < matrix.length; i++){
            for(int j=0;j< matrix[i].length; j++){
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("#------------------#");
    }
    
}
