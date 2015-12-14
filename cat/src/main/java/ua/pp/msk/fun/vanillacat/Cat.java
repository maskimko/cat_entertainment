/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.pp.msk.fun.vanillacat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
public class Cat {
   public static final String IFILE="--ifile", OFILE="--ofile", I="-i", O="-o", N="-n", H="-h";
    public static void main(String[] args) {
     String in = null, out = null;
     boolean num = false, help = false;
       for (int j = 0; j < args.length; j++){
           if (args[j].equals(IFILE) || args[j].equals(I)) in = args[j+1];
           if (args[j].equals(OFILE) || args[j].equals(O)) out = args[j+1];
           if (args[j].equals(H)) help=true;
           if (args[j].equals(N)) num = true;
       }
        if (help) {
            System.out.println("Usage: java cat [-i inputfile] [-o outputfile] [-h help] [-n line numbers]");
            System.exit(0);
        }
        try (BufferedReader br = (in == null) ? new BufferedReader(new InputStreamReader(System.in)) : new BufferedReader(new FileReader(in));
                PrintStream os = (out == null) ? System.out : new PrintStream(out)) {
            int ln = 0;
            String line;
            while ((line = br.readLine()) != null) {
                if (num) os.println(String.format("%4s %s", ++ln, line));
                 else  os.println(line);
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {

        }

    }
}
