import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DateNextDateOkTest {

  private int year, month, day;
  private int eYear, eMonth, eDay;

  public DateNextDateOkTest(int year, int month, int day, int eYear, int eMonth, int eDay) {
    this.year = year; this.month = month; this.day = day;
    this.eYear = eYear; this.eMonth = eMonth; this.eDay = eDay;
  }

  @Parameters
  public static List<Integer[]> data() {
    return Arrays.asList(new Integer[][] {
      // TC1:  1700/06/20 -> 1700/06/21
      { 1700,  6, 20, 1700,  6, 21 },
      // TC2:  2005/04/15 -> 2005/04/16
      { 2005,  4, 15, 2005,  4, 16 },
      // TC3:  1901/07/20 -> 1901/07/21
      { 1901,  7, 20, 1901,  7, 21 },
      // TC4:  3456/03/27 -> 3456/03/28
      { 3456,  3, 27, 3456,  3, 28 },
      // TC5:  1500/02/17 -> 1500/02/18
      { 1500,  2, 17, 1500,  2, 18 },
      // TC6:  1700/06/29 -> 1700/06/30
      { 1700,  6, 29, 1700,  6, 30 },
      // TC7:  1800/11/29 -> 1800/11/30
      { 1800, 11, 29, 1800, 11, 30 },
      // TC8:  3453/01/29 -> 3453/01/30
      { 3453,  1, 29, 3453,  1, 30 },
      // TC9:  444/02/29 -> 444/03/01 (leap year)
      {  444,  2, 29,  444,  3,  1 },
      // TC10: 2005/04/30 -> 2005/05/01
      { 2005,  4, 30, 2005,  5,  1 },
      // TC11: 3453/01/30 -> 3453/01/31
      { 3453,  1, 30, 3453,  1, 31 },
      // TC12: 3456/03/30 -> 3456/03/31
      { 3456,  3, 30, 3456,  3, 31 },
      // TC13: 1901/07/31 -> 1901/08/01
      { 1901,  7, 31, 1901,  8,  1 },
      // TC14: 3453/01/31 -> 3453/02/01
      { 3453,  1, 31, 3453,  2,  1 },
      // TC15: 3456/12/31 -> 3457/01/01
      { 3456, 12, 31, 3457,  1,  1 },
    });
  }

  @Test
  public void testNextDate() {
    Date input = new Date(year, month, day);
    Date expected = new Date(eYear, eMonth, eDay);
    Assert.assertEquals(expected, input.nextDate());
  }
}
