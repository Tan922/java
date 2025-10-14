package tony.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tony.demo.config.ReportConfig;
import tony.demo.model.Report;

import java.util.Objects;
import java.util.Optional;

@Service
public class ReportingService {

    @Autowired
    private ReportConfig config;

    public String getReportName(Long id) {

        Optional<Report> op = config.getReports().stream().filter(r -> Objects.equals(id, r.getId())).findAny();

        if (op.isPresent()) {
            return op.get().getName();
        }
        return "Report Not Found";
    }
}
