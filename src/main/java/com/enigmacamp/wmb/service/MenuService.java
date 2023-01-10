package com.enigmacamp.wmb.service;

import com.enigmacamp.wmb.model.Menu;
import com.enigmacamp.wmb.model.request.MenuRequest;

import java.util.List;

public interface MenuService {
    List<Menu> getAll();
    Menu add(MenuRequest menuRequest);
    void delete(String id);
}
