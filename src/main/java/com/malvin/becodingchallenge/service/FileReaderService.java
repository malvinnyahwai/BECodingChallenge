package com.malvin.becodingchallenge.service;

import java.io.IOException;
import java.util.List;

public interface FileReaderService {
    List<String> readInput(String source) throws IOException;
}
