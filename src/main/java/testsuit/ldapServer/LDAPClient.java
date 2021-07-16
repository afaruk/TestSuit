package testsuit.ldapServer;

import com.unboundid.ldap.sdk.*;
import com.unboundid.ldap.sdk.migrate.ldapjdk.LDAPAttribute;
import com.unboundid.ldap.sdk.migrate.ldapjdk.LDAPAttributeSet;
import com.unboundid.ldap.sdk.migrate.ldapjdk.LDAPEntry;
import com.unboundid.ldif.LDIFException;


public class LDAPClient {

    public static void main(String[] args) throws LDAPException, LDIFException {

        LDAPConnection ldapConnection = new LDAPConnection("0.0.0.0", 10389);
        ldapConnection.bind("uid=admin,ou=system", "secret");
        SearchResultEntry entry = ldapConnection.getEntry("uid=admin,ou=system");

        addEntry(ldapConnection);

        entry.getAttributes();
    }

    private static void addEntry(LDAPConnection connection) throws LDIFException, LDAPException {
        LDAPAttributeSet attributeSet = new LDAPAttributeSet();

        attributeSet.add(
                new LDAPAttribute("objectClass", new String[] { "top", "organizationalUnit" }));
        attributeSet.add(new LDAPAttribute("ou", "Users"));

        connection.add(
                "dn: ou=Users,dc=example,dc=com",
                "objectClass: organizationalUnit",
                "objectClass: top",
                "ou: Users");
    }
}
