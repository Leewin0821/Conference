package service;

import domain.Session;

import java.util.List;

/**
 * Created by leewin on 15/3/8.
 */
public interface Dispatcher {
    public List<Session> dispatch();
}
