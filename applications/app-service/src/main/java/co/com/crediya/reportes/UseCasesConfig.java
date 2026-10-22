package co.com.crediya.reportes;

import co.com.crediya.reportes.model.reporte.gateways.ReporteRepository;
import co.com.crediya.reportes.usecase.reporte.ReporteUseCase;
import co.com.crediya.reportes.usecase.reporte.ReporteUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesConfig {

    @Bean
    public ReporteUseCase reporteUseCase(ReporteRepository reporteRepository) {
        return new ReporteUseCaseImpl(reporteRepository);
    }
}