package tony.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tony.demo.service.ReportingService;

@RestController
@RequestMapping("/report")
public class ReportController
{
    private final ReportingService reportService;

    @Autowired
    public ReportController(ReportingService ReportService) {
        this.reportService = ReportService;
    }

    @GetMapping("/name/{id}")
    public String showReportName(@PathVariable Long id) {
        String name = reportService.getReportName(id);
        return "Report name is " + name + "!";
    }

    @PostMapping("/echo")
    public String echoMessage(@RequestBody String message) {
        return "You sent: " + message;
    }


}
