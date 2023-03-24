import java.time.*;
import java.time.temporal.*;
import java.util.*;
import java.math.*;
class wpm
{
    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("Type the sentence then hit enter when finished");
        Thread.sleep(1000);                                                     //pauses so user can read directions 
        double wpm=test();
        System.out.println(wpm+" words per minute");
    }
    public static double test()
    {
        int x=(int)((Math.random()*3)+1);
        double words=0;
        String s="";
        switch(x){                                                      //different writing prompts, wpm=(characters/5)/time
            case 1:
            s="The quick brown fox jumps over the lazy dog";
            System.out.println(s);
            break;
            case 2:
            s="My very eager mother just served us nine pies";
            System.out.println(s);
            break;
            case 3:
            s="I am growing four stalks of bamboo in my garden at home";
            System.out.println(s);
            break;
            case 4:
            s="Tomorrow morning before noon I have to pick my car up from the repair shop";
            System.out.println(s);
            break;
        }
        words=s.length()/5;                                                     //words based on wpm formula
        LocalTime time=LocalTime.now();                                         //takes time before input is taken
        double min1=time.getMinute();
        double sec1=time.getSecond();
        double tot=min1+(sec1/60);
        Scanner kb=new Scanner(System.in);                                  
        String prompt=kb.next();                                                //user enters prompt
        LocalTime time2=LocalTime.now();                                     //gets time after user hits enter
        double min2=time2.getMinute();
        double sec2=time2.getSecond();
        double tot2=min2+(sec2/60);
        tot2=tot2-tot;                                                  //calculates time between input and end of input
        double wpm=words/tot2;                                          //calculates wpm based on wpm formula
        kb.close();
        if(prompt.compareTo(s)!=0)
            System.out.println("Some errors");
        return wpm;
    }
}