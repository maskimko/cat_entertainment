/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.fun.cat;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
public class Cat {

    public static class Args {

        @Parameter(names = {"-i", "--ifile"})
        String in;
        @Parameter(names = {"-o", "--ofile"})
        String out;
        @Parameter(names = "-h")
        boolean help;
        @Parameter(names = "-n")
        boolean numbers;
    }

    public static void main(String[] args) {
        Args arguments = new Args();
        new JCommander(arguments, args);
        if (arguments.help) {
            System.out.println("Usage: java cat [-i inputfile] [-o outputfile] [-h help] [-n line numbers]");
            System.exit(0);
        }
        try (BufferedReader br = (arguments.in == null) ? new BufferedReader(new InputStreamReader(System.in)) : new BufferedReader(new FileReader(arguments.in));
                PrintStream os = (arguments.out == null) ? System.out : new PrintStream(arguments.out)) {
            int ln = 0;
            String line;
            while ((line = br.readLine()) != null) {
                if (arguments.numbers) os.println(String.format("%4s %s", ++ln, line));
                 else  os.println(line);
                
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {

        }

    }
}
