package edu.eci.pdsw.samples.persistence.mybatisimpl.mappers;

import edu.eci.pdsw.samples.entities.Paciente;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CansultaMapper {
    List<Paciente> getConsultaByPacienteId(@Param("id") int id, @Param("idType") String idType);
}
