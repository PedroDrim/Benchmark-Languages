package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Table {

    private String fileName;
    private List<UserInfo> userInfoList;

    public Table(String fileName) throws IOException {
        this.fileName = fileName;
        this.userInfoList = this.deserializeFile(this.fileName);
    }

    public String getFileName() {
        return fileName;
    }

    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }

    private List<UserInfo> deserializeFile(String fileName) throws IOException {

        List<UserInfo> list = new ArrayList<>();

        Reader reader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(reader);
        bufferedReader.readLine();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] values = line.split(",");

            String user = values[0].trim();
            String password = values[1].trim();
            double credit = Double.valueOf(values[2].trim());

            UserInfo userInfo = new UserInfo(user, password, credit);
            list.add(userInfo);
        }

        bufferedReader.close();
        reader.close();

        return list;
    }
}
