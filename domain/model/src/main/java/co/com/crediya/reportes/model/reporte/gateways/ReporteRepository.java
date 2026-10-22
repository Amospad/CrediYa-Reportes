package co.com.crediya.reportes.model.reporte.gateways;

import co.com.crediya.reportes.model.reporte.Reporte;
import java.math.BigDecimal;

public interface ReporteRepository {
    void incrementarAprobados(BigDecimal monto);
    Reporte obtenerReporte(String metrica);
}