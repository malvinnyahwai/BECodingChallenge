package com.malvin.becodingchallenge.service;

import com.malvin.becodingchallenge.service.impl.FileParserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FileParserServiceTest {

    @Mock
    FileReaderService fileReaderService;

    @DisplayName("Reading results from file test")
    @Test
    void readResultsFromFileTest() throws IOException {
        FileParserService fileParserService = new FileParserServiceImpl(fileReaderService);
        String source = "full/path/to/file";
        List<String> resultList = new ArrayList<>(Arrays.asList(
                "Lions 3, Snakes 3",
                "Tarantulas 1, FC Awesome 0",
                "Lions 1, FC Awesome 1",
                "Tarantulas 3, Snakes 1",
                "Lions 4, Grouches 0"
        ));
        when(fileReaderService.readInput(source)).thenReturn(resultList);
        assertEquals(resultList, fileParserService.readResultsFromFileToAList(source), "resultList does not match");
    }
}
