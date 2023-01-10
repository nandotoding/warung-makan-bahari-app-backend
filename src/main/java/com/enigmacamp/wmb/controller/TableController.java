package com.enigmacamp.wmb.controller;

import com.enigmacamp.wmb.exception.InvalidRequestException;
import com.enigmacamp.wmb.model.Table;
import com.enigmacamp.wmb.model.request.TableRequest;
import com.enigmacamp.wmb.model.response.CommonResponse;
import com.enigmacamp.wmb.model.response.SuccessResponse;
import com.enigmacamp.wmb.service.TableService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tables")
public class TableController {
    private final TableService tableService;

    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping
    public ResponseEntity<CommonResponse> getAll() {
        List<Table> tableData = tableService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Successfully got all tables", tableData));
    }

    @PostMapping
    public ResponseEntity<CommonResponse> add(@RequestBody @Valid TableRequest tableRequest, BindingResult errors) throws Exception {

        if (errors.hasErrors()) {
            throw new InvalidRequestException();
        }

        Table tableData = tableService.add(tableRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Successfully added table", tableData));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse> delete(@PathVariable("id") String id) {
        tableService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Successfully deleted table", null));
    }
}
