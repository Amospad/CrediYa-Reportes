package co.com.crediya.reportes.infra;

import co.com.crediya.reportes.model.reporte.Reporte;
import co.com.crediya.reportes.model.reporte.gateways.ReporteRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class ReporteInMemoryRepository implements ReporteRepository {

    private long contadorAprobados = 0;
    private BigDecimal montoTotal = BigDecimal.ZERO;

    @Override
    public synchronized void incrementarAprobados(BigDecimal monto) {
        this.contadorAprobados++;
        this.montoTotal = this.montoTotal.add(monto);
        System.out.println("📊 [Reporte] Préstamo aprobado. Total aprobados: " + contadorAprobados + ", Monto total: " + montoTotal);
    }

    @Override
    public Reporte obtenerReporte(String metrica) {
        if ("aprobados".equalsIgnoreCase(metrica)) {
            return Reporte.builder().metrica("aprobados").valor(BigDecimal.valueOf(contadorAprobados)).build();
        } else if ("monto_total".equalsIgnoreCase(metrica)) {
            return Reporte.builder().metrica("monto_total").valor(montoTotal).build();
        }
        return null;
    }
}