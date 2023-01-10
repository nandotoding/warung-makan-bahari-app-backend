package com.enigmacamp.wmb.service.implementation;

import com.enigmacamp.wmb.exception.NotFoundException;
import com.enigmacamp.wmb.model.Menu;
import com.enigmacamp.wmb.model.request.MenuRequest;
import com.enigmacamp.wmb.repository.MenuRepository;
import com.enigmacamp.wmb.service.MenuService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MenuServiceImpl(MenuRepository menuRepository, ModelMapper modelMapper) {
        this.menuRepository = menuRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Menu> getAll() {
        List<Menu> menus = menuRepository.findAll();

        if (menus.isEmpty()) {
            throw new NotFoundException();
        }

        return menus;
    }

    @Override
    public Menu add(MenuRequest menuRequest) {
        Menu menu = modelMapper.map(menuRequest, Menu.class);
        return menuRepository.save(menu);
    }

    @Override
    public void delete(String id) {
        Optional<Menu> menu = menuRepository.findById(id);

        if (menu.isEmpty()) {
            throw new NotFoundException();
        }

        menuRepository.deleteById(id);
    }
}
