import java.util.Map;

public class VendingMachine {

    boolean isPushed = false;
    boolean hasBeverage = true;
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


    public void pushBtn(String beverage) {
        if (beverageMap.get(beverage)!=null) {
            isPushed = true;
        } else {
            hasBeverage = false;
        }
    }

    public void insertCoin(int _500yenCount, int _100yenCount, int _50yenCount, int _10yenCount) {
        payment = _500YEN * _500yenCount+_100YEN * _100yenCount+_50YEN * _50yenCount+_10YEN * _10yenCount;
        if (beverageMap.entrySet().stream().anyMatch(e->e.getValue()<=payment)) {
            isPaid = true;
        }
    }

    public String getBeverage(String beverage) {
        if (isPushed && hasBeverage) {
            return beverage;
        } else {
            return "NULL";
        }
    }

    public String buy(String beverage) {
        if (!hasBeverage || !isPushed) {
            return "NULL";
        } else if (isPaid) {
            change = payment - beverageMap.get(beverage);
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
        payment = !hasBeverage?0:beverageMap.get(beverage);
    }
}
