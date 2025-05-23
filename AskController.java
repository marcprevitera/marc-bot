
package com.example.marcbot;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.*;

@RestController
public class AskController {

    private final Map<String, Object> resumeData;

    public AskController() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        resumeData = mapper.readValue(new File("resume.json"), Map.class);
    }

    @PostMapping(value = "/ask", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> ask(@RequestBody Map<String, String> payload) {
        String question = payload.getOrDefault("question", "").toLowerCase();
        String answer = findAnswer(question);
        return ResponseEntity.ok(Collections.singletonMap("answer", answer));
    }

    private String findAnswer(String question) {
        if (question.contains("current role") || question.contains("what does marc do")) {
            return (String) resumeData.getOrDefault("profile_summary", "No profile summary available.");
        } else if (question.contains("skills")) {
            List<String> skills = (List<String>) resumeData.get("skills");
            return skills != null ? String.join(", ", skills) : "No skills listed.";
        } else if (question.contains("certification")) {
            List<String> certs = (List<String>) resumeData.get("certifications");
            return certs != null ? String.join(", ", certs) : "No certifications listed.";
        } else if (question.contains("award")) {
            List<String> awards = (List<String>) resumeData.get("awards");
            return awards != null ? String.join(", ", awards) : "No awards listed.";
        } else if (question.contains("experience") || question.contains("career")) {
            List<Map<String, String>> history = (List<Map<String, String>>) resumeData.get("career_history");
            if (history != null) {
                StringBuilder sb = new StringBuilder();
                for (Map<String, String> job : history) {
                    sb.append(job.get("role")).append(" at ").append(job.get("company")).append(": ")
                      .append(job.get("description")).append("\n");
                }
                return sb.toString();
            } else {
                return "No career history available.";
            }
        }
        return "I'm sorry, I don't have an answer for that question.";
    }
}
