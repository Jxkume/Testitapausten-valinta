import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeUtilsTest {

    @ParameterizedTest(name = "Testi {index}: Sekunnit {0} muutettuna ajaksi {1}")
    @CsvSource({ "3665, '1:01:05'", "0, '0:00:00'", "86400, '24:00:00'", "1, '0:00:01'", "3600, '1:00:00'" })
    public void testSecToTime(int seconds, String expectedTime) {
        String actualTime = TimeUtils.secToTime(seconds);
        assertEquals(expectedTime, actualTime);
    }

    @ParameterizedTest(name = "Testi {index}: Negatiivinen sekuntiarvo {0} muutettuna ajaksi {1}")
    @CsvSource({ "-1, '-1'", "-10, '-1'", "-3600, '-1'" })
    public void testSecToTimeNegative(int seconds, String expectedTime) {
        String actualTime = TimeUtils.secToTime(seconds);
        assertEquals(expectedTime, actualTime);
    } 

    @ParameterizedTest(name = "Testi {index}: Aika {0} muutettuna sekunneiksi")
    @CsvSource({ "1:01:05, 3665", "0:00:00, 0", "24:00:00, 86400", "12:30:15, 45015", "23:59:59, 86399" })
    public void testTimeToSec(String time, int expectedSeconds) {
        int actualSeconds = TimeUtils.timeToSec(time);
        assertEquals(expectedSeconds, actualSeconds);
    }

    @ParameterizedTest(name = "Testi {index}: Sekuntien muuntaminen ajaksi, kun sekunnit ovat yksinumeroisia {0}")
    @CsvSource({ "1, '0:00:01'", "59, '0:00:59'", "3600, '1:00:00'" }) 
    public void testSecToTimeSingleDigitSeconds(int seconds, String expectedTime) {
        String actualTime = TimeUtils.secToTime(seconds);
        assertEquals(expectedTime, actualTime);
    }

    @ParameterizedTest(name = "Testi {index}: Sekuntien muuntaminen ajaksi, kun minuutit ovat yksinumeroisia {0}")
    @CsvSource({ "61, '0:01:01'", "599, '0:09:59'", "3601, '1:00:01'" })
    public void testSecToTimeSingleDigitMinutes(int seconds, String expectedTime) {
        String actualTime = TimeUtils.secToTime(seconds);
        assertEquals(expectedTime, actualTime);
    }
    
    @ParameterizedTest(name = "Testi {index}: Sekuntien muuntaminen ajaksi, kun minuutit ovat kaksinumeroisia {0}")
    @CsvSource({ "3665, '1:01:05'", "7200, '2:00:00'", "9000, '2:30:00'" })
    public void testSecToTimeDoubleDigitMinutes(int seconds, String expectedTime) {
        String actualTime = TimeUtils.secToTime(seconds);
        assertEquals(expectedTime, actualTime);
    }

}
 