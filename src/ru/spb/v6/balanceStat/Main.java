package ru.spb.v6.balanceStat;

import java.io.BufferedReader;
import ru.spb.v6.balanceStat.actions.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import ru.spb.v6.balanceStat.consoleInterface.CLI;
import ru.spb.v6.balanceStat.models.CommandsCLI;

public class Main extends CLI<CommandsCLI> {

    private String site;
    private String login;
    private String type;
    private String description;
    private String password;

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //конструтор главного класса
    Main() {
        super(CommandsCLI.class);
    }

    public static void main(String[] args) throws SQLException, IOException {
        //считываем параметры
        String start = null;
        for (String str : args) {
            start = str;
        }
        //делаем проверку на ввод параметра
        if (start !=null && start.contains("doreport")) {   //если приложение запущенно с параметром doreport, то запускаем создание отчета
            DoReport report = new DoReport();
            {
                try {
                    report.doReport();  //запускаем работу
                    new Main().close(); //закрываем программу
                } catch (SQLException ex) {
                    System.out.println("Не удалось создать отчет");
                    ex.printStackTrace();
                }
            }
        } else {                //иначе
            new Main().run();  //запуск приложения с консольным интерфейсом
        }
    }

    @Override
    protected void onCommand(CommandsCLI command) throws IOException {

        switch (command) {
            case doreport:             //создаем отчет
                DoReport report = new DoReport(); //создаем класс
                 {
                    try {
                        report.doReport();  //запускаем работу
                        close();
                    } catch (SQLException ex) {
                        System.out.println("Не удалось создать отчет");
                        ex.printStackTrace();
                    }
                }

                break;
            case addsupplier:  //добавляем новый договор

                System.out.println("введите тип поставщика");
                type = reader.readLine();
                System.out.println("введите логин");
                login = reader.readLine();
                System.out.println("введите пароль");
                password = reader.readLine();
                System.out.println("введите сайт");
                site = reader.readLine();
                System.out.println("введите описание");
                description = reader.readLine();
                ConfigureTable createSupplier = new ConfigureTable();
                 {
                    try {
                        createSupplier.createNewSupplier(type, login, password, site, description);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        System.out.println("Не удалось добавить договор");
                    }
                }

                break;
            case createtable:  //создаем таблицу если она не созданна

                ConfigureTable createTable = new ConfigureTable();
                 {
                    try {
                        createTable.createSuppliersTable();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        System.out.println("Не удалось создать таблицу, возможно она уже существует");
                    }
                }

                break;
            case showtable:    // показываем таблицу существующих договоров

                System.out.println("-------------------------------------------\n"
                        + "Существующие договора: \n");
                ConfigureTable showTable = new ConfigureTable();
                 {
                    try {
                        showTable.showTable();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        System.out.println("Не удалось отобразить таблицу, возможно она пуста");
                    }
                }
                break;
            case showlastreport:    // показываем таблицу существующих договоров

                System.out.println("-------------------------------------------\n"
                        + "Последний отчет: \n");
                ConfigureTable lastreport = new ConfigureTable();
                 {
                    try {
                        lastreport.showLastReport();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        System.out.println("Не удалось отобразить последний ");
                    }
                }
                break;

            case exit:
                close();
                break;

        }
    }
}
