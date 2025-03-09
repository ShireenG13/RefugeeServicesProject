package com.shireen.refugeeservicesproject.service;


import com.shireen.refugeeservicesproject.model.Item;
import com.shireen.refugeeservicesproject.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    public Item updateItem(Long id, Item updatedItem) {
        return itemRepository.findById(id)
                .map(item -> {
                    item.setItemType(updatedItem.getItemType());
                    item.setItemDescription(updatedItem.getItemDescription());
                    item.setNotes(updatedItem.getNotes());
                    item.setStatus(updatedItem.getStatus());
                    return itemRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found"));
    }
}
