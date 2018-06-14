package Server.Database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMySQLDatabase {

    private Database database = null;

    @BeforeEach
    public void beforeEach(){
            database = new MySQLDatabase("bidsm","bidsm", "YMt8pXt$4ymr", "bisql01");
    }

    @Test
    public void testOpenConnection01(){
        database.openConnection();
        assertTrue(database.isConnectionOpen());
    }
}
