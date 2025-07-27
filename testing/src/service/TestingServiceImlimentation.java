package service;

import dto.TestingDto;
import repository.TestingRepo;
import repository.TestingRepoImplimentation;

public class TestingServiceImlimentation implements TestingService {

    @Override
    public boolean save(TestingDto testingDto) {
        if(testingDto!=null){
            System.out.println("Data is valis");
            TestingRepo testingRepo=new TestingRepoImplimentation();
            return testingRepo.save(testingDto);
        }
        return false;
    }
}
