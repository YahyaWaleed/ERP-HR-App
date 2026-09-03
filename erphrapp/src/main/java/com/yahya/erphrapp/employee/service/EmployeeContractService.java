package com.yahya.erphrapp.employee.service;

import com.yahya.erphrapp.employee.dto.EmployeeContractRequest;
import com.yahya.erphrapp.employee.dto.EmployeeContractResponse;
import com.yahya.erphrapp.employee.entity.Employee;
import com.yahya.erphrapp.employee.entity.EmployeeContract;
import com.yahya.erphrapp.employee.mapper.EmployeeContractMapper;
import com.yahya.erphrapp.employee.repository.EmployeeContractRepository;
import com.yahya.erphrapp.employee.repository.EmployeeRepository;
import com.yahya.erphrapp.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeContractService {
    // inject repos and mapper
    private final EmployeeContractMapper employeeContractMapper;
    private  final EmployeeContractRepository employeeContractRepository;
    private final EmployeeRepository employeeRepository;

    public EmployeeContractService(EmployeeRepository employeeRepository, EmployeeContractMapper employeeContractMapper, EmployeeContractRepository employeeContractRepository) {
        this.employeeContractMapper = employeeContractMapper;
        this.employeeContractRepository = employeeContractRepository;
        this.employeeRepository = employeeRepository;
    }

    // read one contract
    public EmployeeContractResponse getContract(Long id) {
        EmployeeContract employeeContract = employeeContractRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Contract", id));
        return employeeContractMapper.toResponse(employeeContract);
    }

    // read all contracts
    public List<EmployeeContractResponse> getContracts() {
        return employeeContractRepository.findAll().stream().map(employeeContractMapper::toResponse).toList();
    }

    // update (renew) contract
    @Transactional
    public EmployeeContractResponse createContract(Long empId, EmployeeContractRequest employeeContractRequest) {
        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", empId));

        // close the existing active contract, if one exists
        employeeContractRepository.findByEmployeeIdAndStatus(empId, EmployeeContract.ContractStatus.ACTIVE)
                .ifPresent(oldContract -> {
                    oldContract.setStatus(EmployeeContract.ContractStatus.EXPIRED);
                    oldContract.setEndDate(employeeContractRequest.getStartDate().minusDays(1));
                    employeeContractRepository.save(oldContract);
                });

        EmployeeContract newContract = new EmployeeContract();
        newContract.setEmployee(employee);
        employeeContractRepository.save(newContract);
        int contractYear = newContract.getStartDate().getYear();
        newContract.setContractNo(String.format("CT-%d-%03d", contractYear, empId));
        employeeContractRepository.save(newContract);
        newContract.setContractType(EmployeeContract.ContractType.valueOf(employeeContractRequest.getContractType()));
        newContract.setStartDate(employeeContractRequest.getStartDate());
        newContract.setEndDate(employeeContractRequest.getEndDate());
        newContract.setBasicSalary(employeeContractRequest.getBasicSalary());
        newContract.setCurrency(employeeContractRequest.getCurrency());
        newContract.setWeeklyHours(employeeContractRequest.getWeeklyHours());
        newContract.setAnnualLeaveDays(employeeContractRequest.getAnnualLeaveDays());
        newContract.setProbationMonths(employeeContractRequest.getProbationMonths());
        newContract.setNotes(employeeContractRequest.getNotes());
        newContract.setStatus(EmployeeContract.ContractStatus.ACTIVE);

        employeeContractRepository.save(newContract);
        return employeeContractMapper.toResponse(newContract);
    }

    // end a contract
    @Transactional
    public void endContract(Long id) {
        EmployeeContract employeeContract = employeeContractRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Contract", id));
        employeeContract.setStatus(EmployeeContract.ContractStatus.TERMINATED);
        employeeContractRepository.save(employeeContract);
    }


    public List<EmployeeContractResponse> getContractsForEmployee(Long empId) {
        return employeeContractRepository.findByEmployeeId(empId)
                .stream()
                .map(employeeContractMapper::toResponse)
                .toList();
    }
}
