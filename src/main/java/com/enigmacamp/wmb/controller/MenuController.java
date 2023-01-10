package com.enigmacamp.wmb.controller;

import com.enigmacamp.wmb.exception.InvalidRequestException;
import com.enigmacamp.wmb.model.Menu;
import com.enigmacamp.wmb.model.request.MenuRequest;
import com.enigmacamp.wmb.model.response.CommonResponse;
import com.enigmacamp.wmb.model.response.SuccessResponse;
import com.enigmacamp.wmb.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {
    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public ResponseEntity<CommonResponse> getAll() {
        List<Menu> menuData = menuService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Successfully got all menus", menuData));
    }

    @PostMapping
    public ResponseEntity<CommonResponse> add(@RequestBody @Valid MenuRequest menuRequest, BindingResult errors) throws Exception {

        if (errors.hasErrors()) {
            throw new InvalidRequestException();
        }

        Menu menuData = menuService.add(menuRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Successfully added menu", menuData));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse> delete(@PathVariable("id") String id) {
        menuService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Successfully deleted menu", null));
    }
}
