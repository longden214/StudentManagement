/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Schedule;

/**
 *
 * @author admin
 */
public interface ISchedule {
    List<Schedule> getSchedule(String search);
    Schedule find(int id);
    void add(Schedule s);
    void update(Schedule s);
    void delete(int id);
}
