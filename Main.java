package main;

import java.util.List;
import java.util.Scanner;

import DAO.CourierDAO;
import model.Courier;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourierDAO dao = new CourierDAO();
        int choice;

        do {
            System.out.println("\n===== COURIER TRACKING SYSTEM =====");
            System.out.println("1. Add Courier");
            System.out.println("2. View All Couriers");
            System.out.println("3. Update Courier Status");
            System.out.println("4. Delete Courier");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Sender Name: ");
                    String sender = sc.nextLine();
                    System.out.print("Receiver Name: ");
                    String receiver = sc.nextLine();
                    System.out.print("Source: ");
                    String source = sc.nextLine();
                    System.out.print("Destination: ");
                    String dest = sc.nextLine();
                    System.out.print("Status: ");
                    String status = sc.nextLine();
                    dao.addCourier(new Courier(sender, receiver, source, dest, status));
                    break;

                case 2:
                    List<Courier> list = dao.getAllCouriers();
                    System.out.println("\n--- All Couriers ---");
                    for (Courier c : list)
                        System.out.println(c);
                    break;

                case 3:
                    System.out.print("Enter Courier ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); /

                    System.out.println("Select New Status:");
                    System.out.println("1. Parcel Accepted");
                    System.out.println("2. Picked Up");
                    System.out.println("3. In Transit");
                    System.out.println("4. Arrived at Hub");
                    System.out.println("5. Out for Delivery");
                    System.out.println("6. Delivered");
                    System.out.println("7. Delivery Attempted");
                    System.out.println("8. Delivery Failed");
                    System.out.println("9. Returned to Sender");
                    System.out.println("10. Cancelled");

                    System.out.print("Enter your choice (1-10): ");
                    int option = sc.nextInt();
                    sc.nextLine();

                    String newStatus = "";

                    switch (option) {
                        case 1:
                            newStatus = "Parcel Accepted";
                            break;
                        case 2:
                            newStatus = "Picked Up";
                            break;
                        case 3:
                            newStatus = "In Transit";
                            break;
                        case 4:
                            newStatus = "Arrived at Hub";
                            break;
                        case 5:
                            newStatus = "Out for Delivery";
                            break;
                        case 6:
                            newStatus = "Delivered";
                            break;
                        case 7:
                            newStatus = "Delivery Attempted";
                            break;
                        case 8:
                            newStatus = "Delivery Failed";
                            break;
                        case 9:
                            newStatus = "Returned to Sender";
                            break;
                        case 10:
                            newStatus = "Cancelled";
                            break;
                        default:
                            System.out.println("Invalid choice!");
                            break;
                    }

                    if (!newStatus.isEmpty()) {
                        dao.updateStatus(id, newStatus);
                        System.out.println("Status updated successfully to: " + newStatus);
                    } else {
                        System.out.println("Status not updated due to invalid input.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Courier ID to delete: ");
                    int delId = sc.nextInt();
                    dao.deleteCourier(delId);
                    break;

                case 0:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}
