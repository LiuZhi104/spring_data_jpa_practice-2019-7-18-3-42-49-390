package com.tw.apistackbase.controller;

import com.tw.apistackbase.ParkinglotRes;
import com.tw.apistackbase.entity.Parkinglot;
import com.tw.apistackbase.respository.ParkinglotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

@RestController
public class ParkinglotController {
    @Autowired
    private ParkinglotRepository parkinglotRepository;
    @Autowired
    private ParkinglotRes parkinglotRes;
    @PostMapping("/parkinglots")
    public ResponseEntity<Parkinglot> createParkinglot(@RequestBody Parkinglot parkinglot) {
      Parkinglot newparkinglot=parkinglotRepository.save(parkinglot);
        return ResponseEntity.ok(newparkinglot);
    }
    @DeleteMapping("/parkinglots/{id}")
    public ResponseEntity deleteParkinglot(@PathVariable int id, @RequestBody Parkinglot parkinglot) {
        ArrayList<Parkinglot> parkinglots= (ArrayList<Parkinglot>) parkinglotRes.getParkinglots().stream().filter(delete->delete.getId()== id).collect(Collectors.toList());
        if(parkinglots.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(parkinglots.remove(parkinglot));
    }

}

