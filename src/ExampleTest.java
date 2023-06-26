import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExampleTest {

    private VendingMachine sut;

//    @Test
//    public void test() {
//        assertEquals(true, true);
//    }

    @BeforeEach
    public void setUp() {
        sut = new VendingMachine();
    }

    @Test
    public void ボタンを押すとコーラが出る() {
        sut.pushBtn("コーラ");
        assertEquals("コーラ", sut.getBeverage("コーラ"));
    }

    @Test
    public void お金を払う() {
        sut.insertCoin(0, 1, 0, 0, "コーラ");
        sut.pushBtn("コーラ");
        assertEquals("コーラ", sut.buy(0, 1, 0, 0, "コーラ"));
    }

    @Test
    public void お金を払わない() {
        sut.pushBtn("コーラ");
        sut.insertCoin(0, 0, 0, 0, "コーラ");
        assertEquals("not paid enough.", sut.buy(0, 0, 0, 0, "コーラ"));
    }

    @Test
    public void _100円入れてもボタンを押さないとコーラが出ない() {
        sut.insertCoin(0, 1, 0, 0, "コーラ");
        assertEquals("NULL", sut.buy(0, 1, 0, 0, "コーラ"));
    }

    @Test
    public void ウーロン茶追加() {
        sut.pushBtn("ウーロン茶");
        assertEquals("ウーロン茶", sut.getBeverage("ウーロン茶"));
    }

    @Test
    public void レッドブル() {
        sut.insertCoin(0, 2, 0, 0, "レッドブル");
        sut.pushBtn("レッドブル");
        assertEquals("レッドブル", sut.buy(0, 2, 0, 0, "レッドブル"));
    }

    @Test
    public void ミルクティー() {
        sut.insertCoin(0, 2, 0, 0, "ミルクティー");
        sut.pushBtn("ミルクティー");
        assertEquals("ミルクティー", sut.buy(0, 2, 0, 0, "ミルクティー"));
    }

    @Test
    public void 存在しない飲み物は指定できない() {
        sut.insertCoin(0, 2, 0, 0, "水");
        sut.pushBtn("水");
        assertEquals("NULL", sut.buy(0, 2, 0, 0, "水"));
    }

    @Test
    public void ボタンが光る() {
        sut.insertCoin(1, 0, 0, 0,"コーラ");
        assertEquals(true, sut.isPaid);
    }

    @Test
    public void 使えるコイン_500() {
        sut.insertCoin(1, 0, 0, 0,"コーラ");
        assertEquals(500, sut.payment);
    }

    @Test
    public void 使えるコイン_50() {
        sut.insertCoin(0, 0, 1, 0,"コーラ");
        assertEquals(50, sut.payment);
    }

    @Test
    public void 使えるコイン_10() {
        sut.insertCoin(0, 0, 0, 1,"コーラ");
        assertEquals(10, sut.payment);
    }

    @Test
    public void お釣り() {
        sut.insertCoin(1, 0, 0, 0,"コーラ");
        sut.pushBtn("コーラ");
        sut.buy(1, 0, 0, 0,"コーラ");
        assertEquals(400, sut.change);
    }

    @Test
    public void 返却ボタン() {
        sut.insertCoin(1, 0, 0, 0,"コーラ");
        sut.pushReturn();
        assertEquals(500, sut.payment);
    }

    @Test
    public void キャッシュレス決済() {
        sut.payByPhone("ミルクティー");
        sut.pushBtn("ミルクティー");
        assertEquals("ミルクティー", sut.buy(0, 0, 0, 0, "ミルクティー"));
    }

    @Test
    public void キャッシュレス決済_返却ボタン() {
        sut.payByPhone("ミルクティー");
        sut.pushBtn("ミルクティー");
        sut.pushReturn();
        assertEquals(150, sut.payment);
    }

}
