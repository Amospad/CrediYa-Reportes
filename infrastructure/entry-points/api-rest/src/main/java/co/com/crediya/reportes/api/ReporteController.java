package co.com.crediya.reportes.api;

import co.com.crediya.reportes.model.reporte.Reporte;
import co.com.crediya.reportes.usecase.reporte.ReporteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/reportes")
@RequiredArgsConstructor
public class ReporteController {

    private final ReporteUseCase reporteUseCase;

    @GetMapping("/{metrica}")
    public ResponseEntity<Reporte> obtenerReporte(@PathVariable(name = "metrica") String metrica) {
        Reporte reporte = reporteUseCase.obtenerReporte(metrica);
        if (reporte == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reporte);
    }

    // Endpoint simulando la llegada de un mensaje de SQS
    @PostMapping("/simular-sqs")
    public ResponseEntity<String> simularMensajeSQS(@RequestBody Map<String, Object> mensaje) {
        BigDecimal monto = new BigDecimal(mensaje.get("monto").toString());
        reporteUseCase.procesarSolicitudAprobada(monto);
        return ResponseEntity.ok("✅ Mensaje procesado correctamente");
    }
}