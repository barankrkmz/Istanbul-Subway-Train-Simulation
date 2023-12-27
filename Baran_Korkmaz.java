/*Name: Baran Korkmaz
Student ID:2021400090
Date: 26.03.2003
Brief summary: My code first takes the station names and coordinates from the text file
then my code have a method that finds all the possible routes for the all metro lines. After that
it takes inputs(departure and destination) then it looks inside all the routes and finds the one that
contains both the departure and destination and the other methods does the map printing and animation.
 */



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.Color;
import java.awt.Font;
public class Baran_Korkmaz {
    public static void main(String[] args) throws FileNotFoundException {
        //Taking each line to metroFile line by line from MetroStations.txt
        String fileName = "MetroStations.txt";
        File file = new File(fileName);
        Scanner metroFile = new Scanner(file);
        ArrayList<String> tempLines = new ArrayList<>();
        int lineNumber = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (metroFile.hasNextLine()) {
                tempLines.add(metroFile.nextLine());
                lineNumber++;
            } else {
                break;
            }
        }
        metroFile.close();

        //Creating metro lines list.
        ArrayList<String> B1 = new ArrayList<String>();
        ArrayList<String> M1A = new ArrayList<String>();
        ArrayList<String> M1B = new ArrayList<String>();
        ArrayList<String> M2 = new ArrayList<String>();
        ArrayList<String> M4 = new ArrayList<String>();
        ArrayList<String> M5 = new ArrayList<String>();
        ArrayList<String> M6 = new ArrayList<String>();
        ArrayList<String> M7 = new ArrayList<String>();
        ArrayList<String> M9 = new ArrayList<String>();
        ArrayList<String> M11 = new ArrayList<String>();


        // Creating breakpoints
        ArrayList<String> bp1 = new ArrayList<String>();
        ArrayList<String> bp2 = new ArrayList<String>();
        ArrayList<String> bp3 = new ArrayList<String>();
        ArrayList<String> bp4 = new ArrayList<String>();
        ArrayList<String> bp5 = new ArrayList<String>();
        ArrayList<String> bp6 = new ArrayList<String>();
        ArrayList<String> bp7 = new ArrayList<String>();

        // storing all coordinates with their commas in between them
        ArrayList<ArrayList<String>> coordinatesWithComas = new ArrayList<ArrayList<String>>();
        for (int i = 1; i < 20; i = i + 2) {
            String[] tempBp = tempLines.get(i).split(" ");
            ArrayList<String> tempArraylist = new ArrayList<String>();
            for (int j = 1; j < tempBp.length; j = j + 2) {
                tempArraylist.add(tempBp[j]);
            }
            coordinatesWithComas.add(tempArraylist);
        }

        // Storing  each metro line's line color
        ArrayList<String> rgb = new ArrayList<String>();
        for(int i= 0 ;i<20; i= i+2){
            String[] temp = tempLines.get(i).split(" ");
            String rgpPoints = temp[1];
            rgb.add(rgpPoints);
        }

        //Storing each metro station
        ArrayList<ArrayList<String>> newStations = new ArrayList<ArrayList<String>>();
        for(int i= 1 ;i<20; i= i+2){
            String[] temp = tempLines.get(i).split(" ");
            ArrayList<String> tempArraylist = new ArrayList<String>();
            for (int j = 0; j < temp.length; j = j + 2){
                tempArraylist.add(temp[j]);
            }
            newStations.add(tempArraylist);
        }

        // Storing breakpoints
        for (int i = 20; i < 21; i++) {
            String[] tempBp = tempLines.get(i).split(" ");
            for (int j = 0; j < tempBp.length; j++) {
                bp1.add(tempBp[j]);
            }
        }
        for (int i = 21; i < 22; i++) {
            String[] tempBp = tempLines.get(i).split(" ");
            for (int j = 0; j < tempBp.length; j++) {
                bp2.add(tempBp[j]);
            }
        }
        for (int i = 22; i < 23; i++) {
            String[] tempBp = tempLines.get(i).split(" ");
            for (int j = 0; j < tempBp.length; j++) {
                bp3.add(tempBp[j]);
            }
        }
        for (int i = 23; i < 24; i++) {
            String[] tempBp = tempLines.get(i).split(" ");
            for (int j = 0; j < tempBp.length; j++) {
                bp4.add(tempBp[j]);
            }
        }
        for (int i = 24; i < 25; i++) {
            String[] tempBp = tempLines.get(i).split(" ");
            for (int j = 0; j < tempBp.length; j++) {
                bp5.add(tempBp[j]);
            }
        }
        for (int i = 25; i < 26; i++) {
            String[] tempBp = tempLines.get(i).split(" ");
            for (int j = 0; j < tempBp.length; j++) {
                bp6.add(tempBp[j]);
            }
        }
        for (int i = 26; i < 27; i++) {
            String[] tempBp = tempLines.get(i).split(" ");
            for (int j = 0; j < tempBp.length; j++) {
                bp7.add(tempBp[j]);
            }
        }
        ArrayList<ArrayList<String>> breakPoints = new ArrayList<ArrayList<String>>();
        breakPoints.add(bp1);
        breakPoints.add(bp2);
        breakPoints.add(bp3);
        breakPoints.add(bp4);
        breakPoints.add(bp5);
        breakPoints.add(bp6);
        breakPoints.add(bp7);


        //Storing break point's names
        ArrayList<String> breakPointStationNames = new ArrayList<String>();
        for (int i = 0; i < breakPoints.size(); i++) {
            for (int j = 0; j < 1; j++) {
                breakPointStationNames.add(breakPoints.get(i).get(j));
            }
        }

        //Storing station's names
        for (int i = 1; i < (lineNumber - 7); i = i + 2) {
            if (i == 1) {
                String[] splitTemp = tempLines.get(i).split(" ");
                for (int j = 0; j < splitTemp.length; j = j + 2) {
                    B1.add(splitTemp[j]);
                }
            } else if (i == 3) {
                String[] splitTemp = tempLines.get(i).split(" ");
                for (int j = 0; j < splitTemp.length; j = j + 2) {
                    M1A.add(splitTemp[j]);
                }
            } else if (i == 5) {
                String[] splitTemp = tempLines.get(i).split(" ");
                for (int j = 0; j < splitTemp.length; j = j + 2) {
                    M1B.add(splitTemp[j]);
                }
            } else if (i == 7) {
                String[] splitTemp = tempLines.get(i).split(" ");
                for (int j = 0; j < splitTemp.length; j = j + 2) {
                    M2.add(splitTemp[j]);
                }
            } else if (i == 9) {
                String[] splitTemp = tempLines.get(i).split(" ");
                for (int j = 0; j < splitTemp.length; j = j + 2) {
                    M4.add(splitTemp[j]);
                }
            } else if (i == 11) {
                String[] splitTemp = tempLines.get(i).split(" ");
                for (int j = 0; j < splitTemp.length; j = j + 2) {
                    M5.add(splitTemp[j]);
                }
            } else if (i == 13) {
                String[] splitTemp = tempLines.get(i).split(" ");
                for (int j = 0; j < splitTemp.length; j = j + 2) {
                    M6.add(splitTemp[j]);
                }
            } else if (i == 15) {
                String[] splitTemp = tempLines.get(i).split(" ");
                for (int j = 0; j < splitTemp.length; j = j + 2) {
                    M7.add(splitTemp[j]);
                }
            } else if (i == 17) {
                String[] splitTemp = tempLines.get(i).split(" ");
                for (int j = 0; j < splitTemp.length; j = j + 2) {
                    M9.add(splitTemp[j]);
                }
            } else if (i == 19) {
                String[] splitTemp = tempLines.get(i).split(" ");
                for (int j = 0; j < splitTemp.length; j = j + 2) {
                    M11.add(splitTemp[j]);
                }
            }
        }
        ArrayList<ArrayList<String>> asterixStations = new ArrayList<ArrayList<String>>();
        asterixStations.add(B1);
        asterixStations.add(M1A);
        asterixStations.add(M1B);
        asterixStations.add(M2);
        asterixStations.add(M4);
        asterixStations.add(M5);
        asterixStations.add(M6);
        asterixStations.add(M7);
        asterixStations.add(M9);
        asterixStations.add(M11);










        //Storing metro name's without their asterisk at the start
        for (int i = 0; i < B1.size(); i++) {
            if (B1.get(i).startsWith("*")) {
                String tempStr = B1.get(i);
                String x = tempStr.substring(1);
                B1.set(i, x);
            }
        }
        for (int i = 0; i < M1A.size(); i++) {
            if (M1A.get(i).startsWith("*")) {
                String tempStr = M1A.get(i);
                String x = tempStr.substring(1);
                M1A.set(i, x);
            }
        }
        for (int i = 0; i < M1B.size(); i++) {
            if (M1B.get(i).startsWith("*")) {
                String tempStr = M1B.get(i);
                String x = tempStr.substring(1);
                M1B.set(i, x);
            }
        }
        for (int i = 0; i < M2.size(); i++) {
            if (M2.get(i).startsWith("*")) {
                String tempStr = M2.get(i);
                String x = tempStr.substring(1);
                M2.set(i, x);
            }
        }
        for (int i = 0; i < M4.size(); i++) {
            if (M4.get(i).startsWith("*")) {
                String tempStr = M4.get(i);
                String x = tempStr.substring(1);
                M4.set(i, x);
            }
        }
        for (int i = 0; i < M5.size(); i++) {
            if (M5.get(i).startsWith("*")) {
                String tempStr = M5.get(i);
                String x = tempStr.substring(1);
                M5.set(i, x);
            }
        }
        for (int i = 0; i < M6.size(); i++) {
            if (M6.get(i).startsWith("*")) {
                String tempStr = M6.get(i);
                String x = tempStr.substring(1);
                M6.set(i, x);
            }
        }
        for (int i = 0; i < M7.size(); i++) {
            if (M7.get(i).startsWith("*")) {
                String tempStr = M7.get(i);
                String x = tempStr.substring(1);
                M7.set(i, x);
            }
        }
        for (int i = 0; i < M9.size(); i++) {
            if (M9.get(i).startsWith("*")) {
                String tempStr = M9.get(i);
                String x = tempStr.substring(1);
                M9.set(i, x);
            }
        }
        for (int i = 0; i < M11.size(); i++) {
            if (M11.get(i).startsWith("*")) {
                String tempStr = M11.get(i);
                String x = tempStr.substring(1);
                M11.set(i, x);
            }
        }

        //Adding all metro lines to one line
        ArrayList<ArrayList<String>> metroLines = new ArrayList<ArrayList<String>>();
        metroLines.add(B1);
        metroLines.add(M1A);
        metroLines.add(M1B);
        metroLines.add(M2);
        metroLines.add(M4);
        metroLines.add(M5);
        metroLines.add(M6);
        metroLines.add(M7);
        metroLines.add(M9);
        metroLines.add(M11);
        Scanner scanner = new Scanner(System.in);
        String departure = scanner.nextLine();
        String destination = scanner.nextLine();

        int allStationsNumber = 0;
        for (int i = 0; i < metroLines.size(); i++) {
            for (int j = 0; j < metroLines.get(i).size(); j++) {
                allStationsNumber++;
            }
        }
        ArrayList<String> allStationsNamesAsList = new ArrayList<String>();
        for (int i = 0; i < metroLines.size(); i++) {
            for (int j = 0; j < metroLines.get(i).size(); j++) {
                allStationsNamesAsList.add(metroLines.get(i).get(j));
            }
        }


        //Diving all metro line's to their breaking points and adding all divided to lists to a new list
        ArrayList<ArrayList<String>> partsTillBps = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < metroLines.size(); i++) {
            for (int j = 1; j < metroLines.get(i).size() + 1; j++) {
                if (j != metroLines.get(i).size()) {
                    if (metroLines.get(i).size() > 2) {
                        if (breakPointStationNames.contains(metroLines.get(i).get(j))) {
                            List<String> tempList = metroLines.get(i).subList(0, j + 1);
                            ArrayList<String> tempArrayList = new ArrayList<String>(tempList);
                            partsTillBps.add(tempArrayList);
                            metroLines.get(i).subList(0, j).clear();
                            j = 1;
                        } else {
                            continue;
                        }
                    } else {
                        partsTillBps.add(metroLines.get(i));
                    }
                } else {
                    partsTillBps.add(metroLines.get(i));
                    continue;
                }
            }
        }




        ArrayList<String> startAndEnd = new ArrayList<String>();

        partsTillBps.get(2).remove(0);
        ArrayList<String> tempArraylist = new ArrayList<String>();
        tempArraylist.add("Uskudar");
        tempArraylist.add("AyrilikCesmesi");
        partsTillBps.add(tempArraylist);


        //calling the method I created to get the possible routes
        ArrayList<ArrayList<String>> secondPartsTillBps = new ArrayList<ArrayList<String>>();
        secondPartsTillBps = allRoutes(partsTillBps, startAndEnd);
        ArrayList<ArrayList<String>> allRealPathsDuplicates = new ArrayList<ArrayList<String>>();
        allRealPathsDuplicates = allRoutes(secondPartsTillBps, startAndEnd);

        ArrayList<ArrayList<String>> allRealPaths = new ArrayList<ArrayList<String>>();


        //adding those routes to a list
        for (int i = 0; i < allRealPathsDuplicates.size(); i++) {
            ArrayList<String> tempList = new ArrayList<String>();
            for (int j = 0; j < allRealPathsDuplicates.get(i).size(); j++) {
                if (tempList.contains(allRealPathsDuplicates.get(i).get(j))) {
                    continue;
                } else {
                    tempList.add(allRealPathsDuplicates.get(i).get(j));
                }
            }
            allRealPaths.add(tempList);
        }


        //calling the method that includes other methods (this method is where all the things happen)
        validationTest(departure, destination, allStationsNamesAsList, metroLines, allRealPaths, newStations, coordinatesWithComas, rgb);


    }


    //the method that I just explained
    public static void validationTest(String departure, String destination, ArrayList<String> allStationNamesAsList, ArrayList<ArrayList<String>> metroLines,
                                      ArrayList<ArrayList<String>> allRealPaths, ArrayList<ArrayList<String>> newStations,
                                      ArrayList<ArrayList<String>> coordinatesWithComas, ArrayList<String> rgb) {
        if (allStationNamesAsList.contains(departure) && allStationNamesAsList.contains(destination)) {
            if ((metroLines.get(8).contains(departure) && metroLines.get(8).contains(destination)) || (!metroLines.get(8).contains(departure) && !metroLines.get(8).contains(destination))) {
                ArrayList<String> consoleOutputList = new ArrayList<String>();
                consoleOutputList = consoleOutput(departure, destination, allRealPaths);
                animationPart(newStations,coordinatesWithComas,consoleOutputList,rgb);
                //canvas output

            } else {
                System.out.println("These two stations are not connected");
            }
        } else {
            System.out.println("The station names provided are not present in this map.");
        }
    }

    //the method that lists all possible routes
    public static ArrayList<ArrayList<String>> allRoutes(ArrayList<ArrayList<String>> partsTillBps, ArrayList<String> startAndEnd) {
        ArrayList<ArrayList<String>> answer = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < partsTillBps.size(); i++) {
            for (int j = i + 1; j < partsTillBps.size(); j++) {
                if ((startAndEnd.contains(partsTillBps.get(i).get(0)) && startAndEnd.contains(partsTillBps.get(i).get(partsTillBps.get(i).size() - 1))) ||
                        (startAndEnd.contains(partsTillBps.get(j).get(0)) && startAndEnd.contains(partsTillBps.get(j).get(partsTillBps.get(j).size() - 1)))) {
                    continue;
                } else {
                    if (partsTillBps.get(i).get(partsTillBps.get(i).size() - 1).equals(partsTillBps.get(j).get(0))) {
                        ArrayList<String> little = new ArrayList<>();
                        ArrayList<String> check = new ArrayList<>();
                        if (partsTillBps.get(i).size() > 3 && partsTillBps.get(j).size() > 3) {
                            for (int k = 1; k < partsTillBps.get(i).size() - 1; k++) {
                                for (int m = 1; m < partsTillBps.get(j).size() - 1; m++) {
                                    if (partsTillBps.get(i).get(k).equals(partsTillBps.get(j).get(m))) {
                                        check.add(partsTillBps.get(i).get(k));
                                    }
                                }
                            }
                        }
                        if (check.size() == 0) {
                            little.addAll(partsTillBps.get(i));
                            little.addAll(partsTillBps.get(j));
                            answer.add(little);
                        } else {
                            continue;
                        }
                    } else if (partsTillBps.get(i).get(0).equals(partsTillBps.get(j).get(partsTillBps.get(j).size() - 1))) {
                        ArrayList<String> little = new ArrayList<>();
                        ArrayList<String> check = new ArrayList<>();
                        if (partsTillBps.get(i).size() > 3 && partsTillBps.get(j).size() > 3) {
                            for (int k = 1; k < partsTillBps.get(i).size() - 1; k++) {
                                for (int m = 1; m < partsTillBps.get(j).size() - 1; m++) {
                                    if (partsTillBps.get(i).get(k).equals(partsTillBps.get(j).get(m))) {
                                        check.add(partsTillBps.get(i).get(k));
                                    }
                                }
                            }
                        }
                        if (check.size() == 0) {
                            little.addAll(partsTillBps.get(j));
                            little.addAll(partsTillBps.get(i));
                            answer.add(little);
                        } else {
                            continue;
                        }
                    } else if (partsTillBps.get(i).get(0).equals(partsTillBps.get(j).get(0))) {
                        ArrayList<String> little = new ArrayList<>();
                        ArrayList<String> reversed = new ArrayList<>();
                        ArrayList<String> check = new ArrayList<>();
                        if (partsTillBps.get(i).size() > 3 && partsTillBps.get(j).size() > 3) {
                            for (int k = 1; k < partsTillBps.get(i).size() - 1; k++) {
                                for (int m = 1; m < partsTillBps.get(j).size() - 1; m++) {
                                    if (partsTillBps.get(i).get(k).equals(partsTillBps.get(j).get(m))) {
                                        check.add(partsTillBps.get(i).get(k));
                                    }
                                }
                            }
                        }
                        if (check.size() == 0) {
                            reversed.addAll(partsTillBps.get(i));
                            Collections.reverse(reversed);
                            little.addAll(reversed);
                            little.addAll(partsTillBps.get(j));
                            answer.add(little);
                        } else {
                            continue;
                        }
                    } else if (partsTillBps.get(i).get(partsTillBps.get(i).size() - 1).equals(partsTillBps.get(j).get(partsTillBps.get(j).size() - 1))) {
                        ArrayList<String> little = new ArrayList<>();
                        ArrayList<String> reversed = new ArrayList<>();
                        ArrayList<String> check = new ArrayList<>();
                        if (partsTillBps.get(i).size() > 3 && partsTillBps.get(j).size() > 3) {
                            for (int k = 1; k < partsTillBps.get(i).size() - 1; k++) {
                                for (int m = 1; m < partsTillBps.get(j).size() - 1; m++) {
                                    if (partsTillBps.get(i).get(k).equals(partsTillBps.get(j).get(m))) {
                                        check.add(partsTillBps.get(i).get(k));
                                    }
                                }
                            }
                        }
                        if (check.size() == 0) {
                            reversed.addAll(partsTillBps.get(j));
                            Collections.reverse(reversed);
                            little.addAll(partsTillBps.get(i));
                            little.addAll(reversed);
                            answer.add(little);
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return answer;
    }


    //the method that writes the output(the route) to console
    public static ArrayList<String> consoleOutput(String departure, String destination, ArrayList<ArrayList<String>> allRealPaths) {
        for (int i = 0; i < allRealPaths.size(); i++) {
            if (allRealPaths.get(i).contains(departure) && allRealPaths.get(i).contains(destination)) {
                int index1 = allRealPaths.get(i).indexOf(departure);
                int index2 = allRealPaths.get(i).indexOf(destination);
                if (index1 < index2) {
                    List<String> routeSubList = allRealPaths.get(i).subList(index1, index2 + 1);
                    for (int j = 0; j < routeSubList.size(); j++) {
                        System.out.println(routeSubList.get(j));
                    }
                    ArrayList<String> realRoute = new ArrayList<String>();
                    realRoute.addAll(routeSubList);
                    return realRoute;
                } else {
                    List<String> routeSubList = allRealPaths.get(i).subList(index2, index1 + 1);
                    Collections.reverse(routeSubList);
                    for (int j = 0; j < routeSubList.size(); j++) {
                        System.out.println(routeSubList.get(j));
                    }
                    ArrayList<String> realRoute = new ArrayList<String>();
                    realRoute.addAll(routeSubList);
                    return realRoute;
                }
            }
        }
        ArrayList<String> unnecessary = new ArrayList<>();
        return unnecessary;
    }

    //the method that prints the map
    public static void printingMap(ArrayList<ArrayList<String>> newStations, ArrayList<ArrayList<String>> coordinatesWithComas,
                                   ArrayList<String> consoleOutputList, ArrayList<String> rgb) {
        StdDraw.picture(512, 241, "background.jpg");
        for(int i = 0; i< newStations.size(); i++){
            for(int j = 0; j<coordinatesWithComas.get(i).size()-1; j++){
                String[] temp = rgb.get(i).split(",");
                int red = Integer.parseInt(temp[0]);
                int blue = Integer.parseInt(temp[1]);
                int green = Integer.parseInt(temp[2]);
                StdDraw.setPenColor(red,blue,green);
                StdDraw.setPenRadius(0.012);
                String[] temp2 = coordinatesWithComas.get(i).get(j).split(",");
                double x0 = Double.parseDouble(temp2[0]);
                double y0 = Double.parseDouble(temp2[1]);
                String[] temp3 = coordinatesWithComas.get(i).get(j+1).split(",");
                double x1 = Double.parseDouble(temp3[0]);
                double y1 = Double.parseDouble(temp3[1]);
                StdDraw.line(x0,y0,x1,y1);
            }
        }
        for(int i = 0; i< coordinatesWithComas.size(); i++){
            for(int j = 0; j< coordinatesWithComas.get(i).size(); j++){
                String[] temp = coordinatesWithComas.get(i).get(j).split(",");
                double x = Double.parseDouble(temp[0]);
                double y = Double.parseDouble(temp[1]);
                StdDraw.setPenRadius(0.01);
                StdDraw.setPenColor(Color.WHITE);
                StdDraw.point(x,y);
            }
        }
        for(int i = 0; i<newStations.size();i++){
            for(int j = 0; j<newStations.get(i).size(); j++){
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.setFont(new Font("Helvetica", Font.BOLD, 8));
                if (newStations.get(i).get(j).startsWith("*")){
                    String tempString = newStations.get(i).get(j).substring(1);
                    String[] temp = coordinatesWithComas.get(i).get(j).split(",");
                    double x = Double.parseDouble(temp[0]);
                    double y = Double.parseDouble(temp[1]);
                    StdDraw.text(x,y+5,tempString);

                }
            }
        }
        StdDraw.show();
    }

    //the method that does the animation
    public static void animationPart(ArrayList<ArrayList<String>> newStations, ArrayList<ArrayList<String>> coordinatesWithComas,
                                     ArrayList<String> consoleOutputList, ArrayList<String> rgb){
        int canvas_width = 1024;
        int canvas_height = 482;
        StdDraw.setCanvasSize(canvas_width, canvas_height);
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 1024);
        StdDraw.setYscale(0, 482);

        for(int i = 0; i<consoleOutputList.size(); i++){
            printingMap(newStations,coordinatesWithComas,consoleOutputList,rgb);
            String currentStation = consoleOutputList.get(i);
            StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
            for(int j = 0; j< newStations.size(); j++){
                for(int k = 0; k< newStations.get(j).size(); k++){
                        if(newStations.get(j).get(k).equals(currentStation) || newStations.get(j).get(k).substring(1).equals(currentStation)){
                        String[] temp = coordinatesWithComas.get(j).get(k).split(",");
                        double first = Double.parseDouble(temp[0]);
                        double second = Double.parseDouble(temp[1]);
                        StdDraw.setPenRadius(0.02);
                        StdDraw.point(first, second);
                    }
                }
            }
            for(int j = 0; j<i; j++){
                for(int m = 0; m< newStations.size(); m++){
                    for(int k = 0; k< newStations.get(m).size(); k++){
                        if(newStations.get(m).get(k).equals(consoleOutputList.get(j)) || newStations.get(m).get(k).substring(1).equals(consoleOutputList.get(j))){
                            String[] temp = coordinatesWithComas.get(m).get(k).split(",");
                            double first = Double.parseDouble(temp[0]);
                            double second = Double.parseDouble(temp[1]);
                            StdDraw.setPenRadius(0.01);
                            StdDraw.point(first, second);
                        }
                    }
                }
            }
            StdDraw.show();
            StdDraw.pause(300);
            StdDraw.clear();
        }

    }



}