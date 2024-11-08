package com.gob.biblioteca_santa_fe.repository;

import com.gob.biblioteca_santa_fe.DTOs.ResponseStoredDTO;
import com.gob.biblioteca_santa_fe.rowMapper.PrestamoRowMapper;
import jakarta.persistence.EntityManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Map;

@Repository
public class PrestamoDao {

    private final EntityManager entityManager;
    private final JdbcTemplate jdbcTemplate;

    public PrestamoDao(EntityManager entityManager, JdbcTemplate jdbcTemplate) {
        this.entityManager = entityManager;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ResponseStoredDTO> getPrestamosPorEstado(String estado) {

        return this.entityManager.createNamedStoredProcedureQuery("listarPrstamosPorEstadoPrestamo")
                .setParameter("estado", estado)
                .getResultList();
    }

    public Integer getCantPrestamosDevueltos(){

        Map<String, Object> result = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("cantPrestamosDevueltos")
                .declareParameters(
                        new SqlParameter("estado", Types.VARCHAR),
                        new SqlOutParameter("cant", Types.INTEGER)
                )
                .execute(Map.of("estado", "devuelto"));

        return (Integer) result.get("cant");
    }

    public List<ResponseStoredDTO> getPrestamosPorEstado2(){

        Map<String, Object> result = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("listarPrestamosPorEstado")
                .declareParameters(
                        new SqlParameter("estado", Types.VARCHAR)
                )
                .returningResultSet("prestamosDetalle", new PrestamoRowMapper())
                .execute(Map.of("estado", "devuelto"));

        return (List<ResponseStoredDTO>) result.get("prestamosDetalle");
    }
}
