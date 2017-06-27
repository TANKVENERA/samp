package belski.service;

import belski.repository.model.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Администратор on 27.06.2017.
 */
public class UserFileService {

    public List<User> readUserFile(String filename) {
        List<User> users = new ArrayList<User>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            String[] titels = bufferedReader.readLine().split("\\|");
            users.add(new User(titels[0], titels[1], titels[2], titels[3]));
            while (bufferedReader.ready()) {
                User user = new User();
                String[] line = bufferedReader.readLine().split(",");
                for (int i = 0; i < titels.length; i++) {
                    if (titels[i].equalsIgnoreCase("Password")) {
                        user.setPassword(line[i]);
                    } else if (titels[i].equalsIgnoreCase("Login")) {
                        user.setLogin(line[i]);
                    } else if (titels[i].equalsIgnoreCase("Name")) {
                        user.setName(line[i]);
                    } else {
                        user.setRole(line[i]);
                    }
                }
                users.add(user);
            }

        } catch (Exception e) {
            System.out.println("ошибка");
        }


        return users;
    }

    public static void main(String[] args) {
        List<User> users = new UserFileService().readUserFile(".\\web\\src\\main\\resources\\users.txt");
        System.out.println(users.get(0).toString());
    }
}
