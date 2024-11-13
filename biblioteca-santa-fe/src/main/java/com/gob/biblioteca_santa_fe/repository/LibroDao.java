package com.gob.biblioteca_santa_fe.repository;

import com.gob.biblioteca_santa_fe.DTOs.LibroDTO;
import com.gob.biblioteca_santa_fe.model.Libro;
import com.gob.biblioteca_santa_fe.rowMapper.PrestamoRowMapper;
import jakarta.persistence.EntityManager;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LibroDao {

    private final EntityManager entityManager;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public LibroDao(EntityManager entityManager, NamedParameterJdbcTemplate namedParameter){
        this.entityManager = entityManager;
        this.namedParameterJdbcTemplate = namedParameter;
    }

    public List<Libro> getByAutor(String autor){

        String sql = "SELECT * FROM libro WHERE autor = :autor";

        List<Libro> libros = entityManager.createNativeQuery(sql)
                .setParameter("autor", autor)
                .getResultList();

        return libros;
    }

    public List<LibroDTO> getByNombre(String nombre){

        String sql = "SELECT * FROM libro WHERE nombre = :nombre";

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("nombre", nombre);

        return namedParameterJdbcTemplate.query(sql, parameters, (rs, rows) ->
                new LibroDTO(
                        rs.getLong("id"),
                        rs.getString("isbn"),
                        rs.getString("nombre"),
                        rs.getString("autor"),
                        rs.getInt("cantidad"),
                        rs.getDate("fecha_creacion").toInstant(),
                        rs.getDate("fecha_modificacion").toInstant()
                )
        );
    }


}
