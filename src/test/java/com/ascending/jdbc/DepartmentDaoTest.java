package com.ascending.jdbc;

import com.ascending.model.Department;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DepartmentDaoTest {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private DepartmentDao departmentDao;
    private Department testRecord;

    @BeforeClass
    public static void setUpClass(){
        System.out.println("executing beforeClass");
    }

    @Before
    public void setUp(){
        //TODO insert data into database
        logger.debug("executing before");
//        System.out.println("executing before");
        testRecord = new Department();
        departmentDao = new DepartmentDao();
        testRecord= departmentDao.save(testRecord);
    }

    @After
    public void tearDown(){
        //TODO delete data from database
        logger.info("executing after");
        departmentDao.delete(testRecord.getId());
    }


    @Test
    public void getDepartmentsTest() {
        System.out.println("Test method 1");
        List<Department> departments = departmentDao.getDepartments();
        int expectedNumOfDept = 5;

//        for (Department department : departments) {
//            System.out.println(department);
//        }

        Assert.assertEquals(expectedNumOfDept, departments.size());
        departmentDao.delete(testRecord.getId());
    }

    @Test
    public void getAnotherTest() {
        System.out.println("Test method 2");
    }

//    public static void main(String[] args){
//        DepartmentDaoTest departmentDaoTest = new DepartmentDaoTest();
//        departmentDaoTest.setUp();
//        departmentDaoTest.getDepartmentsTest();
//        departmentDaoTest.tearDown();
//    }

}
