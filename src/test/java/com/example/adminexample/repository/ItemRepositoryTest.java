package com.example.adminexample.repository;

import com.example.adminexample.AdminExampleApplicationTests;
import com.example.adminexample.model.entity.Item;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class ItemRepositoryTest extends AdminExampleApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){

        Item item = new Item();
        item.setStatus("UNREGISTERED");
        item.setName("삼성노트북");
        item.setTitle("삼성노트북 A100");
        item.setContent("2021년형 노트북 입니다.");
        item.setPrice(900000);
        item.setBrandName("삼성");
        item.setRegisteredAt(LocalDateTime.now());
        item.setCreatedAt(LocalDateTime.now());
        item.setCreatedBy("Partner01");
//        item.setPartnerId(1L);

        Item newItem = itemRepository.save(item);
        assertNotNull(newItem);
    }

    @Test
    public void read(){

        Long id = 1L;

        Optional<Item> item = itemRepository.findById(id);

//        item.ifPresent(i -> {
//            System.out.println(i);
//        });

        assertTrue(item.isPresent());

    }

}
