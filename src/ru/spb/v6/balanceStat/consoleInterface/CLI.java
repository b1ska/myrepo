package ru.spb.v6.balanceStat.consoleInterface;

import java.io.IOException;

/**
 * @param <E> тип данных, описывающий возможные команды. Дожен быть
 * перечислением
 */
public abstract class CLI<E extends Enum<E>> extends EnumReader<E> implements Runnable {

    private boolean exit;

    /**
     * Основной конструктор класса.
     *
     * @param cls описатель перечисления, которое отражает набор команд,
     * обрабатываемых интерфейсом
     */
    public CLI(Class<E> cls) {
        super(System.in, cls);
    }

    /**
     * Выполняет обработку следующей команды из потока.
     * <p>
     * Следующая команда, содержащаяся в потоке, связанном с текущим объектом,
     * передаётся на обрабтку в метод onCommand.
     */
    protected void processCommand() {
        try {
           
            System.out.print("Введите команду > ");
            onCommand(next());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Алгоритм обработки команд.
     */
    @Override
    public void run() {
         System.out.println("Доступные комманды: \n"
                    + "doreport       Запускает создание отчета\n"
                    + "addsuplier     Добавляет новый договор\n"
                    + "createtable    Создает новую талицу, если еще не созданна\n"
                    + "showtable      Показывает существующую таблицу договров\n"
                    + "showlastreport     Показывает последний отчет\n"
                    + "exit           Выход их программы\n");
        
        while (!exit) {
            processCommand();
        }
    }

    /**
     * Метод жизненного цикла класса.
     * <p>
     * Вызывается, когда от пользозвателя была получена следующая команда.
     *
     * @param command экземпляр перечисления E. Описывает пользовательскую
     * команду.
     * @throws java.io.IOException
     */
    protected void onCommand(E command) throws IOException {
    }

    @Override
    public void close() throws IOException {
        exit = true;
    }
}
