import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class MovieSequence{

     public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        String m1 = sc.next();
        String m2 = sc.next();
        String m3 = sc.next();
        String m4 = sc.next();
        sc.nextLine();  //consume new-line
        char g1 = sc.next().charAt(0);
        char g2 = sc.next().charAt(0);
        char g3 = sc.next().charAt(0);
        char g4 = sc.next().charAt(0);
        sc.nextLine();
        int p1 = sc.nextInt();
        int p2 = sc.nextInt();
        int p3 = sc.nextInt();
        int p4 = sc.nextInt();
        sc.nextLine();
        int n = sc.nextInt();
        sc.nextLine();
        int[] aud = new int[n];
        for(int i = 0; i<n; i++){
            aud[i]=sc.nextInt();
        }
        
        /*
         A' grade : Age Limit : 24-50 (24 and 50 included)

        'B' grade : Age Limit : 15-25 (15 and 25 included)
    
        'C' grade : Age Limit : 3-18 (3 and 18 included)
    
        'D' grade : Age Limit : 45-70 (45 and 70 included)

       */
        
        ArrayList<Integer> am1 = new ArrayList<Integer>(); //audience of movie 1 
        ArrayList<Integer> am2 = new ArrayList<Integer>();
        ArrayList<Integer> am3 = new ArrayList<Integer>();
        ArrayList<Integer> am4 = new ArrayList<Integer>();

        am1 = screenOutAudienceForMovie(g1,aud);
        am2 = screenOutAudienceForMovie(g2,aud);
        am3 = screenOutAudienceForMovie(g3,aud);
        am4 = screenOutAudienceForMovie(g4,aud);
        
        /*
         People between age 3-20 (both included) will have school in the morning, so will not be able to attend morning show.

         People between age 21-40 (both included) will be at their jobs in the afternoon so will not be able to attend afternoon show.
    
         People between age 41-49 (both included) will not be able to watch movie in Evening show.
    
         People between age 50-70 (both included) will not be able to watch movie in Night show.
        */
        
        ArrayList<Integer> pm1 = new ArrayList<Integer>(); //profit of movie 1, index 0 is morning, index 3 is night
        ArrayList<Integer> pm2 = new ArrayList<Integer>();
        ArrayList<Integer> pm3 = new ArrayList<Integer>();
        ArrayList<Integer> pm4 = new ArrayList<Integer>();
        
        pm1 = calculateProfit(am1,p1);
        pm2 = calculateProfit(am2,p2);
        pm3 = calculateProfit(am3,p3);
        pm4 = calculateProfit(am4,p4);
        
        ArrayList<String> generated = new ArrayList<String>();
        //ArrayList<Integer> totalProfit = new ArrayList<String>();
        int maxProfit = 0;
        for(int i=0;i<4;i++){
            for(int j=0; j<4; j++){
                if(j==i)
                    continue;
                for(int k=0; k<4; k++){
                    if(k==j||k==i)
                        continue;
                    for(int l=0; l<4; l++){
                        if(l==k||l==j||l==i)
                            continue;
                        int tempTotalProfit = 0;
                        tempTotalProfit = pm1.get(i)+pm2.get(j)+pm3.get(k)+pm4.get(l);
                        if(tempTotalProfit>maxProfit){
                            maxProfit=tempTotalProfit;
                            generated.clear();
                            //Generate the string of movies and store it
                            String temp="";    
                            int lookingFor = 0;
                            while(lookingFor!=4){
                                if(i==lookingFor){
                                    temp=temp+m1+" ";
                                }
                                else if(j==lookingFor){
                                    temp=temp+m2+" ";
                                }
                                else if(k==lookingFor){
                                    temp=temp+m3+" ";
                                }
                                else{
                                    temp=temp+m4+" ";
                                }
                                lookingFor++;
                            }
                            generated.add(temp);
                        }
                        else if(tempTotalProfit==maxProfit){
                            //Generate the string of movies and store it
                            String temp="";    
                            int lookingFor = 0;
                            while(lookingFor!=4){
                                if(i==lookingFor){
                                    temp=temp+m1+" ";
                                }
                                else if(j==lookingFor){
                                    temp=temp+m2+" ";
                                }
                                else if(k==lookingFor){
                                    temp=temp+m3+" ";
                                }
                                else{
                                    temp=temp+m4+" ";
                                }
                                lookingFor++;
                            }
                            generated.add(temp);
                        }
                    }    
                }    
            }
            
        }
        
        ArrayList<String> finalList = sortMyList(generated);
        for(int i = 0; i<finalList.size(); i++){
            System.out.println(finalList.get(i));
        }
        
        System.out.println("Maximum Profit:"+maxProfit);
        
        sc.close();
     }
     
     public static ArrayList<String> sortMyList(ArrayList<String> list){
        final Pattern p = Pattern.compile("^\\d+");
        ArrayList<String> result = new ArrayList<String>();
        result = list;
        String[] examples = { 
           "Movies1 Movies 2","Movies2 Movies 1"
        };
        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String object1, String object2) {
                Matcher m = p.matcher(object1);
                Integer number1 = null;
                if (!m.find()) {
                    return object1.compareTo(object2);
                }
                else {
                    Integer number2 = null;
                    number1 = Integer.parseInt(m.group());
                    m = p.matcher(object2);
                    if (!m.find()) {
                        return object1.compareTo(object2);
                    }
                    else {
                        number2 = Integer.parseInt(m.group());
                        int comparison = number1.compareTo(number2);
                        if (comparison != 0) {
                            return comparison;
                        }
                        else {
                            return object1.compareTo(object2);
                        }
                    }
                }
            }
        };
        Collections.sort(result, c);
        return result;
    }
     
     public static ArrayList<Integer> calculateProfit(ArrayList<Integer> am, int pm){
         int len = am.size();
         ArrayList<Integer> result = new ArrayList<Integer>();
         ArrayList<Integer> morning = new ArrayList<Integer>();
         ArrayList<Integer> afternoon = new ArrayList<Integer>();
         ArrayList<Integer> eve = new ArrayList<Integer>();
         ArrayList<Integer> night = new ArrayList<Integer>();
         
         for(int j=0; j<4; j++){
             
             switch(j){
                case 0:
                    for(int i=0; i<len; i++){
                        if(am.get(i)>20){
                            morning.add(am.get(i));
                        }
                    } 
                    break;
                case 1:
                    for(int i=0; i<len; i++){
                        if((am.get(i)>2 && am.get(i)<21)||(am.get(i)>40)){
                            afternoon.add(am.get(i));
                        }
                    }
                    break;
                case 2:
                    for(int i=0; i<len; i++){
                        if((am.get(i)>2 && am.get(i)<41)||(am.get(i)>49)){
                            eve.add(am.get(i));
                        }
                    }
                    break;
                case 3:
                    for(int i=0; i<len; i++){
                        if(am.get(i)<50){
                            night.add(am.get(i));
                        }
                    }
                    break;
             }
         }
         
         result.add((morning.size())*pm);
         result.add((afternoon.size())*pm);
         result.add((eve.size())*pm);
         result.add((night.size())*pm);
         
         return result;
         
     }
     
     public static ArrayList<Integer> screenOutAudienceForMovie(char grade, int[] aud){
         int len = aud.length;
         ArrayList<Integer> result = new ArrayList<Integer>();
         switch(grade){
            case 'A':
                 for(int i = 0; i<len; i++){
                     if(aud[i]>23 && aud[i]<51){
                         result.add(aud[i]);
                     }
                 }
                 break;
            case 'B':
                for(int i = 0; i<len; i++){
                     if(aud[i]>14 && aud[i]<26){
                         result.add(aud[i]);
                     }
                 }
                break;
            case 'C':
                for(int i = 0; i<len; i++){
                     if(aud[i]>2 && aud[i]<19){
                         result.add(aud[i]);
                     }
                 }
                break;
            case 'D':
                for(int i = 0; i<len; i++){
                     if(aud[i]>44 && aud[i]<71){
                         result.add(aud[i]);
                     }
                 }
                break;
         }
         return result;
     }
     
     
     
}