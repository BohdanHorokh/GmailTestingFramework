package com.epam.lab.util;

import com.epam.lab.model.Message;
import com.epam.lab.model.Messages;
import com.epam.lab.model.User;
import com.epam.lab.model.Users;
import com.sun.jmx.remote.internal.Unmarshal;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class DataUtils {
    public static List<User> readUsersData(String pathToXml) throws JAXBException {
        File file = new File(pathToXml);
        JAXBContext context = JAXBContext.newInstance(Users.class);
        Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
        Users users = (Users) jaxbUnmarshaller.unmarshal(file);
        List<User> userList = users.getUsers();
        return userList;
    }

    public static List<Message> readMessagesData(String pathToXml) throws JAXBException {
        File file = new File(pathToXml);
        JAXBContext context = JAXBContext.newInstance(Messages.class);
        Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
        Messages messages = (Messages) jaxbUnmarshaller.unmarshal(file);
        List<Message> messagesList = messages.getMessages();
        return messagesList;
    }

    public static List<Message> readDataFromXLSXFile(String pathToXLSXFile) throws IOException, InvalidFormatException {
        List<Message> messages = new ArrayList<>();
        File excelFile = new File(pathToXLSXFile);
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet datatypeSheet = workbook.getSheetAt(0);

        Iterator<Row> iterator = datatypeSheet.iterator();

        while (iterator.hasNext()) {

            Row currentRow = iterator.next();
            Message message = new Message();
            message.setTo(currentRow.getCell(0).toString());
            message.setSubject(currentRow.getCell(1).toString());
            message.setText(currentRow.getCell(2).toString());

            messages.add(message);
        }
        return messages.stream().filter(message -> !message.getTo().contains("to")).collect(Collectors.toList());
    }

    public static List<User> readDataFromCSVFile(String pathToCSV) throws IOException {
        List<User> users = new ArrayList<>();
        Reader in = new FileReader(pathToCSV);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader().parse(in);
        for (CSVRecord record : records) {
            String email = record.get("Email");
            String password = record.get("Password");
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            users.add(user);
        }
        return users;
    }


}
