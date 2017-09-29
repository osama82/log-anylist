/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    private int[] dayCounts;
    HashMap<Integer, Integer> yearCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;
    //String logFileName;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        dayCounts= new int[31];
        yearCounts=new HashMap<Integer, Integer>();
        // Create the reader to obtain the data.
        reader = new LogfileReader();
        
    }
    
    public  LogAnalyzer(String name){
    
        
        hourCounts = new int[24];
        dayCounts= new int[30];
        reader = new LogfileReader(name);
        yearCounts=new HashMap<>();
        
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }
    
    public void analyzeHourlyWeekly()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int day = entry.getDay();
            //System.out.println(day);
            dayCounts[day]++;
        }
    }
    
    
    public void analysYear(){
     int count=0;
     while(reader.hasNext()) {
         
            LogEntry entry = reader.next();
            int year = (Integer)(entry.getYear());
            yearCounts.put(year,count++);
    
    
    
    
    }}
    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
        /*int hour=0;
        while( hour< hourCounts.length){
        System.out.println(hour + ": " + hourCounts[hour]);
        hour++;
        }*/
    }
    public void printWeeklyCounts()
    {
        System.out.println("week: Count");
        for(int day= 0; day < dayCounts.length; day++) {
            System.out.println(day + ": " + dayCounts[day]);
        }
        /*int hour=0;
        while( hour< hourCounts.length){
        System.out.println(hour + ": " + hourCounts[hour]);
        hour++;
        }*/
    }
    
    public void printyear(){
        Set set = yearCounts.entrySet();
    Iterator it= set.iterator();
    while(it.hasNext()) {
         Map.Entry mentry = (Map.Entry)it.next();
         System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
         System.out.println(mentry.getValue());
      }
    
    
    }
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
    
    public int numberOfAccesse(){
    
    int total=0;
    for(int i=0;i< hourCounts.length;i++){
    
    total+=hourCounts[i];
    }
    
    return total;
    
    
    }
    public int busiestHoue(){
    int mean=0;
    int max=0;
      for(int i=0;i<hourCounts.length;i++){
         if(hourCounts[i]>=max){
         max=hourCounts[i];
         mean=i;
         }
    
       }
    
    return mean;
    
    }
    public int quietHoue(){
    int mean=0;
    int min=1000;
      for(int i=0;i<hourCounts.length;i++){
         if(hourCounts[i]<min){
         min=hourCounts[i];
         mean=i;
         }
    
       }
    
    return mean;
    
    
    
    }
    public void quietHouer(){
    int mean=0;
    int min=1000;
      for(int i=0;i<hourCounts.length;i++){
         if(hourCounts[i]<min){
         min=hourCounts[i];
         mean=i;
         }
    
       }
      String res="";
      //System.out.println(min);
      
      for(int i=0;i<hourCounts.length;i++){
        
        if(hourCounts[i]==mean){
        System.out.println(i);
        }
        
        
      }
      
    
    
    
    }
    
    
}
