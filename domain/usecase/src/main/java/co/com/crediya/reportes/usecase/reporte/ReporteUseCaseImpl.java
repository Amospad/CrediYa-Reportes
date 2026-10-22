package co.com.crediya.reportes.usecase.reporte;

import co.com.crediya.reportes.model.reporte.Reporte;
import co.com.crediya.reportes.model.reporte.gateways.ReporteRepository;

import java.math.BigDecimal;

public class ReporteUseCaseImpl implements ReporteUseCase {

    private final ReporteRepository reporteRepository;

    public ReporteUseCaseImpl(ReporteRepository reporteRepository) {
        this.reporteRepository = reporteRepository;
    }

    @Override
    public void procesarSolicitudAprobada(BigDecimal monto) {
        // Incrementar el contador y el monto total
        reporteRepository.incrementarAprobados(monto);
    }

    @Override
    public Reporte obtenerReporte(String metrica) {
        return reporteRepository.obtenerReporte(metrica);
    }
}