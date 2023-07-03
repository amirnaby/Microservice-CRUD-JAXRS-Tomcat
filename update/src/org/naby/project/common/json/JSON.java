package org.naby.project.common.json;

import org.codehaus.jackson.map.ObjectMapper;

public class JSON {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private JSON() {
    }

    public static String get(Object o) throws Exception {
        return OBJECT_MAPPER.writeValueAsString(o);
    }

    public static <T> T map(String json, Class<T> target) throws Exception {
        return OBJECT_MAPPER.readValue(json, target);
    }
}
