package org.igorr.quickstarts.helloworld.web.restful;

import javax.servlet.http.HttpServletRequest;

public class BasicRestService {
    public static final String LDAP_USED_PARAMETER = "ldapUsed";
    protected Boolean getUserFromRequest(HttpServletRequest request) {
        return (Boolean) request.getSession().getAttribute(LDAP_USED_PARAMETER);
    }
}
