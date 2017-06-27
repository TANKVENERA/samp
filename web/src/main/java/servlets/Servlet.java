package servlets;

import belski.repository.model.User;
import belski.service.UserFileService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Администратор on 27.06.2017.
 */
public class Servlet extends HttpServlet {
    UserFileService userFileService = new UserFileService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        List<User> users = userFileService.readUserFile(".\\web\\src\\main\\resources\\users.txt");
        for (User user : users) {
            writer.println("<h1><p align=\"center\">" + user.getPassword() + " " + user.getLogin() + " " + user.getName() + " " +
                    user.getRole() + "</p></h1>");
        }
        writer.println("<p align=\"center\" ><img  src = \"https://s00.yaplakal.com/pics/pics_original/2/0/9/9929902.jpg\" alt=\"альтернативный текст\" ></p>");
       // writer.print("<p align=\"center\" ><img  src = \"eee/111.jpg\" alt=\"альтернативный текст\"></p>");
       writer.flush();
        writer.close();

    }
}
