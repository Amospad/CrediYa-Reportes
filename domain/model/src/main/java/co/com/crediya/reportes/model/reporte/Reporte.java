package co.com.crediya.reportes.model.reporte;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reporte {
    private String metrica; // "aprobados" o "monto_total"
    private BigDecimal valor;
}