package spring.ai.datasql.controller;

import org.springframework.ai.bedrock.anthropic3.BedrockAnthropic3ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.ai.datasql.service.PromptService;

import java.io.IOException;
import java.util.Map;

@RestController
public class SQLGenController {
    private final BedrockAnthropic3ChatModel chatModel;

    @Autowired
    private PromptService prompts;

    @Autowired
    public SQLGenController(BedrockAnthropic3ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @PostMapping("/ai/sql")
    public Map generate(@RequestBody String message) throws IOException {
        String newMsg = prompts.getContent() + message;
        return Map.of("sql", chatModel.call(newMsg));
    }
}
