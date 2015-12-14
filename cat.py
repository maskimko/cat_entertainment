#!/usr/bin/python3
import sys
import getopt


def main(argv):
    inputfile = sys.stdin
    outputfile = sys.stdout
    numbers = False
    try:
        try:
            opts, args = getopt.getopt(argv, "hni:o:", ["ifile=", "ofile="])
        except (getopt.GetoptError) as e:
            print('cat.py -i <inputfile> -o <outputfile>')
            print(str(e))
            sys.exit(2)
        for opt, arg in opts:
            if opt == '-h':
                print('Usage: ')
                print('cat.py -i <inputfile> -o <outputfile>')
                sys.exit()
            elif opt in ("-i", "--ifile"):
                if arg:
                    inputfile = open(arg,"r")
            elif opt in ("-o", "--ofile"):
                if arg:
                    outputfile = open(arg, "w")
            elif opt == '-n':
                numbers = True
        doCat(inputfile, outputfile, numbers)
    except (IOError) as e:
        print('IO Error ' + str(e))
    finally:
        if inputfile:
            inputfile.close()
        if outputfile:
            outputfile.close()


def doCat(inputfile, outputfile, numbers = False):
    line_number = 0;
    for line in inputfile:
        line_number += 1
        print((line.rstrip() if not numbers else '{0:>4} {1}'.format(line_number, line.rstrip())),
        file=outputfile, flush=True)


if __name__ == "__main__":
    main(sys.argv[1:])
