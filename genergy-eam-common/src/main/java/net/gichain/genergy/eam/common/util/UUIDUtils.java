package net.gichain.genergy.eam.common.util;

import java.util.UUID;

public class UUIDUtils {
    public static String randomUUID() {
        UUID uuid = UUID.randomUUID();
        String suuid = uuid.toString();
        return suuid.replace("-", "");
    }
}
