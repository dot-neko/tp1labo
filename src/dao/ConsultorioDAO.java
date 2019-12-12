package dao;

import java.util.List;

import entidades.Medico;
import entidades.Paciente;
import entidades.Turno;
import excepciones.BusinessException;

public interface ConsultorioDAO {

	//Pacientes
	public void insertarPacientes(Paciente p) throws BusinessException;
	public void deletePacienteByDocumento(String documento) throws BusinessException;
	public void updateUsuarioByDocumento(Paciente p) throws BusinessException;
	public Paciente getPacienteByDocumento(String documento) throws BusinessException;
	public List<Paciente> getAllPacientes() throws BusinessException;
	//Medicos
	public void updateMedicoByDocumento(Medico m) throws BusinessException;
	public void deletemedicoByDocumento(String documento) throws BusinessException;
	public List<Medico> getAllMedicos() throws BusinessException;
	public Medico getMedicoByDocumento(String documento) throws BusinessException;
	public void insertarMedico(Medico m) throws BusinessException;
	public void CrearTurnosMedicos(Turno turno) throws BusinessException;
	public List<String> BuscarTurnos(Turno buscaturno) throws BusinessException;
	public void ReservaTurno(Turno turno) throws BusinessException;
	
}
