package com.tw.apistackbase.TestJpa;

import com.tw.apistackbase.entity.Parkinglot;
import com.tw.apistackbase.respository.ParkinglotRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ParkinglotJpaTest {
    @Autowired
    private ParkinglotRepository parkinglotRepository;
    @Test
    public void should_return_size_when_the_add() {
        //given
        Parkinglot parkinglot1=new Parkinglot(1,"parkone",10,"胡同");
        parkinglotRepository.save(parkinglot1);
        Parkinglot parkinglot2=new Parkinglot(2,"parktwo",10,"胡同1");
        parkinglotRepository.save(parkinglot2);
        Parkinglot parkinglot3=new Parkinglot(3,"parkthree",10,"胡同2");
        parkinglotRepository.save(parkinglot3);
        Parkinglot parkinglot4=new Parkinglot(4,"parkfour",10,"胡同3");
        parkinglotRepository.save(parkinglot4);
        //when
        List<Parkinglot> parkinglots=parkinglotRepository.findAll();
        //then
        Assertions.assertEquals(4,parkinglots.size());
    }


}
