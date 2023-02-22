package com.appforworkwithdbwithprst.feature.addData;

import com.appforworkwithdbwithprst.feature.data.Client;
import com.appforworkwithdbwithprst.feature.data.Project;
import com.appforworkwithdbwithprst.feature.data.ProjectWorker;
import com.appforworkwithdbwithprst.feature.data.Worker;

import java.util.ArrayList;
import java.util.List;

public class AddData {

    public List<Client> clients() {
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("ABC Inc."));
        clients.add(new Client("XYZ Corporation"));
        clients.add(new Client("Acme Co."));
        clients.add(new Client("Delta Ltd."));
        clients.add(new Client("Global Corp."));

        return clients;
    }
    public List<Project> projects(){

         List<Project> projects = new ArrayList<>();

         projects.add(new Project(1,  "2021-01-01", "2021-06-30"));
         projects.add(new Project(2, "2021-02-15", "2022-02-14"));
         projects.add(new Project(3, "2021-04-01", "2021-09-30"));
         projects.add(new Project(4, "2021-05-15", "2022-05-14"));
         projects.add(new Project(5, "2021-07-01", "2021-12-31"));
         projects.add(new Project(1, "2021-08-15", "2022-08-14"));
         projects.add(new Project(2, "2021-10-01", "2022-03-31"));
         projects.add(new Project(3, "2021-11-15", "2022-11-14"));
         projects.add(new Project(4, "2022-01-01", "2022-06-30"));
         projects.add(new Project(5, "2022-03-15", "2023-03-14"));

         return projects;
    }
    public List<ProjectWorker> projectWorkers(){

        List<ProjectWorker> projectWorkers = new ArrayList<>();

        projectWorkers.add(new ProjectWorker(1, 1));
        projectWorkers.add(new ProjectWorker(1, 2));
        projectWorkers.add(new ProjectWorker(1, 3));
        projectWorkers.add(new ProjectWorker(2, 3));
        projectWorkers.add(new ProjectWorker(2, 4));
        projectWorkers.add(new ProjectWorker(3, 1));
        projectWorkers.add(new ProjectWorker(3, 5));
        projectWorkers.add(new ProjectWorker(3, 6));
        projectWorkers.add(new ProjectWorker(4, 2));
        projectWorkers.add(new ProjectWorker(4, 4));
        projectWorkers.add(new ProjectWorker(4, 7));
        projectWorkers.add(new ProjectWorker(4, 8));
        projectWorkers.add(new ProjectWorker(5, 3));
        projectWorkers.add(new ProjectWorker(5, 6));
        projectWorkers.add(new ProjectWorker(5, 9));
        projectWorkers.add(new ProjectWorker(6, 1));
        projectWorkers.add(new ProjectWorker(6, 2));
        projectWorkers.add(new ProjectWorker(6, 4));
        projectWorkers.add(new ProjectWorker(7, 5));
        projectWorkers.add(new ProjectWorker(7, 6));
        projectWorkers.add(new ProjectWorker(8, 7));
        projectWorkers.add(new ProjectWorker(8, 8));
        projectWorkers.add(new ProjectWorker(9, 3));
        projectWorkers.add(new ProjectWorker(9, 9));
        projectWorkers.add(new ProjectWorker(9, 10));
        projectWorkers.add(new ProjectWorker(10, 1));
        projectWorkers.add(new ProjectWorker(10, 2));
        projectWorkers.add(new ProjectWorker(10, 5));
        projectWorkers.add(new ProjectWorker(10, 7));
        projectWorkers.add(new ProjectWorker(10, 10));

        return projectWorkers;
    }
    public List<Worker> workers(){

        List<Worker> workers = new ArrayList<>();

        workers.add(new Worker("John Smith", "1990-05-20", "Trainee", 800));
        workers.add(new Worker("Mary Johnson", "1985-11-15", "Junior", 1200));
        workers.add(new Worker("Mark Brown", "1978-03-10", "Senior", 6000));
        workers.add(new Worker("Anna Lee", "1995-07-02", "Middle", 3000));
        workers.add(new Worker("David Kim", "1980-01-01", "Middle", 4000));
        workers.add(new Worker("Sarah Jones", "1993-09-05", "Trainee", 900));
        workers.add(new Worker("Robert Davis", "1992-04-25", "Senior", 7000));
        workers.add(new Worker("Emily Wilson", "1988-12-10", "Junior", 1500));
        workers.add(new Worker("James Anderson", "1982-06-15", "Middle", 3500));
        workers.add(new Worker("Jessica Taylor", "1991-02-28", "Junior", 1100));

        return workers;
    }
}
