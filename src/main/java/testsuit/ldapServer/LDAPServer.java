package testsuit.ldapServer;

import com.unboundid.ldap.listener.InMemoryDirectoryServer;
import com.unboundid.ldap.listener.InMemoryDirectoryServerConfig;
import com.unboundid.ldap.sdk.BindResult;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.SearchResultEntry;

public class LDAPServer {

    public static void main(String[] args) throws LDAPException {

        // Create the configuration to use for the server.
        InMemoryDirectoryServerConfig config =
                new InMemoryDirectoryServerConfig("dc=example,dc=com");
        config.addAdditionalBindCredentials("cn=Directory Manager", "password");

// Create the directory server instance, populate it with data from the
// "test-data.ldif" file, and start listening for client connections.
        InMemoryDirectoryServer ds = new InMemoryDirectoryServer(config);
        ds.importFromLDIF(true, "src/main/resources/test-data.ldif");
        ds.startListening();

// Get a client connection to the server and use it to perform various
// operations.
        LDAPConnection conn = ds.getConnection();
        SearchResultEntry entry = conn.getEntry("dc=example,dc=com");

        LDAPConnection c = new LDAPConnection();
        c.connect("0.0.0.0", 389);
        BindResult result = c.bind("cn=Micha Kops,ou=Users,dc=example,dc=com", "abcdefg");

// Do more stuff here....

// Disconnect from the server and cause the server to shut down.
        conn.close();
        ds.shutDown(true);
    }
}
