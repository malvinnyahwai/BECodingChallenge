package com.malvin.becodingchallenge.service.impl;

import com.malvin.becodingchallenge.service.FileReaderService;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileReaderServiceImpl implements FileReaderService {

    @Override
    public List<String> readInput(String source) throws IOException {
        List<String> resultList = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(source))) {
            String result;
            while((result = bufferedReader.readLine()) != null) {
                resultList.add(result);
            }
        }
        return resultList;
    }
}
