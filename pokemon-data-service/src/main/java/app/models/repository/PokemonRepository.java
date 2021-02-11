package app.models.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import interfaces.PokemonInterface;

@Repository
public interface PokemonRepository extends MongoRepository<PokemonInterface, String>{

}
