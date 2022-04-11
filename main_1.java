package JavaApp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int measurer = 1;

        System.out.println("Welcome to text manager");
        System.out.println("If you want text manager then, you write your text's file path. Do you want contiune?");
        System.out.println("click 1 for yes, click 0 for no");
        int Q1 = scan.nextInt();
        if(Q1==0){
          System.out.println("Thanks for everything");
        }
        else if(Q1==1){
            System.out.println("Menu\n 1-Read the text\n 2-Write to file\n 3-Get info about file\n 4-Calcuating Processes");
            int Q2 = scan.nextInt();
            if(Q2==1){
              readFile();
            }
            if(Q2==2){
              writeFile();
              System.out.println("Do you want read your file?");
              int Q3 = scan.nextInt();
              if(Q3==1){
                readFile();
              }
              else{}
            }
            if(Q2==3){
              getFileInfo();
            }
            if(Q2==4){
              System.out.println("What do you want calcuate?");
              System.out.println("1-Total letter number\n 2-Total word number\n 3-Know how much there are your want letter");
              int QM = scan.nextInt();
              if(QM==1){
                calLetter();
              }
              else if(QM == 2){
                calWord();
              }
              else if(QM == 3){
                calSingleLetter();
              }
              else{}
            }

        }
        else{
          System.out.println("Please enter valid value");
        }

      
    }
    public static void readFile() {
       
      try {
        
        Scanner input = new Scanner(System.in);
        System.out.println("Where is your file?");
        String filePath = input.nextLine(); 
        
        File file = new File(filePath);
        Scanner reader = new Scanner(file);
        while(reader.hasNextLine()){
            String line = reader.nextLine();
            System.out.println(line);
            
        }
        reader.close();
      } catch (FileNotFoundException e) {
         e.getStackTrace();
      }
    }

    public static void writeFile() {
      try {
            Scanner scan = new Scanner(System.in);
            Scanner input = new Scanner(System.in);

            System.out.println("Where is your file?");
            String filePath = input.nextLine(); 

            System.out.println("What you want write to file?");
            String Q1 = scan.nextLine();
          
        
        File file = new File(filePath);
          BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true)); //true dosyanın içine yazar "true" kullanmazsak dosyanın üzerine yazar

              writer.newLine(); //yeni satır oluştur.
              writer.write(Q1);
              writer.close();
          
          System.out.println("Dosyaya yazıldı");
          
      } catch (IOException e) {
          e.printStackTrace();
      }
  }

  public static void getFileInfo() {
    Scanner scan = new Scanner(System.in);
    Scanner input = new Scanner(System.in);

    System.out.println("Where is your file?");
    String filePath = input.nextLine(); 

    File file = new File(filePath);
    if(file.exists()){ // .exists yazılan yolda istenen dosyanın olup olmadığını sorgular booleandır.
        System.out.println("File name:" + " " +file.getName());
        System.out.println("File path:"+ " " + file.getAbsolutePath());
        System.out.println("Can file read?:"+ " "+ file.canRead()); // dosyanın okunabilirliğini sorgular
        System.out.println("Can file write?:"+ " "+ file.canWrite()); // dosyanın yazılabilirliğini sorgular
        System.out.println("File size (byte):"+ " " + file.length()); 
    }
}


public static void calLetter() {
  try {
    Scanner input = new Scanner(System.in);
    System.out.println("Where is your file?");
    String filePath = input.nextLine(); 
    
    File file = new File(filePath);
    Scanner reader = new Scanner(file);
    while(reader.hasNextLine()){
        String line = reader.nextLine();
        System.out.println("Total letter number:"+line.length()); 
    }
    
    reader.close();
  } catch (FileNotFoundException e) {
     e.getStackTrace();
  }
}

public static void calWord() {
  try {
    Scanner scan = new Scanner(System.in);
    Scanner input = new Scanner(System.in);
    System.out.println("Where is your file?");
    String filePath = input.nextLine(); 
    int measurer = 1;
    File file = new File(filePath);
    Scanner reader = new Scanner(file);
    while(reader.hasNextLine()){
        String line = reader.nextLine();
        for(int i=0; i<line.length();i++){
          if(line.charAt(i) == ' '){
            measurer++;
          }
        }
        System.out.println("Total word number:"+measurer);
    }
    
    reader.close();
  } catch (FileNotFoundException e) {
     e.getStackTrace();
  }
}

public static void calSingleLetter() {
  try {
    Scanner scan = new Scanner(System.in);
    Scanner input = new Scanner(System.in);
    System.out.println("Where is your file?");
    String filePath = input.nextLine(); 
    int measurer = 0;
    File file = new File(filePath);
    Scanner reader = new Scanner(file);
    while(reader.hasNextLine()){
        String line = reader.nextLine();
        for(int i=0; i<line.length();i++){
          if(line.charAt(i) == ' '){
            measurer++;
          }
        }
        System.out.println("what you want find which letter?");
        char letter = scan.next().charAt(0);
        System.out.println("There is/are"+" "+measurer+" "+letter+" "+ "in this text");
    }
    
    reader.close();
  } catch (FileNotFoundException e) {
     e.getStackTrace();
  }

}
  
}
