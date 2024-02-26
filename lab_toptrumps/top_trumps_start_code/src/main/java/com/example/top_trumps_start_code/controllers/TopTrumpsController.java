package com.example.top_trumps_start_code.controllers;

import com.example.top_trumps_start_code.models.Card;
import com.example.top_trumps_start_code.models.Suit;
import com.example.top_trumps_start_code.services.TopTrumpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static com.example.top_trumps_start_code.models.Suit.DIAMONDS;
import static com.example.top_trumps_start_code.models.Suit.HEARTS;

@RestController
@RequestMapping(value = "/toptrumps")
public class TopTrumpsController {

    @Autowired
    TopTrumpsService topTrumpsService;

    @PostMapping
    public ResponseEntity<String> compareCards(@RequestBody ArrayList<Card> cards){
        String card = topTrumpsService.checkWinner(cards);
        return new ResponseEntity<>(card, HttpStatus.OK);

    }

}
