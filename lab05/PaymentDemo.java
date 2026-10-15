package lab05;

// ---------- Version 1: instanceof ----------
class CardPaymentV1 {
    void chargeCard() { System.out.println("Charging card"); }
}

class MobileMoneyPaymentV1 {
    void sendMobileMoney() { System.out.println("Sending mobile money"); }
}

class PaymentProcessorV1 {
    // must be edited every time a new payment type appears
    void pay(Object p) {
        if (p instanceof CardPaymentV1 c) {
            c.chargeCard();
        } else if (p instanceof MobileMoneyPaymentV1 m) {
            m.sendMobileMoney();
        } else {
            System.out.println("Unknown payment type");
        }
    }
}

// ---------- Version 2: polymorphic process() ----------
abstract class Payment {
    abstract void process();
}

class CardPayment extends Payment {
    @Override void process() { System.out.println("Charging card"); }
}

class MobileMoneyPayment extends Payment {
    @Override void process() { System.out.println("Sending mobile money"); }
}

class PaymentProcessorV2 {
    // never needs to change when new payment types are added
    void pay(Payment p) {
        p.process();
    }
}

public class PaymentDemo {
    public static void main(String[] args) {
        System.out.println("--- Version 1 (instanceof) ---");
        PaymentProcessorV1 v1 = new PaymentProcessorV1();
        v1.pay(new CardPaymentV1());
        v1.pay(new MobileMoneyPaymentV1());
        v1.pay("cash");

        System.out.println("--- Version 2 (polymorphism) ---");
        PaymentProcessorV2 v2 = new PaymentProcessorV2();
        v2.pay(new CardPayment());
        v2.pay(new MobileMoneyPayment());
    }
}