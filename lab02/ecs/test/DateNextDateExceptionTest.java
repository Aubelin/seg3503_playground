import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DateNextDateExceptionTest {

  private int year, month, day;

  public DateNextDateExceptionTest(int year, int month, int day) {
    this.year = year; this.month = month; this.day = day;
  }

  @Parameters
  public static List<Integer[]> data() {
    return Arrays.asList(new Integer[][] {
      // TC16: 1500/02/31 - invalid day for February
      { 1500,  2, 31 },
      // TC17: 1500/02/29 - invalid: 1500 is not a leap year (century not div by 400)
      { 1500,  2, 29 },
      // TC18: -1/10/20 - invalid negative year
      {   -1, 10, 20 },
      // TC19: 1458/15/12 - invalid month
      { 1458, 15, 12 },
      // TC20: 1975/06/-50 - invalid negative day
      { 1975,  6, -50 },
    });
  }

  @Test(expected = IllegalArgumentException.class)
  public void testException() {
    new Date(year, month, day);
  }
}
