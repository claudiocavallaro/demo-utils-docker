package com.example.testdb.demodb.persistence;

import com.example.testdb.demodb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select nome \n" +
            "from userdb\n" +
            "where nome = ?1", nativeQuery = true)
    String getNome(String nome);

    User findByNomeAndCognome(@Param("nome") String nome, @Param("cognome") String cognome);
}
