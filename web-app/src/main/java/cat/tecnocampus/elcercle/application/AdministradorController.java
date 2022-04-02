package cat.tecnocampus.elcercle.application;
import cat.tecnocampus.elcercle.application.daosInterface.IUsuariDAO;
import cat.tecnocampus.elcercle.application.dto.ComandaDTO;
import cat.tecnocampus.elcercle.application.dto.SubscripcioDTO;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AdministradorController {

    IUsuariDAO usuariDAO;

    public AdministradorController(IUsuariDAO usuariDAO) {
        this.usuariDAO = usuariDAO;
    }

    public List<SubscripcioDTO> consultarSubscripcions(String idMembre) {
        return usuariDAO.consultarSubscripcions(idMembre);
    }

    public List<SubscripcioDTO> consultarSubscripcionsDeProducte(String idProducte) {
        return usuariDAO.consultarSubscripcionsDeProducte(idProducte);
    }
    public List<SubscripcioDTO> consultarSubscripcio(String idMembre) {
        return usuariDAO.consultarSubscripcions(idMembre);
    }

    public List<ComandaDTO> consultarComandes(String idComanda) {
        return usuariDAO.consultarComandes(idComanda);
    }

    public List<ComandaDTO> consultarComandesObertes(String idComanda) {
        return usuariDAO.consultarComandesObertes(idComanda);
    }


    /********************************************************************
     * Translations between DTOs and domain objects
     ********************************************************************/
/*
    private StudentDTO student2StudentDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setName(student.getName());
        studentDTO.setSecondName(student.getSecondName());

        return studentDTO;
    }

    private Student studentDTO2Student(StudentDTO studentDTO) {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setEmail(studentDTO.getEmail());
        student.setName(studentDTO.getName());
        student.setSecondName(studentDTO.getSecondName());

        return student;
    }

    private ClassroomDTO classroom2classroomDTOnoAllocations(Classroom classroom) {
        ClassroomDTO classroomDTO = new ClassroomDTO();
        classroomDTO.setName(classroom.getName());
        classroomDTO.setCapacity(classroom.getCapacity());
        classroomDTO.setOrientation(classroom.getOrientation());
        classroomDTO.setPlugs(classroom.isPlugs());

        return classroomDTO;
    }

    private ClassroomDTO classroom2classroomDTO(Classroom classroom) {
        ClassroomDTO classroomDTO = classroom2classroomDTOnoAllocations(classroom);
        classroomDTO.setAllocations(classroomGetAllocationsDTO(classroom));

        return classroomDTO;
    }

    private Classroom classroomDTO2classroom(ClassroomDTO classroomDTO) {
        Classroom classroom = new Classroom();

        classroom.setName(classroomDTO.getName());
        classroom.setCapacity(classroomDTO.getCapacity());
        classroom.setPlugs(classroomDTO.isPlugs());
        classroom.setOrientation(classroomDTO.getOrientation());
        classroomDTO.getAllocations().stream()
                .forEach(a -> classroom.allocate(studentDTO2Student(a.getStudent()), DayOfWeek.valueOf(a.getDayOfWeek())));
        return classroom;
    }

    private List<AllocationDTO> classroomGetAllocationsDTO(Classroom classroom) {
        return classroom.getAllocations().stream().map(this::allocation2AllocationDTO).collect(Collectors.toList());
    }

    private AllocationDTO allocation2AllocationDTO(Allocation allocation) {
        AllocationDTO allocationDTO = new AllocationDTO();
        allocationDTO.setStudent(student2StudentDTO(allocation.getStudent()));
        allocationDTO.setDayOfWeek(allocation.getDayOfWeek().name());

        return allocationDTO;
    } */
}
