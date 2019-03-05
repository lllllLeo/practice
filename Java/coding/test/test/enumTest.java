package test;

import main.TableStatus;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class enumTest {

    @Test
    public void tableStatusTest() throws Exception {
        TableStatus tableStatus = selectFromOriginTable();
        System.out.println(tableStatus);
        String table1Value = tableStatus.getTable1Value();
        System.out.println(table1Value);
        boolean table2Value = tableStatus.isTable2Value();
        System.out.println(table2Value);

        assertThat(tableStatus, is(TableStatus.YES));
        assertThat(table1Value, is("1"));
        assertThat(table2Value, is(true));
        assertEquals(table1Value, tableStatus.getTable1Value());
    }

    private TableStatus selectFromOriginTable() {

        return TableStatus.YES;
    }
}
