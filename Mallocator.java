import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

class Mallocator {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        WF();
        BF();
        FF();
    }
    public static void FF()throws FileNotFoundException, IOException {
        BufferedReader min = new BufferedReader(new FileReader("Minput.data"));
        BufferedReader pin = new BufferedReader(new FileReader("Pinput.data"));

        String slots_available = min.readLine();
        String processes = pin.readLine();
        int slots = Integer.parseInt(slots_available.trim());
        int process = Integer.parseInt(processes.trim());


        //fills in matrix with memory data
        int mem[][] = new int[slots][2];
        for(int i=0; i < slots; i++) {
            String line = min.readLine();
            if (line != null){
                String[] parts = line.trim().split("\\s+");
                mem[i][0] = Integer.parseInt(parts[0]);
                mem[i][1] = Integer.parseInt(parts[1]);
            } else {
                System.out.println("Error");
                System.exit(0);
            }
        }


        //fill in matrix with process data
        int procs[][] = new int[process][2];
        for(int i=0; i < process; i++) {
            String line = pin.readLine();
            if (line != null){
                String[] parts = line.trim().split("\\s+");
                procs[i][0] = Integer.parseInt(parts[0]);
                procs[i][1] = Integer.parseInt(parts[1]);
            } else {
                System.out.println("Error");
                System.exit(0);
            }
        }

        //lists to make writing to file easier
        List<String> output = new ArrayList<>();
        List<Integer> unalloted = new ArrayList<>();

        //build output
        for (int i = 0; i < process; i++) { //loop through processes
            boolean allocated = false;
            for (int j = 0; j < slots; j++) { //loop through memory slots
                int size = mem[j][1] - mem[j][0];
                if (size >= procs[i][1]) {
                    output.add(mem[j][0] + " " + (mem[j][0] + procs[i][1]) + " " + procs[i][0]);//start address, end address, proccess id
                    mem[j][0] += procs[i][1]; //adjust memory since slot was filled
                    allocated = true;
                    break;
                }
            }
            if (!allocated) {
                unalloted.add(procs[i][0]);
            }
        }

        //write output to file
        write(output, unalloted, "FFoutput.data");


       

        min.close();
        pin.close();
    }
    public static void BF() throws FileNotFoundException, IOException {
        BufferedReader min = new BufferedReader(new FileReader("Minput.data"));
        BufferedReader pin = new BufferedReader(new FileReader("Pinput.data"));

        String slots_available = min.readLine();
        String processes = pin.readLine();
        int slots = Integer.parseInt(slots_available.trim());
        int process = Integer.parseInt(processes.trim());


        //fills in matrix with memory data
        int mem[][] = new int[slots][2];
        for(int i=0; i < slots; i++) {
            String line = min.readLine();
            if (line != null){
                String[] parts = line.trim().split("\\s+");
                mem[i][0] = Integer.parseInt(parts[0]);
                mem[i][1] = Integer.parseInt(parts[1]);
            } else {
                System.out.println("Error");
                System.exit(0);
            }
        }


        //fill in matrix with process data
        int procs[][] = new int[process][2];
        for(int i=0; i < process; i++) {
            String line = pin.readLine();
            if (line != null){
                String[] parts = line.trim().split("\\s+");
                procs[i][0] = Integer.parseInt(parts[0]);
                procs[i][1] = Integer.parseInt(parts[1]);
            } else {
                System.out.println("Error");
                System.exit(0);
            }
        }

        //lists to make writing to file easier
        List<String> output = new ArrayList<>();
        List<Integer> unalloted = new ArrayList<>();

        //build output
        int mem_size[] = new int[slots];
        int bestfit_size = 100000;
        boolean alloted = false;
        int bestfit = -1;
        

        for (int i = 0; i < slots; i++) {
            mem_size[i] = mem[i][1] - mem[i][0];
        }
        for (int i = 0; i < process; i++) { //loops through procs
            alloted = false;
            for (int j=0; j < slots; j++) { //loops through mem
                if((mem_size[j]-procs[i][1]) >= 0) {
                    if((mem_size[j]-procs[i][1]) < bestfit_size) {
                        bestfit_size = mem_size[j];
                        bestfit = j;
                    }
                }
            }
            if (bestfit != -1) {
                output.add(mem[bestfit][0]+" "+(mem[bestfit][0]+procs[i][1])+" "+procs[i][0]);
                mem_size[bestfit] = mem_size[bestfit] - procs[i][1];
                alloted = true;
            }
            if (alloted == false)
                unalloted.add(procs[i][0]);
        }

        //write output to file
        write(output, unalloted, "BFoutput.data");


        min.close();
        pin.close();
    }
    public static void WF() throws FileNotFoundException, IOException {
        BufferedReader min = new BufferedReader(new FileReader("Minput.data"));
        BufferedReader pin = new BufferedReader(new FileReader("Pinput.data"));

        String slots_available = min.readLine();
        String processes = pin.readLine();
        int slots = Integer.parseInt(slots_available.trim());
        int process = Integer.parseInt(processes.trim());


        //fills in matrix with memory data
        int mem[][] = new int[slots][2];
        for(int i=0; i < slots; i++) {
            String line = min.readLine();
            if (line != null){
                String[] parts = line.trim().split("\\s+");
                mem[i][0] = Integer.parseInt(parts[0]);
                mem[i][1] = Integer.parseInt(parts[1]);
            } else {
                System.out.println("Error");
                System.exit(0);
            }
        }


        //fill in matrix with process data
        int procs[][] = new int[process][2];
        for(int i=0; i < process; i++) {
            String line = pin.readLine();
            if (line != null){
                String[] parts = line.trim().split("\\s+");
                procs[i][0] = Integer.parseInt(parts[0]);
                procs[i][1] = Integer.parseInt(parts[1]);
            } else {
                System.out.println("Error");
                System.exit(0);
            }
        }

        //lists to make writing to file easier
        List<String> output = new ArrayList<>();
        List<Integer> unalloted = new ArrayList<>();

        //build output
        int mem_size[] = new int[slots];
        int worstfit_size = 0;
        boolean alloted = false;
        int worstfit = -1;
        

        for (int i = 0; i < slots; i++) {
            mem_size[i] = mem[i][1] - mem[i][0]; //fills array with memory sizes
            if (mem_size[i] > worstfit_size)
            {
                worstfit_size = mem_size[i];
                worstfit = i;
            }
        }
        for (int i = 0; i < process; i++) { //loops through procs
            alloted = false;
            if (procs[i][1] <= mem_size[worstfit])
            {
                output.add(mem[worstfit][0]+" "+(mem[worstfit][0]+procs[i][1])+" "+procs[i][0]);
                mem_size[worstfit] = mem_size[worstfit] - procs[i][1];
                mem[worstfit][0] += procs[i][1];    
                alloted = true;

                worstfit_size = 0;
                for (int j =0; j < slots; j++)
                {
                    if (mem_size[j] > worstfit_size)
                    {
                        worstfit_size = mem_size[j];
                        worstfit = j;
                    }
                }
            }
            if (!alloted)
                unalloted.add(procs[i][0]);
        }

        //write output to file
        write(output, unalloted, "WFoutput.data");


        min.close();
        pin.close();
    }



    //Universally used methods
    public static void write(List<String> output, List<Integer> unalloted, String name) throws FileNotFoundException, IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(name));
        for (String line : output) {
            writer.write(line);
            writer.newLine();
        }
        for (int leftover : unalloted) {
            writer.write(String.valueOf(leftover));
            writer.write(",");
        }
        writer.close();
    }
}