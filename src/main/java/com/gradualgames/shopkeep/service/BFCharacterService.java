package com.gradualgames.shopkeep.service;

import com.gradualgames.shopkeep.entity.BFCharacter;
import com.gradualgames.shopkeep.repository.BFCharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BFCharacterService {

    private final BFCharacterRepository bfCharacterRepository;

    public BFCharacterService(BFCharacterRepository bfCharacterRepository) {
        this.bfCharacterRepository = bfCharacterRepository;
    }

    public void createCharacter(BFCharacter bfCharacter) {
        bfCharacterRepository.save(bfCharacter);
    }

    public List<BFCharacter> getAllCharacters() {
        return bfCharacterRepository.findAll();
    }
}
