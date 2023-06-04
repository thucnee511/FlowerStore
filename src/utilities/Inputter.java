/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Inputter {

    private static Scanner sc = new Scanner(System.in);

    public static int getInt(String inputMsg) {
        while (true) {
            try {
                System.out.print(inputMsg);
                int num = Integer.parseInt(sc.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Must be an integer number.");
            }
        }
    }

    public static double getReal(String inputMsg) {
        while (true) {
            try {
                System.out.print(inputMsg);
                double num = Double.parseDouble(sc.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Must be a real number.");
            }
        }
    }

    public static int getPositiveInt(String inputMsg) {
        while (true) {
            try {
                System.out.print(inputMsg);
                int num = Integer.parseInt(sc.nextLine());
                if (num < 0) {
                    throw new Exception();
                }
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Mus be an integer number.");
            } catch (Exception e) {
                System.out.println("Must be higher than 0.");
            }
        }
    }

    public static double getPositiveReal(String inputMsg) {
        while (true) {
            try {
                System.out.print(inputMsg);
                double num = Double.parseDouble(sc.nextLine());
                if (num < 0) {
                    throw new Exception();
                }
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Mus be an integer number.");
            } catch (Exception e) {
                System.out.println("Must be higher than 0.");
            }
        }
    }

    public static String getString(String inputMsg) {
        System.out.print(inputMsg);
        return sc.nextLine();
    }

    public static String getStringNonBlank(String inputMsg) {
        while (true) {
            try {
                System.out.print(inputMsg);
                String str = sc.nextLine();
                if (str == null || str.isEmpty()) {
                    throw new Exception();
                }
                return str;
            } catch (Exception e) {
                System.out.println("This field cannot be empty.");
            }
        }
    }

    public static String getString(String inputMsg, String errorMsg, String regex) {
        while (true) {
            try {
                System.out.print(inputMsg);
                String str = sc.nextLine();
                if (str == null || str.isEmpty()) {
                    throw new Exception("This feild cannot be empty.");
                }
                if (!str.matches(regex)) {
                    throw new Exception(errorMsg);
                }
                return str;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String getString(String inputMsg, int min, int max) {
        while (true) {
            try {
                System.out.print(inputMsg);
                String str = sc.nextLine();
                int len = str.length();
                if (len < min || len > max) {
                    throw new Exception();
                }
                return str;
            } catch (Exception e) {
                System.out.println(String.format("String length must be in [%d,%d].", min, max));
            }
        }
    }

    public static Date getDate(String inputMsg, String format) {
        while (true) {
            try {
                System.out.print(inputMsg);
                SimpleDateFormat formatter = new SimpleDateFormat(format);
                formatter.setLenient(false);
                return formatter.parse(sc.nextLine());
            } catch (ParseException e) {
                System.out.println("Invalid date format (" + format + ")");
            }
        }
    }
    
    public static boolean getYesOrNo(String msg){
        Menu yesno = new Menu(msg) ;
        yesno.addOption("Yes");
        yesno.addOption("No");
        yesno.print();
        return yesno.getChoice() == 1;
    }
}
