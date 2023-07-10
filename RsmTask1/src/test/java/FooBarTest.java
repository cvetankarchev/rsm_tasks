import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FooBarTest {
    @Test
    public void testFooBar() {
        assertEquals("1,2,foo,4,bar,foo,foobar",
                FooBar.fooBar("1,2,3,4,5,6,45"));
        assertEquals("1,2,foo,1-copy,2-copy,foo-copy,1-copy,1-copy",
                FooBar.fooBar("1,2,3,1,2,3,1,1"));
        assertEquals("1,1-copy,foo,foo-copy,bar,bar-copy,foobar,foobar-copy",
                FooBar.fooBar("1,1,3,3,5,5,45,45"));
    }
}
