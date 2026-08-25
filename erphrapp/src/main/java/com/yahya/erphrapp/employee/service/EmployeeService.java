package com.yahya.erphrapp.employee.service;

import com.yahya.erphrapp.employee.dto.EmployeeContractRequest;
import com.yahya.erphrapp.employee.dto.EmployeeRequest;
import com.yahya.erphrapp.employee.dto.EmployeeResponse;
import com.yahya.erphrapp.employee.entity.Employee;
import com.yahya.erphrapp.employee.entity.EmployeeContract;
import com.yahya.erphrapp.employee.mapper.EmployeeMapper;
import com.yahya.erphrapp.employee.repository.EmployeeContractRepository;
import com.yahya.erphrapp.employee.repository.EmployeeRepository;
import com.yahya.erphrapp.exception.ResourceNotFoundException;
import com.yahya.erphrapp.organization.entity.Branch;
import com.yahya.erphrapp.organization.entity.Department;
import com.yahya.erphrapp.organization.entity.JobTitle;
import com.yahya.erphrapp.organization.repository.BranchRepository;
import com.yahya.erphrapp.organization.repository.DepartmentRepository;
import com.yahya.erphrapp.organization.repository.JobTitleRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    // inject the repo and mapper
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final BranchRepository branchRepository;
    private final DepartmentRepository departmentRepository;
    private  final JobTitleRepository jobTitleRepository;
    private final EmployeeContractRepository employeeContractRepository;

    public EmployeeService(EmployeeMapper employeeMapper, EmployeeRepository employeeRepository, BranchRepository branchRepository, DepartmentRepository departmentRepository, JobTitleRepository jobTitleRepository, EmployeeContractRepository employeeContractRepository) {
        this.employeeMapper = employeeMapper;
        this.employeeRepository = employeeRepository;
        this.branchRepository = branchRepository;
        this.departmentRepository = departmentRepository;
        this.jobTitleRepository = jobTitleRepository;
        this.employeeContractRepository =employeeContractRepository;
    }

    @Transactional
    // create an employee
    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest, EmployeeContractRequest employeeContractRequest) {
        Branch branch = branchRepository.findById(employeeRequest.getBranchId()).orElseThrow(() -> new ResourceNotFoundException("Branch",employeeRequest.getBranchId()));
        Department department = departmentRepository.findById(employeeRequest.getDeptId()).orElseThrow(() -> new ResourceNotFoundException("Departmetn" , employeeRequest.getDeptId()));
        JobTitle title = jobTitleRepository.findById(employeeRequest.getJobId()).orElseThrow(() -> new ResourceNotFoundException("Job Title", employeeRequest.getJobId()));

        Employee manager = null;
        if (employeeRequest.getManagerId() != null) {
            manager = employeeRepository.findById(employeeRequest.getManagerId())
                    .orElseThrow(() -> new ResourceNotFoundException("Manager", employeeRequest.getManagerId()));
        }

        Employee employee = new Employee();

        employee.setEmpCode(employeeRequest.getEmpCode());
        employee.setFullNameAr(employeeRequest.getFullNameAr());
        employee.setFullNameEn(employeeRequest.getFullNameEn());
        employee.setAddress(employeeRequest.getAddress());
        employee.setBankAccount(employeeRequest.getBankAccount());
        employee.setBankName(employeeRequest.getBankName());
        employee.setBranch(branch);
        employee.setBirthDate(employeeRequest.getBirthDate());
        employee.setNationalId(employeeRequest.getNationalId());
        employee.setEmail(employeeRequest.getEmail());
        employee.setDepartment(department);
        employee.setDependents(employeeRequest.getDependents());
        employee.setPaymentMethod(Employee.PaymentMethod.valueOf(employeeRequest.getPaymentMethod()));
        employee.setInsuranceNo(employeeRequest.getInsuranceNo());
        employee.setHireDate(employeeRequest.getHireDate());
        employee.setMaritalStatus(Employee.MaritalStatus.valueOf(employeeRequest.getMaritalStatus()));
        employee.setMobile(employeeRequest.getMobile());
        employee.setManager(manager);
        employee.setJobTitle(title);
        employee.setGender(Employee.Gender.valueOf(employeeRequest.getGender()));
        employee.setEmpStatus(Employee.EmployeeStatus.ACTIVE);

        // create the contract for the employee
        EmployeeContract employeeContract = new EmployeeContract();

        employeeContract.setAnnualLeaveDays(employeeContractRequest.getAnnualLeaveDays());
        employeeContract.setBasicSalary(employeeContractRequest.getBasicSalary());
        employeeContract.setContractNo(employeeContractRequest.getContractNo());
        employeeContract.setCurrency(employeeContractRequest.getCurrency());
        employeeContract.setContractType(EmployeeContract.ContractType.valueOf(employeeContractRequest.getContractType()));
        employeeContract.setEmployee(employee);
        employeeContract.setNotes(employeeContractRequest.getNotes());
        employeeContract.setStartDate(employeeContractRequest.getStartDate());
        employeeContract.setEndDate(employeeContractRequest.getEndDate());
        employeeContract.setWeeklyHours(employeeContractRequest.getWeeklyHours());
        employeeContract.setProbationMonths(employeeContractRequest.getProbationMonths());
        employeeContract.setStatus(EmployeeContract.ContractStatus.ACTIVE);

        employeeContractRepository.save(employeeContract);
        employeeRepository.save(employee);
        return employeeMapper.toResponse(employee);
    }

    // read all employees
    public List<EmployeeResponse> getEmployees() {
        List<EmployeeResponse> employees = employeeRepository.findAll().stream().map(employeeMapper::toResponse).toList();
        return  employees;
    }

    // read one employee
    public EmployeeResponse getEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", id));
        return employeeMapper.toResponse(employee);
    }

    @Transactional
    // update an employee
    public EmployeeResponse updateEmployee(Long id, EmployeeRequest employeeRequest) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", id));

        Branch branch = branchRepository.findById(employeeRequest.getBranchId()).orElseThrow(() -> new ResourceNotFoundException("Branch",employeeRequest.getBranchId()));
        Department department = departmentRepository.findById(employeeRequest.getDeptId()).orElseThrow(() -> new ResourceNotFoundException("Departmetn" , employeeRequest.getDeptId()));
        JobTitle title = jobTitleRepository.findById(employeeRequest.getJobId()).orElseThrow(() -> new ResourceNotFoundException("Job Title", employeeRequest.getJobId()));

        Employee manager = null;
        if (employeeRequest.getManagerId() != null) {
            manager = employeeRepository.findById(employeeRequest.getManagerId())
                    .orElseThrow(() -> new ResourceNotFoundException("Manager", employeeRequest.getManagerId()));
        }


        employee.setEmpCode(employeeRequest.getEmpCode());
        employee.setFullNameAr(employeeRequest.getFullNameAr());
        employee.setFullNameEn(employeeRequest.getFullNameEn());
        employee.setAddress(employeeRequest.getAddress());
        employee.setBankAccount(employeeRequest.getBankAccount());
        employee.setBankName(employeeRequest.getBankName());
        employee.setBranch(branch);
        employee.setBirthDate(employeeRequest.getBirthDate());
        employee.setNationalId(employeeRequest.getNationalId());
        employee.setEmail(employeeRequest.getEmail());
        employee.setDepartment(department);
        employee.setDependents(employeeRequest.getDependents());
        employee.setMaritalStatus(Employee.MaritalStatus.valueOf(employeeRequest.getMaritalStatus()));
        employee.setPaymentMethod(Employee.PaymentMethod.valueOf(employeeRequest.getPaymentMethod()));
        employee.setInsuranceNo(employeeRequest.getInsuranceNo());
        employee.setHireDate(employeeRequest.getHireDate());
        employee.setMobile(employeeRequest.getMobile());
        employee.setManager(manager);
        employee.setJobTitle(title);
        employee.setGender(Employee.Gender.valueOf(employeeRequest.getGender()));

        employeeRepository.save(employee);

        return employeeMapper.toResponse(employee);
    }

    @Transactional
    // set his status to TERMINATED
    public void terminateEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", id));
        employee.setEmpStatus(Employee.EmployeeStatus.TERMINATED);
        employeeRepository.save(employee);
    }
}
