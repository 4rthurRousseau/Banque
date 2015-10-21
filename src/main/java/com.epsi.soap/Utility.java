package com.epsi.soap;

import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.util.List;
import java.util.Map;

public class Utility {
    public static String[] RetrieveCredentials(WebServiceContext context) {
        MessageContext message = context.getMessageContext();

        Map http_headers = (Map) message.get(MessageContext.HTTP_REQUEST_HEADERS);
        List userList = (List) http_headers.get(Constante.FIELD_USERNAME);
        List passList = (List) http_headers.get(Constante.FIELD_PASSWORD);

        String login = "";
        String password = "";

        if (userList != null) {
            login = userList.get(0).toString();
        }

        if (passList != null) {
            password = userList.get(0).toString();
        }

        return new String[] { login, password };
    }
}
