package system;

//คลาสหลักที่เก็บข้อมูลของสินค้า
class Product {
 protected int id; 
 protected String name; 
 protected double price; 

 // คอนสตรัคเตอร์สำหรับตั้งชื่อและราคาของสินค้า
 public Product(String name, double price) {
     this.id = generateId(); // สร้างรหัสสินค้าโดยใช้เมธอด generateId()
     this.name = name; 
     this.price = price; 
 }

 // เมธอดที่สร้างรหัสสินค้าแบบสุ่ม
 protected int generateId() {
     return (int) (Math.random() * 1000); // สุ่มรหัสสินค้าเป็นตัวเลขระหว่าง 0 ถึง 999
 }

 // เมธอดแสดงข้อมูลของสินค้า
 public void displayInfo() {
     System.out.println("รหัสสินค้า: " + id);
     System.out.println("ชื่อสินค้า: " + name);
     System.out.println("ราคา: " + price);
 }

 // เมธอดที่แปลงอ็อบเจ็กต์เป็นข้อความ (Overriding)
 @Override
 public String toString() {
     return "Product: " + name + ", Price: " + price;
 }
}

//คลาส Drink ที่สืบทอดจาก Product โดยเพิ่มข้อมูลของเครื่องดื่ม
class Drink extends Product {
 private String expirationDate; 
 private String manufacturer; 

 // คอนสตรัคเตอร์สำหรับ Drink ที่เรียกใช้คอนสตรัคเตอร์ของ Product ด้วยคำว่า super
 public Drink(String name, double price, String expirationDate, String manufacturer) {
     super(name, price); // เรียกคอนสตรัคเตอร์ของ Product เพื่อกำหนดชื่อและราคา
     this.expirationDate = expirationDate; 
     this.manufacturer = manufacturer; 
 }

 // เมธอดแสดงข้อมูลของ Drink (Overriding) 
 @Override
 public void displayInfo() {
     super.displayInfo(); // เรียกใช้เมธอด displayInfo ของ Product เพื่อแสดงรหัส ชื่อ และราคา
     System.out.println("วันที่หมดอายุ: " + expirationDate);
     System.out.println("ผู้ผลิต: " + manufacturer);
 }

 // เมธอดที่แปลงข้อมูลของ Drink เป็นข้อความ (Overriding)
 @Override
 public String toString() {
     return "Drink: " + name + ", Price: " + price + ", Expiration Date: " + expirationDate + ", Manufacturer: " + manufacturer;
 }
}

//คลาส Food ที่สืบทอดจาก Product โดยเพิ่มข้อมูลเกี่ยวกับประเภทอาหาร
class Food extends Product {
 private String category; // ประเภทของอาหาร เช่น ต้ม ผัด ทอด

 // คอนสตรัคเตอร์สำหรับ Food
 public Food(String name, double price, String category) {
     super(name, price); // เรียกคอนสตรัคเตอร์ของ Product เพื่อกำหนดชื่อและราคา
     this.category = category; 
 }

 // เมธอดแสดงข้อมูลของ Food (Overriding)
 @Override
 public void displayInfo() {
     super.displayInfo(); // เรียกใช้เมธอด displayInfo ของ Product เพื่อแสดงรหัส ชื่อ และราคา
     System.out.println("ประเภทอาหาร: " + category); 
 }

 // เมธอดที่แปลงข้อมูลของ Food เป็นข้อความ (Overriding)
 @Override
 public String toString() {
     return "Food: " + name + ", Price: " + price + ", Category: " + category;
 }
}

//คลาส Customer ที่เก็บข้อมูลของลูกค้า
class Customer {
 protected String name; 

 // คอนสตรัคเตอร์สำหรับ Customer
 public Customer(String name) {
     this.name = name; 
 }

 // เมธอดคำนวณส่วนลด (ใน Customer ไม่มีส่วนลดโดยค่าเริ่มต้น)
 public double calculateDiscount(double totalAmount) {
     return totalAmount; // คืนค่าเต็มจำนวน ไม่มีส่วนลด
 }

 // เมธอดแสดงข้อมูลของลูกค้า
 public void displayInfo() {
     System.out.println("ลูกค้า: " + name);
 }

 // เมธอดที่แปลงข้อมูลของ Customer เป็นข้อความ (Overriding)
 @Override
 public String toString() {
     return "Customer: " + name;
 }
}

//คลาส Member ที่สืบทอดจาก Customer โดยเพิ่มข้อมูลเกี่ยวกับคะแนนสะสม
class Member extends Customer {
 protected int points; // 

 // คอนสตรัคเตอร์สำหรับ Member
 public Member(String name) {
     super(name); // เรียกคอนสตรัคเตอร์ของ Customer เพื่อกำหนดชื่อ
     this.points = 0; 
 }

 // เมธอดเพิ่มคะแนนสะสมตามจำนวนเงินที่จ่าย
 public void addPoints(double amount) {
     points += (int) (amount / 25); // สมาชิกปกติได้ 1 point ต่อ 25 บาท
 }

 // เมธอดคำนวณส่วนลด (Overriding) สำหรับสมาชิกปกติ
 @Override
 public double calculateDiscount(double totalAmount) {
     return totalAmount * 0.95; // คืนยอดรวมที่หักส่วนลด 5% สำหรับสมาชิกปกติ
 }

 // เมธอดแสดงข้อมูลของสมาชิก
 @Override
 public void displayInfo() {
     super.displayInfo(); // แสดงชื่อสมาชิก
     System.out.println("ประเภทสมาชิก: ปกติ");
     System.out.println("คะแนนสะสม: " + points);
 }

 // เมธอดที่แปลงข้อมูลของ Member เป็นข้อความ (Overriding)
 @Override
 public String toString() {
     return "Member: " + name + ", Points: " + points;
 }
}

//คลาส VIPMember ที่สืบทอดจาก Member โดยมีการคำนวณคะแนนและส่วนลดที่ต่างจากสมาชิกปกติ
class VIPMember extends Member {

 // คอนสตรัคเตอร์สำหรับ VIPMember
 public VIPMember(String name) {
     super(name); // เรียกคอนสตรัคเตอร์ของ Member เพื่อกำหนดชื่อ
 }

 // เมธอดเพิ่มคะแนนสะสม (Overriding) สำหรับสมาชิก VIP
 @Override
 public void addPoints(double amount) {
     points += (int) (amount / 20); // สมาชิก VIP ได้ 1 point ต่อ 20 บาท
 }

 // เมธอดคำนวณส่วนลด (Overriding) สำหรับสมาชิก VIP
 @Override
 public double calculateDiscount(double totalAmount) {
     return totalAmount * 0.90; // คืนยอดรวมที่หักส่วนลด 10% สำหรับสมาชิก VIP
 }

 // เมธอดแสดงข้อมูลของสมาชิก VIP
 @Override
 public void displayInfo() {
     super.displayInfo(); // แสดงชื่อและคะแนนสะสม
     System.out.println("ประเภทสมาชิก: VIP");
 }

 // เมธอดที่แปลงข้อมูลของ VIPMember เป็นข้อความ (Overriding)
 @Override
 public String toString() {
     return "VIP Member: " + name + ", Points: " + points;
 }
}
