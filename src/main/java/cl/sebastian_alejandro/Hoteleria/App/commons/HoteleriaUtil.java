package cl.sebastian_alejandro.Hoteleria.App.commons;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class HoteleriaUtil {
    public static BigDecimal calcularValorReserva(String valorDia, Date fechaInicio, Date fechaTermino) {

        System.out.println(fechaInicio);
        System.out.println(fechaTermino);
        LocalDateTime ldtFechaInicio = fechaInicio.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        LocalDateTime ldtFechaTermino = fechaTermino.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        long diferencia = ChronoUnit.MINUTES.between(ldtFechaInicio, ldtFechaTermino);
        int cantMediasHoras = (int) (diferencia / 30);
        BigDecimal valor = new BigDecimal(valorDia);
        valor = valor.divide(new BigDecimal(48), 6, RoundingMode.FLOOR);
        valor = valor.multiply(new BigDecimal(cantMediasHoras));
        return valor.round(new MathContext(2));
    }
}
