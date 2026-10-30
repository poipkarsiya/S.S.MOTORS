
package com.garage.garagemanagementsystem.entity;

import java.util.List;

public class DiagnosisResult {

    private String summary;
    private String urgency;
    private List<String> possibleCauses;
    private List<String> recommendedActions;
    private String safetyAdvice;

    public DiagnosisResult() {
    }

    public DiagnosisResult(
            String summary,
            String urgency,
            List<String> possibleCauses,
            List<String> recommendedActions,
            String safetyAdvice) {
        this.summary = summary;
        this.urgency = urgency;
        this.possibleCauses = possibleCauses;
        this.recommendedActions = recommendedActions;
        this.safetyAdvice = safetyAdvice;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public List<String> getPossibleCauses() {
        return possibleCauses;
    }

    public void setPossibleCauses(List<String> possibleCauses) {
        this.possibleCauses = possibleCauses;
    }

    public List<String> getRecommendedActions() {
        return recommendedActions;
    }

    public void setRecommendedActions(List<String> recommendedActions) {
        this.recommendedActions = recommendedActions;
    }

    public String getSafetyAdvice() {
        return safetyAdvice;
    }

    public void setSafetyAdvice(String safetyAdvice) {
        this.safetyAdvice = safetyAdvice;
    }
}
