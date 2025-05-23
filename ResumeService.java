
package com.example.marcbot;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Map;

@Service
public class ResumeService {

    private final Map<String, Object> resumeData;

    public ResumeService() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        resumeData = mapper.readValue(new File("resume.json"), Map.class);
    }

    public String getProfileSummary() {
        return (String) resumeData.getOrDefault("profile_summary", "No profile summary available.");
    }

    public List<String> getSkills() {
        return (List<String>) resumeData.getOrDefault("skills", List.of("No skills listed."));
    }

    public List<String> getCertifications() {
        return (List<String>) resumeData.getOrDefault("certifications", List.of("No certifications listed."));
    }

    public List<String> getAwards() {
        return (List<String>) resumeData.getOrDefault("awards", List.of("No awards listed."));
    }

    public List<Map<String, String>> getCareerHistory() {
        return (List<Map<String, String>>) resumeData.getOrDefault("career_history", List.of(Map.of("No career history available.", "")));
    }
}
