import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class P1 {
  public static void main(String[] args) {


    try{
      checkOnlyOneArgument(args);
    }
    catch(Exception e){
      System.out.print(e.getMessage());
      System.exit(0);
    }

    String filePath = args[0];
    Object average;
    Object STD;
    List<Double> doublesInFile = new ArrayList<>();

    try{
      checkIfCharInFile(filePath);
      doublesInFile = getDoublesFromFile(filePath);
      average = calcVersatileAverage(doublesInFile);
      System.out.print(average+ " ");
      STD = calcVersatileSTD(doublesInFile);
      System.out.print(STD);
    }
    catch(Exception e){
      System.out.println(e.getMessage());
      System.exit(0);
    }
  }

  public static void checkOnlyOneArgument(String[] args) throws Exception{
    if(args.length!=1){
      throw new Exception("Error: invalid argument numbers");
    }
  }


  public static Object calcVersatileSTD(List<Double> doublesInFile){
    int size = doublesInFile.size();
    double STD;

    if(size <= 1){
      return "UNDEFINED";
    }
    else{
      STD = calcNormalSTD(doublesInFile);
      return STD;
    }
  }
  public static double calcNormalSTD(List<Double> doublesInFile){
    int size = doublesInFile.size();
    double variance;
    double STD;
    Object average = calcVersatileAverage(doublesInFile);
    double sigma = 0.0;

      for (double number : doublesInFile){
        double difference = number - (double)average;
        sigma += Math.pow(difference, 2);
      }
      variance = sigma / (size - 1);
  
      STD = Math.sqrt(variance);
      return STD;
  }
  public static Object calcVersatileAverage(List<Double> doublesInFile){
    Object average;
    int size = doublesInFile.size();

    if(size == 0){
      return "UNDEFINED";
    }
    else{
      average = calcNormalAverage(doublesInFile);
      return average;
    }
  }
  public static double calcNormalAverage(List<Double> doublesInFile){
    double sum = 0.0;
    double average;
    int size = doublesInFile.size();

    for (double number : doublesInFile) {
      sum+= number;
    }
    average = sum/size; 
    return average;
  }
  public static List<Double> getDoublesFromFile(String filePath){

    File file = new File(filePath);
    List<Double> doublesInFile = new ArrayList<>();
    
    try{
      Scanner myScanner = new Scanner(file);
      while (myScanner.hasNext()){
        if (myScanner.hasNextDouble()){
          doublesInFile.add(myScanner.nextDouble());
        } 
        else{
          myScanner.next();
        }
      }
      //System.out.println(doublesInFile);
      myScanner.close();

    }
    catch(FileNotFoundException e){
      System.out.println("Error! File does not exist!");
    }
    return doublesInFile;
  }


  public static void checkIfCharInFile(String filePath) throws Exception{
    File file = new File(filePath);
    char[] listOfDigits = {'0','1','2','3','4','5','6','7','8','9','.',' ', '-'};
    try{
      Scanner myScanner = new Scanner(file);
      
      while (myScanner.hasNextLine()){
        String line = myScanner.nextLine();
        int LineLength = line.length();
        for (int indexOfCharInLine = 0; indexOfCharInLine<LineLength; indexOfCharInLine++){
          int flagger = 0;
          for (int j = 0; j<listOfDigits.length; j++){
            if(line.charAt(indexOfCharInLine) == listOfDigits[j]){
              flagger+=1;
            }
          }
          if(flagger==0){
            myScanner.close();
            throw new Exception("Error: character(s) found in the file");
          }
        }   
      }
      myScanner.close();
    }
    catch(FileNotFoundException e){
      System.out.println("Error: file does not exist");
      System.exit(0);
    }
  }


  public static void printFileContent(String filePath){

    File file = new File(filePath);
    
    try{
      Scanner myScanner = new Scanner(file);
      while (myScanner.hasNextLine()) {
        String data = myScanner.nextLine();
        System.out.println(data);
        }
        myScanner.close();
      }

    catch(FileNotFoundException e){
      System.out.println("Exception! File does not exist!");
    }
  }
}
