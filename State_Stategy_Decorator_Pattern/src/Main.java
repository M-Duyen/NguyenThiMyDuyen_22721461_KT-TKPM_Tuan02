import decorator.DiscountDecorator;
import decorator.FeeDecorator;
import model.Order;
import strategy.CreditCardPayment;
import strategy.PayPalPayment;
import strategy.PaymentStrategy;

public class Main {

    public static void main(String[] args) {

        printBanner("Bai 1: Don hang hoan thanh (PayPal + Fee + Discount)");

        Order order1 = new Order("DH001", "Laptop Dell XPS 15", 25000000);
        System.out.println("Don hang: " + order1.getId()
                + " | San pham: " + order1.getProductName()
                + " | Gia: " + order1.getPrice() + " VND");

        // --- STATE PATTERN: Chuyen trang thai ---
        order1.nextState();
        order1.nextState();

        System.out.println("\n>> Trang thai cuoi: " + order1.getStatus());

        // --- STRATEGY + DECORATOR PATTERN: Chon thanh toan ---
        System.out.println("\n>> Tien hanh thanh toan cho don: " + order1.getId());

        PaymentStrategy paypal = new PayPalPayment("user@gmail.com");
        PaymentStrategy withDiscount = new DiscountDecorator(paypal, "SALE10");
        PaymentStrategy withFeeAndDiscount = new FeeDecorator(withDiscount);

        order1.setPaymentStrategy(withFeeAndDiscount);
        String result1 = order1.checkout();
        System.out.println("  => " + result1);


        printBanner("DEMO 2: Don hang bi huy (The tin dung, khong decorator)");

        Order order2 = new Order("DH002", "iPhone 15 Pro Max", 34000000);
        System.out.println("Don hang: " + order2.getId()
                + " | San pham: " + order2.getProductName()
                + " | Gia: " + order2.getPrice() + " VND");

        order2.nextState();
        order2.cancel();

        System.out.println("\n>> Trang thai cuoi: " + order2.getStatus());

        // Thanh toan the tin dung thuan (khong decorator)
        System.out.println("\n>> Thanh toan hoan tien cho don: " + order2.getId());
        PaymentStrategy card = new CreditCardPayment("1234567890123456");
        order2.setPaymentStrategy(card);
        String result2 = order2.checkout();
        System.out.println("  => " + result2);


        printBanner("DEMO 3: Doi Strategy luc runtime");

        Order order3 = new Order("DH003", "Samsung Galaxy S24", 18000000);
        System.out.println("Don hang: " + order3.getId()
                + " | San pham: " + order3.getProductName()
                + " | Gia: " + order3.getPrice() + " VND");

        order3.nextState();
        order3.nextState();
        System.out.println("\n>> Trang thai cuoi: " + order3.getStatus());

        System.out.println("\n>> Lan 1: Dung PayPal thuan");
        order3.setPaymentStrategy(new PayPalPayment("buyer@example.com"));
        System.out.println("  => " + order3.checkout());

        System.out.println("\n>> Lan 2: Doi sang The tin dung + Phi xu ly");
        PaymentStrategy cardWithFee = new FeeDecorator(
                new CreditCardPayment("9876543210987654")
        );
        order3.setPaymentStrategy(cardWithFee);
        System.out.println("  Phuong thuc: " + cardWithFee.getMethodName());
        System.out.println("  => " + order3.checkout());

    }

    private static void printBanner(String title) {
        System.out.println("\n");
        System.out.println("_".repeat(60));
        System.out.println("  " + title);
        System.out.println("_".repeat(60));
    }
}
