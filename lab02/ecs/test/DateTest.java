import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DateTest {

  // TC1: Normal day in June
  @Test
  void tc01_1700_06_20_nextDay() {
    assertEquals(new Date(1700,6,21), new Date(1700,6,20).nextDate());
  }

  // TC2: Normal day in April
  @Test
  void tc02_2005_04_15_nextDay() {
    assertEquals(new Date(2005,4,16), new Date(2005,4,15).nextDate());
  }

  // TC3: Normal day in July
  @Test
  void tc03_1901_07_20_nextDay() {
    assertEquals(new Date(1901,7,21), new Date(1901,7,20).nextDate());
  }

  // TC4: Normal day in March
  @Test
  void tc04_3456_03_27_nextDay() {
    assertEquals(new Date(3456,3,28), new Date(3456,3,27).nextDate());
  }

  // TC5: February non-leap year
  @Test
  void tc05_1500_02_17_nextDay() {
    assertEquals(new Date(1500,2,18), new Date(1500,2,17).nextDate());
  }

  // TC6: Day before end of June
  @Test
  void tc06_1700_06_29_nextDay() {
    assertEquals(new Date(1700,6,30), new Date(1700,6,29).nextDate());
  }

  // TC7: Day before end of November
  @Test
  void tc07_1800_11_29_nextDay() {
    assertEquals(new Date(1800,11,30), new Date(1800,11,29).nextDate());
  }

  // TC8: Day before end of January
  @Test
  void tc08_3453_01_29_nextDay() {
    assertEquals(new Date(3453,1,30), new Date(3453,1,29).nextDate());
  }

  // TC9: Last day of February leap year (444 % 4 == 0, not century)
  @Test
  void tc09_444_02_29_lastDayLeapFeb() {
    assertEquals(new Date(444,3,1), new Date(444,2,29).nextDate());
  }

  // TC10: Last day of April (30-day month)
  @Test
  void tc10_2005_04_30_endOfMonth() {
    assertEquals(new Date(2005,5,1), new Date(2005,4,30).nextDate());
  }

  // TC11: Second to last day of January
  @Test
  void tc11_3453_01_30_nextDay() {
    assertEquals(new Date(3453,1,31), new Date(3453,1,30).nextDate());
  }

  // TC12: Second to last day of March
  @Test
  void tc12_3456_03_30_nextDay() {
    assertEquals(new Date(3456,3,31), new Date(3456,3,30).nextDate());
  }

  // TC13: Last day of July (31-day month)
  @Test
  void tc13_1901_07_31_endOfMonth() {
    assertEquals(new Date(1901,8,1), new Date(1901,7,31).nextDate());
  }

  // TC14: Last day of January
  @Test
  void tc14_3453_01_31_endOfMonth() {
    assertEquals(new Date(3453,2,1), new Date(3453,1,31).nextDate());
  }

  // TC15: Last day of December (end of year)
  @Test
  void tc15_3456_12_31_endOfYear() {
    assertEquals(new Date(3457,1,1), new Date(3456,12,31).nextDate());
  }

  // TC16: Invalid day 31 in February non-leap year
  @Test
  void tc16_1500_02_31_invalid() {
    assertThrows(IllegalArgumentException.class, () -> new Date(1500,2,31));
  }

  // TC17: Invalid day 29 in February non-leap year (1500 is century non-leap)
  @Test
  void tc17_1500_02_29_invalid() {
    assertThrows(IllegalArgumentException.class, () -> new Date(1500,2,29));
  }

  // TC18: Invalid year (negative)
  @Test
  void tc18_neg1_10_20_invalidYear() {
    assertThrows(IllegalArgumentException.class, () -> new Date(-1,10,20));
  }

  // TC19: Invalid month (15)
  @Test
  void tc19_1458_15_12_invalidMonth() {
    assertThrows(IllegalArgumentException.class, () -> new Date(1458,15,12));
  }

  // TC20: Invalid day (negative)
  @Test
  void tc20_1975_06_neg50_invalidDay() {
    assertThrows(IllegalArgumentException.class, () -> new Date(1975,6,-50));
  }
}
