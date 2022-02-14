import javax.sound.midi.Soundbank;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        printAllNumbersBetween(1, 10);

        printAllEvenNumbersBetween(1, 20);

        System.out.println("Enter number and program will print all exact " +
                "squares of natural numbers that are not exceeding a given number");
        printAllExactSquares(scanner.nextInt());

        System.out.println("Print number greater than 2 and program will print " +
                "the smallest natural divisor other than 1 for a given number");
        printSmallestDivisor(scanner.nextInt());

        System.out.println("Enter number and program will" +
                "print all integer powers of two not exceeding N");
        printAllPowerOf2(scanner.nextInt());

        System.out.println("Enter number and program will" +
                "print integers in descending order");
        printIntegersInDescending(scanner.nextInt());

        System.out.println("Enter number and program will" +
                "print all integers that are multiple of 2 in descending order");
        printMultipleOfTwo(scanner.nextInt());

        findAndPrintPowerOf2();

        System.out.println("Enter number and program will print the smallest integer k that`\n" +
                " Math.pow(2,k)≥N\n");
        printNextNumAfterInput(scanner.nextInt());

        printAsciiTable();

        System.out.println("Enter number and program will " +
                "print all integer numbers from 1 to N, except that are multiple of 3");
        printNumbersExceptMultipleOf3(1, scanner.nextInt());

        System.out.println("Enter number and program will define and print what is the Fibonacci number is your number");
        printFibonacciNumber(scanner.nextInt());

        System.out.println("Enter how mani kilometer athlete run in first day");
        double startKm = scanner.nextDouble();
        System.out.println("Enter finish kilometer and program will print " +
                "how many days will need athlete to run that distance");
        calculateRunDays(startKm, scanner.nextDouble());

        bank();

        System.out.println("Enter number and program will print sum of the digits");
        printSumOfDigits(scanner.nextInt());


        guessNumber();

        System.out.println("Enter numbers bigger than 0 and last number enter 0 " +
                "and program find the second largest element in sequence," +
                "after every number press enter");
        findAndPrintSecondLargNum();
    }

    /**
     * finding and printing the second largest element in sequence
     */
    private static void findAndPrintSecondLargNum() {
        Scanner scanner = new Scanner(System.in);
        int max = 0;
        int secondMax = 0;
        int inputNum = scanner.nextInt();
        while (true) {
            if (max < inputNum) {
                secondMax = max;
                max = inputNum;
            }
            inputNum = scanner.nextInt();
            if (inputNum != 0) continue;
            System.out.println(secondMax);
            break;
        }

    }

    /**
     * program  generates a random from 0 to 100 number and asks the user to guess what the number is.
     */
    private static void guessNumber() {
        int randomNum = new Random().nextInt(100);
        Scanner scanner = new Scanner(System.in);
        int userNum;
        while (true) {
            System.out.println("Guess the number from 0 to 100");
            userNum = scanner.nextInt();
            if (randomNum != userNum) {
                System.out.println(randomNum > userNum ? "Too low, try again" : "Too high, try again");
                continue;
            } else System.out.println("Yes, you guessed the number");
            break;
        }
    }

    /**
     * print sum of the input number digits
     *
     * @param num
     */
    private static void printSumOfDigits(int num) {
        int sum = 0;
        while (true) {
            sum += num % 10;
            num = num / 10;
            if (num >= 10) continue;
            else sum += num;
            break;
        }
        System.out.println(sum);
    }

    /**
     * The deposit in the bank is 'x' dollars.
     * It increases annually by 'p' percent, after which the fractional part of cents is discarded.
     * program are determine how many years the contribution will be at least 'y' dollars.
     */
    private static void bank() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter deposit");
        int deposit = scanner.nextInt();
        System.out.println("Enter percent");
        int percent = scanner.nextInt();
        System.out.println("Enter contribution");
        int contribution = scanner.nextInt();
        int years = 0;

        while (true) {
            deposit += deposit * percent / 100;
            years++;
            if (deposit < contribution) continue;
            break;
        }
        System.out.println("Years " + years);
    }

    /**
     * calculating how many days will need athlete to run that distance if
     * in first day he run X km and every day he increased the mileage by 10% from the previous value
     *
     * @param startKm
     * @param finishKm
     */
    private static void calculateRunDays(double startKm, double finishKm) {
        int days = 1;
        while (true) {
            startKm += startKm * 10 / 100;
            days++;
            if (startKm < finishKm) continue;
            System.out.println(days);
            break;
        }
    }

    /**
     * define and print what is the Fibonacci number is input number
     *
     * @param num
     */
    private static void printFibonacciNumber(int num) {
        if (num == 1) {
            System.out.println("1 is first and second number in Fibonacii sequence");
            return;
        }
        int prev = 1;
        int next = 1;
        int count = 2;
        int fib = 1;
        while (true) {
            fib = prev + next;
            prev = next;
            next = fib;
            count++;
            if (fib < num) continue;
            break;
        }
        if (fib == num) {
            System.out.println(num + " is " + count + " number in Fibonacii sequence");
        } else System.out.println(-1);
    }

    /**
     * Print all integer numbers from 1 to N, except that are multiple of 3
     *
     * @param i
     * @param num
     */
    private static void printNumbersExceptMultipleOf3(int i, int num) {
        while (i <= num) {
            if (i % 3 == 0) {
                i++;
                continue;
            }
            System.out.print(i + " ");
            i++;
        }
    }

    /**
     * printing the table of characters that are equivalent to the Ascii codes from 32 to 122
     */
    private static void printAsciiTable() {
        int count = 0;
        char ch = 32;
        do {
            ch++;
            System.out.print(ch + " ");
            count++;
            if (count % 10 == 0) System.out.println("\n");
        } while (ch < 122);
    }


    /**
     * printing the smallest integer k that`
     * Math.pow(2,k)≥N.
     *
     * @param N
     */
    private static void printNextNumAfterInput(int N) {
        int k = 1;
        int num = 2;
        while (true) {
            if (num > N) {
                break;
            }
            num *= 2;
            k++;
        }
        System.out.println(k);
    }

    /**
     * program  check is input number power of two and print attempts
     */
    private static void findAndPrintPowerOf2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number and program will check is it power of two");
        int num = scanner.nextInt();
        int count = 1;
        while (true) {
            if ((num > 0) && (num & (num - 1)) == 0) {
                break;
            }
            System.out.println("Wrong, enter again");
            num = scanner.nextInt();
            count++;
        }
        System.out.println("Number is " + num + " attempts : " + count);
    }

    private static void printMultipleOfTwo(int num) {
        while (true) {
            if ((num & 1) == 0) System.out.println(num);
            num--;
            if (num < 2) {
                break;
            }
        }
    }

    /**
     * printing all integers in descending order for given number
     *
     * @param num
     */
    private static void printIntegersInDescending(int num) {
        while (true) {
            System.out.println(num);
            num--;
            if (num < 0) {
                break;
            }
        }
    }

    /**
     * Printing all integer powers of two not exceeding N in ascending order
     *
     * @param num
     */
    private static void printAllPowerOf2(int num) {
        int count = 1;
        while (true) {
            System.out.println(count);
            count *= 2;
            if (count > num) {
                break;
            }
        }
    }

    /**
     * printing the smallest natural divisor other than 1 for a given number
     *
     * @param num
     */
    private static void printSmallestDivisor(int num) {
        int divisor = 2;
        while (divisor <= num) {
            if (num % divisor == 0) {
                break;
            }
            divisor++;
        }
        System.out.println(divisor);
    }

    /**
     * printing all exact
     * squares of natural numbers that are not exceeding a given number
     *
     * @param num
     */
    private static void printAllExactSquares(int num) {
        int count = 1;
        while (count * count <= num) {
            System.out.println(count * count);
            count++;
        }
    }

    /**
     * Printing all even numbers between input numbers
     *
     * @param num1
     * @param num2
     */
    private static void printAllEvenNumbersBetween(int num1, int num2) {
        while (num1 <= num2) {
            if ((num1 & 1) == 0) {
                System.out.println(num1);
            }
            num1++;
        }
    }

    /**
     * printing all numbers between input numbers
     *
     * @param num1
     * @param num2
     */
    private static void printAllNumbersBetween(int num1, int num2) {
        while (num1 <= num2) {
            System.out.print(num1 + " ");
            num1++;
        }
    }
}
