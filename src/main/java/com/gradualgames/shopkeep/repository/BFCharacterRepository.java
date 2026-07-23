package com.gradualgames.shopkeep.repository;

import com.gradualgames.shopkeep.entity.BFCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BFCharacterRepository
        extends JpaRepository<BFCharacter, Long> {
}