package com.company;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Task3 {
    static void printOnAccr(School[] array, int accrLevel) {
        System.out.printf("With accr level %s:%n", accrLevel);
        for (var ins : array) {
            if (ins instanceof University) {
                if (((University) ins).getAccrLevel() == accrLevel) {
                    System.out.println(ins);
                }
            }
        }
    }

    static SecondarySchool minStuds(School[] array) {
        var min = new SecondarySchool();
        int i = 0;
        for (; i < array.length; ++i) {
            if (array[i] instanceof SecondarySchool) {
                min = (SecondarySchool) array[i];
                break;
            }
        }

        for (; i < array.length; ++i) {
            if (array[i] instanceof SecondarySchool) {
                if (((SecondarySchool) array[i]).getStudAmount() < min.getStudAmount()) {
                    min = (SecondarySchool) array[i];
                }
            }
        }
        return min;
    }

    private static void execute(int accrLevel) {
        var list = new LinkedList<School>();

        try {
            Scanner input = new Scanner(new File("src/input.txt"));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] inputArgs = line.split("\\s+");
                var type = inputArgs[0];
                School instance;

                if (type.equals("SecondarySchool")) {
                    instance = new SecondarySchool(
                            inputArgs[1],
                            inputArgs[2],
                            Integer.parseInt(inputArgs[3]),
                            Integer.parseInt(inputArgs[4]),
                            Integer.parseInt(inputArgs[5])
                    );
                } else if (type.equals("University")) {
                    instance = new University(
                            inputArgs[1],
                            inputArgs[2],
                            Integer.parseInt(inputArgs[3]),
                            Integer.parseInt(inputArgs[4]),
                            Integer.parseInt(inputArgs[5])
                    );
                } else {
                    throw new Exception("Invalid instance name");
                }
                list.add(instance);
            }
        } catch (Exception exception) {
            System.out.println(exception.toString());
        }

        var array = list.toArray(new School[0]);

        System.out.printf("Array: %s%n", Arrays.toString(array));
        Arrays.sort(array);
        System.out.printf("Sorted array: %s%n", Arrays.toString(array));

        System.out.printf("Min stud amount in: %s%n", minStuds(array));

        printOnAccr(array, accrLevel);
    }

    public static void Run() {
        var in = new Scanner(System.in);
        int accrLevel = in.nextInt();
        execute(accrLevel);
    }

    public static void RunTest() {
        System.out.println("Running with accreditation level: 2");
        execute(2);
    }
}

class School implements Comparable<School> {
    protected String title;
    protected String address;
    protected int year;

    School(String title, String address, int year) {
        this.title = title;
        this.address = address;
        this.year = year;
    }

    public int compareTo(School ins) {
        return Integer.compare(year, ins.year);
    }

    School() {
    }
}

class SecondarySchool extends School {
    private int number;
    private int studAmount;

    SecondarySchool(String title, String address, int year, int number, int studAmount) {
        super(title, address, year);
        this.number = number;
        this.studAmount = studAmount;
    }

    SecondarySchool() {
    }

    public String toString() {
        return String.format("SecSchool(%s, %s, %s, %s, %s)",
                title, address, year, number, studAmount);
    }

    public int getStudAmount() {
        return studAmount;
    }
}

class University extends School {
    private final int accrLevel;
    private final int nFaculties;

    University(String title, String address, int year, int accrLevel, int nFaculties) {
        super(title, address, year);
        this.accrLevel = accrLevel;
        this.nFaculties = nFaculties;
    }

    public String toString() {
        return String.format("SecSchool(%s, %s, %s, %s, %s)",
                title, address, year, accrLevel, nFaculties);
    }

    public int getAccrLevel() {
        return accrLevel;
    }
}
