package dasturlash.uz.service;

import dasturlash.uz.dto.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private List<StudentDTO> studentList = new LinkedList<>();

    public StudentService() {
        StudentDTO dto1 = new StudentDTO();
        dto1.setId(UUID.randomUUID().toString());
        dto1.setName("Alish");
        dto1.setSurname("Aliyev");
        dto1.setAge(21);
        studentList.add(dto1);
        //-------------------------
        StudentDTO dto2 = new StudentDTO();
        dto2.setId(UUID.randomUUID().toString());
        dto2.setName("Valish");
        dto2.setSurname("Valiyev");
        dto2.setAge(25);
        studentList.add(dto2);
        //-------------------------
        StudentDTO dto3 = new StudentDTO();
        dto3.setId(UUID.randomUUID().toString());
        dto3.setName("Eshmat");
        dto3.setSurname("Eshmatov");
        dto3.setAge(16);
        studentList.add(dto3);
        //-------------------------
        StudentDTO dto4 = new StudentDTO();
        dto4.setId(UUID.randomUUID().toString());
        dto4.setName("Toshmat");
        dto4.setSurname("Toshmatov");
        dto4.setAge(19);
        studentList.add(dto4);

    }

    public List<StudentDTO> getStudentList() {
        return studentList;
    }

    public StudentDTO getById(String id) {
        StudentDTO exist = get(id);
        if (exist == null) {
            throw new IllegalArgumentException("Student not found");
        }
        return exist;
    }

    public StudentDTO create(StudentDTO dto) {
//        validate(dto);
        dto.setId(UUID.randomUUID().toString());
        studentList.add(dto);
        return dto;
    }

    public boolean update(String id, StudentDTO dto) {
        StudentDTO exist = get(id);
        if(exist == null) {
            throw new IllegalArgumentException("Student not found");
        }
        exist.setName(dto.getName());
        exist.setSurname(dto.getSurname());
        exist.setAge(dto.getAge());
        return true;
    }

    public boolean delete(String id) {
        StudentDTO exist = get(id);
        if (exist == null) {
            throw new IllegalArgumentException("Student not found");
        }
        studentList.remove(exist);
        return true;
    }

    public void validate(StudentDTO dto) {
        if (dto.getName() == null || dto.getName().trim().length() < 2) {
            throw new IllegalArgumentException("Name required");
        }
        if (dto.getSurname() == null || dto.getSurname().trim().length() < 2) {
            throw new IllegalArgumentException("Surname required");
        }
        if (dto.getAge() == null || dto.getAge() < 15) {
            throw new IllegalArgumentException("Age required");
        }
    }

    public StudentDTO get(String id) {
        for (StudentDTO exist : studentList) {
            if (exist.getId().equals(id)) {
                return exist;
            }
        }
        return null;
    }

}
