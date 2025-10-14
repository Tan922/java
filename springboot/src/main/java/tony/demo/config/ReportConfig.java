package tony.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import tony.demo.model.Report;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "app")
public class ReportConfig {

    private List<Report> reports;

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
}
