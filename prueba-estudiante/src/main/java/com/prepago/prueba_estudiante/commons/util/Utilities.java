package com.prepago.prueba_estudiante.commons.util;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Utilities {
    private Utilities() {
    }

    public static String getTimestampValue() {
        var zoneIdCo = ZoneId.of("America/Bogota");
        var now = ZonedDateTime.now(zoneIdCo);
        var dtf = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

        return now.truncatedTo(ChronoUnit.MILLIS).format(dtf);
    }
}
