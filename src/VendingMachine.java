import java.util.Map;

public class VendingMachine {

    boolean isPushed = false;
    boolean isPaid = false;
    boolean usePhone = false;
    int payment = 0;
    int change = 0;

    private static final int _500YEN = 500;
    private static final int _100YEN = 100;
    private static final int _50YEN = 50;
    private static final int _10YEN = 10;

    private Map<String, Integer> beverageMap = Map.of(
            "コーラ", 100,
            "ウーロン茶", 110,
            "レッドブル", 200,
            "ミルクティー", 150
    );


    public void pushBtn() {
        isPushed = true;
    }

    public void insertCoin(int _500yenCount, int _100yenCount, int _50yenCount, int _10yenCount, String beverage) {
        payment = _500YEN * _500yenCount+_100YEN * _100yenCount+_50YEN * _50yenCount+_10YEN * _10yenCount;
        if (payment >= beverageMap.get(beverage)) {
            isPaid = true;
        }
    }

    public String getBeverage(String beverage) {
        if (isPushed && beverageMap.containsKey(beverage)) {
            return beverage;
        } else {
            return "NULL";
        }
    }

    public String buy(int _500yenCount, int _100yenCount, int _50yenCount, int _10yenCount, String beverage) {
        if (usePhone) {
            payByPhone(beverage);
        } else {
            insertCoin(_500yenCount, _100yenCount, _50yenCount, _10yenCount, beverage);
        }

        if (isPaid) {
            change = payment-beverageMap.get(beverage);
            return getBeverage(beverage);
        } else {
            return "not paid enough.";
        }
    }


    public int pushReturn() {
        return payment;
    }

    public void payByPhone(String beverage) {
        usePhone = true;
        isPaid = true;
        payment = beverageMap.get(beverage);
    }
}
