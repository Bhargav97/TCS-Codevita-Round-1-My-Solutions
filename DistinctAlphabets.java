import java.util.*;
public class DistinctAlphabets{
    
    public static void main(String[] args){
        String n;
        Scanner sc = new Scanner(System.in);
        n=sc.next();
        int[] flag = new int[26];
        for(int i = 0; i<26; i++){
            flag[i]=0;
        }
        char[] num = n.toCharArray();
        for(int i=0; i<num.length; i++){
            switch(num[i]){
                case '2':
                    flag[0]=1;
                    if(i!=0){
                        switch(Integer.parseInt(String.valueOf(num[i-1]))%3){
                            case 0:
                                flag[2]=1;
                                break;
                            case 1:
                                flag[0]=1;
                                break;
                            case 2:
                                flag[1]=1;
                                break;
                        }
                    }
                    break;
                case '3':
                    flag[3]=1;
                    if(i!=0){
                        switch((Integer.parseInt(String.valueOf(num[i-1])))%3){
                            case 0:
                                flag[5]=1;
                                break;
                            case 1:
                                flag[3]=1;
                                break;
                            case 2:
                                flag[4]=1;
                                break;
                        }
                    }
                    break;
                case '4':
                    flag[6]=1;
                    if(i!=0){
                        switch((Integer.parseInt(String.valueOf(num[i-1])))%3){
                            case 0:
                                flag[8]=1;
                                break;
                            case 1:
                                flag[6]=1;
                                break;
                            case 2:
                                flag[7]=1;
                                break;
                        }
                    }
                    break;
                case '5':
                    flag[9]=1;
                    if(i!=0){
                        switch((Integer.parseInt(String.valueOf(num[i-1])))%3){
                            case 0:
                                flag[11]=1;
                                break;
                            case 1:
                                flag[9]=1;
                                break;
                            case 2:
                                flag[10]=1;
                                break;
                        }
                    }
                    break;
                case '6':
                    flag[12]=1;
                    if(i!=0){
                        switch((Integer.parseInt(String.valueOf(num[i-1])))%3){
                            case 0:
                                flag[14]=1;
                                break;
                            case 1:
                                flag[12]=1;
                                break;
                            case 2:
                                flag[13]=1;
                                break;
                        }
                    }
                    break;
                case '7':
                    flag[15]=1;
                    if(i!=0){
                        switch((Integer.parseInt(String.valueOf(num[i-1])))%4){
                            case 0:
                                flag[18]=1;
                                break;
                            case 1:
                                flag[15]=1;
                                break;
                            case 2:
                                flag[16]=1;
                                break;
                            case 3:
                                flag[17]=1;
                                break;    
                        }
                    }
                    break;
                case '8':
                    flag[19]=1;
                    if(i!=0){
                        switch((Integer.parseInt(String.valueOf(num[i-1])))%3){
                            case 0:
                                flag[21]=1;
                                break;
                            case 1:
                                flag[19]=1;
                                break;
                            case 2:
                                flag[20]=1;
                                break;
                        }
                    }
                    break;
                case '9':
                    flag[22]=1;
                    if(i!=0){
                        switch((Integer.parseInt(String.valueOf(num[i-1])))%4){
                            case 0:
                                flag[25]=1;
                                break;
                            case 1:
                                flag[22]=1;
                                break;
                            case 2:
                                flag[23]=1;
                                break;
                            case 3:
                                flag[24]=1;
                                break;
                        }
                    }
                    break;    
            }
        }
        int count = 0;
        for(int i = 0; i<26; i++){
            if(flag[i]==1){
                count+=1;
            }
        }
        System.out.println(count);
    }
}