package com.emplyeemanagement.employeeManagment.Services;

import com.emplyeemanagement.employeeManagment.DTO.AttendenceDTO;
import com.emplyeemanagement.employeeManagment.Model.Attendence;
import com.emplyeemanagement.employeeManagment.repos.AttendenceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendenceService {


    @Autowired
    private AttendenceRepository attendenceRepository;

    private ModelMapper modelMapper;

    public void markAttendence(Attendence attendence)
    {
        attendenceRepository.save(attendence);
    }

    public void save(Attendence attendence) {
        attendenceRepository.save(attendence);
    }

    public List<AttendenceDTO> findAll() {

        return attendenceRepository.findAll().stream().map(attendence->modelMapper.map(attendence,AttendenceDTO.class
        )).collect(Collectors.toList());
    }
}

