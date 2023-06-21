import com.example.visitsacompose.common.util.isTourAllowed
import junit.framework.TestCase.assertEquals
import org.junit.Test

class ToursExtTest {
    @Test
    fun `isTourAllowed should return expected results`() {
        // Test case 1: Index = 1, expected result = true
        assertEquals(true, 1.isTourAllowed())

        // Test case 2: Index = 2, expected result = false
        assertEquals(false, 2.isTourAllowed())

        // Test case 3: Index = 3, expected result = true
        assertEquals(true, 3.isTourAllowed())
    }
}