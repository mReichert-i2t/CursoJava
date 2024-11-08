package com.gob.biblioteca_santa_fe.rowMapper;

import com.gob.biblioteca_santa_fe.DTOs.ResponseStoredDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PrestamoRowMapper implements RowMapper<ResponseStoredDTO>{

    @Override
    public ResponseStoredDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new ResponseStoredDTO(
                rs.getString("isbn"),
                rs.getString("nombre_libro"),
                rs.getString("autor"),
                rs.getDate("fecha_inicio").toLocalDate(),
                rs.getDate("rs_fin").toLocalDate(),
                rs.getString("estado"),
                rs.getString("nombre_usuario"),
                rs.getString("apellido")
        );
    }
}
