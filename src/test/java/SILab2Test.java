import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    private List<String> createList(String... elems) {
        return new ArrayList<>(Arrays.asList(elems));
    }

    @Test
    void testEveryPath() {
        IllegalArgumentException ex;

    //1,2, 3, 17 - ""
        List <String> list=new ArrayList<String>();
        ex=assertThrows(IllegalArgumentException.class, () -> SILab2.function(list));
        assertTrue(ex.getMessage().contains("List length should be greater than 0"));

    //1,2, 4, 5.1, 5.2, 16, 17 - Ne e vozmozhno so nieden broj na elementi

    //1,2, 4, 5.1, 5.2, (6, 13,14, 15, 5.3, 5.2), 16, 17 - ##
        assertEquals(createList("#","#"), SILab2.function(createList("#","#")));

    //1,2, 4, 5.1, 5.2, (6, 7, 8, 9, 10, 11, 12, 15, 5.3, 5.2), 16, 17 - #0#
        assertEquals(createList("#","2","#"), SILab2.function(createList("#","0","#")));

    //1,2, 4 , 5.1, 5.2, (6, 7, 8, 9, 10, 12, 15, 5.3, 5.2), 16, 17 - #00
        assertEquals(createList("#","1","0"), SILab2.function(createList("#","0","0")));

    //1,2, 4, 5.1, 5.2, (6, 7, 8, 10, 11, 12, 15, 5.3, 5.2), 16, 17 - 00#
        assertEquals(createList("0","1","#"), SILab2.function(createList("0","0","#")));

    //1,2, 4 , 5.1, 5.2, (6, 7, 8, 10, 12, 15, 5.3, 5.2), 16, 17 - 000
        assertEquals(createList("0","0","0"), SILab2.function(createList("0","0","0")));

    }

    @Test
    void multipleConditionsTest() {

        //if (i - 1 >= 0 && list.get(i - 1).equals("#"))

        //T && T - ##
        assertEquals(createList("#","#"), SILab2.function(createList("#","#")));
        //T && F - 00
        assertEquals(createList("0","0"), SILab2.function(createList("0","0")));
        //F && X - 0
        assertEquals(createList("0"), SILab2.function(createList("0")));

        //if (i + 1 < list.size() && list.get(i + 1).equals("#"))

        //T && T - 0#
        assertEquals(createList("1","#"), SILab2.function(createList("0","#")));
        //T && F - 00
        assertEquals(createList("0","0"), SILab2.function(createList("0","0")));
        //F && X - 0
        assertEquals(createList("0"), SILab2.function(createList("0")));
    }
}