package org.naby.common;

import org.naby.common.exception.RecordNotExistException;
import org.naby.common.exception.WrongNameException;
import org.naby.common.exception.WrongPhoneException;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ErrorHandler {
    private ErrorHandler() {
    }

    public static Map getError(Exception e) {
        Map<String, String> map = new HashMap<>();
        e.printStackTrace();
        if (e instanceof ArithmeticException) {
            map.put("CODE", "101");
            map.put("MSG", "Arithmetic Error");
            return map;
        } else if (e instanceof SQLException) {
            map.put("CODE", "102");
            map.put("MSG", "DataBase Error");
            return map;
        } else if (e instanceof RecordNotExistException) {
            map.put("CODE", "103");
            map.put("MSG", "Not Found Error");
            return map;
        } else if (e instanceof WrongNameException) {
            map.put("CODE", "104");
            map.put("MSG", "Name Error");
            return map;
        } else if (e instanceof WrongPhoneException) {
            map.put("CODE", "105");
            map.put("MSG", "Phone Error");
            return map;
        } else {
            map.put("CODE", "200");
            map.put("MSG", "Call Support");
            return map;
        }
    }
}
