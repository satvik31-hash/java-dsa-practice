package Practice;
//CHECKING A FRUIT
//import java.util.Scanner;
//public class Switch {
//    static void main() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter a Fruit:- ");
//        String a = sc.next();
//        switch (a){
//            case "Apple":
//                System.out.println("Apple");
//                break;
//                case "Orange":
//                    System.out.println("Orange");
//                    break;
//            default:
//                System.out.println("Not a Fruit");
//        }
//
//    }
//
//}



// CHECKING DAY OF A WEEK
import java.util.Scanner;
public class Switch{
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number the Day:- ");
        String day = sc.nextLine();
        switch (day){
            case "Monday":
                System.out.println("Monday");
                break;
            case "Tuesday":
                System.out.println("Tuesday");
                break;
            case "Wednesday":
                System.out.println("Wednesday");
                break;
                case "Thursday":
                    System.out.println("Thursday");
                    break;
                    case "Friday":
                        System.out.println("Friday");
                        break;
                        case "Saturday":
                            System.out.println("Saturday");
                            break;
                            case "Sunday":
                                System.out.println("Sunday");
                                break;
            default:
                System.out.println("Invalid Day");

        }
    }
}

