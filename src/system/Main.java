package system;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // สร้างอ็อบเจ็กต์ Scanner เพื่อรับข้อมูลจากผู้ใช้

        // รับข้อมูลเครื่องดื่มจากผู้ใช้
        System.out.println("เพิ่มข้อมูลเครื่องดื่ม:");
        System.out.print("ชื่อเครื่องดื่ม: ");
        String drinkName = scanner.nextLine(); // รับชื่อเครื่องดื่มจากผู้ใช้
        System.out.print("ราคา: ");
        double drinkPrice = scanner.nextDouble(); // รับราคาของเครื่องดื่ม
        scanner.nextLine(); // เพื่อรับ enter หลังจากการรับข้อมูลชนิด double
        System.out.print("วันที่หมดอายุ (เช่น 12/05/2025): ");
        String expirationDate = scanner.nextLine(); // รับวันที่หมดอายุของเครื่องดื่ม
        System.out.print("ผู้ผลิต: ");
        String manufacturer = scanner.nextLine(); // รับชื่อผู้ผลิตของเครื่องดื่ม
        
        // สร้างอ็อบเจ็กต์ Drink ด้วยข้อมูลที่รับมา
        Drink drink = new Drink(drinkName, drinkPrice, expirationDate, manufacturer);

        // รับข้อมูลอาหารจากผู้ใช้
        System.out.println("\nเพิ่มข้อมูลอาหาร:");
        System.out.print("ชื่ออาหาร: ");
        String foodName = scanner.nextLine(); // รับชื่ออาหารจากผู้ใช้
        System.out.print("ราคา: ");
        double foodPrice = scanner.nextDouble(); // รับราคาอาหาร
        scanner.nextLine(); // เพื่อรับ enter หลังจากการรับข้อมูลชนิด double
        System.out.print("ประเภทอาหาร (ต้ม/ผัด/ทอด): ");
        String foodCategory = scanner.nextLine(); // รับประเภทของอาหาร เช่น ต้ม ผัด ทอด
        
        // สร้างอ็อบเจ็กต์ Food ด้วยข้อมูลที่รับมา
        Food food = new Food(foodName, foodPrice, foodCategory);

        // แสดงข้อมูลสินค้า (เครื่องดื่มและอาหาร)
        System.out.println("\nสินค้าในร้าน:");
        drink.displayInfo(); // แสดงข้อมูลของเครื่องดื่ม
        System.out.println(); // เว้นบรรทัดเพื่อความเป็นระเบียบ
        food.displayInfo(); // แสดงข้อมูลของอาหาร
        System.out.println(); // เว้นบรรทัดเพื่อความเป็นระเบียบ

        // รับข้อมูลประเภทของลูกค้า
        System.out.println("เลือกลูกค้า:");
        System.out.println("1. ลูกค้าทั่วไป");
        System.out.println("2. สมาชิกปกติ");
        System.out.println("3. สมาชิก VIP");
        System.out.print("เลือกประเภทลูกค้า (1-3): ");
        int customerType = scanner.nextInt(); // รับตัวเลือกประเภทลูกค้าจากผู้ใช้

        // กำหนดประเภทของลูกค้าตามที่ผู้ใช้เลือก
        Customer customer;
        if (customerType == 1) {
            customer = new Customer("ลูกค้าทั่วไป"); // สร้างอ็อบเจ็กต์ Customer สำหรับลูกค้าทั่วไป
        } else if (customerType == 2) {
            customer = new Member("สมาชิกปกติ"); // สร้างอ็อบเจ็กต์ Member สำหรับสมาชิกปกติ
        } else {
            customer = new VIPMember("สมาชิก VIP"); // สร้างอ็อบเจ็กต์ VIPMember สำหรับสมาชิก VIP
        }

        // รับข้อมูลยอดรวมการชำระเงินจากลูกค้า
        System.out.print("\nป้อนยอดรวมการชำระเงิน: ");
        double totalAmount = scanner.nextDouble(); // รับยอดรวมการชำระเงิน

        // แสดงผลการชำระเงินของลูกค้า
        System.out.println("\nการชำระเงินของลูกค้า:");
        customer.displayInfo(); // แสดงข้อมูลของลูกค้า เช่น ชื่อและประเภทสมาชิก
        System.out.println("ยอดเงินที่ต้องชำระ: " + customer.calculateDiscount(totalAmount)); // แสดงยอดเงินที่ต้องชำระหลังหักส่วนลด

        scanner.close(); // ปิดการใช้งาน Scanner เพื่อคืนทรัพยากร
    }
}
