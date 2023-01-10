package com.enigmacamp.wmb.service;

import com.enigmacamp.wmb.model.Table;
import com.enigmacamp.wmb.model.request.TableRequest;

import java.util.List;

public interface TableService {
    List<Table> getAll();
    Table add(TableRequest tableRequest);
    void delete(String id);
}
