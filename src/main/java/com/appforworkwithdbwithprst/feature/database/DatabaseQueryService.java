package com.appforworkwithdbwithprst.feature.database;

import com.appforworkwithdbwithprst.feature.data.RequestForLongestProject;
import com.appforworkwithdbwithprst.feature.data.RequestForMaxProjectsClient;
import com.appforworkwithdbwithprst.feature.data.RequestForMaxSalaryWorker;
import com.appforworkwithdbwithprst.feature.data.RequestForYoungestEldestWorkers;
import com.appforworkwithdbwithprst.feature.prefs.Prefs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    private PreparedStatement statement;

    public List<RequestForLongestProject> findLongestProject() {
        List<RequestForLongestProject> projectList = new ArrayList<>();
        try {
            String findProject = new Prefs().getString(Prefs.FIND_LONGEST_PROJECT_FILE_PATH);

            String sql = String.join("\n",
                    Files.readAllLines(Paths.get(findProject))
            );
            statement = Database.getInstance().getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                projectList.add(new RequestForLongestProject(
                        resultSet.getString("name"),
                        resultSet.getInt("MONTH_COUNT")));
            }
            statement.close();
            System.out.println(projectList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return projectList;
    }

    public List<RequestForMaxProjectsClient> findMaxProjectsClient() {
        List<RequestForMaxProjectsClient> projectsClients = new ArrayList<>();
        try {
            String findClientProject = new Prefs().getString(Prefs.FIND_MAX_PROJECTS_CLIENT_FILE_PATH);

            String sql = String.join("\n",
                    Files.readAllLines(Paths.get(findClientProject))
            );
            statement = Database.getInstance().getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                projectsClients.add(new RequestForMaxProjectsClient(
                        resultSet.getString("name"),
                        resultSet.getInt("NUM_PROJECTS")));
            }
            statement.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return projectsClients;
    }

    public List<RequestForMaxSalaryWorker> findMaxSalaryWorker() {
        List<RequestForMaxSalaryWorker> salaryWorkers = new ArrayList<>();
        try {
            String findMaxSalary = new Prefs().getString(Prefs.FIND_MAX_SALARY_WORKER_FILE_PATH);

            String sql = String.join("\n",
                    Files.readAllLines(Paths.get(findMaxSalary))
            );
            statement = Database.getInstance().getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                salaryWorkers.add(new RequestForMaxSalaryWorker(
                        resultSet.getString("name"),
                        resultSet.getInt("salary")));
            }
            statement.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return salaryWorkers;
    }

    public List<RequestForYoungestEldestWorkers> findYoungestEldestWorkers() {
        List<RequestForYoungestEldestWorkers> eldestWorkers = new ArrayList<>();
        try {
            String youngestEldest = new Prefs().getString(Prefs.FIND_YOUNGEST_ELDEST_WORKERS_FILE_PATH);

            String sql = String.join("\n",
                    Files.readAllLines(Paths.get(youngestEldest))
            );
            statement = Database.getInstance().getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                eldestWorkers.add(new RequestForYoungestEldestWorkers(
                        resultSet.getString("type"),
                        resultSet.getString("name"),
                        LocalDate.parse(resultSet.getString("birthday"))
                ));
            }
            statement.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return eldestWorkers;
    }
}

