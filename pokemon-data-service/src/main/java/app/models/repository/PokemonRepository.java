package app.models.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import app.models.Pokemon;

@Repository
public interface PokemonRepository extends MongoRepository<Pokemon, String>{

}
