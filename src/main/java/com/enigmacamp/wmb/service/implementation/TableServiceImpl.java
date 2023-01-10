package com.enigmacamp.wmb.service.implementation;

import com.enigmacamp.wmb.exception.NotFoundException;
import com.enigmacamp.wmb.model.Table;
import com.enigmacamp.wmb.model.request.TableRequest;
import com.enigmacamp.wmb.repository.TableRepository;
import com.enigmacamp.wmb.service.TableService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TableServiceImpl implements TableService {
    private final TableRepository tableRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TableServiceImpl(TableRepository tableRepository, ModelMapper modelMapper) {
        this.tableRepository = tableRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<Table> getAll() {
        List<Table> tables = tableRepository.findAll();

        if (tables.isEmpty()) {
            throw new NotFoundException();
        }

        return tables;
    }

    @Override
    public Table add(TableRequest tableRequest) {
        Table table = modelMapper.map(tableRequest, Table.class);
        return tableRepository.save(table);
    }

    @Override
    public void delete(String id) {
        Optional<Table> table = tableRepository.findById(id);

        if (table.isEmpty()) {
            throw new NotFoundException();
        }

        tableRepository.deleteById(id);
    }
}
