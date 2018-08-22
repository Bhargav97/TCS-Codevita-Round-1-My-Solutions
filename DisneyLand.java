import java.util.*;
public class DisneyLand{
    
    public static void main(String[] args){
        int n, m;
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        try{
            sc.nextLine();
        }
        catch(Exception e){
            
        }
        int[][] matrix = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=sc.nextInt();
            }
            try{
            sc.nextLine();
        }
        catch(Exception e){
            
        }
        }
       /* for(int i=0; i<n; i++){
            for(int j=0;j<m;j++){
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }*/
        int h=0;
        try{
            h = sc.nextInt();
        }
        catch(Exception e){
            h=0;
        }
        try{
            sc.nextLine();
        }
        catch(Exception e){
            
        }
        int x[] = new int[h];
        int y[] = new int[h];
        int z[] = new int[h];
        for(int i=0;i<h;i++){
            x[i]=sc.nextInt();
            y[i]=sc.nextInt();
            z[i]=sc.nextInt();
            try{
            sc.nextLine();
        }
        catch(Exception e){
            
        }
        }
        int b=0;
        if(n==m){
            b=n/2;
        }
        else{
            int limiter = n > m ? m : n;
            //System.out.println("limiter is"+limiter);
            b=limiter/2;
            while(((m%b)!=0)||((n%b)!=0)){
                b-=1;
            }
            //System.out.println("b is"+b+"it is"+10%4);

        }
        int seats = (n*m)/(b*b);//System.out.println("n is"+ n+"  m is"+m+ "seats are"+seats);
        int[] win1 = new int[2];
        win1 = determineWinner(matrix, b, n, m);
        //Horse Trade and change the matrix
        for(int i=0;i<h;i++){
            matrix[x[i]-1][y[i]-1]= z[i];
        }
        int[] win2 = new int[2];
        win2 = determineWinner(matrix, b, n, m);
        if(win1[0]==-1){
            System.out.println("No Majority");
        }
        else{
            switch(win1[0]){
                case 1:
                    System.out.println("Initial Majority Party:Seats = "+"AAA"+":"+win1[1] );
                    break;
                case 2: 
                    System.out.println("Initial Majority Party:Seats = "+"BBB"+":"+win1[1] );
                    break;
                case 3:
                    System.out.println("Initial Majority Party:Seats = "+"Others"+":"+win1[1] );
                    break;
            }
        }
        if(win2[0]==-1){
            System.out.println("No Majority");
        }
        else{
            switch(win2[0]){
                case 1:
                    System.out.println("Party Won Party:Seats = "+"AAA"+":"+win2[1] );
                    break;
                case 2: 
                    System.out.println("Party Won Party:Seats = "+"BBB"+":"+win2[1] );
                    break;
                case 3:
                    System.out.println("Party Won Party:Seats = "+"Others"+":"+win2[1] );
                    break;
            }
        }
    }
    
    
    public static int[] determineWinner(int[][] matrix, int b, int n, int m){
        int oneseats=0, twoseats=0, threeseats=0;
        int winner = -1, wonseats = 0;
        for(int i=0; i<n; i+=b){
            for(int j=0; j<m; j+=b){
                int one = 0;
                int two = 0;
                int three = 0;
                for(int p=i;p<i+b;p++){
                    for(int q=j;q<j+b;q++){
                        if(matrix[p][q]==1){
                            one+=1;
                        }
                        else if(matrix[p][q]==2){
                            two+=1;
                        }
                        else{
                            three+=1;
                        }
                    }
                }
                if(one>two&&one>three){
                    oneseats+=1;
                }
                else if(two>one&&two>three){
                    twoseats+=1;
                }
                else if(three>one&&three>two){
                    threeseats+=1;
                }
            }
        }
        if(oneseats>twoseats&&oneseats>threeseats){
            winner = 1;
            wonseats = oneseats;
        }
        else if(twoseats>oneseats&&twoseats>threeseats){
            winner = 2;
            wonseats = twoseats;
        }
        else if(threeseats>oneseats&&threeseats>twoseats){
            winner = 3;
            wonseats = threeseats;
        }
        int[] result = new int[2];
        result[0]=winner;
        result[1]=wonseats;
        return result;
    }
}