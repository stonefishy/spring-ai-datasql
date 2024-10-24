package spring.ai.datasql.service;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class PromptService {

    @Value("classpath:prompts.txt")
    private org.springframework.core.io.Resource resource;

    private String fileContent;

    @PostConstruct
    public void init() throws IOException {
        fileContent = new String(Files.readAllBytes(Paths.get(resource.getURI())));
    }

    public String getContent() {
        return fileContent;
    }
}

