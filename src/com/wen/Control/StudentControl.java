package com.wen.Control;

import com.wen.Entity.Student;
import com.wen.Repository.StudentRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/student")
public class StudentControl extends HttpServlet {
    StudentRepository repository = new StudentRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method == null) {
            method = "findAll";
        }
        switch (method) {
            case "findAll":
                List<Student> all = repository.findAll();
                req.setAttribute("list", all);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                break;
            case "deleteById":
                String idStr = req.getParameter("id");
                int id = Integer.parseInt(idStr);
                repository.deleteById(id);
                resp.sendRedirect("/student");
                break;
            case "findById":
                idStr = req.getParameter("id");
                id = Integer.parseInt(idStr);
                Student byId = repository.findById(id);
                req.setAttribute("student", byId);
                req.getRequestDispatcher("update.jsp").forward(req, resp);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method == null) {
            method = "add";
        }
        switch (method) {
            case "add":
                String name = req.getParameter("name");
                String score = req.getParameter("score");
                Double v = Double.parseDouble(score);
                repository.add(name, v);
                break;
            case "update":
                Integer id=Integer.parseInt(req.getParameter("id"));
                name = req.getParameter("name");
                score = req.getParameter("score");
                v = Double.parseDouble(score);
                repository.update(id,name,v);
        }
        resp.sendRedirect("/student");
    }

}
