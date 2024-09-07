package com.example.sboot.controller;

import com.example.sboot.entity.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ItemController {

    @GetMapping("/items")
    public String items(Model model){
        List<Item> items=new ArrayList<>();
        items.add(new Item("Apple", 10));
        items.add(new Item("Banana", 5));
        items.add(new Item("Orange", 8));
        model.addAttribute("items", items); // items-->번지값(List<Item>)
        return "items"; // items.html -->${items}
    }

    @PostMapping("/submitData")
    @ResponseBody
    public String submitData(@RequestBody String data){ // { data : "sasasasa" }
        System.out.println("Received data: " + data);
        return "Data received successfully!"; // -->ajax응답
    }

    @GetMapping("/fetchTest")
    public String fetchTest(){
        return "fetchAwait"; // fetchAwait.html
    }

}
