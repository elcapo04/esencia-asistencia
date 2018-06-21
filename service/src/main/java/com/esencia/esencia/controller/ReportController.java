package com.esencia.esencia.controller;





import com.esencia.esencia.dto.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/report")
public class ReportController {
    List<Entity> entityList = new ArrayList<>();

    @Autowired
    private EntityManager entityManager;

    @RequestMapping(path="Attendance",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Entity>> getAttendanceReport(){

        String jrxmlFileName = "C:/reports/Leaf_Grey.jrxml";
        String jasperFileName = "C:/reports/Leaf_Grey.jasper";
        String pdfFileName = "C:/reports/C1_report.pdf";
        try {
            JasperCompileManager.compileReportToFile(jrxmlFileName, jasperFileName);
        } catch (JRException e) {
            e.printStackTrace();
        }


        // Load the JDBC driver
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5433/esenciadb?user=postgres&password=intel1234";
            Connection conn = DriverManager.getConnection(url);




        // Create arguments
        // Map params = new HashMap()
        HashMap hm = new HashMap();
        hm.put("ID", "123");
        hm.put("DATENAME", "April 2006");

        // Generate jasper print
        JasperPrint jprint = (JasperPrint) JasperFillManager.fillReport(jasperFileName, hm, conn);

        // Export pdf file
        JasperExportManager.exportReportToPdfFile(jprint, pdfFileName);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JRException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        entityList.add(new Entity(false, 1, "Test 1"));
        Todo todo = new Todo(entityList);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Access-Control-Allow-Origin", "http://localhost:4200");
        return new ResponseEntity<>(entityList, HttpStatus.OK);


    }

    @Transactional
    @RequestMapping(path="Attendance",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Entity>> postAttendanceReport(@RequestBody final String request){



        Person person = new Gson().fromJson(request, Person.class);


        entityManager.persist(person);


        return new ResponseEntity<>(entityList, HttpStatus.OK);
    }
    public class Todo {
        public Todo(final List<Entity> todos) {
            this.todos = todos;
        }

        public List<Entity> getTodos() {
            return todos;
        }

        public void setTodos(final List<Entity> todos) {
            this.todos = todos;
        }


        private  List<Entity> todos;
    }
    public class Entity {
        private boolean complete;
        private int id;

        public Entity(final boolean complete, final int id, final String title) {
            this.complete = complete;
            this.id = id;
            this.title = title;
        }

        public boolean isComplete() {
            return complete;
        }

        public void setComplete(final boolean complete) {
            this.complete = complete;
        }

        public int getId() {
            return id;
        }

        public void setId(final int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(final String title) {
            this.title = title;
        }

        private String title;

    }
}
