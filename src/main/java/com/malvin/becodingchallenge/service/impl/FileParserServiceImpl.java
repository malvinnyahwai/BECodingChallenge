package com.malvin.becodingchallenge.service.impl;

import com.malvin.becodingchallenge.service.FileParserService;
import com.malvin.becodingchallenge.service.FileReaderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileParserServiceImpl implements FileParserService {
    private final FileReaderService fileReaderService;

    public FileParserServiceImpl(FileReaderService fileReaderService) {
        this.fileReaderService = fileReaderService;
    }

    @Override
    public List<String> readResultsFromFileToAList(String source) {
        Logger logger = LoggerFactory.getLogger(FileParserServiceImpl.class);
        List<String> resultList = new ArrayList<>();
        try {
            Paths.get(source);
            resultList = fileReaderService.readInput(source);
        } catch (IOException ioException) {
            logger.error("Error reading file {}", ioException.getMessage());
        }
        return resultList;
    }

}
