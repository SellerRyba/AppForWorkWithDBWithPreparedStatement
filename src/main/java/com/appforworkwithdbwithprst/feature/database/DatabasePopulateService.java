package com.appforworkwithdbwithprst.feature.database;

import com.appforworkwithdbwithprst.feature.addData.AddData;
import com.appforworkwithdbwithprst.feature.data.Client;
import com.appforworkwithdbwithprst.feature.data.Project;
import com.appforworkwithdbwithprst.feature.data.ProjectWorker;
import com.appforworkwithdbwithprst.feature.data.Worker;
import com.appforworkwithdbwithprst.feature.prefs.Prefs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabasePopulateService {
    private final Database database;
    private final PreparedStatement insertToClient;
    private final PreparedStatement insertToProject;
    private final PreparedStatement insertToProjectWorker;
    private final PreparedStatement insertToWorker;

    public static void main(String[] args) {
        DatabasePopulateService databasePopulateService = new DatabasePopulateService(Database.getInstance());
        databasePopulateService.setInsertToProjectWorker(new AddData().projectWorkers());
        Database.getInstance().close();
    }

    public DatabasePopulateService(Database database) {
        this.database = database;
        Connection connection = database.getConnection();
        try {
            this.insertToClient = connection.
                    prepareStatement("INSERT INTO client (NAME) VALUES (?)");
            this.insertToProject = connection.
                    prepareStatement("INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE) VALUES (?, ?, ?)");
            this.insertToProjectWorker = connection.
                    prepareStatement("INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (?, ?)");
            this.insertToWorker = connection.
                    prepareStatement("INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY) VALUES (?, ?, ?, ?)");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void setInsertToClient(List<Client> clients){
        try{
            for (Client client: clients) {
                insertToClient.setString(1, client.getName());
                insertToClient.addBatch();
            }
            insertToClient.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void setInsertToProject(List<Project> projects){
        try {
            for (Project project: projects) {
                insertToProject.setInt(1, project.getClientId());
                insertToProject.setObject(2, project.getStartDate());
                insertToProject.setObject(3, project.getFinishDate());
                insertToProject.addBatch();
            }
            insertToProject.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void setInsertToProjectWorker(List<ProjectWorker> projectWorkers){
        try {
            for (ProjectWorker projectWorker: projectWorkers) {
                insertToProjectWorker.setInt(1, projectWorker.getProjectId());
                insertToProjectWorker.setInt(2, projectWorker.getWorkerId());
                insertToProjectWorker.addBatch();
            }
            insertToProjectWorker.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void setInsertToWorker(List<Worker> workers){
        try {
            for (Worker worker: workers) {
                insertToWorker.setString(1, worker.getName());
                insertToWorker.setObject(2, worker.getBirthday());
                insertToWorker.setString(3, worker.getLevel());
                insertToWorker.setInt(4, worker.getSalary());
                insertToWorker.addBatch();
            }
            insertToWorker.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

