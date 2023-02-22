package com.appforworkwithdbwithprst.feature.data;

import java.time.LocalDate;

public class Project {
    private int clientId;
    private LocalDate startDate;
    private LocalDate finishDate;

    public Project(int clientId, String startDate, String finishDate) {
        this.clientId = clientId;
        this.startDate = LocalDate.parse(startDate);
        this.finishDate = LocalDate.parse(finishDate);
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    @Override
    public String toString() {
        return "Project{" +
                "clientId=" + clientId +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                '}';
    }
}
