/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.spb.v6.balanceStat.models;

/**
 *
 * @author b1ska
 */
public enum CommandsCLI {
   
    doreport,        //запускает создание отчета
    addsupplier,      //добавляет новый договор
    createtable,    //создает новую талицу, если еще не созданна
    showtable,
    showlastreport,//показывает существующую таблицу по полю тип\описание
    exit            //завершает работу приложения
    
   
}

