package com.example.adminexample.repository;

import com.example.adminexample.AdminExampleApplicationTests;
import com.example.adminexample.model.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryRepositoryTest extends AdminExampleApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void create(){

        String type = "Computer";
        String title = "컴퓨터";
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";
        Category category = new Category();

        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(createdAt);
        category.setCreatedBy(createdBy);

        Category newCategory = categoryRepository.save(category);
        /*

           Assert : 우리가 미리 이 값 혹은 객체들은 무엇이다 라고 가정을 해놓아서 이 값들이 우리가 가정을 해 놓은 타입 혹은 값이랑
           같지 않으면 에러 메세지를 반환해 주어 경고를 해준다.

         */
        assertNotNull(newCategory);  // 만약 newCategory 객체가 null이면 error 메세지를 반환한다. (null이면 안되기 때문에 사용)
        assertEquals(newCategory.getType(), type);  // 우리가 넣어준 객체의 type과 위에서 지정해준 type이 같은지를 확인
        assertEquals(newCategory.getTitle(), title);


    }

    @Test
    public void read(){

        String type = "Computer";
        Optional<Category> optionalCategory = categoryRepository.findByType(type);

        optionalCategory.ifPresent( c -> {

            assertEquals(c.getType(), type);

            System.out.println(c.getId());
            System.out.println(c.getType());
            System.out.println(c.getTitle());
        });


    }


}
