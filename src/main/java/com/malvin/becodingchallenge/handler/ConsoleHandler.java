package com.malvin.becodingchallenge.handler;

import com.malvin.becodingchallenge.service.FileParserService;
import com.malvin.becodingchallenge.service.OutputFormatterService;
import com.malvin.becodingchallenge.service.ResultsInterpreterService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsoleHandler{
    private final FileParserService fileParserService;
    private final ResultsInterpreterService resultsInterpreterService;
    private final OutputFormatterService outputFormatterService;

    public ConsoleHandler(FileParserService fileParserService, ResultsInterpreterService resultsInterpreterService,
                          OutputFormatterService outputFormatterService) {
        this.fileParserService = fileParserService;
        this.resultsInterpreterService = resultsInterpreterService;
        this.outputFormatterService = outputFormatterService;
    }

    public String handle(String source) {
        List<String> resultList = fileParserService.readResultsFromFileToAList(source);
        resultList.forEach(resultsInterpreterService::allocateWinLossOrDrawToTeams);
        return outputFormatterService.createOutputTable();
    }
}
