package co.com.crediya.reportes.scheduler;

import co.com.crediya.reportes.model.reporte.Reporte;
import co.com.crediya.reportes.usecase.reporte.ReporteUseCase;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ReporteScheduler {

    private final ReporteUseCase reporteUseCase;

    public ReporteScheduler(ReporteUseCase reporteUseCase) {
        this.reporteUseCase = reporteUseCase;
    }

    // initialDelay = 5000 ms (5 segundos) para que no falle al arrancar
    @Scheduled(cron = "", initialDelay = 5000)
    public void enviarReporteDiario() {
        try {
            System.out.println("⏰ [Scheduler] Iniciando envío de reporte diario...");

            Reporte aprobados = reporteUseCase.obtenerReporte("aprobados");
            Reporte montoTotal = reporteUseCase.obtenerReporte("monto_total");

            String cuerpo = "📊 Reporte de rendimiento diario de CrediYa:\n\n" +
                    "✅ Total préstamos aprobados: " + (aprobados != null ? aprobados.getValor() : BigDecimal.ZERO) + "\n" +
                    "💰 Monto total prestado: $" + (montoTotal != null ? montoTotal.getValor() : BigDecimal.ZERO) + "\n\n" +
                    "Este es un correo automático generado a las 8 PM.";

            System.out.println("📧 --- SIMULACIÓN DEL CORREO ---");
            System.out.println("Para: admin@crediya.com");
            System.out.println("Asunto: Reporte Diario CrediYa");
            System.out.println(cuerpo);
            System.out.println("--------------------------------");

        } catch (Exception e) {
            System.err.println("❌ [Scheduler] Error al generar el reporte: " + e.getMessage());
        }
    }
}