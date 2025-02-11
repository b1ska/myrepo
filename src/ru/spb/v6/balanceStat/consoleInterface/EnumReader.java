package ru.spb.v6.balanceStat.consoleInterface;

import java.io.*;

/**
 * Модель потокового объекта, позволяющего читать из преданного потока
 * экземпляры перечисления, описанного типом Е.
 *
 * @param <E>
 */
public class EnumReader<E extends Enum<E>> implements Closeable {

    /**
     * Читатель потока
     */
    private BufferedReader in;

    /**
     * Описатель типа перечисления, описанного параметром шаблона
     */
    private Class<E> cls;

    /**
     * Основной констуктор класса.
     *
     * @param stream поток, в котором ожидаются экземпляры перечисления.
     * @param cls описатель типа перечисления, описанного параметром шаблона Е
     */
    public EnumReader(InputStream stream, Class<E> cls) {
        this.cls = cls;
        in = new BufferedReader(new InputStreamReader(stream));
    }

    /**
     * Возвращает следующий экземпляр пересиления из потока.
     *
     * @return экземпляр типа E
     *
     * @throws IOException в случае ошиюки ввода/вывода
     */
    public final E next() throws IOException {
        try {
            return E.valueOf(cls, in.readLine());
        } catch (IllegalArgumentException e) {
            //System.out.println("Введен неверный параметр");   
            throw new IOException("Введена неверная команда. Доступные комманды: \n"
                     +"doreport        Запускает создание отчета\n"
                     +"addsuplier      Добавляет новый договор\n"
                     +"createtable     Создает новую талицу, если еще не созданна\n"
                     +"showtable       Показывает существующую таблицу договров\n"
                     +"showlastreport  Показывает последний отчет\n"
                     +"exit            Выход их программы", e);
        }
    }

    /**
     * ОСвобождает ресурсы, связанные с экземпляром класса.
     *
     * @throws IOException в случае ошибки ввода/вывода
     */
    @Override
    public void close() throws IOException {
        in.close();
        in = null;
        cls = null;
    }

}
