/**
 * this is a program designed for getting a workout schedule and accpeting user input to decide what workouts they will have for the week
 * @version(2.05)
 * @author Luke Herron
 * This is the public class that gets the user to enter the name of the file and then create the plan
 */

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class workouts {
    /**
     * The main function of the whole class. The one that sets the systems and the names and gets the menu up
     * This is wehre the scanner is set up and closed, 
     * Also where the file name is created
     */
    public static void main(String[] args) {
        System.out.println("Please enter username: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        String day = "";
        double wchange = 0;
        
        do{
        System.out.println("What day of the week is it?");
        day = scanner.next();
        day = day.toUpperCase();
        if (!day.equals("MONDAY") && !day.equals("TUESDAY") && !day.equals("WEDNESDAY") && !day.equals("THURSDAY") && !day.equals("FRIDAY") && !day.equals("SATURDAY") && !day.equals("SUNDAY")){
            System.out.println(day + " is not a valid day. (Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday)");
        }
        }while(!day.equals("MONDAY") && !day.equals("TUESDAY") && !day.equals("WEDNESDAY") && !day.equals("THURSDAY") && !day.equals("FRIDAY") && !day.equals("SATURDAY") && !day.equals("SUNDAY"));
        
        
        String endString = findNextDay(day);
        String fileName = (name.toLowerCase() + "_workoutplan.txt");
        String fileName1 = (name.toLowerCase() + "_1_workoutplan.txt");
        
        File file = new File(fileName);
        File file1 = new File(fileName1);
        try{
            if (file.exists()){
                System.out.println("File already exists");
                displayDay(file,day,endString);
                String weekupdate = "";
                
                if( day.equals("MONDAY")){
                do{
                    System.out.println("Did you complete last weeks workout plan? (yes/no)");
                    weekupdate = scanner.next();
                    weekupdate = weekupdate.toUpperCase();
                    if (!weekupdate.equals("YES") && (!weekupdate.equals("NO"))){
                        System.out.println(weekupdate + " is not yes or no, please re-enter");
                    }}while (!weekupdate.equals("YES") && !weekupdate.equals("NO"));
                if (weekupdate.equals("YES")){
                    
                    do{
                        System.out.println("Enter a percent that you want to incease the weight by (0.0-100.0)");
                        wchange = scanner.nextDouble();
                        
                    if (wchange < 0.0 && wchange >100.0){
                        System.out.println(wchange + "is not a valid number");
                    }
                    
                    }while(wchange < 0.0 && wchange > 100.0);
                    System.out.println("Weights updated");  
                    ArrayList<Workout> workoutList = createWorkouts(file, day, wchange);
                    file = updateFile(file, file1, day, workoutList ,name,fileName);
                    System.out.println("");
                    printMenu(file, day, endString, scanner, workoutList);
                } else if (weekupdate.equals("NO")){
                    System.out.println("Weights not updated");
                    ArrayList<Workout> workoutList = createWorkouts(file, day, wchange);
                    System.out.println("");
                    printMenu(file, day, endString, scanner, workoutList);
                    
                }
            }else{ //if its not monday, and file already exists
                ArrayList<Workout> workoutList = createWorkouts(file, day, wchange);
                System.out.println("");
                printMenu(file, day, endString, scanner, workoutList);
            }
            }else if (file.createNewFile()){
                    System.out.println("File has been created");
                    ArrayList<Workout> workoutList = createNewWorkouts();
                    /**
                     * the many lines of the BufferWriter class.
                     * making the file to write to for the workouts and asking the week and setting days
                     * This is so long because of how it needed to be presented
                     */
                    try {
                        FileWriter fileWriter = new FileWriter(file);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                        // Writing to the file
                        bufferedWriter.write(name + "'s workout File");
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write("Today is " + day);
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write("Week: 1"  );
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write("MONDAY");
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write(workoutList.get(5).toString());
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write(workoutList.get(9).toString());
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write(workoutList.get(10).toString());
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write(workoutList.get(3).toString());
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write(workoutList.get(4).toString());
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write("TUESDAY");
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write(workoutList.get(0).toString());
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write(workoutList.get(1).toString());
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write(workoutList.get(2).toString());
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write(workoutList.get(15).toString());
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write(workoutList.get(3).toString());
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write(workoutList.get(4).toString());
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write("WEDNESDAY");
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write(workoutList.get(16).toString());
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write(workoutList.get(17).toString());
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write(workoutList.get(14).toString());
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write(workoutList.get(3).toString());
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write(workoutList.get(4).toString());
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write("THURSDAY");
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write(workoutList.get(8).toString());
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write(workoutList.get(6).toString());
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write(workoutList.get(7).toString());
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write(workoutList.get(11).toString());
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write(workoutList.get(3).toString());
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write(workoutList.get(4).toString());
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write("FRIDAY");
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write(workoutList.get(0).toString());
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write(workoutList.get(12).toString());
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write(workoutList.get(13).toString());
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write(workoutList.get(3).toString());
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write(workoutList.get(4).toString());
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write("SATURDAY");
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write("Rest Day");
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write("Wait for Monday");
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write("SUNDAY");
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write("Rest Day");
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.write("Wait for Monday");
                        bufferedWriter.newLine(); // Move to the next line
                        bufferedWriter.close();
                        fileWriter.close();
                        System.out.println("Data has been written to the file.");
                        System.out.println("");
                        displayDay(file,day,endString);
                        System.out.println("");
                        printMenu(file, day, endString, scanner, workoutList);
                        
                        

                        // Close the writer to save the changes to the file
                        
                        
                            
                    } catch (IOException e) {
                        e.printStackTrace();
                }
                }
                else{
                    System.out.println("File creating has failed");
                }
            }
         catch (IOException e){
            e.printStackTrace();
        }
        
        scanner.close();
    
    }
     /**
         * the public Workout arrayLists that needed to be for storing each workout.
         * this also organizes the workouts by number
         * @return the workout list
         */
        public static ArrayList<Workout> createNewWorkouts() {
            ArrayList<Workout> workoutList = new ArrayList<>();
    
            // Adding workouts to the list
            workoutList.add(new Workout("BENCH PRESS", 135.5, 4, 8)); //0
            workoutList.add(new Workout("SHOULDER PRESS", 50, 4, 8)); //1
            workoutList.add(new Workout("INCLINE BENCH PRESS", 100, 4, 8)); //2
            workoutList.add(new Workout("PLANK", 0, 3, 1)); //3
            workoutList.add(new Workout("SIT UPS", 0, 3, 20)); //4
            workoutList.add(new Workout("SQUAT", 315, 5, 5)); //5
            workoutList.add(new Workout("POWER CLEAN", 225, 5, 4)); //6
            workoutList.add(new Workout("HANG CLEAN", 225, 5, 4)); //7
            workoutList.add(new Workout("SNATCH", 135.5, 4, 5)); //8
            workoutList.add(new Workout("DEADLIFT", 405, 5, 6)); //9
            workoutList.add(new Workout("RDL", 315 , 4, 8)); //10
            workoutList.add(new Workout("LEG PRESS", 500, 4, 8)); //11
            workoutList.add(new Workout("QUAD EXTENSIONS", 225, 4, 8)); //12
            workoutList.add(new Workout("HAMSTRING CURL", 185, 4, 8)); //13
            workoutList.add(new Workout("BICEP CURL", 80, 4, 8));  //14
            workoutList.add(new Workout("TRICEP EXTENSION", 100, 6, 8)); //15
            workoutList.add(new Workout("BARBELL ROW", 225, 4, 8));  //16
            workoutList.add(new Workout("LAT PULL DOWN", 150.5, 4, 8)); //17
    
            return workoutList;
        }
        /**
         * the previous class with the parameters that are needed for the project
         * This also writes to the files and uses Matches and Patterns to help check against the file to see if it is set up right.
         * @param( file that is instantiated at the beginning of the class, Day that is uppercased to check against the days in the array)
         * @return the completed workoutlist
         */
        public static ArrayList<Workout> createWorkouts(File file, String day, double wchange){
            ArrayList<Workout> workoutList = new ArrayList<>(); //create workoutlist array
            String workoutName;
            double weight;
            int sets;
            int reps;
            try(BufferedReader reader = new BufferedReader(new FileReader(file))){  //create new reader for file
                

                int linecount =0;
                boolean startPrinting = false;
                String line;
                //String searchString = day.toUpperCase();
                String[] days = {"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY","SUNDAY"};
                int i = 0;
                while (i < 5){
                if((line = reader.readLine()) != null){
                    linecount++;
                    if (linecount >= 4){  //skip non workouts
                        if (line.contains(days[i])){
                        startPrinting = true;
                        
                            
                    }
                    if(line.contains(days[i + 1])){ //if day is in line
                           // startPrinting = false;
                           
                            i++; //next day
                    } 

                    }
                    
                    if (!line.contains(days[i]) && startPrinting && !line.equals("\n")){ //if line is not a day, and not newline
                        
                        
                        // Regular expressions to match the patterns and extract data
                        Pattern exercisePattern = Pattern.compile("(.+?) -"); //grabs exercise name
                        Pattern weightPattern = Pattern.compile("Weight: (\\d+\\.?\\d*)"); //grabs weight
                        Pattern setsPattern = Pattern.compile("Sets: (\\d+)"); //grabs sets
                        Pattern repsPattern = Pattern.compile("Reps: (\\d+)"); // grabs reps

                        // Extracting the exercise name
                        Matcher exerciseMatcher = exercisePattern.matcher(line); //matches line
                        workoutName = exerciseMatcher.find() ? exerciseMatcher.group(1).trim() : null; //sets workoutname to workoutname

                        // Extracting the weight (double)
                        Matcher weightMatcher = weightPattern.matcher(line); //mathces line
                        weight = weightMatcher.find() ? Double.parseDouble(weightMatcher.group(1)) : 0.0; //sets weight

                        weight = (weight * (1.0 + (wchange * .01))); //updates weight, if no change is needed, nothing changed
                        
                        // Extracting the sets (int)
                        Matcher setsMatcher = setsPattern.matcher(line); //matches line
                        sets = setsMatcher.find() ? Integer.parseInt(setsMatcher.group(1)) : 0; // sets sets

                        // Extracting the reps (int)
                        Matcher repsMatcher = repsPattern.matcher(line); //matches line
                        reps = repsMatcher.find() ? Integer.parseInt(repsMatcher.group(1)) : 0; //sets reps
                        
                        ArrayList<String> wrknames = new ArrayList<>(); //creates empty array for workouts
                        if (workoutList.size() >= 1){ //if a workout has been added already
                            ArrayList<String> exerciseNames = new ArrayList<>(); //empty then stored names already created
                        for(Workout workouts : workoutList){ //grabs all the createe exercises
                            exerciseNames.add(workouts.getExerciseName()); //adds exercie names to list
                        }
                        
                        wrknames.addAll(exerciseNames); //adds them to differetn array
                        if (workoutName != null && !wrknames.contains(workoutName)){ //if new workout is not null and is not repeat
                        workoutList.add(new Workout(workoutName, weight, sets, reps)); //add new workout
                        
                        }
                    }else if (workoutName != null) { //if first workout
                        workoutList.add(new Workout(workoutName, weight, sets, reps)); //add
                    }}}
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
                return workoutList;
            

        }
        /**
         * static method only made in this file that gets the file name day and endString of the day to check the days agaisnt themselves
         * @param( the file, day and the day that comes after it.)
         * @return(empty string as most of it is checking and displaying the days correctly)
         */
        public static String displayDay(File file,String day , String endString){
                System.out.println("Today is: " + day);
                System.out.println("Todays workouts are: ");
                try(BufferedReader reader = new BufferedReader(new FileReader(file))){
                int linecount = 0;
                boolean startPrinting = false;
                boolean startPrinting1 = false;
                String line;
                String searchString = day.toUpperCase();
                while ((line = reader.readLine()) != null){
                    linecount++;
                    if(linecount > 3){
                        startPrinting1 = true;
                    }
                    if (startPrinting1 && line.contains(searchString)){
                    startPrinting = true;

                    }
                    if (startPrinting){
                        if (line.contains(endString)){
                            break;
                     } 
                    else if(endString == "Monday"){
                        while(reader.readLine() != null){
                            System.out.println(line);
                        }
                    
                    }else{
                        System.out.println(line);
                     }
                    }
                  
                }
                }catch (IOException e){
                    e.printStackTrace();
                }
            System.out.println("");
            return "";
        }
        /**
         * The static method that returns the next day in the workout list.
         * @param(The day,)
         * @return(the next day/ end string)
         */
        public static String findNextDay(String day){
            String endString;
            switch(day){
                case "MONDAY":
                endString = "TUESDAY";
                break;
                case "TUESDAY":
                endString = "WEDNESDAY";
                break;
                case "WEDNESDAY":
                endString = "THURSDAY";
                break;
                case "THURSDAY":
                endString = "FRIDAY";
                break;
                case "FRIDAY":
                endString = "SATURDAY";
                break;
                case "SATURDAY":
                endString = "SUNDAY";
                break;
                default:
                throw new IllegalArgumentException("Invalid day: " + day);
            
            }
            return endString;
        }
        /**
         * method of looking through the file to check the lines for the workouts
         * @param( the file made from the main method)
         * @return( an empty string)
         */
        public static String displayPlan(File file){
            try(BufferedReader reader1 = new BufferedReader(new FileReader(file))){
                String line1;
                while((line1 = reader1.readLine()) != null){
                    System.out.println(line1);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            System.out.println("");
            return "";
        }
        /**
         * This is the Method used to display the menu that is used for the workouts
         * It takes input and uses the scanner object to display choices for the user.
         * it also allows you to customize your workout experience and change workouts.
         * @param(The name of the file, the day that the file uses the day after the one in the file the scanner object and the arrayworkout)
         * @return( a blank String)
         */
        public static String printMenu(File file, String day, String endString, Scanner scanner, ArrayList<Workout> workoutList){
            int choice = 0;
            while(choice != 5){
            System.out.println("Workout Menu:");
            System.out.println("Option 1: Display Current Days Workout");
            System.out.println("Option 2: Display whole workoutplan");
            System.out.println("Option 3: Display all workouts");
            System.out.println("Option 4: Change a workout (Name, Weight, Sets, Reps )");
            System.out.println("Option 5: Quit!");
            System.out.println("");
            
            do{
            choice = scanner.nextInt();
            if (choice != 1 && choice != 2 && choice != 3 && choice !=4 && choice !=5){
                System.out.println(choice + " is not a valid choice (1,2,3,4,5)");
                System.out.println("Please enter a valid choice");
            }
            }while(choice != 1 && choice != 2 && choice != 3 && choice !=4 && choice !=5);



            if (choice == 1){
                displayDay(file,day,endString);
            }
            else if (choice == 2){
                displayPlan(file);
            }
            else if (choice == 3){
                for (Workout workouts : workoutList){
                System.out.println(workouts);
                }
            }
            else if (choice == 4){
                String choice2;
                System.out.println("These are the workouts you can chose from");
                ArrayList<String> wrkouts = new ArrayList<>();
                for(Workout workouts : workoutList){
                    wrkouts.add(workouts.getExerciseName());
                }
                
                String[] wrkoutsArray = wrkouts.toArray(new String[0]);
                for(String exerciseName : wrkoutsArray){
                System.out.println(exerciseName);
                }
                System.out.println("What exercise would you like to change? ");
                scanner.nextLine();
                choice2 = scanner.nextLine();
                choice2 = choice2.toUpperCase();
                // Check if choice2 is in wrkoutsArray
                boolean found = false;
                for (String exerciseName : wrkoutsArray) {
                    if (exerciseName.equals(choice2)) {
                    found = true;
                    
                    break;
                    }
                }
                // Execute code if choice2 is found in wrkoutsArray
                if (found) {
                    
                    for (Workout workouts : workoutList){
                        if (workouts.getExerciseName().equals(choice2)){
                        boolean continueChange = true;
                        while (continueChange){
                        System.out.println("Name: " + workouts.getExerciseName());
                        System.out.println("Weight: " + workouts.getWeight());
                        System.out.println("Sets: " + workouts.getSets());
                        System.out.println("Reps: " + workouts.getReps());
                        System.out.println("What would you like to do? (1,2,3,4)");
                        System.out.println("Option 1: Change the Name");
                        System.out.println("Option 2: Change the Weight");
                        System.out.println("Option 3: Change the Sets");
                        System.out.println("Option 4: Change the Reps");
                        System.out.println("Option 5: Quit!");
                        int choice3 = 0;
                        
                        do{
                        choice3 = scanner.nextInt();
                        scanner.nextLine();
                        if (choice3 != 1 && choice3 != 2 && choice3 != 3 && choice3 !=4 && choice3 !=5){
                            System.out.println(choice3 + " is not a valid choice (1,2,3,4,5)");
                        }
                        }while(choice3 != 1 && choice3 != 2 && choice3 != 3 && choice3 !=4 && choice3 !=5);
                        
                        if (choice3 == 1){
                            System.out.println("What would you like the to change this exercise name to?");
                            String choice4 = scanner.nextLine();
                            System.out.println(choice2 + " Changed to " + choice4);
                            workouts.setExerciseName(choice4);
                        } else if (choice3 == 2){
                            System.out.println("What would you like the to change the Weight to?");
                            double choice4 = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.println(choice2 + " Weight changed from " + workouts.getWeight() + " to " + choice4);
                            workouts.setWeight(choice4);
                        } else if (choice3 == 3){
                            System.out.println("What would you like the to change the Sets to?");
                            int choice4 = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println(choice2 + " Sets chaned from  " + workouts.getSets() + " to " + choice4);
                            workouts.setSets(choice4);
                        } else if (choice3 == 4){
                            System.out.println("What would you like the to change the Reps to?");
                            int choice4 = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println(choice2 + " Reps chaned from  " + workouts.getReps() + " to " + choice4);
                            workouts.setReps(choice4);
                        } else if(choice3 == 5){
                            System.out.println("Exiting " + choice2 + " Changing");
                            continueChange = false;
                            break;
                        }

                    }
                        }}
                // Add your code logic here
                } else {
                System.out.println("The exercise '" + choice2 + "' was not found in the list.");
                }}}
        System.out.println("");    
        return "";
        }
        /**
         * This is the Method used to update the file with the new weeks
         * It takes the new workouts and adds them to the begining of the file.
         * @param(The name of the file, the day that the file uses the day after the one in the file the scanner object and the arrayworkout)
         * @return(updated File)
         */
        public static File updateFile(File file, File file1, String day, ArrayList<Workout> workoutList, String name, String fileName){

            try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(file1))) {

                String line;
                int weekNumber = 0;
                String weekNumberStr;
                Pattern weekNumPattern = Pattern.compile("Week: (\\d+)");
                while ((line = reader.readLine()) != null) {
                    // Find the week number using the regular expression
                    Matcher matcher = weekNumPattern.matcher(line);
                    if (matcher.find()) {
                        weekNumberStr = matcher.group(1); //find week number
                        weekNumber = Integer.parseInt(weekNumberStr);
                        
                    }
                }
                for (Workout workouts: workoutList){
                    System.out.println(workouts.toString());
                }

                writer.write(name + "'s workout File");
                writer.newLine(); // Move to the next line
                writer.write("Today is " + day);
                writer.newLine(); // Move to the next line
                writer.write("Week: " + (weekNumber + 1)  ); //change week number +1
                writer.newLine(); // Move to the next line
                writer.newLine(); // Move to the next line
                writer.write("MONDAY");
                writer.newLine(); // Move to the next line
                writer.write(workoutList.get(0).toString());
                writer.newLine(); // Move to the next line
                writer.write(workoutList.get(1).toString());
                writer.newLine(); // Move to the next line
                writer.write(workoutList.get(2).toString());
                writer.newLine(); // Move to the next line
                writer.write(workoutList.get(3).toString());
                writer.newLine(); // Move to the next line
                writer.write(workoutList.get(4).toString());
                writer.newLine(); // Move to the next line
                writer.newLine(); // Move to the next line
                writer.write("TUESDAY");
                writer.newLine(); // Move to the next line
                writer.write(workoutList.get(5).toString());
                writer.newLine(); // Move to the next line
                writer.write(workoutList.get(6).toString());
                writer.newLine(); // Move to the next line
                writer.write(workoutList.get(7).toString());
                writer.newLine(); // Move to the next line
                writer.write(workoutList.get(8).toString());
                writer.newLine(); // Move to the next line
                writer.write(workoutList.get(3).toString());
                writer.newLine(); // Move to the next line
                writer.write(workoutList.get(4).toString());
                writer.newLine(); // Move to the next line
                writer.newLine(); // Move to the next line
                writer.newLine(); // Move to the next line
                writer.write("WEDNESDAY");
                writer.newLine(); // Move to the next line
                writer.write(workoutList.get(9).toString());
                writer.newLine(); // Move to the next line
                writer.write(workoutList.get(10).toString());
                writer.newLine(); // Move to the next line
                writer.write(workoutList.get(11).toString());
                writer.newLine(); // Move to the next line
                writer.write(workoutList.get(3).toString());
                writer.newLine(); // Move to the next line
                writer.write(workoutList.get(4).toString());
                writer.newLine(); // Move to the next line
                writer.newLine(); // Move to the next line
                writer.write("THURSDAY");
                writer.newLine(); // Move to the next line
                writer.write(workoutList.get(12).toString());
                writer.newLine(); // Move to the next line
                writer.write(workoutList.get(13).toString());
                writer.newLine(); // Move to the next line
                writer.write(workoutList.get(14).toString());
                writer.newLine(); // Move to the next line
                writer.write(workoutList.get(15).toString());
                writer.newLine(); // Move to the next line
                writer.write(workoutList.get(3).toString());
                writer.newLine(); // Move to the next line
                writer.write(workoutList.get(4).toString());
                writer.newLine(); // Move to the next line
                writer.newLine(); // Move to the next line
                writer.write("FRIDAY");
                writer.newLine(); // Move to the next line
                writer.write(workoutList.get(5).toString());
                writer.newLine(); // Move to the next line
                writer.write(workoutList.get(16).toString());
                writer.newLine(); // Move to the next line
                writer.write(workoutList.get(17).toString());
                writer.newLine(); // Move to the next line
                writer.write(workoutList.get(3).toString());
                writer.newLine(); // Move to the next line
                writer.write(workoutList.get(4).toString());
                writer.newLine(); // Move to the next line
                writer.newLine(); // Move to the next line
                writer.write("SATURDAY");
                writer.newLine(); // Move to the next line
                writer.write("Rest Day");
                writer.newLine(); // Move to the next line
                writer.write("Wait for Monday");
                writer.newLine(); // Move to the next line
                writer.newLine(); // Move to the next line
                writer.write("SUNDAY");
                writer.newLine(); // Move to the next line
                writer.write("Rest Day");
                writer.newLine(); // Move to the next line
                writer.write("Wait for Monday");
                writer.newLine(); // Move to the next line
                writer.newLine();
                writer.newLine();
                writer.write("--------------------------------------------------------------------------------------------------");
                writer.newLine();
                writer.write("PREVIOUS WEEK");
                writer.newLine();
                writer.newLine();
                writer.newLine();
                int linecounter = 0;
                
                reader.close(); //close reader
                BufferedReader reader2 = new BufferedReader(new FileReader(file)); //new reader to reset the file
                while ((line = reader2.readLine()) != null) {
                linecounter++;
                
                if (linecounter > 2){
                    writer.write(line); //writes old workout plan
                    writer.newLine();
                }
            }
            writer.close();
            reader.close();
            reader2.close();
            
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (file.exists()) {
                try {
                    // Delete the original file
                    if (file.delete()) {
                        // Rename the new file to have the same name as the original file
                        if (file1.renameTo(file)) {
                            System.out.println("File operations completed successfully.");
                        } else {
                            // Failed to rename the new file
                            System.err.println("Failed to rename the new file.");
                        }
                    } else {
                        // Failed to delete the original file
                        System.err.println("Failed to delete the original file.");
                    }
                } catch (Exception e) {
                    // Handle any exception that may occur during file operations
                    System.err.println("An error occurred during file operations: " + e.getMessage());
                }
            } else {
                // The original file does not exist
                System.err.println("The original file does not exist.");
            }
        


            return file;
        }
    
    
    
    }
        
   

