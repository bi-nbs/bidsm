package Server.Database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMySQLDatabase {

    private Database database = null;

    @BeforeEach
    public void beforeEach(){
            database = new MySQLDatabase("bidsm","bidsm", "YMt8pXt$4ymr", "bisql01");
    }

    /**
     * Tests a regular opening of a database connection
     */
    @Test
    public void testOpenConnection01(){
        database.openConnection();
        assertTrue(database.isConnectionOpen());
    }

    /**
     * Tests that a database stays unchanged and working when openConnection is called on an already opened database
     */
    @Test
    public void testOpenConncetion02(){
        database.openConnection();
        database.openConnection();
        assertTrue(database.isConnectionOpen());
    }

    /**
     * Test a regular closing of a database connection
     */
    @Test
    public void testCloseConnection01(){
        database.openConnection();
        assertTrue(database.isConnectionOpen());
        database.closeConnection();
        assertFalse(database.isConnectionOpen());
    }

    /**
     * Testing that the program handles closing an already closed connection without crashing.
     */
    @Test
    public void testCloseConnection02(){
        database.openConnection();
        assertTrue(database.isConnectionOpen());
        database.closeConnection();
        database.closeConnection();
        assertFalse(database.isConnectionOpen());
    }
}