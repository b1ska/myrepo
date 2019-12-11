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

        new Main().run(); //запуск приложения с консольным интерфейсом
        // DoReport report = new DoReport();
        //  report.doReport();   //тут будет запуск приложения с параметром для запуска по расписанию

    }

    @Override
    protected void onCommand(CommandsCLI command) throws IOException {

        switch (command) {
            case doreport:             //создаем отчет
                DoReport report = new DoReport(); //создаем класс
                 {
                    try {
                        report.doReport();  //запускаем работу
                    } catch (SQLException ex) {
                        System.out.println("Не удалось создать отчет");
                        ex.printStackTrace();
                    }
                }

                break;
            case addsuplier:  //добавляем новый договор

                System.out.println("введите типо поставщика");
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

            case exit:
                close();
                break;

        }
    }
}
