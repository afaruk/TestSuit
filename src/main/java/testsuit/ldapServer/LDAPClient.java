package testsuit.ldapServer;

import com.unboundid.ldap.sdk.*;
import com.unboundid.ldap.sdk.migrate.ldapjdk.LDAPAttribute;
import com.unboundid.ldap.sdk.migrate.ldapjdk.LDAPAttributeSet;
import com.unboundid.ldap.sdk.migrate.ldapjdk.LDAPEntry;
import com.unboundid.ldif.LDIFException;

import java.util.stream.IntStream;


public class LDAPClient {

    public static void main(String[] args) throws LDAPException, LDIFException {

        LDAPConnection ldapConnection = new LDAPConnection("0.0.0.0", 10389);
        ldapConnection.bind("cn=ahmet faruk yazi,ou=Users,dc=example,dc=com", "12345");
        SearchResultEntry entry = ldapConnection.getEntry("cn=ahmet,ou=Users,dc=example,dc=com");

        addEntry(ldapConnection);

        entry.getAttributes();
    }

    private static void addEntry(LDAPConnection connection) throws LDIFException, LDAPException {
        LDAPAttributeSet attributeSet = new LDAPAttributeSet();

        attributeSet.add(
                new LDAPAttribute("objectClass", new String[] { "top", "organizationalUnit" }));
        attributeSet.add(new LDAPAttribute("ou", "Users"));

        IntStream.range(0, 20).forEach(index -> {
            try {
                connection.add(
                        "dn: cn=testuser"+ index +",ou=Users,dc=example,dc=com",
                        "objectClass: inetOrgPerson",
                        "objectClass: organizationalPerson",
                        "objectClass: person",
                        "objectClass: top",
                        "cn: testuser"+ index,
                        "sn: testuser"+ index,
                        "userPassword: 12345");
            } catch (LDIFException e) {
                e.printStackTrace();
            } catch (LDAPException e) {
                e.printStackTrace();
            }
        });
    }
}
