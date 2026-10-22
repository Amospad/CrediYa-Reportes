package co.com.crediya.reportes.usecase.reporte;

import co.com.crediya.reportes.model.reporte.Reporte;
import java.math.BigDecimal;

public interface ReporteUseCase {
    void procesarSolicitudAprobada(BigDecimal monto);
    Reporte obtenerReporte(String metrica);
}